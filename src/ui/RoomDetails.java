
package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoomDetails {

    // =========================================================
    // COLORS
    // =========================================================

    private static final Color DARK_BLUE =
            new Color(15, 23, 42);

    private static final Color PRIMARY =
            new Color(30, 64, 175);

    private static final Color LIGHT_BG =
            new Color(241, 245, 249);

    private static final Color WHITE =
            Color.WHITE;

    private static final Color TEXT =
            new Color(30, 41, 59);

    private static final Color GRAY =
            new Color(100, 116, 139);

    private static final Color GREEN =
            new Color(22, 163, 74);


    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        // =====================================================
        // LOOK AND FEEL
        // =====================================================

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (Exception e) {

            e.printStackTrace();
        }


        // =====================================================
        // FRAME
        // =====================================================

        JFrame frame =
                new JFrame("My Room");

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
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(LIGHT_BG);


        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar =
                new JPanel();

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
                        35,
                        20,
                        25,
                        20
                )
        );


        // =====================================================
        // LOGO
        // =====================================================

        JLabel logo =
                new JLabel("🏠");

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


        JLabel portalName =
                new JLabel("HOSTEL");

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


        sidebar.add(logo);

        sidebar.add(
                Box.createVerticalStrut(10)
        );

        sidebar.add(portalName);

        sidebar.add(portalName2);


        sidebar.add(
                Box.createVerticalStrut(45)
        );


        // =====================================================
        // SIDEBAR BUTTONS
        // =====================================================

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


        // =====================================================
        // ACTIVE PAGE
        // =====================================================

        roomButton.setBackground(PRIMARY);


        // =====================================================
        // ADD SIDEBAR BUTTONS
        // =====================================================

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


        // =====================================================
        // LOGOUT AT BOTTOM
        // =====================================================

        sidebar.add(
                Box.createVerticalGlue()
        );


        JButton logoutButton =
                createSidebarButton(
                        "🚪   Logout"
                );

        sidebar.add(logoutButton);


        // =====================================================
        // RIGHT SIDE
        // =====================================================

        JPanel rightSide =
                new JPanel(
                        new BorderLayout()
                );

        rightSide.setBackground(LIGHT_BG);


        // =====================================================
        // TOP BAR
        // =====================================================

        JPanel topBar =
                new JPanel(
                        new BorderLayout()
                );

        topBar.setBackground(WHITE);

        topBar.setPreferredSize(
                new Dimension(
                        870,
                        70
                )
        );

        topBar.setBorder(
                new EmptyBorder(
                        15,
                        30,
                        15,
                        30
                )
        );


        JLabel pageTitle =
                new JLabel("My Room");

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
                new EmptyBorder(
                        30,
                        30,
                        30,
                        30
                )
        );


        // =====================================================
        // HEADING
        // =====================================================

        JLabel heading =
                new JLabel(
                        "Room Information"
                );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27
                )
        );

        heading.setForeground(TEXT);

        heading.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel subtitle =
                new JLabel(
                        "View your current room details and roommates."
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


        content.add(heading);

        content.add(
                Box.createVerticalStrut(5)
        );

        content.add(subtitle);

        content.add(
                Box.createVerticalStrut(25)
        );


        // =====================================================
        // ROOM CARD
        // =====================================================

        JPanel roomCard =
                new JPanel();

        roomCard.setBackground(WHITE);

        roomCard.setLayout(
                new BoxLayout(
                        roomCard,
                        BoxLayout.Y_AXIS
                )
        );

        roomCard.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        roomCard.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        roomCard.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        220
                )
        );


        // =====================================================
        // ROOM TITLE
        // =====================================================

        JLabel roomTitle =
                new JLabel(
                        "🛏  ROOM 204"
                );

        roomTitle.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        24
                )
        );

        roomTitle.setForeground(PRIMARY);

        roomTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        JLabel floor =
                new JLabel(
                        "2nd Floor"
                );

        floor.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        floor.setForeground(GRAY);

        floor.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        roomCard.add(roomTitle);

        roomCard.add(
                Box.createVerticalStrut(3)
        );

        roomCard.add(floor);

        roomCard.add(
                Box.createVerticalStrut(25)
        );


        // =====================================================
        // ROOM DETAILS
        // =====================================================

        JPanel detailsPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                3,
                                30,
                                0
                        )
                );

        detailsPanel.setBackground(WHITE);

        detailsPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        detailsPanel.add(
                createDetail(
                        "Room Type",
                        "Double Sharing"
                )
        );


        detailsPanel.add(
                createDetail(
                        "Bed Number",
                        "B-204-2"
                )
        );


        detailsPanel.add(
                createDetail(
                        "Room Status",
                        "Occupied"
                )
        );


        roomCard.add(detailsPanel);

        content.add(roomCard);


        // =====================================================
        // ROOMMATES
        // =====================================================

        content.add(
                Box.createVerticalStrut(25)
        );


        JLabel roommateTitle =
                new JLabel(
                        "Roommates"
                );

        roommateTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        roommateTitle.setForeground(TEXT);

        roommateTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        content.add(roommateTitle);

        content.add(
                Box.createVerticalStrut(12)
        );


        JPanel roommatesPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                2,
                                20,
                                0
                        )
                );

        roommatesPanel.setBackground(LIGHT_BG);

        roommatesPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        roommatesPanel.add(
                createRoommateCard(
                        "👤",
                        "John",
                        "Resident"
                )
        );


        roommatesPanel.add(
                createRoommateCard(
                        "👤",
                        "Alex",
                        "Resident"
                )
        );


        content.add(roommatesPanel);


        // =====================================================
        // FACILITIES
        // =====================================================

        content.add(
                Box.createVerticalStrut(25)
        );


        JLabel facilitiesTitle =
                new JLabel(
                        "Room Facilities"
                );

        facilitiesTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        facilitiesTitle.setForeground(TEXT);

        facilitiesTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        content.add(facilitiesTitle);

        content.add(
                Box.createVerticalStrut(12)
        );


        JPanel facilitiesPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                15,
                                0
                        )
                );

        facilitiesPanel.setBackground(LIGHT_BG);

        facilitiesPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );


        facilitiesPanel.add(
                createFacility(
                        "🛏",
                        "Bed"
                )
        );


        facilitiesPanel.add(
                createFacility(
                        "🪑",
                        "Study Table"
                )
        );


        facilitiesPanel.add(
                createFacility(
                        "💡",
                        "Electricity"
                )
        );


        facilitiesPanel.add(
                createFacility(
                        "📶",
                        "Wi-Fi"
                )
        );


        content.add(facilitiesPanel);


        // =====================================================
        // ADD CONTENT
        // =====================================================

        rightSide.add(
                topBar,
                BorderLayout.NORTH
        );

        rightSide.add(
                content,
                BorderLayout.CENTER
        );


        mainPanel.add(
                sidebar,
                BorderLayout.WEST
        );

        mainPanel.add(
                rightSide,
                BorderLayout.CENTER
        );


        frame.add(mainPanel);

        frame.setVisible(true);


        // =====================================================
        // NAVIGATION
        // =====================================================

        dashboardButton.addActionListener(e -> {

            frame.dispose();

            residentdashboard.main(null);

        });


        roomButton.addActionListener(e -> {

            // Already on My Room

        });


        paymentButton.addActionListener(e -> {

            frame.dispose();

            Payment.main(null);

        });


        complaintButton.addActionListener(e -> {

            frame.dispose();

            Complaint.main(null);

        });


        notificationButton.addActionListener(e -> {

            frame.dispose();

            Notifications.main(null);

        });


        profileButton.addActionListener(e -> {

            frame.dispose();

            Profile.main(null);

        });


        // =====================================================
        // LOGOUT
        // =====================================================

        logoutButton.addActionListener(e -> {

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to logout?",
                            "Logout",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );


            if (choice ==
                    JOptionPane.YES_OPTION) {

                frame.dispose();

                login.main(null);
            }

        });

    }


    // =========================================================
    // SIDEBAR BUTTON METHOD
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
                        226,
                        232,
                        240
                )
        );

        button.setBackground(DARK_BLUE);

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


    // =========================================================
    // ROOM DETAIL METHOD
    // =========================================================

    private static JPanel createDetail(
            String title,
            String value
    ) {

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel titleLabel =
                new JLabel(title);

        titleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        titleLabel.setForeground(GRAY);


        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        valueLabel.setForeground(TEXT);


        panel.add(titleLabel);

        panel.add(
                Box.createVerticalStrut(5)
        );

        panel.add(valueLabel);


        return panel;
    }


    // =========================================================
    // ROOMMATE CARD METHOD
    // =========================================================

    private static JPanel createRoommateCard(
            String icon,
            String name,
            String role
    ) {

        JPanel card =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                15,
                                15
                        )
                );

        card.setBackground(WHITE);


        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        30
                )
        );


        JPanel information =
                new JPanel();

        information.setBackground(WHITE);

        information.setLayout(
                new BoxLayout(
                        information,
                        BoxLayout.Y_AXIS
                )
        );


        JLabel nameLabel =
                new JLabel(name);

        nameLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        nameLabel.setForeground(TEXT);


        JLabel roleLabel =
                new JLabel(role);

        roleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        roleLabel.setForeground(GRAY);


        information.add(nameLabel);

        information.add(
                Box.createVerticalStrut(3)
        );

        information.add(roleLabel);


        card.add(iconLabel);

        card.add(information);


        return card;
    }


    // =========================================================
    // FACILITY CARD METHOD
    // =========================================================

    private static JPanel createFacility(
            String icon,
            String name
    ) {

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
                new EmptyBorder(
                        12,
                        10,
                        12,
                        10
                )
        );


        JLabel iconLabel =
                new JLabel(icon);

        iconLabel.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        22
                )
        );

        iconLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        JLabel nameLabel =
                new JLabel(name);

        nameLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        nameLabel.setForeground(TEXT);

        nameLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );


        panel.add(iconLabel);

        panel.add(
                Box.createVerticalStrut(5)
        );

        panel.add(nameLabel);


        return panel;
    }
}