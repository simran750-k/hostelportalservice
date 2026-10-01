package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminNotifications {

    // =========================================================
    // COLORS
    // =========================================================

    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color BORDER = new Color(226, 232, 240);
    private static final Color GREEN = new Color(22, 163, 74);
    private static final Color RED = new Color(220, 38, 38);
    private static final Color ORANGE = new Color(234, 88, 12);

    // =========================================================
    // TABLE
    // =========================================================

    private static JTable notificationTable;
    private static DefaultTableModel tableModel;
    private static JLabel unreadCountLabel;
    private static TableRowSorter<DefaultTableModel> sorter;

    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Admin Notifications");

        frame.setSize(1150, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);
        sidebar.setPreferredSize(new Dimension(230, 680));

        sidebar.setLayout(
                new BoxLayout(sidebar, BoxLayout.Y_AXIS)
        );

        // -----------------------------------------------------
        // LOGO
        // -----------------------------------------------------

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
        logoPanel.add(
                Box.createVerticalStrut(5)
        );
        logoPanel.add(logoTitle);
        logoPanel.add(logoSubtitle);

        sidebar.add(logoPanel);

        // =====================================================
        // SIDEBAR BUTTONS
        // =====================================================

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

        JButton notificationButton =
                createSidebarButton("🔔  Notifications");

        JButton profileButton =
                createSidebarButton("👤  Profile");

        notificationButton.setBackground(PRIMARY);
        notificationButton.setForeground(WHITE);

        sidebar.add(dashboardButton);
        sidebar.add(residentsButton);
        sidebar.add(roomsButton);
        sidebar.add(paymentsButton);
        sidebar.add(complaintsButton);
        sidebar.add(reportsButton);
        sidebar.add(notificationButton);
        sidebar.add(profileButton);

        sidebar.add(
                Box.createVerticalGlue()
        );

        JButton logoutButton =
                createSidebarButton("🚪  Logout");

        sidebar.add(logoutButton);

        sidebar.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // RIGHT PANEL
        // =====================================================

        JPanel rightPanel = new JPanel(
                new BorderLayout()
        );

        rightPanel.setBackground(LIGHT_BG);

        // =====================================================
        // TOP BAR
        // =====================================================

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
                "Notifications"
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

        // =====================================================
        // CONTENT
        // =====================================================

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

        // =====================================================
        // HEADING
        // =====================================================

        JPanel headingPanel = new JPanel(
                new BorderLayout()
        );

        headingPanel.setBackground(LIGHT_BG);

        headingPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        65
                )
        );

        headingPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JPanel headingText = new JPanel();

        headingText.setBackground(LIGHT_BG);

        headingText.setLayout(
                new BoxLayout(
                        headingText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel heading = new JLabel(
                "Admin Notifications"
        );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        26
                )
        );

        heading.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "Stay updated with important hostel activities."
        );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(GRAY);

        headingText.add(heading);

        headingText.add(
                Box.createVerticalStrut(3)
        );

        headingText.add(subtitle);

        headingPanel.add(
                headingText,
                BorderLayout.WEST
        );

        // -----------------------------------------------------
        // UNREAD COUNT
        // -----------------------------------------------------

        unreadCountLabel = new JLabel();

        unreadCountLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        unreadCountLabel.setForeground(PRIMARY);

        headingPanel.add(
                unreadCountLabel,
                BorderLayout.EAST
        );

        content.add(headingPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // SEARCH + BUTTON PANEL
        // =====================================================

        JPanel controlPanel = new JPanel(
                new BorderLayout(10, 0)
        );

        controlPanel.setBackground(LIGHT_BG);

        controlPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        controlPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // Search field

        JTextField searchField =
                new JTextField();

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 12, 8, 12
                        )
                )
        );

        searchField.setToolTipText(
                "Search notifications..."
        );

        controlPanel.add(
                searchField,
                BorderLayout.CENTER
        );

        // -----------------------------------------------------
        // BUTTON PANEL
        // -----------------------------------------------------

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        8,
                        0
                )
        );

        buttonPanel.setBackground(LIGHT_BG);

        JButton markReadButton =
                createActionButton(
                        "✓ Mark as Read",
                        PRIMARY
                );

        JButton viewButton =
                createActionButton(
                        "👁 View",
                        GREEN
                );

        JButton deleteButton =
                createActionButton(
                        "🗑 Delete",
                        RED
                );

        JButton markAllButton =
                createActionButton(
                        "✓ Mark All",
                        ORANGE
                );

        buttonPanel.add(markReadButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(markAllButton);

        controlPanel.add(
                buttonPanel,
                BorderLayout.EAST
        );

        content.add(controlPanel);

        content.add(
                Box.createVerticalStrut(15)
        );

        // =====================================================
        // TABLE
        // =====================================================

        String[] columns = {
                "ID",
                "Type",
                "Notification",
                "Message",
                "Date & Time",
                "Status"
        };

        tableModel = new DefaultTableModel(
                columns,
                0
        ) {

            @Override
            public boolean isCellEditable(
                    int row,
                    int column
            ) {
                return false;
            }
        };

        notificationTable =
                new JTable(tableModel);

        notificationTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        notificationTable.setRowHeight(48);

        notificationTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        notificationTable.setShowGrid(false);

        notificationTable.setIntercellSpacing(
                new Dimension(0, 0)
        );

        notificationTable.setBackground(WHITE);

        notificationTable.setForeground(TEXT);

        notificationTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                12
                        )
                );

        notificationTable.getTableHeader()
                .setBackground(
                        new Color(226, 232, 240)
                );

        notificationTable.getTableHeader()
                .setForeground(TEXT);

        notificationTable.getTableHeader()
                .setPreferredSize(
                        new Dimension(0, 40)
                );

        // Column widths

        notificationTable.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(45);

        notificationTable.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(90);

        notificationTable.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(160);

        notificationTable.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(350);

        notificationTable.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(130);

        notificationTable.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(80);

        // =====================================================
        // SAMPLE DATA
        // =====================================================

        addNotification(
                "N001",
                "Payment",
                "Payment Received",
                "Payment of Rs. 8,000 received from John Doe (Room 204).",
                "Today • 10:30 AM",
                "UNREAD"
        );

        addNotification(
                "N002",
                "Complaint",
                "New Complaint Submitted",
                "Alex Smith from Room 205 submitted a room maintenance complaint.",
                "Today • 09:15 AM",
                "UNREAD"
        );

        addNotification(
                "N003",
                "Resident",
                "New Resident Registered",
                "Emma Davis has been successfully registered as a new resident.",
                "Yesterday • 04:20 PM",
                "READ"
        );

        addNotification(
                "N004",
                "System",
                "Hostel Announcement",
                "Monthly hostel maintenance will be conducted this weekend.",
                "2 days ago",
                "READ"
        );

        addNotification(
                "N005",
                "Room",
                "Room Assignment Updated",
                "Room 206 has been assigned to Michael Brown.",
                "3 days ago",
                "READ"
        );

        // =====================================================
        // SORTER
        // =====================================================

        sorter =
                new TableRowSorter<>(
                        tableModel
                );

        notificationTable.setRowSorter(sorter);

        JScrollPane tableScrollPane =
                new JScrollPane(
                        notificationTable
                );

        tableScrollPane.setBorder(
                BorderFactory.createLineBorder(
                        BORDER
                )
        );

        tableScrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        content.add(tableScrollPane);

        // =====================================================
        // SEARCH ACTION
        // =====================================================

        searchField.getDocument()
                .addDocumentListener(
                        new javax.swing.event.DocumentListener() {

                            private void search() {

                                String text =
                                        searchField
                                                .getText()
                                                .trim();

                                if (text.isEmpty()) {

                                    sorter.setRowFilter(null);

                                } else {

                                    sorter.setRowFilter(
                                            RowFilter.regexFilter(
                                                    "(?i)"
                                                            + java.util.regex.Pattern
                                                            .quote(text)
                                            )
                                    );
                                }
                            }

                            @Override
                            public void insertUpdate(
                                    javax.swing.event.DocumentEvent e
                            ) {
                                search();
                            }

                            @Override
                            public void removeUpdate(
                                    javax.swing.event.DocumentEvent e
                            ) {
                                search();
                            }

                            @Override
                            public void changedUpdate(
                                    javax.swing.event.DocumentEvent e
                            ) {
                                search();
                            }
                        }
                );

        // =====================================================
        // MARK SELECTED AS READ
        // =====================================================

        markReadButton.addActionListener(e -> {

            int selectedRow =
                    notificationTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a notification first.",
                        "No Selection",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    notificationTable
                            .convertRowIndexToModel(
                                    selectedRow
                            );

            tableModel.setValueAt(
                    "READ",
                    modelRow,
                    5
            );

            updateUnreadCount();

            JOptionPane.showMessageDialog(
                    frame,
                    "Notification marked as read.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =====================================================
        // VIEW NOTIFICATION
        // =====================================================

        viewButton.addActionListener(e -> {

            int selectedRow =
                    notificationTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a notification first.",
                        "No Selection",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    notificationTable
                            .convertRowIndexToModel(
                                    selectedRow
                            );

            String id =
                    tableModel
                            .getValueAt(
                                    modelRow,
                                    0
                            )
                            .toString();

            String type =
                    tableModel
                            .getValueAt(
                                    modelRow,
                                    1
                            )
                            .toString();

            String title =
                    tableModel
                            .getValueAt(
                                    modelRow,
                                    2
                            )
                            .toString();

            String message =
                    tableModel
                            .getValueAt(
                                    modelRow,
                                    3
                            )
                            .toString();

            String date =
                    tableModel
                            .getValueAt(
                                    modelRow,
                                    4
                            )
                            .toString();

            JOptionPane.showMessageDialog(
                    frame,
                    "Notification ID: " + id
                            + "\nType: " + type
                            + "\n\n"
                            + title
                            + "\n\n"
                            + message
                            + "\n\nDate & Time: "
                            + date,
                    "Notification Details",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // Automatically mark as read
            tableModel.setValueAt(
                    "READ",
                    modelRow,
                    5
            );

            updateUnreadCount();
        });

        // =====================================================
        // DELETE NOTIFICATION
        // =====================================================

        deleteButton.addActionListener(e -> {

            int selectedRow =
                    notificationTable.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a notification first.",
                        "No Selection",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    notificationTable
                            .convertRowIndexToModel(
                                    selectedRow
                            );

            String title =
                    tableModel
                            .getValueAt(
                                    modelRow,
                                    2
                            )
                            .toString();

            int confirm =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete:\n\n"
                                    + title
                                    + "?",
                            "Delete Notification",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

            if (confirm ==
                    JOptionPane.YES_OPTION) {

                tableModel.removeRow(
                        modelRow
                );

                updateUnreadCount();

                JOptionPane.showMessageDialog(
                        frame,
                        "Notification deleted successfully.",
                        "Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        // =====================================================
        // MARK ALL AS READ
        // =====================================================

        markAllButton.addActionListener(e -> {

            if (getUnreadCount() == 0) {

                JOptionPane.showMessageDialog(
                        frame,
                        "There are no unread notifications.",
                        "Notifications",
                        JOptionPane.INFORMATION_MESSAGE
                );

                return;
            }

            for (
                    int i = 0;
                    i < tableModel.getRowCount();
                    i++
            ) {

                tableModel.setValueAt(
                        "READ",
                        i,
                        5
                );
            }

            updateUnreadCount();

            JOptionPane.showMessageDialog(
                    frame,
                    "All notifications have been marked as read.",
                    "Notifications",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =====================================================
        // SIDEBAR NAVIGATION
        // =====================================================

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

            frame.dispose();
            ComplaintManagement.main(null);

        });

        reportsButton.addActionListener(e -> {

            frame.dispose();
            Reports.main(null);

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
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                frame.dispose();
                login.main(null);
            }
        });

        // =====================================================
        // ADD TO FRAME
        // =====================================================

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightPanel,
                BorderLayout.CENTER
        );

        frame.add(mainPanel);

        // Update unread count

        updateUnreadCount();

        frame.setVisible(true);
    }

    // =========================================================
    // ADD NOTIFICATION
    // =========================================================

    private static void addNotification(
            String id,
            String type,
            String title,
            String message,
            String date,
            String status
    ) {

        tableModel.addRow(
                new Object[]{
                        id,
                        type,
                        title,
                        message,
                        date,
                        status
                }
        );
    }

    // =========================================================
    // GET UNREAD COUNT
    // =========================================================

    private static int getUnreadCount() {

        int count = 0;

        for (
                int i = 0;
                i < tableModel.getRowCount();
                i++
        ) {

            String status =
                    tableModel
                            .getValueAt(
                                    i,
                                    5
                            )
                            .toString();

            if (status.equals("UNREAD")) {
                count++;
            }
        }

        return count;
    }

    // =========================================================
    // UPDATE UNREAD COUNT
    // =========================================================

    private static void updateUnreadCount() {

        int unread =
                getUnreadCount();

        if (unread == 0) {

            unreadCountLabel.setText(
                    "✓ All notifications are read"
            );

            unreadCountLabel.setForeground(
                    GREEN
            );

        } else {

            unreadCountLabel.setText(
                    "🔔 " + unread
                            + " unread notification"
                            + (unread > 1 ? "s" : "")
            );

            unreadCountLabel.setForeground(
                    PRIMARY
            );
        }
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private static JButton createActionButton(
            String text,
            Color color
    ) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        button.setForeground(color);

        button.setBackground(WHITE);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                7, 10, 7, 10
                        )
                )
        );

        return button;
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