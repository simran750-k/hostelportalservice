package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Notifications {

    // ================= COLORS =================

    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color GREEN = new Color(22, 163, 74);
    private static final Color ORANGE = new Color(234, 88, 12);
    private static final Color RED = new Color(220, 38, 38);

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

        JFrame frame = new JFrame("Notifications");

        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // =========================================================
        // MAIN PANEL
        // =========================================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // =========================================================
        // SIDEBAR
        // =========================================================

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);

        sidebar.setPreferredSize(
                new Dimension(230, 650)
        );

        sidebar.setLayout(
                new BoxLayout(
                        sidebar,
                        BoxLayout.Y_AXIS
                )
        );

        sidebar.setBorder(
                new EmptyBorder(
                        35, 20, 25, 20
                )
        );

        // ================= LOGO =================

        JLabel logo = new JLabel("🏠");

        logo.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        40
                )
        );

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(logo);

        sidebar.add(
                Box.createVerticalStrut(10)
        );

        // ================= PORTAL NAME =================

        JLabel portalName = new JLabel("HOSTEL");

        portalName.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        portalName.setForeground(WHITE);

        portalName.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(portalName);

        JLabel portalName2 =
                new JLabel("SERVICE PORTAL");

        portalName2.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        portalName2.setForeground(
                new Color(147, 197, 253)
        );

        portalName2.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        sidebar.add(portalName2);

        sidebar.add(
                Box.createVerticalStrut(45)
        );

        // =========================================================
        // SIDEBAR BUTTONS
        // =========================================================

        JButton dashboardButton =
                createSidebarButton(
                        "🏠   Dashboard"
                );

        JButton roomButton =
                createSidebarButton(
                        "🛏   My Room"
                );

        JButton paymentButton =
                createSidebarButton(
                        "💳   Payment"
                );

        JButton complaintButton =
                createSidebarButton(
                        "📝   Complaint"
                );

        JButton notificationButton =
                createSidebarButton(
                        "🔔   Notifications"
                );

        JButton profileButton =
                createSidebarButton(
                        "👤   Profile"
                );

        JButton logoutButton =
                createSidebarButton(
                        "🚪   Logout"
                );

        // Current page

        notificationButton.setBackground(
                PRIMARY
        );

        // =========================================================
        // ADD BUTTONS
        // =========================================================

        sidebar.add(dashboardButton);

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(roomButton);

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(paymentButton);

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(complaintButton);

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(notificationButton);

        sidebar.add(
                Box.createVerticalStrut(8)
        );

        sidebar.add(profileButton);

        sidebar.add(
                Box.createVerticalGlue()
        );

        sidebar.add(logoutButton);

        // =========================================================
        // SIDEBAR NAVIGATION
        // =========================================================

        dashboardButton.addActionListener(e -> {

            frame.dispose();

            residentdashboard.main(null);
        });

        roomButton.addActionListener(e -> {

            frame.dispose();

            RoomDetails.main(null);
        });

        paymentButton.addActionListener(e -> {

            frame.dispose();

            Payment.main(null);
        });

        complaintButton.addActionListener(e -> {

            frame.dispose();

            Complaint.main(null);
        });

        profileButton.addActionListener(e -> {

            frame.dispose();

            Profile.main(null);
        });

        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice == JOptionPane.YES_OPTION) {

                frame.dispose();

                login.main(null);
            }
        });

        // =========================================================
        // RIGHT SIDE
        // =========================================================

        JPanel rightSide =
                new JPanel(
                        new BorderLayout()
                );

        rightSide.setBackground(
                LIGHT_BG
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        JPanel topBar =
                new JPanel(
                        new BorderLayout()
                );

        topBar.setBackground(WHITE);

        topBar.setPreferredSize(
                new Dimension(870, 70)
        );

        topBar.setBorder(
                new EmptyBorder(
                        15, 30, 15, 30
                )
        );

        JLabel pageTitle =
                new JLabel(
                        "Notifications"
                );

        pageTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        pageTitle.setForeground(TEXT);

        JLabel user =
                new JLabel(
                        "👤  Resident"
                );

        user.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        user.setForeground(TEXT);

        topBar.add(
                pageTitle,
                BorderLayout.WEST
        );

        topBar.add(
                user,
                BorderLayout.EAST
        );

        // =========================================================
        // CONTENT
        // =========================================================

        JPanel content =
                new JPanel();

        content.setBackground(
                LIGHT_BG
        );

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        content.setBorder(
                new EmptyBorder(
                        22, 30, 20, 30
                )
        );

        // =========================================================
        // HEADING
        // =========================================================

        JPanel headingPanel =
                new JPanel(
                        new BorderLayout()
                );

        headingPanel.setBackground(
                LIGHT_BG
        );

        headingPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel heading =
                new JLabel(
                        "My Notifications"
                );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        heading.setForeground(TEXT);

        JLabel unread =
                new JLabel(
                        "3 Unread"
                );

        unread.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        unread.setForeground(WHITE);

        unread.setOpaque(true);

        unread.setBackground(
                ORANGE
        );

        unread.setBorder(
                new EmptyBorder(
                        6, 12, 6, 12
                )
        );

        headingPanel.add(
                heading,
                BorderLayout.WEST
        );

        headingPanel.add(
                unread,
                BorderLayout.EAST
        );

        content.add(
                headingPanel
        );

        content.add(
                Box.createVerticalStrut(5)
        );

        JLabel subtitle =
                new JLabel(
                        "Stay updated with important hostel announcements and messages."
                );

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
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

        // =========================================================
        // NOTIFICATION 1
        // =========================================================

        JPanel notification1 =
                createNotificationCard(
                        "💰",
                        "Payment Reminder",
                        "Your hostel fee payment of Rs. 2,000 is still remaining.",
                        "30 Sep 2026 • 10:30 AM",
                        ORANGE,
                        true
                );

        content.add(notification1);

        content.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // NOTIFICATION 2
        // =========================================================

        JPanel notification2 =
                createNotificationCard(
                        "🛠",
                        "Complaint Update",
                        "Your complaint about the room light has been resolved.",
                        "29 Sep 2026 • 04:15 PM",
                        GREEN,
                        true
                );

        content.add(notification2);

        content.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // NOTIFICATION 3
        // =========================================================

        JPanel notification3 =
                createNotificationCard(
                        "📢",
                        "Hostel Announcement",
                        "Hostel inspection will be conducted on 5 October 2026.",
                        "28 Sep 2026 • 09:00 AM",
                        PRIMARY,
                        true
                );

        content.add(notification3);

        content.add(
                Box.createVerticalStrut(10)
        );

        // =========================================================
        // NOTIFICATION 4
        // =========================================================

        JPanel notification4 =
                createNotificationCard(
                        "🧹",
                        "Cleaning Schedule",
                        "Common area cleaning will be carried out every Saturday.",
                        "25 Sep 2026 • 11:20 AM",
                        GRAY,
                        false
                );

        content.add(notification4);

        content.add(
                Box.createVerticalStrut(15)
        );

        // =========================================================
        // BOTTOM BUTTONS
        // =========================================================

        JPanel actionPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        actionPanel.setBackground(
                LIGHT_BG
        );

        actionPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JButton markAllButton =
                new JButton(
                        "✓  Mark All as Read"
                );

        markAllButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        markAllButton.setForeground(
                PRIMARY
        );

        markAllButton.setBackground(
                WHITE
        );

        markAllButton.setFocusPainted(false);

        markAllButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        JButton clearButton =
                new JButton(
                        "Clear All"
                );

        clearButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        clearButton.setForeground(
                WHITE
        );

        clearButton.setBackground(
                RED
        );

        clearButton.setFocusPainted(false);

        clearButton.setBorderPainted(false);

        clearButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        actionPanel.add(
                markAllButton
        );

        actionPanel.add(
                clearButton
        );

        content.add(
                actionPanel
        );

        // =========================================================
        // MARK ALL ACTION
        // =========================================================

        markAllButton.addActionListener(e -> {

            unread.setText("0 Unread");

            unread.setBackground(GREEN);

            JOptionPane.showMessageDialog(
                    frame,
                    "All notifications have been marked as read.",
                    "Notifications",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // =========================================================
        // CLEAR ALL ACTION
        // =========================================================

        clearButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to clear all notifications?",
                            "Clear Notifications",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

            if (choice == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(
                        frame,
                        "All notifications have been cleared.",
                        "Notifications",
                        JOptionPane.INFORMATION_MESSAGE
                );

                unread.setText("0 Unread");

                unread.setBackground(GREEN);
            }
        });

        // =========================================================
        // ADD RIGHT SIDE
        // =========================================================

        rightSide.add(
                topBar,
                BorderLayout.NORTH
        );

        rightSide.add(
                content,
                BorderLayout.CENTER
        );

        // =========================================================
        // ADD MAIN PANEL
        // =========================================================

        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightSide,
                BorderLayout.CENTER
        );

        // =========================================================
        // SHOW FRAME
        // =========================================================

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // =============================================================
    // NOTIFICATION CARD
    // =============================================================

    private static JPanel createNotificationCard(
            String icon,
            String title,
            String message,
            String date,
            Color iconColor,
            boolean unread
    ) {

        JPanel card =
                new JPanel(
                        new BorderLayout(
                                15,
                                0
                        )
                );

        card.setBackground(WHITE);

        card.setBorder(
                new EmptyBorder(
                        13, 15, 13, 15
                )
        );

        card.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        card.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        88
                )
        );

        // =========================================================
        // ICON
        // =========================================================

        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        28
                )
        );

        iconLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        iconLabel.setPreferredSize(
                new Dimension(
                        45,
                        45
                )
        );

        // =========================================================
        // TEXT PANEL
        // =========================================================

        JPanel textPanel =
                new JPanel();

        textPanel.setBackground(
                WHITE
        );

        textPanel.setLayout(
                new BoxLayout(
                        textPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        titleLabel.setForeground(TEXT);

        JLabel messageLabel =
                new JLabel(message);

        messageLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        messageLabel.setForeground(GRAY);

        JLabel dateLabel =
                new JLabel(date);

        dateLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        dateLabel.setForeground(
                new Color(
                        148,
                        163,
                        184
                )
        );

        textPanel.add(titleLabel);

        textPanel.add(
                Box.createVerticalStrut(4)
        );

        textPanel.add(messageLabel);

        textPanel.add(
                Box.createVerticalStrut(5)
        );

        textPanel.add(dateLabel);

        // =========================================================
        // STATUS
        // =========================================================

        JPanel statusPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                0,
                                8
                        )
                );

        statusPanel.setBackground(
                WHITE
        );

        if (unread) {

            JLabel unreadLabel =
                    new JLabel("UNREAD");

            unreadLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            10
                    )
            );

            unreadLabel.setForeground(
                    iconColor
            );

            statusPanel.add(
                    unreadLabel
            );
        }

        card.add(
                iconLabel,
                BorderLayout.WEST
        );

        card.add(
                textPanel,
                BorderLayout.CENTER
        );

        card.add(
                statusPanel,
                BorderLayout.EAST
        );

        // Small colored line

        JPanel colorLine =
                new JPanel();

        colorLine.setBackground(
                iconColor
        );

        colorLine.setPreferredSize(
                new Dimension(
                        4,
                        50
                )
        );

        card.add(
                colorLine,
                BorderLayout.NORTH
        );

        return card;
    }

    // =============================================================
    // SIDEBAR BUTTON
    // =============================================================

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
                        226,
                        232,
                        240
                )
        );

        button.setBackground(
                DARK_BLUE
        );

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setFocusPainted(false);

        button.setBorderPainted(false);

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        42
                )
        );

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        return button;
    }
}