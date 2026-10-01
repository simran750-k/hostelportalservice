package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports {

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
    private static final Color ORANGE = new Color(234, 88, 12);
    private static final Color RED = new Color(220, 38, 38);

    // =========================================================
    // REPORT VALUES
    // Temporary values until database is connected
    // =========================================================

    private static int totalResidents = 120;

    private static int totalRooms = 50;
    private static int occupiedRooms = 42;
    private static int availableRooms = 8;

    private static int totalCapacity = 150;
    private static int currentResidents = 120;

    private static double totalExpectedPayment = 400000;
    private static double collectedPayment = 336000;
    private static double remainingPayment =
            totalExpectedPayment - collectedPayment;

    private static int paidPayments = 42;
    private static int pendingPayments = 8;

    private static int pendingComplaints = 4;
    private static int inProgressComplaints = 2;
    private static int resolvedComplaints = 2;

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

        JFrame frame = new JFrame("Reports");

        frame.setSize(1100, 650);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setResizable(false);

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel =
                new JPanel(new BorderLayout());

        mainPanel.setBackground(LIGHT_BG);

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar = createSidebar(frame);

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
                new JLabel("Reports");

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

        JLabel heading =
                new JLabel("Hostel Reports");

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
                        "Overview of hostel residents, rooms, payments and complaints."
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
                Box.createVerticalStrut(15)
        );

        // =====================================================
        // BUTTON PANEL
        // =====================================================

        JPanel actionPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        actionPanel.setBackground(LIGHT_BG);

        actionPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        40
                )
        );

        actionPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JButton refreshButton =
                new JButton("🔄 Refresh Reports");

        JButton printButton =
                new JButton("🖨 Print Report");

        stylePrimaryButton(refreshButton);

        styleNormalButton(printButton);

        actionPanel.add(printButton);

        actionPanel.add(refreshButton);

        content.add(actionPanel);

        content.add(
                Box.createVerticalStrut(15)
        );

        // =====================================================
        // STAT CARDS
        // =====================================================

        JPanel statsPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                15,
                                0
                        )
                );

        statsPanel.setBackground(LIGHT_BG);

        statsPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        120
                )
        );

        statsPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JPanel residentCard =
                createReportCard(
                        "👥",
                        "Total Residents",
                        String.valueOf(
                                totalResidents
                        ),
                        "Registered residents",
                        PRIMARY
                );

        JPanel roomCard =
                createReportCard(
                        "🛏",
                        "Total Rooms",
                        String.valueOf(
                                totalRooms
                        ),
                        occupiedRooms
                                + " occupied rooms",
                        GREEN
                );

        JPanel paymentCard =
                createReportCard(
                        "💳",
                        "Payments",
                        formatCurrency(
                                collectedPayment
                        ),
                        "Collected this month",
                        PRIMARY
                );

        int totalComplaints =
                pendingComplaints
                        + inProgressComplaints
                        + resolvedComplaints;

        JPanel complaintCard =
                createReportCard(
                        "📝",
                        "Complaints",
                        String.valueOf(
                                totalComplaints
                        ),
                        "Total complaints",
                        ORANGE
                );

        statsPanel.add(residentCard);
        statsPanel.add(roomCard);
        statsPanel.add(paymentCard);
        statsPanel.add(complaintCard);

        content.add(statsPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // LOWER SECTION
        // =====================================================

        JPanel lowerPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                20,
                                0
                        )
                );

        lowerPanel.setBackground(LIGHT_BG);

        lowerPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        270
                )
        );

        lowerPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // =====================================================
        // OCCUPANCY PANEL
        // =====================================================

        JPanel occupancyPanel =
                createWhitePanel();

        JLabel occupancyTitle =
                new JLabel(
                        "Room Occupancy"
                );

        occupancyTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        occupancyTitle.setForeground(TEXT);

        occupancyTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        occupancyPanel.add(occupancyTitle);

        occupancyPanel.add(
                Box.createVerticalStrut(12)
        );

        addReportRow(
                occupancyPanel,
                "Occupied Rooms",
                occupiedRooms + " rooms"
        );

        addReportRow(
                occupancyPanel,
                "Available Rooms",
                availableRooms + " rooms"
        );

        addReportRow(
                occupancyPanel,
                "Total Capacity",
                totalCapacity + " residents"
        );

        addReportRow(
                occupancyPanel,
                "Current Residents",
                currentResidents
                        + " residents"
        );

        occupancyPanel.add(
                Box.createVerticalStrut(12)
        );

        int occupancyPercentage = 0;

        if (totalRooms > 0) {

            occupancyPercentage =
                    (occupiedRooms * 100)
                            / totalRooms;
        }

        JProgressBar occupancyBar =
                new JProgressBar(
                        0,
                        100
                );

        occupancyBar.setValue(
                occupancyPercentage
        );

        occupancyBar.setStringPainted(
                true
        );

        occupancyBar.setString(
                occupancyPercentage
                        + "% Occupied"
        );

        occupancyBar.setForeground(
                PRIMARY
        );

        occupancyBar.setBackground(
                new Color(226, 232, 240)
        );

        occupancyBar.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        occupancyPanel.add(
                occupancyBar
        );

        lowerPanel.add(
                occupancyPanel
        );

        // =====================================================
        // COMPLAINT PANEL
        // =====================================================

        JPanel complaintPanel =
                createWhitePanel();

        JLabel complaintTitle =
                new JLabel(
                        "Complaint Summary"
                );

        complaintTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        complaintTitle.setForeground(TEXT);

        complaintTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        complaintPanel.add(
                complaintTitle
        );

        complaintPanel.add(
                Box.createVerticalStrut(12)
        );

        addReportRow(
                complaintPanel,
                "Pending",
                pendingComplaints
                        + " complaints"
        );

        addReportRow(
                complaintPanel,
                "In Progress",
                inProgressComplaints
                        + " complaints"
        );

        addReportRow(
                complaintPanel,
                "Resolved",
                resolvedComplaints
                        + " complaints"
        );

        addReportRow(
                complaintPanel,
                "Total Complaints",
                totalComplaints
                        + " complaints"
        );

        complaintPanel.add(
                Box.createVerticalStrut(12)
        );

        JLabel complaintInfo =
                new JLabel(
                        "Pending complaints require attention."
                );

        complaintInfo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        complaintInfo.setForeground(
                ORANGE
        );

        complaintInfo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        complaintPanel.add(
                complaintInfo
        );

        lowerPanel.add(
                complaintPanel
        );

        content.add(lowerPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // PAYMENT SUMMARY
        // =====================================================

        JPanel paymentPanel =
                new JPanel(
                        new BorderLayout()
                );

        paymentPanel.setBackground(WHITE);

        paymentPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                15,
                                20,
                                15,
                                20
                        )
                )
        );

        paymentPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        105
                )
        );

        paymentPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel paymentTitle =
                new JLabel(
                        "💳  Monthly Payment Summary"
                );

        paymentTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        paymentTitle.setForeground(TEXT);

        JLabel paymentInfo =
                new JLabel(
                        "Paid: "
                                + paidPayments
                                + "     |     Pending: "
                                + pendingPayments
                                + "     |     Total Expected: "
                                + formatCurrency(
                                totalExpectedPayment
                        )
                );

        paymentInfo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        paymentInfo.setForeground(GRAY);

        JLabel remainingInfo =
                new JLabel(
                        "Collected: "
                                + formatCurrency(
                                collectedPayment
                        )
                                + "     |     Remaining: "
                                + formatCurrency(
                                remainingPayment
                        )
                );

        remainingInfo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        remainingInfo.setForeground(
                remainingPayment > 0
                        ? ORANGE
                        : GREEN
        );

        paymentPanel.add(
                paymentTitle,
                BorderLayout.NORTH
        );

        paymentPanel.add(
                paymentInfo,
                BorderLayout.CENTER
        );

        paymentPanel.add(
                remainingInfo,
                BorderLayout.SOUTH
        );

        content.add(paymentPanel);

        content.add(
                Box.createVerticalStrut(15)
        );

        // =====================================================
        // LAST UPDATED
        // =====================================================

        JLabel lastUpdated =
                new JLabel(
                        "Last updated: "
                                + new SimpleDateFormat(
                                "dd MMM yyyy, hh:mm a"
                        ).format(
                                new Date()
                        )
                );

        lastUpdated.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        lastUpdated.setForeground(GRAY);

        lastUpdated.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(lastUpdated);

        // =====================================================
        // REFRESH ACTION
        // =====================================================

        refreshButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    frame,
                    "Reports refreshed successfully!",
                    "Reports Updated",
                    JOptionPane.INFORMATION_MESSAGE
            );

            frame.dispose();

            Reports.main(null);
        });

        // =====================================================
        // PRINT ACTION
        // =====================================================

        printButton.addActionListener(e -> {

            showPrintPreview(frame);
        });

        // =====================================================
        // RIGHT PANEL
        // =====================================================

        JScrollPane scrollPane =
                new JScrollPane(content);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(15);

        rightPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =====================================================
        // MAIN PANEL
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

        frame.setVisible(true);
    }

    // =========================================================
    // SIDEBAR
    // =========================================================

    private static JPanel createSidebar(
            JFrame frame
    ) {

        JPanel sidebar =
                new JPanel();

        sidebar.setBackground(DARK_BLUE);

        sidebar.setPreferredSize(
                new Dimension(
                        230,
                        650
                )
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        // =====================================================
        // LOGO
        // =====================================================

        JPanel logoPanel =
                new JPanel();

        logoPanel.setBackground(
                DARK_BLUE
        );

        logoPanel.setLayout(
                new BoxLayout(
                        logoPanel,
                        BoxLayout.Y_AXIS
                )
        );

        logoPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        15,
                        25,
                        15
                )
        );

        JLabel logoIcon =
                new JLabel("🏠");

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

        JLabel logoTitle =
                new JLabel("HOSTEL");

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

        JLabel logoSubtitle =
                new JLabel(
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
                new Color(
                        148,
                        163,
                        184
                )
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
        // BUTTONS
        // =====================================================

        JButton dashboardButton =
                createSidebarButton(
                        "🏠  Dashboard"
                );

        JButton residentsButton =
                createSidebarButton(
                        "👥  Residents"
                );

        JButton roomsButton =
                createSidebarButton(
                        "🛏  Rooms"
                );

        JButton paymentsButton =
                createSidebarButton(
                        "💳  Payments"
                );

        JButton complaintsButton =
                createSidebarButton(
                        "📝  Complaints"
                );

        JButton reportsButton =
                createSidebarButton(
                        "📊  Reports"
                );

        JButton notificationsButton =
                createSidebarButton(
                        "🔔  Notifications"
                );

        JButton profileButton =
                createSidebarButton(
                        "👤  Profile"
                );

        JButton logoutButton =
                createSidebarButton(
                        "🚪  Logout"
                );

        // Highlight current page

        reportsButton.setBackground(
                PRIMARY
        );

        reportsButton.setForeground(
                WHITE
        );

        sidebar.add(dashboardButton);
        sidebar.add(residentsButton);
        sidebar.add(roomsButton);
        sidebar.add(paymentsButton);
        sidebar.add(complaintsButton);
        sidebar.add(reportsButton);
        sidebar.add(notificationsButton);
        sidebar.add(profileButton);

        sidebar.add(
                Box.createVerticalGlue()
        );

        sidebar.add(logoutButton);

        sidebar.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // NAVIGATION
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
            // Already on Reports
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

            if (choice ==
                    JOptionPane.YES_OPTION) {

                frame.dispose();

                login.main(null);
            }
        });

        return sidebar;
    }

    // =========================================================
    // REPORT CARD
    // =========================================================

    private static JPanel createReportCard(
            String icon,
            String title,
            String value,
            String description,
            Color accent
    ) {

        JPanel card =
                new JPanel();

        card.setBackground(WHITE);

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                10,
                                15,
                                10,
                                15
                        )
                )
        );

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        24
                )
        );

        iconLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        titleLabel.setForeground(GRAY);

        titleLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        valueLabel.setForeground(accent);

        valueLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel descriptionLabel =
                new JLabel(description);

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        descriptionLabel.setForeground(GRAY);

        descriptionLabel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        card.add(iconLabel);

        card.add(titleLabel);

        card.add(valueLabel);

        card.add(descriptionLabel);

        return card;
    }

    // =========================================================
    // WHITE REPORT PANEL
    // =========================================================

    private static JPanel createWhitePanel() {

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        panel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                18,
                                20,
                                18,
                                20
                        )
                )
        );

        return panel;
    }

    // =========================================================
    // REPORT ROW
    // =========================================================

    private static void addReportRow(
            JPanel panel,
            String label,
            String value
    ) {

        JPanel row =
                new JPanel(
                        new BorderLayout()
                );

        row.setBackground(WHITE);

        row.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        30
                )
        );

        JLabel labelText =
                new JLabel(label);

        labelText.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        labelText.setForeground(GRAY);

        JLabel valueText =
                new JLabel(value);

        valueText.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        valueText.setForeground(TEXT);

        row.add(
                labelText,
                BorderLayout.WEST
        );

        row.add(
                valueText,
                BorderLayout.EAST
        );

        panel.add(row);

        panel.add(
                Box.createVerticalStrut(3)
        );
    }

    // =========================================================
    // CURRENCY FORMAT
    // =========================================================

    private static String formatCurrency(
            double amount
    ) {

        return String.format(
                "Rs. %,.0f",
                amount
        );
    }

    // =========================================================
    // PRIMARY BUTTON
    // =========================================================

    private static void stylePrimaryButton(
            JButton button
    ) {

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        button.setForeground(WHITE);

        button.setBackground(PRIMARY);

        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        8,
                        14,
                        8,
                        14
                )
        );
    }

    // =========================================================
    // NORMAL BUTTON
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
                                7,
                                12,
                                7,
                                12
                        )
                )
        );
    }

    // =========================================================
    // PRINT PREVIEW
    // =========================================================

    private static void showPrintPreview(
            JFrame parent
    ) {

        String report =
                "========================================\n"
                        + "          HOSTEL SERVICE PORTAL\n"
                        + "               REPORT\n"
                        + "========================================\n\n"

                        + "RESIDENT SUMMARY\n"
                        + "Total Residents: "
                        + totalResidents
                        + "\n\n"

                        + "ROOM SUMMARY\n"
                        + "Total Rooms: "
                        + totalRooms
                        + "\n"
                        + "Occupied Rooms: "
                        + occupiedRooms
                        + "\n"
                        + "Available Rooms: "
                        + availableRooms
                        + "\n"
                        + "Total Capacity: "
                        + totalCapacity
                        + "\n"
                        + "Current Residents: "
                        + currentResidents
                        + "\n\n"

                        + "PAYMENT SUMMARY\n"
                        + "Total Expected: "
                        + formatCurrency(
                        totalExpectedPayment
                )
                        + "\n"
                        + "Collected: "
                        + formatCurrency(
                        collectedPayment
                )
                        + "\n"
                        + "Remaining: "
                        + formatCurrency(
                        remainingPayment
                )
                        + "\n"
                        + "Paid Payments: "
                        + paidPayments
                        + "\n"
                        + "Pending Payments: "
                        + pendingPayments
                        + "\n\n"

                        + "COMPLAINT SUMMARY\n"
                        + "Pending: "
                        + pendingComplaints
                        + "\n"
                        + "In Progress: "
                        + inProgressComplaints
                        + "\n"
                        + "Resolved: "
                        + resolvedComplaints
                        + "\n\n"

                        + "Generated: "
                        + new SimpleDateFormat(
                        "dd MMM yyyy, hh:mm a"
                ).format(
                        new Date()
                )
                        + "\n"
                        + "========================================";

        JTextArea textArea =
                new JTextArea(report);

        textArea.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        13
                )
        );

        textArea.setEditable(false);

        textArea.setBackground(WHITE);

        JScrollPane scrollPane =
                new JScrollPane(textArea);

        scrollPane.setPreferredSize(
                new Dimension(
                        550,
                        450
                )
        );

        JOptionPane.showMessageDialog(
                parent,
                scrollPane,
                "Report Preview",
                JOptionPane.INFORMATION_MESSAGE
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
                new Color(
                        203,
                        213,
                        225
                )
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