package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class residentdashboard {

    // ================= COLORS =================
    private static final Color DARK_BLUE = new Color(20, 35, 60);
    private static final Color SIDEBAR_HOVER = new Color(32, 50, 80);
    private static final Color PRIMARY = new Color(37, 99, 235);
    private static final Color LIGHT_BG = new Color(245, 247, 250);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 40, 55);
    private static final Color GRAY = new Color(100, 110, 125);
    private static final Color GREEN = new Color(34, 197, 94);
    private static final Color ORANGE = new Color(245, 158, 11);
    private static final Color RED = new Color(239, 68, 68);

    private JFrame frame;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public residentdashboard() {

        frame = new JFrame("Hostel Service Portal - Resident Dashboard");

        frame.setSize(1250, 780);
        frame.setMinimumSize(new Dimension(1100, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar = new JPanel();
        sidebar.setBackground(DARK_BLUE);
        sidebar.setPreferredSize(new Dimension(230, 780));
        sidebar.setLayout(new BorderLayout());

        // ---------------- LOGO ----------------

        JPanel logoPanel = new JPanel();
        logoPanel.setBackground(DARK_BLUE);
        logoPanel.setBorder(new EmptyBorder(25, 20, 20, 20));
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("HOSTEL");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("Segoe UI", Font.BOLD, 25));

        JLabel portal = new JLabel("SERVICE PORTAL");
        portal.setForeground(new Color(180, 190, 210));
        portal.setFont(new Font("Segoe UI", Font.PLAIN, 11));

        logoPanel.add(logo);
        logoPanel.add(Box.createVerticalStrut(2));
        logoPanel.add(portal);

        sidebar.add(logoPanel, BorderLayout.NORTH);

        // ---------------- MENU ----------------

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(DARK_BLUE);
        menuPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JButton dashboardBtn = createMenuButton("Dashboard", true);
        JButton roomBtn = createMenuButton("My Room", false);
        JButton paymentBtn = createMenuButton("Payment", false);
        JButton complaintBtn = createMenuButton("Complaint", false);
        JButton notificationBtn = createMenuButton("Notifications", false);
        JButton profileBtn = createMenuButton("Profile", false);

        menuPanel.add(dashboardBtn);
        menuPanel.add(Box.createVerticalStrut(8));

        menuPanel.add(roomBtn);
        menuPanel.add(Box.createVerticalStrut(8));

        menuPanel.add(paymentBtn);
        menuPanel.add(Box.createVerticalStrut(8));

        menuPanel.add(complaintBtn);
        menuPanel.add(Box.createVerticalStrut(8));

        menuPanel.add(notificationBtn);
        menuPanel.add(Box.createVerticalStrut(8));

        menuPanel.add(profileBtn);

        sidebar.add(menuPanel, BorderLayout.CENTER);

        // ---------------- LOGOUT ----------------

        JPanel logoutPanel = new JPanel();
        logoutPanel.setBackground(DARK_BLUE);
        logoutPanel.setBorder(new EmptyBorder(10, 10, 25, 10));
        logoutPanel.setLayout(new BorderLayout());

        JButton logoutBtn = createMenuButton("Logout", false);

        logoutPanel.add(logoutBtn, BorderLayout.CENTER);

        sidebar.add(logoutPanel, BorderLayout.SOUTH);

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // =====================================================
        // TOP BAR
        // =====================================================

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(WHITE);
        topBar.setPreferredSize(new Dimension(1000, 70));

        topBar.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        new Color(225, 228, 235)
                )
        );

        JLabel title = new JLabel("Resident Dashboard");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(TEXT);
        title.setBorder(new EmptyBorder(0, 30, 0, 0));

        JLabel residentLabel = new JLabel("John Doe");
        residentLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        residentLabel.setForeground(GRAY);
        residentLabel.setBorder(new EmptyBorder(0, 25, 0, 25));

        topBar.add(title, BorderLayout.WEST);
        topBar.add(residentLabel, BorderLayout.EAST);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // =====================================================
        // CONTENT
        // =====================================================

        JPanel content = new JPanel();
        content.setBackground(LIGHT_BG);
        content.setBorder(new EmptyBorder(25, 30, 25, 30));

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // =====================================================
        // WELCOME
        // =====================================================

        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(LIGHT_BG);
        welcomePanel.setLayout(new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));

        JLabel welcome = new JLabel("Welcome back, John!");

        welcome.setFont(
                new Font("Segoe UI", Font.BOLD, 25)
        );

        welcome.setForeground(TEXT);

        JLabel subtitle = new JLabel(
                "Here is an overview of your hostel information."
        );

        subtitle.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );

        subtitle.setForeground(GRAY);

        welcomePanel.add(welcome);
        welcomePanel.add(Box.createVerticalStrut(5));
        welcomePanel.add(subtitle);

        content.add(welcomePanel);

        content.add(Box.createVerticalStrut(20));

        // =====================================================
        // SUMMARY CARDS
        // =====================================================

        JPanel cardsPanel = new JPanel(
                new GridLayout(1, 4, 15, 0)
        );

        cardsPanel.setBackground(LIGHT_BG);
        cardsPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 145)
        );

        cardsPanel.add(
                createCard(
                        "ROOM",
                        "204",
                        "Double Sharing",
                        PRIMARY
                )
        );

        cardsPanel.add(
                createCard(
                        "HOSTEL FEE",
                        "Rs. 10,000",
                        "Monthly Fee",
                        new Color(124, 58, 237)
                )
        );

        cardsPanel.add(
                createCard(
                        "AMOUNT PAID",
                        "Rs. 8,000",
                        "This Month",
                        GREEN
                )
        );

        cardsPanel.add(
                createCard(
                        "REMAINING",
                        "Rs. 2,000",
                        "Payment Due",
                        ORANGE
                )
        );

        content.add(cardsPanel);

        content.add(Box.createVerticalStrut(20));

        // =====================================================
        // LOWER SECTION
        // =====================================================

        JPanel lowerPanel = new JPanel(
                new GridLayout(1, 2, 20, 0)
        );

        lowerPanel.setBackground(LIGHT_BG);

        lowerPanel.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, 300)
        );

        // =====================================================
        // QUICK STATUS
        // =====================================================

        JPanel statusPanel = new JPanel();

        statusPanel.setBackground(WHITE);

        statusPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 228, 235)
                        ),
                        new EmptyBorder(
                                20,
                                25,
                                20,
                                25
                        )
                )
        );

        statusPanel.setLayout(
                new BoxLayout(
                        statusPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel statusTitle = new JLabel("Quick Status");

        statusTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        statusTitle.setForeground(TEXT);

        statusTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        statusPanel.add(statusTitle);

        statusPanel.add(Box.createVerticalStrut(20));

        statusPanel.add(
                createStatusRow(
                        "Pending Complaints",
                        "1",
                        ORANGE
                )
        );

        statusPanel.add(Box.createVerticalStrut(12));

        statusPanel.add(
                createStatusRow(
                        "Unread Notifications",
                        "3",
                        RED
                )
        );

        statusPanel.add(Box.createVerticalStrut(12));

        statusPanel.add(
                createStatusRow(
                        "Room Status",
                        "Occupied",
                        GREEN
                )
        );

        statusPanel.add(Box.createVerticalStrut(12));

        statusPanel.add(
                createStatusRow(
                        "Payment Status",
                        "Partial",
                        ORANGE
                )
        );

        lowerPanel.add(statusPanel);

        // =====================================================
        // RECENT NOTIFICATIONS
        // =====================================================

        JPanel recentPanel = new JPanel();

        recentPanel.setBackground(WHITE);

        recentPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 228, 235)
                        ),
                        new EmptyBorder(
                                20,
                                25,
                                20,
                                25
                        )
                )
        );

        recentPanel.setLayout(
                new BoxLayout(
                        recentPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel recentTitle =
                new JLabel("Recent Notifications");

        recentTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        recentTitle.setForeground(TEXT);

        recentTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        recentPanel.add(recentTitle);

        recentPanel.add(Box.createVerticalStrut(15));

        recentPanel.add(
                createNotificationRow(
                        "Payment Reminder",
                        "Rs. 2,000 payment is remaining.",
                        "30 Sep 2026",
                        ORANGE
                )
        );

        recentPanel.add(
                Box.createVerticalStrut(10)
        );

        recentPanel.add(
                createNotificationRow(
                        "Complaint Update",
                        "Room light complaint was resolved.",
                        "29 Sep 2026",
                        GREEN
                )
        );

        recentPanel.add(
                Box.createVerticalStrut(10)
        );

        recentPanel.add(
                createNotificationRow(
                        "Hostel Announcement",
                        "Room inspection on 5 Oct 2026.",
                        "28 Sep 2026",
                        PRIMARY
                )
        );

        lowerPanel.add(recentPanel);

        content.add(lowerPanel);

        // =====================================================
        // SCROLL
        // =====================================================

        JScrollPane scrollPane =
                new JScrollPane(content);

        scrollPane.setBorder(null);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // =====================================================
        // ADD PANELS
        // =====================================================

        frame.add(
                sidebar,
                BorderLayout.WEST
        );

        frame.add(
                mainPanel,
                BorderLayout.CENTER
        );

        // =====================================================
        // NAVIGATION
        // =====================================================

        dashboardBtn.addActionListener(e -> {
            // Already on dashboard
        });

        roomBtn.addActionListener(e -> {
            frame.dispose();
            RoomDetails.main(null);
        });

        paymentBtn.addActionListener(e -> {
            frame.dispose();
            Payment.main(null);
        });

        complaintBtn.addActionListener(e -> {
            frame.dispose();
            Complaint.main(null);
        });

        notificationBtn.addActionListener(e -> {
            frame.dispose();
            Notifications.main(null);
        });

        profileBtn.addActionListener(e -> {
            frame.dispose();
            Profile.main(null);
        });

        logoutBtn.addActionListener(e -> {

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
        // SHOW
        // =====================================================

        frame.setVisible(true);
    }

    // =========================================================
    // MENU BUTTON
    // =========================================================

    private JButton createMenuButton(
            String text,
            boolean active
    ) {

        JButton button = new JButton(text);

        button.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        // IMPORTANT:
        // Always white text on dark sidebar
        button.setForeground(Color.WHITE);

        if (active) {
            button.setBackground(PRIMARY);
        } else {
            button.setBackground(DARK_BLUE);
        }

        button.setHorizontalAlignment(
                SwingConstants.LEFT
        );

        button.setBorder(
                new EmptyBorder(
                        12,
                        18,
                        12,
                        10
                )
        );

        button.setFocusPainted(false);

        button.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        button.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        button.addMouseListener(
                new MouseAdapter() {

                    @Override
                    public void mouseEntered(
                            MouseEvent e
                    ) {

                        if (!active) {
                            button.setBackground(
                                    SIDEBAR_HOVER
                            );
                        }
                    }

                    @Override
                    public void mouseExited(
                            MouseEvent e
                    ) {

                        if (!active) {
                            button.setBackground(
                                    DARK_BLUE
                            );
                        }
                    }
                }
        );

        return button;
    }

    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private JPanel createCard(
            String title,
            String value,
            String subtitle,
            Color accent
    ) {

        JPanel card = new JPanel();

        card.setBackground(WHITE);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(225, 228, 235)
                        ),
                        new EmptyBorder(
                                15,
                                20,
                                15,
                                20
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
                )
        );

        JPanel top = new JPanel(
                new BorderLayout()
        );

        top.setBackground(WHITE);

        top.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        25
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        titleLabel.setForeground(GRAY);

        JPanel accentBox = new JPanel();

        accentBox.setBackground(accent);

        accentBox.setPreferredSize(
                new Dimension(
                        7,
                        30
                )
        );

        top.add(
                titleLabel,
                BorderLayout.WEST
        );

        top.add(
                accentBox,
                BorderLayout.EAST
        );

        card.add(top);

        card.add(
                Box.createVerticalStrut(12)
        );

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        23
                )
        );

        valueLabel.setForeground(TEXT);

        card.add(valueLabel);

        card.add(
                Box.createVerticalStrut(5)
        );

        JLabel subtitleLabel =
                new JLabel(subtitle);

        subtitleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        subtitleLabel.setForeground(GRAY);

        card.add(subtitleLabel);

        return card;
    }

    // =========================================================
    // STATUS ROW
    // =========================================================

    private JPanel createStatusRow(
            String title,
            String value,
            Color valueColor
    ) {

        JPanel row =
                new JPanel(
                        new BorderLayout()
                );

        row.setBackground(WHITE);

        row.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        35
                )
        );

        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        titleLabel.setForeground(TEXT);

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        valueLabel.setForeground(
                valueColor
        );

        row.add(
                titleLabel,
                BorderLayout.WEST
        );

        row.add(
                valueLabel,
                BorderLayout.EAST
        );

        return row;
    }

    // =========================================================
    // NOTIFICATION ROW
    // =========================================================

    private JPanel createNotificationRow(
            String title,
            String message,
            String date,
            Color accent
    ) {

        JPanel row =
                new JPanel(
                        new BorderLayout(10, 0)
                );

        row.setBackground(WHITE);

        row.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        55
                )
        );

        JPanel indicator = new JPanel();

        indicator.setBackground(accent);

        indicator.setPreferredSize(
                new Dimension(
                        5,
                        45
                )
        );

        JPanel textPanel =
                new JPanel();

        textPanel.setBackground(WHITE);

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
                        13
                )
        );

        titleLabel.setForeground(TEXT);

        JLabel messageLabel =
                new JLabel(message);

        messageLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        messageLabel.setForeground(GRAY);

        textPanel.add(titleLabel);

        textPanel.add(
                Box.createVerticalStrut(3)
        );

        textPanel.add(messageLabel);

        JLabel dateLabel =
                new JLabel(date);

        dateLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        10
                )
        );

        dateLabel.setForeground(GRAY);

        row.add(
                indicator,
                BorderLayout.WEST
        );

        row.add(
                textPanel,
                BorderLayout.CENTER
        );

        row.add(
                dateLabel,
                BorderLayout.EAST
        );

        return row;
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new residentdashboard();
        });
    }
}