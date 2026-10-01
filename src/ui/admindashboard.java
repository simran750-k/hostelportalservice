package ui;

import javax.swing.*;
import java.awt.*;

public class admindashboard {

    // Colors
    static final Color PRIMARY = new Color(30, 64, 175);
    static final Color DARK_BLUE = new Color(15, 23, 42);
    static final Color LIGHT_BG = new Color(241, 245, 249);
    static final Color WHITE = Color.WHITE;
    static final Color TEXT = new Color(30, 41, 59);
    static final Color GRAY = new Color(100, 116, 139);

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hostel Service Portal - Admin Dashboard");

        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        // ================= SIDEBAR =================

        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(230, 650));
        sidebar.setBackground(DARK_BLUE);
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));

        // Logo
        JLabel logo = new JLabel("🏠  HOSTEL");
        logo.setForeground(WHITE);
        logo.setFont(new Font("Arial", Font.BOLD, 20));
        logo.setBorder(BorderFactory.createEmptyBorder(25, 20, 5, 10));

        JLabel portal = new JLabel("     SERVICE PORTAL");
        portal.setForeground(new Color(148, 163, 184));
        portal.setFont(new Font("Arial", Font.PLAIN, 12));
        portal.setBorder(BorderFactory.createEmptyBorder(0, 20, 25, 10));

        sidebar.add(logo);
        sidebar.add(portal);

        // Sidebar buttons
        JButton dashboardButton = createSidebarButton("▣  Dashboard");
        JButton residentButton = createSidebarButton("👥  Residents");
        JButton roomButton = createSidebarButton("🛏  Rooms");
        JButton paymentButton = createSidebarButton("💳  Payments");
        JButton complaintButton = createSidebarButton("⚠  Complaints");
        JButton reportButton = createSidebarButton("📊  Reports");
        JButton notificationButton = createSidebarButton("🔔  Notifications");
        JButton profileButton = createSidebarButton("👤  Profile");
        JButton logoutButton = createSidebarButton("↪  Logout");

        sidebar.add(dashboardButton);
        sidebar.add(residentButton);
        sidebar.add(roomButton);
        sidebar.add(paymentButton);
        sidebar.add(complaintButton);
        sidebar.add(reportButton);
        sidebar.add(notificationButton);
        sidebar.add(profileButton);

        sidebar.add(Box.createVerticalGlue());

        logoutButton.setForeground(new Color(248, 113, 113));
        sidebar.add(logoutButton);

        // ================= TOP BAR =================

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(WHITE);
        topBar.setBorder(
                BorderFactory.createEmptyBorder(15, 25, 15, 25)
        );

        JLabel pageTitle = new JLabel("Admin Dashboard");
        pageTitle.setFont(new Font("Arial", Font.BOLD, 22));
        pageTitle.setForeground(TEXT);

        JLabel adminLabel = new JLabel("👤  Admin");
        adminLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        adminLabel.setForeground(GRAY);

        topBar.add(pageTitle, BorderLayout.WEST);
        topBar.add(adminLabel, BorderLayout.EAST);

        // ================= CONTENT =================

        JPanel content = new JPanel();
        content.setBackground(LIGHT_BG);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        JLabel welcome = new JLabel("Welcome back, Admin! 👋");
        welcome.setFont(new Font("Arial", Font.BOLD, 24));
        welcome.setForeground(TEXT);
        welcome.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "Here's what's happening in your hostel today."
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(GRAY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        content.add(welcome);
        content.add(Box.createVerticalStrut(5));
        content.add(subtitle);
        content.add(Box.createVerticalStrut(25));

        // ================= STAT CARDS =================

        JPanel cards = new JPanel(new GridLayout(1, 4, 15, 0));
        cards.setOpaque(false);
        cards.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));
        cards.setAlignmentX(Component.LEFT_ALIGNMENT);

        cards.add(createCard("👥", "Residents", "120"));
        cards.add(createCard("🛏", "Rooms", "50"));
        cards.add(createCard("💳", "Payments", "42"));
        cards.add(createCard("⚠", "Complaints", "8"));

        content.add(cards);
        content.add(Box.createVerticalStrut(25));

        // ================= RECENT ACTIVITY =================

        JPanel activityPanel = new JPanel();
        activityPanel.setBackground(WHITE);
        activityPanel.setLayout(new BoxLayout(activityPanel, BoxLayout.Y_AXIS));
        activityPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(226, 232, 240)
                        ),
                        BorderFactory.createEmptyBorder(15, 20, 15, 20)
                )
        );
        activityPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel activityTitle = new JLabel("Recent Activity");
        activityTitle.setFont(new Font("Arial", Font.BOLD, 17));
        activityTitle.setForeground(TEXT);

        activityPanel.add(activityTitle);
        activityPanel.add(Box.createVerticalStrut(15));

        activityPanel.add(
                createActivity(
                        "👤",
                        "New resident registered",
                        "John Doe was added to Room 204",
                        "Today"
                )
        );

        activityPanel.add(Box.createVerticalStrut(10));

        activityPanel.add(
                createActivity(
                        "💳",
                        "Payment received",
                        "Rs. 8,000 payment received from Alex Smith",
                        "Today"
                )
        );

        activityPanel.add(Box.createVerticalStrut(10));

        activityPanel.add(
                createActivity(
                        "⚠",
                        "New complaint",
                        "Water leakage complaint submitted",
                        "Yesterday"
                )
        );

        content.add(activityPanel);

        // ================= ADD TO FRAME =================

        frame.add(sidebar, BorderLayout.WEST);
        frame.add(topBar, BorderLayout.NORTH);
        frame.add(content, BorderLayout.CENTER);

        // ==================================================
        //                 NAVIGATION
        // ==================================================

        residentButton.addActionListener(e -> {
            ResidentManagement.main(null);
            frame.dispose();
        });

        roomButton.addActionListener(e -> {
            RoomManagement.main(null);
            frame.dispose();
        });

        paymentButton.addActionListener(e -> {
            PaymentManagement.main(null);
            frame.dispose();
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

        // Logout
        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                login.main(null);
                frame.dispose();
            }
        });

        // Show frame
        frame.setVisible(true);
    }

    // ==================================================
    //              SIDEBAR BUTTON
    // ==================================================

    private static JButton createSidebarButton(String text) {

        JButton button = new JButton(text);

        button.setMaximumSize(new Dimension(
                Integer.MAX_VALUE,
                45
        ));

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        button.setForeground(WHITE);
        button.setBackground(DARK_BLUE);

        button.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 10
                )
        );

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        return button;
    }

    // ==================================================
    //                 STAT CARD
    // ==================================================

    private static JPanel createCard(
            String icon,
            String title,
            String value
    ) {

        JPanel card = new JPanel();

        card.setBackground(WHITE);

        card.setLayout(
                new BoxLayout(card, BoxLayout.Y_AXIS)
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(226, 232, 240)
                        ),
                        BorderFactory.createEmptyBorder(
                                12, 15, 12, 15
                        )
                )
        );

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(
                new Font("Arial", Font.PLAIN, 20)
        );

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );
        titleLabel.setForeground(GRAY);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );
        valueLabel.setForeground(TEXT);

        card.add(iconLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(titleLabel);
        card.add(valueLabel);

        return card;
    }

    // ==================================================
    //              RECENT ACTIVITY
    // ==================================================

    private static JPanel createActivity(
            String icon,
            String title,
            String description,
            String time
    ) {

        JPanel panel = new JPanel(new BorderLayout(10, 0));

        panel.setBackground(WHITE);

        JLabel iconLabel = new JLabel(icon);
        iconLabel.setFont(
                new Font("Arial", Font.PLAIN, 18)
        );

        JPanel textPanel = new JPanel();
        textPanel.setBackground(WHITE);
        textPanel.setLayout(
                new BoxLayout(
                        textPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 13)
        );
        titleLabel.setForeground(TEXT);

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(
                new Font("Arial", Font.PLAIN, 12)
        );
        descriptionLabel.setForeground(GRAY);

        textPanel.add(titleLabel);
        textPanel.add(descriptionLabel);

        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(
                new Font("Arial", Font.PLAIN, 11)
        );
        timeLabel.setForeground(GRAY);

        panel.add(iconLabel, BorderLayout.WEST);
        panel.add(textPanel, BorderLayout.CENTER);
        panel.add(timeLabel, BorderLayout.EAST);

        return panel;
    }
}