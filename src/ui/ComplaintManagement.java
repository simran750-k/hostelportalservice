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

public class ComplaintManagement {

    // ================= COLORS =================
    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color BORDER = new Color(203, 213, 225);

    // ================= TABLE =================
    private static JTable table;
    private static DefaultTableModel model;
    private static TableRowSorter<DefaultTableModel> sorter;

    private static JTextField searchField;
    private static JComboBox<String> statusFilter;

    // ================= MAIN =================
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Complaint Management");

        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ================= MAIN PANEL =================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);
        sidebar.setPreferredSize(new Dimension(230, 650));
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // ---------- LOGO ----------

        JPanel logoPanel = new JPanel();

        logoPanel.setBackground(DARK_BLUE);
        logoPanel.setLayout(
                new BoxLayout(logoPanel, BoxLayout.Y_AXIS)
        );

        logoPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25, 15, 25, 15
                )
        );

        JLabel logoIcon = new JLabel("🏠");

        logoIcon.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        35
                )
        );

        logoIcon.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel logoTitle = new JLabel("HOSTEL");

        logoTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        logoTitle.setForeground(WHITE);

        logoTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel logoSubtitle = new JLabel(
                "SERVICE PORTAL"
        );

        logoSubtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
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

        // ---------- SIDEBAR BUTTONS ----------

        JButton dashboardButton =
                createSidebarButton("🏠  Dashboard");

        JButton residentsButton =
                createSidebarButton("👥  Residents");

        JButton roomsButton =
                createSidebarButton("🛏  Rooms");

        JButton paymentsButton =
                createSidebarButton("💳  Payments");

        JButton complaintsButton =
                createSidebarButton("📝  Complaints");

        JButton reportsButton =
                createSidebarButton("📊  Reports");

        JButton notificationsButton =
                createSidebarButton("🔔  Notifications");

        JButton profileButton =
                createSidebarButton("👤  Profile");

        JButton logoutButton =
                createSidebarButton("🚪  Logout");

        sidebar.add(dashboardButton);
        sidebar.add(residentsButton);
        sidebar.add(roomsButton);
        sidebar.add(paymentsButton);
        sidebar.add(complaintsButton);
        sidebar.add(reportsButton);
        sidebar.add(notificationsButton);
        sidebar.add(profileButton);

        sidebar.add(Box.createVerticalGlue());

        sidebar.add(logoutButton);

        sidebar.add(Box.createVerticalStrut(20));

        // ================= SIDEBAR NAVIGATION =================

        dashboardButton.addActionListener(e -> {

            frame.dispose();

            admindashboard.main(null);
        });

        residentsButton.addActionListener(e -> {

            frame.dispose();

            ResidentManagement.main(null);
        });

        roomsButton.addActionListener(e -> {

            frame.dispose();

            RoomManagement.main(null);
        });

        paymentsButton.addActionListener(e -> {

            frame.dispose();

            PaymentManagement.main(null);
        });

        complaintsButton.addActionListener(e -> {

            // Already on complaint page
        });

        reportsButton.addActionListener(e -> {

            frame.dispose();

            Reports.main(null);
        });

        notificationsButton.addActionListener(e -> {

            frame.dispose();

            AdminNotifications.main(null);
        });

        profileButton.addActionListener(e -> {

            frame.dispose();

            AdminProfile.main(null);
        });

        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to logout?",
                            "Confirm Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice == JOptionPane.YES_OPTION) {

                frame.dispose();

                login.main(null);
            }
        });

        // ================= RIGHT PANEL =================

        JPanel rightPanel =
                new JPanel(new BorderLayout());

        rightPanel.setBackground(LIGHT_BG);

        // ================= TOP BAR =================

        JPanel topBar =
                new JPanel(new BorderLayout());

        topBar.setBackground(WHITE);

        topBar.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 15, 25
                )
        );

        JLabel pageTitle =
                new JLabel("Complaint Management");

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

        // ================= CONTENT =================

        JPanel content = new JPanel();

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
                new JLabel("Manage Complaints");

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
                        "Review, add and manage resident complaints."
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

        // ================= ACTION PANEL =================

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

        // SEARCH

        searchField = new JTextField();

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        searchField.setPreferredSize(
                new Dimension(300, 40)
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
                "Search by ID, resident, room, category or complaint"
        );

        actionPanel.add(
                searchField,
                BorderLayout.WEST
        );

        // STATUS FILTER

        statusFilter =
                new JComboBox<>(
                        new String[]{
                                "All Status",
                                "Pending",
                                "In Progress",
                                "Resolved"
                        }
                );

        statusFilter.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        statusFilter.setPreferredSize(
                new Dimension(150, 40)
        );

        actionPanel.add(
                statusFilter,
                BorderLayout.CENTER
        );

        // ADD BUTTON

        JButton addButton =
                new JButton("＋ Add Complaint");

        stylePrimaryButton(addButton);

        actionPanel.add(
                addButton,
                BorderLayout.EAST
        );

        content.add(actionPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // ================= TABLE =================

        String[] columns = {
                "ID",
                "Resident",
                "Room",
                "Category",
                "Complaint",
                "Date",
                "Status"
        };

        Object[][] data = {

                {
                        "C001",
                        "John Doe",
                        "204",
                        "Water",
                        "Water leakage",
                        "28 Sep 2026",
                        "Pending"
                },

                {
                        "C002",
                        "Alex Smith",
                        "205",
                        "Maintenance",
                        "Room light not working",
                        "27 Sep 2026",
                        "Resolved"
                },

                {
                        "C003",
                        "Michael Brown",
                        "206",
                        "Internet",
                        "Wi-Fi connection issue",
                        "26 Sep 2026",
                        "In Progress"
                },

                {
                        "C004",
                        "Sarah Wilson",
                        "207",
                        "Cleanliness",
                        "Room cleaning required",
                        "25 Sep 2026",
                        "Pending"
                },

                {
                        "C005",
                        "Emma Davis",
                        "208",
                        "Electricity",
                        "Power socket problem",
                        "23 Sep 2026",
                        "Resolved"
                }
        };

        model =
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

        table = new JTable(model);

        // ---------- TABLE STYLE ----------

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

        // ---------- COLUMN WIDTHS ----------

        table.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(55);

        table.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(110);

        table.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(55);

        table.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(100);

        table.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(200);

        table.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(100);

        table.getColumnModel()
                .getColumn(6)
                .setPreferredWidth(100);

        // ================= SORTER =================

        sorter =
                new TableRowSorter<>(model);

        table.setRowSorter(sorter);

        // ================= SEARCH =================

        searchField
                .getDocument()
                .addDocumentListener(
                        new DocumentListener() {

                            @Override
                            public void insertUpdate(
                                    DocumentEvent e
                            ) {

                                applyFilters();
                            }

                            @Override
                            public void removeUpdate(
                                    DocumentEvent e
                            ) {

                                applyFilters();
                            }

                            @Override
                            public void changedUpdate(
                                    DocumentEvent e
                            ) {

                                applyFilters();
                            }
                        }
                );

        // ================= STATUS FILTER =================

        statusFilter.addActionListener(
                e -> applyFilters()
        );

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

        // ================= BOTTOM BUTTONS =================

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

        JButton viewButton =
                new JButton("👁 View Complaint");

        JButton editButton =
                new JButton("✏ Edit Complaint");

        JButton updateButton =
                new JButton("🔄 Update Status");

        JButton deleteButton =
                new JButton("🗑 Delete Complaint");

        styleNormalButton(viewButton);
        styleNormalButton(editButton);
        styleNormalButton(updateButton);
        styleDangerButton(deleteButton);

        // ================= VIEW =================

        viewButton.addActionListener(e -> {

            int viewRow =
                    table.getSelectedRow();

            if (viewRow == -1) {

                showWarning(
                        frame,
                        "Please select a complaint first."
                );

                return;
            }

            int selectedRow =
                    table.convertRowIndexToModel(
                            viewRow
                    );

            showComplaintDetails(
                    frame,
                    selectedRow
            );
        });

        // ================= EDIT =================

        editButton.addActionListener(e -> {

            int viewRow =
                    table.getSelectedRow();

            if (viewRow == -1) {

                showWarning(
                        frame,
                        "Please select a complaint first."
                );

                return;
            }

            int selectedRow =
                    table.convertRowIndexToModel(
                            viewRow
                    );

            showEditComplaintDialog(
                    frame,
                    selectedRow
            );
        });

        // ================= UPDATE STATUS =================

        updateButton.addActionListener(e -> {

            int viewRow =
                    table.getSelectedRow();

            if (viewRow == -1) {

                showWarning(
                        frame,
                        "Please select a complaint first."
                );

                return;
            }

            int selectedRow =
                    table.convertRowIndexToModel(
                            viewRow
                    );

            String[] statuses = {
                    "Pending",
                    "In Progress",
                    "Resolved"
            };

            String currentStatus =
                    model.getValueAt(
                            selectedRow,
                            6
                    ).toString();

            String selectedStatus =
                    (String) JOptionPane.showInputDialog(
                            frame,
                            "Select new complaint status:",
                            "Update Status",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            statuses,
                            currentStatus
                    );

            if (selectedStatus != null) {

                model.setValueAt(
                        selectedStatus,
                        selectedRow,
                        6
                );

                JOptionPane.showMessageDialog(
                        frame,
                        "Complaint status updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ================= DELETE =================

        deleteButton.addActionListener(e -> {

            int viewRow =
                    table.getSelectedRow();

            if (viewRow == -1) {

                showWarning(
                        frame,
                        "Please select a complaint first."
                );

                return;
            }

            int selectedRow =
                    table.convertRowIndexToModel(
                            viewRow
                    );

            String complaintId =
                    model.getValueAt(
                            selectedRow,
                            0
                    ).toString();

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete complaint "
                                    + complaintId
                                    + "?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                model.removeRow(selectedRow);

                JOptionPane.showMessageDialog(
                        frame,
                        "Complaint deleted successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ================= ADD =================

        addButton.addActionListener(e -> {

            showAddComplaintDialog(frame);
        });

        buttonPanel.add(viewButton);
        buttonPanel.add(editButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        content.add(buttonPanel);

        // ================= RIGHT PANEL =================

        rightPanel.add(
                new JScrollPane(content),
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
    // APPLY SEARCH + FILTER
    // =========================================================

    private static void applyFilters() {

        String searchText =
                searchField.getText()
                        .trim()
                        .toLowerCase();

        String selectedStatus =
                statusFilter
                        .getSelectedItem()
                        .toString();

        RowFilter<DefaultTableModel, Object> filter =
                new RowFilter<DefaultTableModel, Object>() {

                    @Override
                    public boolean include(
                            Entry<? extends DefaultTableModel, ? extends Object> entry
                    ) {

                        // SEARCH
                        if (!searchText.isEmpty()) {

                            boolean matchesSearch = false;

                            for (int i = 0;
                                 i < entry.getValueCount();
                                 i++) {

                                String value =
                                        entry.getStringValue(i)
                                                .toLowerCase();

                                if (value.contains(searchText)) {

                                    matchesSearch = true;

                                    break;
                                }
                            }

                            if (!matchesSearch) {

                                return false;
                            }
                        }

                        // STATUS FILTER
                        if (!selectedStatus.equals(
                                "All Status"
                        )) {

                            String status =
                                    entry.getStringValue(6);

                            if (!status.equals(
                                    selectedStatus
                            )) {

                                return false;
                            }
                        }

                        return true;
                    }
                };

        sorter.setRowFilter(filter);
    }

    // =========================================================
    // ADD COMPLAINT
    // =========================================================

    private static void showAddComplaintDialog(
            JFrame parent
    ) {

        JDialog dialog =
                new JDialog(
                        parent,
                        "Add Complaint",
                        true
                );

        dialog.setSize(500, 500);

        dialog.setLocationRelativeTo(parent);

        dialog.setResizable(false);

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );

        panel.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(8, 8, 8, 8);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        // ---------- RESIDENT ----------

        JTextField residentField =
                new JTextField();

        // ---------- ROOM ----------

        JTextField roomField =
                new JTextField();

        // ---------- CATEGORY ----------

        JComboBox<String> categoryBox =
                new JComboBox<>(
                        new String[]{
                                "Water",
                                "Maintenance",
                                "Internet",
                                "Cleanliness",
                                "Electricity",
                                "Other"
                        }
                );

        // ---------- COMPLAINT ----------

        JTextArea complaintArea =
                new JTextArea(4, 20);

        complaintArea.setLineWrap(true);

        complaintArea.setWrapStyleWord(true);

        complaintArea.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        JScrollPane complaintScroll =
                new JScrollPane(
                        complaintArea
                );

        // ---------- STATUS ----------

        JComboBox<String> statusBox =
                new JComboBox<>(
                        new String[]{
                                "Pending",
                                "In Progress",
                                "Resolved"
                        }
                );

        // ---------- ADD FIELDS ----------

        addFormRow(
                panel,
                gbc,
                0,
                "Resident Name:",
                residentField
        );

        addFormRow(
                panel,
                gbc,
                1,
                "Room Number:",
                roomField
        );

        addFormRow(
                panel,
                gbc,
                2,
                "Category:",
                categoryBox
        );

        addFormRow(
                panel,
                gbc,
                3,
                "Complaint:",
                complaintScroll
        );

        addFormRow(
                panel,
                gbc,
                4,
                "Status:",
                statusBox
        );

        // ---------- BUTTONS ----------

        JButton saveButton =
                new JButton("Save Complaint");

        JButton cancelButton =
                new JButton("Cancel");

        stylePrimaryButton(saveButton);

        styleNormalButton(cancelButton);

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        buttonPanel.setBackground(WHITE);

        buttonPanel.add(cancelButton);

        buttonPanel.add(saveButton);

        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.gridwidth = 2;

        panel.add(
                buttonPanel,
                gbc
        );

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );

        saveButton.addActionListener(e -> {

            String resident =
                    residentField.getText()
                            .trim();

            String room =
                    roomField.getText()
                            .trim();

            String category =
                    categoryBox
                            .getSelectedItem()
                            .toString();

            String complaint =
                    complaintArea.getText()
                            .trim();

            String status =
                    statusBox
                            .getSelectedItem()
                            .toString();

            // ---------- VALIDATION ----------

            if (resident.isEmpty()) {

                showWarning(
                        dialog,
                        "Please enter resident name."
                );

                return;
            }

            if (room.isEmpty()) {

                showWarning(
                        dialog,
                        "Please enter room number."
                );

                return;
            }

            if (complaint.isEmpty()) {

                showWarning(
                        dialog,
                        "Please enter the complaint."
                );

                return;
            }

            // ---------- ID ----------

            String complaintId =
                    generateComplaintId();

            String date =
                    new SimpleDateFormat(
                            "dd MMM yyyy"
                    ).format(
                            new Date()
                    );

            model.addRow(
                    new Object[]{
                            complaintId,
                            resident,
                            room,
                            category,
                            complaint,
                            date,
                            status
                    }
            );

            dialog.dispose();

            JOptionPane.showMessageDialog(
                    parent,
                    "Complaint added successfully!\nComplaint ID: "
                            + complaintId,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        dialog.add(panel);

        dialog.setVisible(true);
    }

    // =========================================================
    // EDIT COMPLAINT
    // =========================================================

    private static void showEditComplaintDialog(
            JFrame parent,
            int row
    ) {

        JDialog dialog =
                new JDialog(
                        parent,
                        "Edit Complaint",
                        true
                );

        dialog.setSize(500, 500);

        dialog.setLocationRelativeTo(parent);

        dialog.setResizable(false);

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 20, 25
                )
        );

        panel.setLayout(
                new GridBagLayout()
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(8, 8, 8, 8);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        // ---------- EXISTING VALUES ----------

        String resident =
                model.getValueAt(
                        row, 1
                ).toString();

        String room =
                model.getValueAt(
                        row, 2
                ).toString();

        String category =
                model.getValueAt(
                        row, 3
                ).toString();

        String complaint =
                model.getValueAt(
                        row, 4
                ).toString();

        String status =
                model.getValueAt(
                        row, 6
                ).toString();

        // ---------- FIELDS ----------

        JTextField residentField =
                new JTextField(resident);

        JTextField roomField =
                new JTextField(room);

        JComboBox<String> categoryBox =
                new JComboBox<>(
                        new String[]{
                                "Water",
                                "Maintenance",
                                "Internet",
                                "Cleanliness",
                                "Electricity",
                                "Other"
                        }
                );

        categoryBox.setSelectedItem(
                category
        );

        JTextArea complaintArea =
                new JTextArea(
                        complaint,
                        4,
                        20
                );

        complaintArea.setLineWrap(true);

        complaintArea.setWrapStyleWord(true);

        complaintArea.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        JScrollPane complaintScroll =
                new JScrollPane(
                        complaintArea
                );

        JComboBox<String> statusBox =
                new JComboBox<>(
                        new String[]{
                                "Pending",
                                "In Progress",
                                "Resolved"
                        }
                );

        statusBox.setSelectedItem(status);

        // ---------- FORM ----------

        addFormRow(
                panel,
                gbc,
                0,
                "Resident Name:",
                residentField
        );

        addFormRow(
                panel,
                gbc,
                1,
                "Room Number:",
                roomField
        );

        addFormRow(
                panel,
                gbc,
                2,
                "Category:",
                categoryBox
        );

        addFormRow(
                panel,
                gbc,
                3,
                "Complaint:",
                complaintScroll
        );

        addFormRow(
                panel,
                gbc,
                4,
                "Status:",
                statusBox
        );

        // ---------- BUTTONS ----------

        JButton saveButton =
                new JButton("Save Changes");

        JButton cancelButton =
                new JButton("Cancel");

        stylePrimaryButton(saveButton);

        styleNormalButton(cancelButton);

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT
                        )
                );

        buttonPanel.setBackground(WHITE);

        buttonPanel.add(cancelButton);

        buttonPanel.add(saveButton);

        gbc.gridx = 0;

        gbc.gridy = 5;

        gbc.gridwidth = 2;

        panel.add(
                buttonPanel,
                gbc
        );

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );

        saveButton.addActionListener(e -> {

            String newResident =
                    residentField.getText()
                            .trim();

            String newRoom =
                    roomField.getText()
                            .trim();

            String newCategory =
                    categoryBox
                            .getSelectedItem()
                            .toString();

            String newComplaint =
                    complaintArea.getText()
                            .trim();

            String newStatus =
                    statusBox
                            .getSelectedItem()
                            .toString();

            if (newResident.isEmpty()) {

                showWarning(
                        dialog,
                        "Please enter resident name."
                );

                return;
            }

            if (newRoom.isEmpty()) {

                showWarning(
                        dialog,
                        "Please enter room number."
                );

                return;
            }

            if (newComplaint.isEmpty()) {

                showWarning(
                        dialog,
                        "Please enter the complaint."
                );

                return;
            }

            model.setValueAt(
                    newResident,
                    row,
                    1
            );

            model.setValueAt(
                    newRoom,
                    row,
                    2
            );

            model.setValueAt(
                    newCategory,
                    row,
                    3
            );

            model.setValueAt(
                    newComplaint,
                    row,
                    4
            );

            model.setValueAt(
                    newStatus,
                    row,
                    6
            );

            dialog.dispose();

            JOptionPane.showMessageDialog(
                    parent,
                    "Complaint updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        dialog.add(panel);

        dialog.setVisible(true);
    }

    // =========================================================
    // VIEW COMPLAINT
    // =========================================================

    private static void showComplaintDetails(
            JFrame parent,
            int row
    ) {

        String id =
                model.getValueAt(
                        row, 0
                ).toString();

        String resident =
                model.getValueAt(
                        row, 1
                ).toString();

        String room =
                model.getValueAt(
                        row, 2
                ).toString();

        String category =
                model.getValueAt(
                        row, 3
                ).toString();

        String complaint =
                model.getValueAt(
                        row, 4
                ).toString();

        String date =
                model.getValueAt(
                        row, 5
                ).toString();

        String status =
                model.getValueAt(
                        row, 6
                ).toString();

        String message =
                "Complaint ID: " + id
                        + "\n\n"
                        + "Resident: " + resident
                        + "\n"
                        + "Room: " + room
                        + "\n"
                        + "Category: " + category
                        + "\n"
                        + "Complaint: " + complaint
                        + "\n"
                        + "Date: " + date
                        + "\n"
                        + "Status: " + status;

        JOptionPane.showMessageDialog(
                parent,
                message,
                "Complaint Details",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================================================
    // GENERATE COMPLAINT ID
    // =========================================================

    private static String generateComplaintId() {

        int maxId = 0;

        for (int i = 0;
             i < model.getRowCount();
             i++) {

            String id =
                    model.getValueAt(
                            i,
                            0
                    ).toString();

            try {

                int number =
                        Integer.parseInt(
                                id.substring(1)
                        );

                if (number > maxId) {

                    maxId = number;
                }

            } catch (Exception ignored) {
            }
        }

        return String.format(
                "C%03d",
                maxId + 1
        );
    }

    // =========================================================
    // FORM ROW
    // =========================================================

    private static void addFormRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            String labelText,
            Component component
    ) {

        JLabel label =
                new JLabel(labelText);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(TEXT);

        gbc.gridx = 0;

        gbc.gridy = row;

        gbc.gridwidth = 1;

        gbc.weightx = 0.25;

        panel.add(
                label,
                gbc
        );

        gbc.gridx = 1;

        gbc.gridy = row;

        gbc.gridwidth = 1;

        gbc.weightx = 0.75;

        panel.add(
                component,
                gbc
        );
    }

    // =========================================================
    // SIDEBAR BUTTON STYLE
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

    // =========================================================
    // PRIMARY BUTTON STYLE
    // =========================================================

    private static void stylePrimaryButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        button.setForeground(WHITE);

        button.setBackground(PRIMARY);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 18, 10, 18
                )
        );
    }

    // =========================================================
    // NORMAL BUTTON STYLE
    // =========================================================

    private static void styleNormalButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(TEXT);

        button.setBackground(WHITE);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 12, 8, 12
                        )
                )
        );
    }

    // =========================================================
    // DANGER BUTTON STYLE
    // =========================================================

    private static void styleDangerButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(
                new Color(185, 28, 28)
        );

        button.setBackground(WHITE);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(252, 165, 165)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 12, 8, 12
                        )
                )
        );
    }

    // =========================================================
    // WARNING MESSAGE
    // =========================================================

    private static void showWarning(
            Component parent,
            String message
    ) {

        JOptionPane.showMessageDialog(
                parent,
                message,
                "Warning",
                JOptionPane.WARNING_MESSAGE
        );
    }
}