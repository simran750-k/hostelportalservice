package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.regex.Pattern;

public class ResidentManagement {

    // ==============================
    // COLORS
    // ==============================

    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color GREEN = new Color(22, 163, 74);
    private static final Color RED = new Color(220, 38, 38);
    private static final Color BORDER = new Color(226, 232, 240);

    public static void main(String[] args) {

        // ==============================
        // LOOK AND FEEL
        // ==============================

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Resident Management");

        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ==============================
        // MAIN PANEL
        // ==============================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // ==============================
        // SIDEBAR
        // ==============================

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);
        sidebar.setPreferredSize(new Dimension(230, 650));

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        // ==============================
        // LOGO
        // ==============================

        JPanel logoPanel = new JPanel();

        logoPanel.setBackground(DARK_BLUE);

        logoPanel.setLayout(
                new BoxLayout(
                        logoPanel,
                        BoxLayout.Y_AXIS
                )
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

        logoIcon.setForeground(WHITE);
        logoIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoTitle = new JLabel("HOSTEL");

        logoTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        logoTitle.setForeground(WHITE);
        logoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoSubtitle = new JLabel("SERVICE PORTAL");

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

        // ==============================
        // SIDEBAR BUTTONS
        // ==============================

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

        // ==============================
        // RIGHT SIDE
        // ==============================

        JPanel rightPanel = new JPanel(
                new BorderLayout()
        );

        rightPanel.setBackground(LIGHT_BG);

        // ==============================
        // TOP BAR
        // ==============================

        JPanel topBar = new JPanel(
                new BorderLayout()
        );

        topBar.setBackground(WHITE);

        topBar.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 15, 25
                )
        );

        JLabel pageTitle = new JLabel(
                "Resident Management"
        );

        pageTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        pageTitle.setForeground(TEXT);

        JLabel adminLabel = new JLabel(
                "👤  Admin"
        );

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

        // ==============================
        // CONTENT
        // ==============================

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

        // ==============================
        // HEADING
        // ==============================

        JLabel heading = new JLabel(
                "Manage Residents"
        );

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

        JLabel subtitle = new JLabel(
                "View and manage all hostel residents."
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

        // ==============================
        // SEARCH + ADD BUTTON
        // ==============================

        JPanel actionPanel = new JPanel(
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

        // ==============================
        // SEARCH FIELD
        // ==============================

        JTextField searchField = new JTextField();

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        searchField.setPreferredSize(
                new Dimension(350, 40)
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(203, 213, 225)
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        searchField.setToolTipText(
                "Search by ID, name, username, email, room or status"
        );

        actionPanel.add(
                searchField,
                BorderLayout.WEST
        );

        // ==============================
        // ADD BUTTON
        // ==============================

        JButton addButton = new JButton(
                "＋  Add Resident"
        );

        addButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        addButton.setForeground(WHITE);
        addButton.setBackground(PRIMARY);
        addButton.setFocusPainted(false);

        addButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 20
                )
        );

        actionPanel.add(
                addButton,
                BorderLayout.EAST
        );

        content.add(actionPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // ==============================
        // TABLE DATA
        // ==============================

        String[] columns = {
                "ID",
                "Name",
                "Username",
                "Email",
                "Room",
                "Status"
        };

        Object[][] data = {

                {
                        "R001",
                        "John Doe",
                        "john123",
                        "john@gmail.com",
                        "204",
                        "Active"
                },

                {
                        "R002",
                        "Alex Smith",
                        "alex123",
                        "alex@gmail.com",
                        "205",
                        "Active"
                },

                {
                        "R003",
                        "Michael Brown",
                        "michael123",
                        "michael@gmail.com",
                        "206",
                        "Active"
                },

                {
                        "R004",
                        "Sarah Wilson",
                        "sarah123",
                        "sarah@gmail.com",
                        "207",
                        "Inactive"
                },

                {
                        "R005",
                        "Emma Davis",
                        "emma123",
                        "emma@gmail.com",
                        "208",
                        "Active"
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

        JTable table = new JTable(model);

        // ==============================
        // TABLE DESIGN
        // ==============================

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        table.setRowHeight(40);

        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        table.setGridColor(BORDER);

        table.setBackground(WHITE);

        table.setForeground(TEXT);

        table.setSelectionBackground(
                new Color(219, 234, 254)
        );

        table.setSelectionForeground(TEXT);

        // ==============================
        // TABLE HEADER
        // ==============================

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        table.getTableHeader().setBackground(
                new Color(226, 232, 240)
        );

        table.getTableHeader().setForeground(TEXT);

        table.getTableHeader().setPreferredSize(
                new Dimension(0, 40)
        );

        // ==============================
        // COLUMN WIDTHS
        // ==============================

        table.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(60);

        table.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(130);

        table.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(120);

        table.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(180);

        table.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(70);

        table.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(90);

        // ==============================
        // SEARCH FUNCTIONALITY
        // ==============================

        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(model);

        table.setRowSorter(sorter);

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

        // ==============================
        // TABLE SCROLL PANE
        // ==============================

        JScrollPane tableScrollPane =
                new JScrollPane(table);

        tableScrollPane.setBackground(WHITE);

        tableScrollPane.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        tableScrollPane.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(tableScrollPane);

        content.add(
                Box.createVerticalStrut(15)
        );

        // ==============================
        // BOTTOM BUTTONS
        // ==============================

        JPanel buttonPanel = new JPanel(
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

        JButton editButton = new JButton(
                "✏  Edit Resident"
        );

        JButton deleteButton = new JButton(
                "🗑  Delete Resident"
        );

        editButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);

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

        editButton.setForeground(
                WHITE
        );

        editButton.setBackground(
                GREEN
        );

        deleteButton.setForeground(
                WHITE
        );

        deleteButton.setBackground(
                RED
        );

        editButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 18, 10, 18
                )
        );

        deleteButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 18, 10, 18
                )
        );

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        content.add(buttonPanel);

        // ==============================
        // ADD RESIDENT
        // ==============================

        addButton.addActionListener(e -> {

            JTextField nameField =
                    new JTextField();

            JTextField usernameField =
                    new JTextField();

            JTextField emailField =
                    new JTextField();

            JTextField roomField =
                    new JTextField();

            JComboBox<String> statusBox =
                    new JComboBox<>(
                            new String[]{
                                    "Active",
                                    "Inactive"
                            }
                    );

            JPanel form = new JPanel(
                    new GridLayout(
                            5,
                            2,
                            10,
                            10
                    )
            );

            form.setBorder(
                    BorderFactory.createEmptyBorder(
                            10,
                            10,
                            10,
                            10
                    )
            );

            form.add(new JLabel("Name:"));
            form.add(nameField);

            form.add(new JLabel("Username:"));
            form.add(usernameField);

            form.add(new JLabel("Email:"));
            form.add(emailField);

            form.add(new JLabel("Room:"));
            form.add(roomField);

            form.add(new JLabel("Status:"));
            form.add(statusBox);

            int result =
                    JOptionPane.showConfirmDialog(
                            frame,
                            form,
                            "Add Resident",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                    );

            if (result ==
                    JOptionPane.OK_OPTION) {

                String name =
                        nameField.getText().trim();

                String username =
                        usernameField
                                .getText()
                                .trim();

                String email =
                        emailField
                                .getText()
                                .trim();

                String room =
                        roomField
                                .getText()
                                .trim();

                String status =
                        statusBox
                                .getSelectedItem()
                                .toString();

                if (name.isEmpty()
                        || username.isEmpty()
                        || email.isEmpty()
                        || room.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields.",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                String id =
                        String.format(
                                "R%03d",
                                model.getRowCount() + 1
                        );

                model.addRow(
                        new Object[]{
                                id,
                                name,
                                username,
                                email,
                                room,
                                status
                        }
                );

                JOptionPane.showMessageDialog(
                        frame,
                        "Resident added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ==============================
        // EDIT RESIDENT
        // ==============================

        editButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a resident first.",
                        "No Resident Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            JTextField nameField =
                    new JTextField(
                            model.getValueAt(
                                    modelRow,
                                    1
                            ).toString()
                    );

            JTextField usernameField =
                    new JTextField(
                            model.getValueAt(
                                    modelRow,
                                    2
                            ).toString()
                    );

            JTextField emailField =
                    new JTextField(
                            model.getValueAt(
                                    modelRow,
                                    3
                            ).toString()
                    );

            JTextField roomField =
                    new JTextField(
                            model.getValueAt(
                                    modelRow,
                                    4
                            ).toString()
                    );

            JComboBox<String> statusBox =
                    new JComboBox<>(
                            new String[]{
                                    "Active",
                                    "Inactive"
                            }
                    );

            statusBox.setSelectedItem(
                    model.getValueAt(
                            modelRow,
                            5
                    ).toString()
            );

            JPanel form = new JPanel(
                    new GridLayout(
                            5,
                            2,
                            10,
                            10
                    )
            );

            form.setBorder(
                    BorderFactory.createEmptyBorder(
                            10,
                            10,
                            10,
                            10
                    )
            );

            form.add(new JLabel("Name:"));
            form.add(nameField);

            form.add(new JLabel("Username:"));
            form.add(usernameField);

            form.add(new JLabel("Email:"));
            form.add(emailField);

            form.add(new JLabel("Room:"));
            form.add(roomField);

            form.add(new JLabel("Status:"));
            form.add(statusBox);

            int result =
                    JOptionPane.showConfirmDialog(
                            frame,
                            form,
                            "Edit Resident",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE
                    );

            if (result ==
                    JOptionPane.OK_OPTION) {

                if (nameField.getText()
                        .trim()
                        .isEmpty()
                        || usernameField.getText()
                        .trim()
                        .isEmpty()
                        || emailField.getText()
                        .trim()
                        .isEmpty()
                        || roomField.getText()
                        .trim()
                        .isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill all fields.",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE
                    );

                    return;
                }

                model.setValueAt(
                        nameField.getText().trim(),
                        modelRow,
                        1
                );

                model.setValueAt(
                        usernameField.getText().trim(),
                        modelRow,
                        2
                );

                model.setValueAt(
                        emailField.getText().trim(),
                        modelRow,
                        3
                );

                model.setValueAt(
                        roomField.getText().trim(),
                        modelRow,
                        4
                );

                model.setValueAt(
                        statusBox.getSelectedItem(),
                        modelRow,
                        5
                );

                JOptionPane.showMessageDialog(
                        frame,
                        "Resident updated successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ==============================
        // DELETE RESIDENT
        // ==============================

        deleteButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a resident first.",
                        "No Resident Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            String residentName =
                    model.getValueAt(
                            modelRow,
                            1
                    ).toString();

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete "
                                    + residentName
                                    + "?",
                            "Delete Resident",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                model.removeRow(modelRow);

                JOptionPane.showMessageDialog(
                        frame,
                        "Resident deleted successfully!",
                        "Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // ==============================
        // ADD CONTENT
        // ==============================

        rightPanel.add(
                new JScrollPane(content),
                BorderLayout.CENTER
        );

        // ==============================
        // MAIN PANEL
        // ==============================

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );

        frame.add(mainPanel);

        // =========================================================
        // SIDEBAR NAVIGATION
        // =========================================================

        // Dashboard
        dashboardButton.addActionListener(e -> {

            admindashboard.main(null);
            frame.dispose();

        });

        // Residents
        residentButton.addActionListener(e -> {

            // Already on Resident Management

        });

        // Rooms
        roomButton.addActionListener(e -> {

            RoomManagement.main(null);
            frame.dispose();

        });

        // Payments
        paymentButton.addActionListener(e -> {

            PaymentManagement.main(null);
            frame.dispose();

        });

        // Complaints
        complaintButton.addActionListener(e -> {

            ComplaintManagement.main(null);
            frame.dispose();

        });

        // Reports
        reportButton.addActionListener(e -> {

            Reports.main(null);
            frame.dispose();

        });

        // Notifications
        notificationButton.addActionListener(e -> {

            AdminNotifications.main(null);
            frame.dispose();

        });

        // Profile
        profileButton.addActionListener(e -> {

            AdminProfile.main(null);
            frame.dispose();

        });

        // Logout
        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                login.main(null);
                frame.dispose();

            }
        });

        // ==============================
        // SHOW FRAME
        // ==============================

        frame.setVisible(true);
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

        button.setBackground(
                DARK_BLUE
        );

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        12,
                        20,
                        12,
                        10
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