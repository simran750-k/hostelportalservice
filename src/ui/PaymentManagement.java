package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class PaymentManagement {

    // =========================================================
    // ROOM FEES - CHANGE THESE AMOUNTS ACCORDING TO YOUR HOSTEL
    // These fees already INCLUDE ALL FACILITIES.
    // =========================================================

    private static final double SINGLE_SEATER_FEE = 12000;
    private static final double TWO_SEATER_FEE = 10000;
    private static final double THREE_SEATER_FEE = 8000;
    private static final double FOUR_SEATER_FEE = 7000;

    // =========================================================
    // COLORS
    // =========================================================

    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color RED = new Color(220, 38, 38);
    private static final Color GREEN = new Color(22, 163, 74);
    private static final Color BORDER = new Color(203, 213, 225);

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Payment Management");

        frame.setSize(1150, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar = new JPanel();
        sidebar.setBackground(DARK_BLUE);
        sidebar.setPreferredSize(new Dimension(230, 680));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(DARK_BLUE);
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        logoPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 15, 25, 15
                )
        );

        JLabel logoIcon = new JLabel("🏠");
        logoIcon.setFont(
                new Font("Segoe UI Emoji", Font.PLAIN, 35)
        );
        logoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoTitle = new JLabel("HOSTEL");
        logoTitle.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );
        logoTitle.setForeground(WHITE);
        logoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoSubtitle = new JLabel("SERVICE PORTAL");
        logoSubtitle.setFont(
                new Font("Segoe UI", Font.PLAIN, 11)
        );
        logoSubtitle.setForeground(
                new Color(148, 163, 184)
        );
        logoSubtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        logoPanel.add(logoIcon);
        logoPanel.add(Box.createVerticalStrut(5));
        logoPanel.add(logoTitle);
        logoPanel.add(logoSubtitle);

        sidebar.add(logoPanel);

        JButton dashboardButton =
                createSidebarButton("🏠  Dashboard");

        JButton residentButton =
                createSidebarButton("👥  Residents");

        JButton roomButton =
                createSidebarButton("🛏  Rooms");

        JButton paymentButton =
                createSidebarButton("💳  Payments");

        JButton complaintButton =
                createSidebarButton("📝  Complaints");

        JButton reportButton =
                createSidebarButton("📊  Reports");

        JButton notificationButton =
                createSidebarButton("🔔  Notifications");

        JButton profileButton =
                createSidebarButton("👤  Profile");

        JButton logoutButton =
                createSidebarButton("🚪  Logout");

        sidebar.add(dashboardButton);
        sidebar.add(residentButton);
        sidebar.add(roomButton);
        sidebar.add(paymentButton);
        sidebar.add(complaintButton);
        sidebar.add(reportButton);
        sidebar.add(notificationButton);
        sidebar.add(profileButton);

        sidebar.add(Box.createVerticalGlue());

        sidebar.add(logoutButton);
        sidebar.add(Box.createVerticalStrut(20));

        dashboardButton.addActionListener(e -> {
            admindashboard.main(null);
            frame.dispose();
        });

        residentButton.addActionListener(e -> {
            ResidentManagement.main(null);
            frame.dispose();
        });

        roomButton.addActionListener(e -> {
            RoomManagement.main(null);
            frame.dispose();
        });

        paymentButton.addActionListener(e -> {
            // Already on Payment Management
        });

        complaintButton.addActionListener(e -> {
            ComplaintManagement.main(null);
            frame.dispose();
        });

        reportButton.addActionListener(e -> {
            Reports.main(null);
            frame.dispose();
        });

        notificationButton.addActionListener(e -> {
            AdminNotifications.main(null);
            frame.dispose();
        });

        profileButton.addActionListener(e -> {
            AdminProfile.main(null);
            frame.dispose();
        });

        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

            if (choice == JOptionPane.YES_OPTION) {
                login.main(null);
                frame.dispose();
            }
        });

        // =====================================================
        // RIGHT PANEL
        // =====================================================

        JPanel rightPanel =
                new JPanel(new BorderLayout());

        rightPanel.setBackground(LIGHT_BG);

        // =====================================================
        // TOP BAR
        // =====================================================

        JPanel topBar =
                new JPanel(new BorderLayout());

        topBar.setBackground(WHITE);

        topBar.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 15, 25
                )
        );

        JLabel pageTitle =
                new JLabel("Payment Management");

        pageTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        pageTitle.setForeground(TEXT);

        JLabel adminLabel =
                new JLabel("👤  Admin");

        adminLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        adminLabel.setForeground(GRAY);

        topBar.add(
                pageTitle,
                BorderLayout.WEST
        );

        topBar.add(
                adminLabel,
                BorderLayout.EAST
        );

        rightPanel.add(
                topBar,
                BorderLayout.NORTH
        );

        // =====================================================
        // CONTENT
        // =====================================================

        JPanel content =
                new JPanel();

        content.setBackground(LIGHT_BG);

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 30, 25, 30
                )
        );

        JLabel heading =
                new JLabel("Manage Payments");

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26
                )
        );

        heading.setForeground(TEXT);

        heading.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(heading);

        content.add(
                Box.createVerticalStrut(5)
        );

        JLabel subtitle =
                new JLabel(
                        "Manage room fees, payments and remaining balances."
                );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(GRAY);

        subtitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(subtitle);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // SEARCH + RECORD BUTTON
        // =====================================================

        JPanel actionPanel =
                new JPanel(
                        new BorderLayout(15, 0)
                );

        actionPanel.setBackground(LIGHT_BG);

        actionPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        actionPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JTextField searchField =
                new JTextField();

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        searchField.setPreferredSize(
                new Dimension(400, 40)
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        searchField.setToolTipText(
                "Search by payment ID, resident, room or status"
        );

        actionPanel.add(
                searchField,
                BorderLayout.WEST
        );

        JButton recordButton =
                new JButton("＋  Record Payment");

        recordButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        recordButton.setForeground(WHITE);

        recordButton.setBackground(PRIMARY);

        recordButton.setFocusPainted(false);

        recordButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 20
                )
        );

        actionPanel.add(
                recordButton,
                BorderLayout.EAST
        );

        content.add(actionPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // TABLE
        // =====================================================

        String[] columns = {
                "Payment ID",
                "Resident",
                "Room",
                "Room Type",
                "Total Fee",
                "Paid",
                "Remaining",
                "Date",
                "Status"
        };

        Object[][] data = {

                {
                        "P001",
                        "John Doe",
                        "204",
                        "2 Seater",
                        "Rs. 10,000",
                        "Rs. 8,000",
                        "Rs. 2,000",
                        "05 Sep 2026",
                        "PARTIAL"
                },

                {
                        "P002",
                        "Alex Smith",
                        "205",
                        "Single Seater",
                        "Rs. 12,000",
                        "Rs. 12,000",
                        "Rs. 0",
                        "04 Sep 2026",
                        "PAID"
                },

                {
                        "P003",
                        "Michael Brown",
                        "206",
                        "3 Seater",
                        "Rs. 8,000",
                        "Rs. 5,000",
                        "Rs. 3,000",
                        "03 Sep 2026",
                        "PARTIAL"
                },

                {
                        "P004",
                        "Sarah Wilson",
                        "207",
                        "4 Seater",
                        "Rs. 7,000",
                        "Rs. 0",
                        "Rs. 7,000",
                        "-",
                        "PENDING"
                },

                {
                        "P005",
                        "Emma Davis",
                        "208",
                        "2 Seater",
                        "Rs. 10,000",
                        "Rs. 10,000",
                        "Rs. 0",
                        "01 Sep 2026",
                        "PAID"
                }
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        data,
                        columns
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };

        JTable table =
                new JTable(model);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        table.setRowHeight(40);

        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        table.setGridColor(
                new Color(226, 232, 240)
        );

        table.setBackground(WHITE);

        table.setForeground(TEXT);

        table.setSelectionBackground(
                new Color(219, 234, 254)
        );

        table.setSelectionForeground(TEXT);

        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(model);

        table.setRowSorter(sorter);

        // =====================================================
        // SEARCH
        // =====================================================

        searchField.getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                            private void search() {

                                String text =
                                        searchField
                                                .getText()
                                                .trim();

                                if (text.isEmpty()) {

                                    sorter.setRowFilter(
                                            null
                                    );

                                } else {

                                    sorter.setRowFilter(
                                            RowFilter.regexFilter(
                                                    "(?i)"
                                                            + Pattern.quote(
                                                            text
                                                    )
                                            )
                                    );
                                }
                            }

                            @Override
                            public void insertUpdate(
                                    DocumentEvent e
                            ) {
                                search();
                            }

                            @Override
                            public void removeUpdate(
                                    DocumentEvent e
                            ) {
                                search();
                            }

                            @Override
                            public void changedUpdate(
                                    DocumentEvent e
                            ) {
                                search();
                            }
                        }
                );

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        table.getTableHeader().setBackground(
                new Color(226, 232, 240)
        );

        table.getTableHeader().setForeground(TEXT);

        table.getTableHeader().setPreferredSize(
                new Dimension(0, 40)
        );

        // Column sizes

        table.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(70);

        table.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(110);

        table.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(55);

        table.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(90);

        table.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(100);

        table.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(90);

        table.getColumnModel()
                .getColumn(6)
                .setPreferredWidth(100);

        table.getColumnModel()
                .getColumn(7)
                .setPreferredWidth(100);

        table.getColumnModel()
                .getColumn(8)
                .setPreferredWidth(85);

        JScrollPane tableScrollPane =
                new JScrollPane(table);

        tableScrollPane.setBorder(
                BorderFactory.createLineBorder(
                        new Color(226, 232, 240)
                )
        );

        tableScrollPane.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(tableScrollPane);

        content.add(
                Box.createVerticalStrut(15)
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                5
                        )
                );

        buttonPanel.setBackground(LIGHT_BG);

        buttonPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        buttonPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JButton feeButton =
                new JButton("💰 View Fee Details");

        JButton editButton =
                new JButton("✏ Edit Payment");

        JButton deleteButton =
                new JButton("🗑 Delete Payment");

        feeButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        editButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        deleteButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        feeButton.setForeground(
                GREEN
        );

        editButton.setForeground(TEXT);

        deleteButton.setForeground(RED);

        feeButton.setBackground(WHITE);
        editButton.setBackground(WHITE);
        deleteButton.setBackground(WHITE);

        feeButton.setFocusPainted(false);
        editButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);

        feeButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(187, 247, 208)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 15, 8, 15
                        )
                )
        );

        editButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 15, 8, 15
                        )
                )
        );

        deleteButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(254, 202, 202)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 15, 8, 15
                        )
                )
        );

        // =====================================================
        // RECORD PAYMENT
        // =====================================================

        recordButton.addActionListener(e -> {

            showPaymentForm(
                    frame,
                    model,
                    -1
            );
        });

        // =====================================================
        // VIEW FEE DETAILS
        // =====================================================

        feeButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a payment first.",
                        "No Payment Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            showFeeDetails(
                    frame,
                    model,
                    modelRow
            );
        });

        // =====================================================
        // EDIT PAYMENT
        // =====================================================

        editButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a payment first.",
                        "No Payment Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            showPaymentForm(
                    frame,
                    model,
                    modelRow
            );
        });

        // =====================================================
        // DELETE PAYMENT
        // =====================================================

        deleteButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a payment first.",
                        "No Payment Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            String paymentId =
                    model.getValueAt(
                            modelRow,
                            0
                    ).toString();

            String resident =
                    model.getValueAt(
                            modelRow,
                            1
                    ).toString();

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete payment "
                                    + paymentId
                                    + " for "
                                    + resident
                                    + "?",
                            "Delete Payment",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                model.removeRow(modelRow);

                JOptionPane.showMessageDialog(
                        frame,
                        "Payment deleted successfully.",
                        "Payment Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        buttonPanel.add(feeButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        content.add(buttonPanel);

        JScrollPane contentScrollPane =
                new JScrollPane(content);

        contentScrollPane.setBorder(null);

        contentScrollPane
                .getVerticalScrollBar()
                .setUnitIncrement(16);

        rightPanel.add(
                contentScrollPane,
                BorderLayout.CENTER
        );

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // =========================================================
    // PAYMENT FORM
    // =========================================================

    private static void showPaymentForm(
            JFrame parent,
            DefaultTableModel model,
            int editRow
    ) {

        boolean editing =
                editRow != -1;

        JDialog dialog =
                new JDialog(
                        parent,
                        editing
                                ? "Edit Payment"
                                : "Record Payment",
                        true
                );

        dialog.setSize(500, 600);

        dialog.setLocationRelativeTo(parent);

        dialog.setResizable(false);

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(WHITE);

        // =====================================================
        // HEADER
        // =====================================================

        JPanel header =
                new JPanel(new BorderLayout());

        header.setBackground(PRIMARY);

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 20, 15, 20
                )
        );

        JLabel title =
                new JLabel(
                        editing
                                ? "Edit Payment"
                                : "Record New Payment"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        title.setForeground(WHITE);

        header.add(
                title,
                BorderLayout.WEST
        );

        mainPanel.add(
                header,
                BorderLayout.NORTH
        );

        // =====================================================
        // FORM
        // =====================================================

        JPanel form =
                new JPanel(
                        new GridBagLayout()
                );

        form.setBackground(WHITE);

        form.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 10, 25
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(7, 5, 7, 5);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        JLabel residentLabel =
                new JLabel("Resident Name:");

        JTextField residentField =
                new JTextField();

        JLabel roomLabel =
                new JLabel("Room Number:");

        JTextField roomField =
                new JTextField();

        JLabel typeLabel =
                new JLabel("Room Type:");

        JComboBox<String> typeBox =
                new JComboBox<>(
                        new String[]{
                                "Single Seater",
                                "2 Seater",
                                "3 Seater",
                                "4 Seater"
                        }
                );

        JLabel totalFeeLabel =
                new JLabel("Total Room Fee:");

        JTextField totalFeeField =
                new JTextField();

        totalFeeField.setEditable(false);

        totalFeeField.setBackground(
                new Color(241, 245, 249)
        );

        JLabel paidLabel =
                new JLabel("Amount Paid:");

        JTextField paidField =
                new JTextField();

        JLabel remainingLabel =
                new JLabel("Remaining Fee:");

        JTextField remainingField =
                new JTextField();

        remainingField.setEditable(false);

        remainingField.setBackground(
                new Color(241, 245, 249)
        );

        JLabel dateLabel =
                new JLabel("Payment Date:");

        JTextField dateField =
                new JTextField();

        JLabel statusLabel =
                new JLabel("Status:");

        JComboBox<String> statusBox =
                new JComboBox<>(
                        new String[]{
                                "PENDING",
                                "PARTIAL",
                                "PAID"
                        }
                );

        // =====================================================
        // LOAD EXISTING DATA
        // =====================================================

        if (editing) {

            residentField.setText(
                    model.getValueAt(
                            editRow,
                            1
                    ).toString()
            );

            roomField.setText(
                    model.getValueAt(
                            editRow,
                            2
                    ).toString()
            );

            typeBox.setSelectedItem(
                    model.getValueAt(
                            editRow,
                            3
                    ).toString()
            );

            totalFeeField.setText(
                    model.getValueAt(
                            editRow,
                            4
                    ).toString()
            );

            paidField.setText(
                    model.getValueAt(
                                    editRow,
                                    5
                            ).toString()
                            .replace("Rs. ", "")
                            .replace(",", "")
            );

            remainingField.setText(
                    model.getValueAt(
                            editRow,
                            6
                    ).toString()
            );

            dateField.setText(
                    model.getValueAt(
                            editRow,
                            7
                    ).toString()
            );

            statusBox.setSelectedItem(
                    model.getValueAt(
                            editRow,
                            8
                    ).toString()
            );

        } else {

            dateField.setText(
                    new SimpleDateFormat(
                            "dd MMM yyyy"
                    ).format(new Date())
            );

            updateFeeFields(
                    typeBox,
                    paidField,
                    totalFeeField,
                    remainingField,
                    statusBox
            );
        }

        // =====================================================
        // ROOM TYPE CHANGE
        // =====================================================

        typeBox.addActionListener(e -> {

            updateFeeFields(
                    typeBox,
                    paidField,
                    totalFeeField,
                    remainingField,
                    statusBox
            );
        });

        // =====================================================
        // AMOUNT PAID CHANGE
        // =====================================================

        paidField.getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                            private void update() {

                                updateRemainingOnly(
                                        typeBox,
                                        paidField,
                                        totalFeeField,
                                        remainingField,
                                        statusBox
                                );
                            }

                            @Override
                            public void insertUpdate(
                                    DocumentEvent e
                            ) {
                                update();
                            }

                            @Override
                            public void removeUpdate(
                                    DocumentEvent e
                            ) {
                                update();
                            }

                            @Override
                            public void changedUpdate(
                                    DocumentEvent e
                            ) {
                                update();
                            }
                        }
                );

        // =====================================================
        // ADD FORM ROWS
        // =====================================================

        addFormRow(
                form,
                gbc,
                0,
                residentLabel,
                residentField
        );

        addFormRow(
                form,
                gbc,
                1,
                roomLabel,
                roomField
        );

        addFormRow(
                form,
                gbc,
                2,
                typeLabel,
                typeBox
        );

        addFormRow(
                form,
                gbc,
                3,
                totalFeeLabel,
                totalFeeField
        );

        addFormRow(
                form,
                gbc,
                4,
                paidLabel,
                paidField
        );

        addFormRow(
                form,
                gbc,
                5,
                remainingLabel,
                remainingField
        );

        addFormRow(
                form,
                gbc,
                6,
                dateLabel,
                dateField
        );

        addFormRow(
                form,
                gbc,
                7,
                statusLabel,
                statusBox
        );

        mainPanel.add(
                form,
                BorderLayout.CENTER
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                10
                        )
                );

        buttonPanel.setBackground(WHITE);

        JButton cancelButton =
                new JButton("Cancel");

        JButton saveButton =
                new JButton(
                        editing
                                ? "Update Payment"
                                : "Save Payment"
                );

        cancelButton.setFocusPainted(false);

        saveButton.setFocusPainted(false);

        cancelButton.setBackground(
                new Color(226, 232, 240)
        );

        saveButton.setBackground(PRIMARY);

        saveButton.setForeground(WHITE);

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );

        // =====================================================
        // SAVE
        // =====================================================

        saveButton.addActionListener(e -> {

            String resident =
                    residentField
                            .getText()
                            .trim();

            String room =
                    roomField
                            .getText()
                            .trim();

            String roomType =
                    typeBox
                            .getSelectedItem()
                            .toString();

            String paidText =
                    paidField
                            .getText()
                            .trim();

            String date =
                    dateField
                            .getText()
                            .trim();

            if (resident.isEmpty()
                    || room.isEmpty()
                    || paidText.isEmpty()
                    || date.isEmpty()) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please fill in all fields.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            double totalFee =
                    getRoomFee(roomType);

            double paid;

            try {

                paid =
                        Double.parseDouble(
                                paidText
                                        .replace(
                                                "Rs.",
                                                ""
                                        )
                                        .replace(
                                                "Rs",
                                                ""
                                        )
                                        .replace(
                                                ",",
                                                ""
                                        )
                                        .trim()
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Amount Paid must be a valid number.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (paid < 0) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Amount Paid cannot be negative.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (paid > totalFee) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Amount paid cannot be greater than the total room fee.",
                        "Invalid Payment",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            double remaining =
                    totalFee - paid;

            String status;

            if (remaining == 0) {
                status = "PAID";
            } else if (paid == 0) {
                status = "PENDING";
            } else {
                status = "PARTIAL";
            }

            String formattedTotal =
                    formatMoney(totalFee);

            String formattedPaid =
                    formatMoney(paid);

            String formattedRemaining =
                    formatMoney(remaining);

            if (!editing) {

                String paymentId =
                        generatePaymentId(model);

                model.addRow(
                        new Object[]{
                                paymentId,
                                resident,
                                room,
                                roomType,
                                formattedTotal,
                                formattedPaid,
                                formattedRemaining,
                                date,
                                status
                        }
                );

                JOptionPane.showMessageDialog(
                        dialog,
                        "Payment recorded successfully.\n\n"
                                + "Payment ID: "
                                + paymentId
                                + "\n"
                                + "Remaining Fee: "
                                + formattedRemaining,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } else {

                model.setValueAt(
                        resident,
                        editRow,
                        1
                );

                model.setValueAt(
                        room,
                        editRow,
                        2
                );

                model.setValueAt(
                        roomType,
                        editRow,
                        3
                );

                model.setValueAt(
                        formattedTotal,
                        editRow,
                        4
                );

                model.setValueAt(
                        formattedPaid,
                        editRow,
                        5
                );

                model.setValueAt(
                        formattedRemaining,
                        editRow,
                        6
                );

                model.setValueAt(
                        date,
                        editRow,
                        7
                );

                model.setValueAt(
                        status,
                        editRow,
                        8
                );

                JOptionPane.showMessageDialog(
                        dialog,
                        "Payment updated successfully.\n\n"
                                + "Remaining Fee: "
                                + formattedRemaining,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            dialog.dispose();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        dialog.add(mainPanel);

        dialog.setVisible(true);
    }

    // =========================================================
    // UPDATE TOTAL + REMAINING FEE
    // =========================================================

    private static void updateFeeFields(
            JComboBox<String> typeBox,
            JTextField paidField,
            JTextField totalFeeField,
            JTextField remainingField,
            JComboBox<String> statusBox
    ) {

        String roomType =
                typeBox
                        .getSelectedItem()
                        .toString();

        double totalFee =
                getRoomFee(roomType);

        totalFeeField.setText(
                formatMoney(totalFee)
        );

        updateRemainingOnly(
                typeBox,
                paidField,
                totalFeeField,
                remainingField,
                statusBox
        );
    }

    // =========================================================
    // UPDATE REMAINING FEE
    // =========================================================

    private static void updateRemainingOnly(
            JComboBox<String> typeBox,
            JTextField paidField,
            JTextField totalFeeField,
            JTextField remainingField,
            JComboBox<String> statusBox
    ) {

        String roomType =
                typeBox
                        .getSelectedItem()
                        .toString();

        double totalFee =
                getRoomFee(roomType);

        double paid = 0;

        try {

            String text =
                    paidField
                            .getText()
                            .trim()
                            .replace(
                                    "Rs.",
                                    ""
                            )
                            .replace(
                                    "Rs",
                                    ""
                            )
                            .replace(
                                    ",",
                                    ""
                            )
                            .trim();

            if (!text.isEmpty()) {
                paid = Double.parseDouble(text);
            }

        } catch (Exception ignored) {
        }

        double remaining =
                totalFee - paid;

        if (remaining < 0) {
            remaining = 0;
        }

        totalFeeField.setText(
                formatMoney(totalFee)
        );

        remainingField.setText(
                formatMoney(remaining)
        );

        if (paid == 0) {

            statusBox.setSelectedItem(
                    "PENDING"
            );

        } else if (remaining == 0) {

            statusBox.setSelectedItem(
                    "PAID"
            );

        } else {

            statusBox.setSelectedItem(
                    "PARTIAL"
            );
        }
    }

    // =========================================================
    // GET ROOM FEE
    // =========================================================

    private static double getRoomFee(
            String roomType
    ) {

        switch (roomType) {

            case "Single Seater":
                return SINGLE_SEATER_FEE;

            case "2 Seater":
                return TWO_SEATER_FEE;

            case "3 Seater":
                return THREE_SEATER_FEE;

            case "4 Seater":
                return FOUR_SEATER_FEE;

            default:
                return 0;
        }
    }

    // =========================================================
    // FORMAT MONEY
    // =========================================================

    private static String formatMoney(
            double amount
    ) {

        return "Rs. "
                + String.format(
                "%,.0f",
                amount
        );
    }

    // =========================================================
    // FEE DETAILS
    // =========================================================

    private static void showFeeDetails(
            JFrame parent,
            DefaultTableModel model,
            int row
    ) {

        String paymentId =
                model.getValueAt(
                        row,
                        0
                ).toString();

        String resident =
                model.getValueAt(
                        row,
                        1
                ).toString();

        String room =
                model.getValueAt(
                        row,
                        2
                ).toString();

        String roomType =
                model.getValueAt(
                        row,
                        3
                ).toString();

        String total =
                model.getValueAt(
                        row,
                        4
                ).toString();

        String paid =
                model.getValueAt(
                        row,
                        5
                ).toString();

        String remaining =
                model.getValueAt(
                        row,
                        6
                ).toString();

        String date =
                model.getValueAt(
                        row,
                        7
                ).toString();

        String status =
                model.getValueAt(
                        row,
                        8
                ).toString();

        JDialog dialog =
                new JDialog(
                        parent,
                        "Fee Details",
                        true
                );

        dialog.setSize(450, 500);

        dialog.setLocationRelativeTo(parent);

        dialog.setResizable(false);

        JPanel main =
                new JPanel(
                        new BorderLayout()
                );

        main.setBackground(WHITE);

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(PRIMARY);

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 20, 15, 20
                )
        );

        JLabel title =
                new JLabel("Room Fee Details");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        title.setForeground(WHITE);

        header.add(
                title,
                BorderLayout.WEST
        );

        main.add(
                header,
                BorderLayout.NORTH
        );

        JPanel details =
                new JPanel(
                        new GridLayout(
                                9,
                                2,
                                10,
                                10
                        )
                );

        details.setBackground(WHITE);

        details.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 30, 20, 30
                )
        );

        addDetail(
                details,
                "Payment ID",
                paymentId
        );

        addDetail(
                details,
                "Resident",
                resident
        );

        addDetail(
                details,
                "Room Number",
                room
        );

        addDetail(
                details,
                "Room Type",
                roomType
        );

        addDetail(
                details,
                "Total Room Fee",
                total
        );

        addDetail(
                details,
                "Amount Paid",
                paid
        );

        addDetail(
                details,
                "Remaining Fee",
                remaining
        );

        addDetail(
                details,
                "Payment Date",
                date
        );

        addDetail(
                details,
                "Status",
                status
        );

        main.add(
                details,
                BorderLayout.CENTER
        );

        JButton closeButton =
                new JButton("Close");

        closeButton.setFocusPainted(false);

        closeButton.addActionListener(
                e -> dialog.dispose()
        );

        JPanel bottom =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        bottom.setBackground(WHITE);

        bottom.add(closeButton);

        main.add(
                bottom,
                BorderLayout.SOUTH
        );

        dialog.add(main);

        dialog.setVisible(true);
    }

    // =========================================================
    // DETAIL ROW
    // =========================================================

    private static void addDetail(
            JPanel panel,
            String label,
            String value
    ) {

        JLabel labelText =
                new JLabel(label);

        labelText.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        labelText.setForeground(TEXT);

        JLabel valueText =
                new JLabel(value);

        valueText.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        valueText.setForeground(GRAY);

        panel.add(labelText);
        panel.add(valueText);
    }

    // =========================================================
    // GENERATE PAYMENT ID
    // =========================================================

    private static String generatePaymentId(
            DefaultTableModel model
    ) {

        int highestNumber = 0;

        for (int i = 0;
             i < model.getRowCount();
             i++) {

            String id =
                    model.getValueAt(
                            i,
                            0
                    ).toString();

            if (id.startsWith("P")) {

                try {

                    int number =
                            Integer.parseInt(
                                    id.substring(1)
                            );

                    if (number > highestNumber) {
                        highestNumber = number;
                    }

                } catch (NumberFormatException ignored) {
                }
            }
        }

        return String.format(
                "P%03d",
                highestNumber + 1
        );
    }

    // =========================================================
    // FORM ROW
    // =========================================================

    private static void addFormRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            JLabel label,
            JComponent component
    ) {

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.35;

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(TEXT);

        panel.add(
                label,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 0.65;

        component.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        panel.add(
                component,
                gbc
        );
    }

    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private static JButton createSidebarButton(
            String text
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        button.setForeground(
                new Color(203, 213, 225)
        );

        button.setBackground(DARK_BLUE);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12, 20, 12, 10
                )
        );

        button.setFocusPainted(false);

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        button.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return button;
    }
}