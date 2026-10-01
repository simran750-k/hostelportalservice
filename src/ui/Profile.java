package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Profile {

    // ================= COLORS =================

    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color GREEN = new Color(22, 163, 74);

    // ================= USER DATA =================

    private static String fullName = "John Doe";
    private static String username = "john123";
    private static String email = "john@gmail.com";
    private static String phone = "98XXXXXXXX";
    private static String roomNumber = "204";
    private static String floor = "2nd Floor";

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

        JFrame frame = new JFrame("Profile");

        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // =========================================================
        // MAIN PANEL
        // =========================================================

        JPanel mainPanel = new JPanel(
                new BorderLayout()
        );

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

        JLabel portalName = new JLabel(
                "HOSTEL"
        );

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

        JLabel portalName2 = new JLabel(
                "SERVICE PORTAL"
        );

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

        // ================= ACTIVE PAGE =================

        profileButton.setBackground(
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

        notificationButton.addActionListener(e -> {

            frame.dispose();

            Notifications.main(null);
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
                        "Profile"
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
                        "👤  " + fullName
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
                        25, 30, 25, 30
                )
        );

        // =========================================================
        // HEADING
        // =========================================================

        JLabel heading =
                new JLabel(
                        "My Profile"
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
                        "View and manage your personal information."
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
                Box.createVerticalStrut(20)
        );

        // =========================================================
        // PROFILE CARD
        // =========================================================

        JPanel profileCard =
                new JPanel(
                        new BorderLayout(
                                25,
                                0
                        )
                );

        profileCard.setBackground(WHITE);

        profileCard.setBorder(
                new EmptyBorder(
                        20, 25, 20, 25
                )
        );

        profileCard.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        profileCard.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        235
                )
        );

        // =========================================================
        // AVATAR
        // =========================================================

        JPanel avatarPanel =
                new JPanel();

        avatarPanel.setBackground(WHITE);

        avatarPanel.setPreferredSize(
                new Dimension(
                        120,
                        180
                )
        );

        avatarPanel.setLayout(
                new BoxLayout(
                        avatarPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel avatar =
                new JLabel("👤");

        avatar.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        65
                )
        );

        avatar.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JLabel residentLabel =
                new JLabel(
                        "Resident"
                );

        residentLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        15
                )
        );

        residentLabel.setForeground(TEXT);

        residentLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        avatarPanel.add(
                Box.createVerticalStrut(10)
        );

        avatarPanel.add(avatar);

        avatarPanel.add(
                Box.createVerticalStrut(5)
        );

        avatarPanel.add(residentLabel);

        // =========================================================
        // INFORMATION PANEL
        // =========================================================

        JPanel information =
                new JPanel(
                        new GridLayout(
                                3,
                                2,
                                30,
                                15
                        )
                );

        information.setBackground(WHITE);

        JLabel fullNameValue =
                createInfo(
                        "Full Name",
                        fullName
                );

        JLabel usernameValue =
                createInfo(
                        "Username",
                        username
                );

        JLabel emailValue =
                createInfo(
                        "Email",
                        email
                );

        JLabel phoneValue =
                createInfo(
                        "Phone",
                        phone
                );

        JLabel roomValue =
                createInfo(
                        "Room Number",
                        roomNumber
                );

        JLabel floorValue =
                createInfo(
                        "Floor",
                        floor
                );

        information.add(
                createInfoPanel(
                        "Full Name",
                        fullNameValue
                )
        );

        information.add(
                createInfoPanel(
                        "Username",
                        usernameValue
                )
        );

        information.add(
                createInfoPanel(
                        "Email",
                        emailValue
                )
        );

        information.add(
                createInfoPanel(
                        "Phone",
                        phoneValue
                )
        );

        information.add(
                createInfoPanel(
                        "Room Number",
                        roomValue
                )
        );

        information.add(
                createInfoPanel(
                        "Floor",
                        floorValue
                )
        );

        profileCard.add(
                avatarPanel,
                BorderLayout.WEST
        );

        profileCard.add(
                information,
                BorderLayout.CENTER
        );

        content.add(profileCard);

        content.add(
                Box.createVerticalStrut(18)
        );

        // =========================================================
        // BUTTONS
        // =========================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                0,
                                0
                        )
                );

        buttonPanel.setBackground(
                LIGHT_BG
        );

        buttonPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JButton editButton =
                new JButton(
                        "Edit Profile"
                );

        editButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        editButton.setForeground(WHITE);

        editButton.setBackground(PRIMARY);

        editButton.setFocusPainted(false);

        editButton.setBorderPainted(false);

        editButton.setPreferredSize(
                new Dimension(
                        140,
                        40
                )
        );

        editButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        JButton passwordButton =
                new JButton(
                        "Change Password"
                );

        passwordButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        passwordButton.setForeground(PRIMARY);

        passwordButton.setBackground(WHITE);

        passwordButton.setFocusPainted(false);

        passwordButton.setPreferredSize(
                new Dimension(
                        160,
                        40
                )
        );

        passwordButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        buttonPanel.add(editButton);

        buttonPanel.add(
                Box.createHorizontalStrut(12)
        );

        buttonPanel.add(passwordButton);

        content.add(buttonPanel);

        // =========================================================
        // EDIT PROFILE ACTION
        // =========================================================

        editButton.addActionListener(e -> {

            showEditProfileDialog(
                    frame,
                    fullNameValue,
                    emailValue,
                    phoneValue,
                    user
            );
        });

        // =========================================================
        // CHANGE PASSWORD ACTION
        // =========================================================

        passwordButton.addActionListener(e -> {

            showChangePasswordDialog(frame);
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
        // SHOW
        // =========================================================

        frame.add(mainPanel);

        frame.setVisible(true);
    }

    // =============================================================
    // EDIT PROFILE DIALOG
    // =============================================================

    private static void showEditProfileDialog(
            JFrame parent,
            JLabel nameLabel,
            JLabel emailLabel,
            JLabel phoneLabel,
            JLabel topUserLabel
    ) {

        JTextField nameField =
                new JTextField(fullName);

        JTextField emailField =
                new JTextField(email);

        JTextField phoneField =
                new JTextField(phone);

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                3,
                                2,
                                10,
                                12
                        )
                );

        panel.setBorder(
                new EmptyBorder(
                        10, 10, 5, 10
                )
        );

        panel.add(
                new JLabel("Full Name:")
        );

        panel.add(nameField);

        panel.add(
                new JLabel("Email:")
        );

        panel.add(emailField);

        panel.add(
                new JLabel("Phone:")
        );

        panel.add(phoneField);

        int result =
                JOptionPane.showConfirmDialog(
                        parent,
                        panel,
                        "Edit Profile",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (result == JOptionPane.OK_OPTION) {

            String newName =
                    nameField.getText().trim();

            String newEmail =
                    emailField.getText().trim();

            String newPhone =
                    phoneField.getText().trim();

            if (newName.isEmpty()
                    || newEmail.isEmpty()
                    || newPhone.isEmpty()) {

                JOptionPane.showMessageDialog(
                        parent,
                        "Please fill in all fields.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (!newEmail.contains("@")) {

                JOptionPane.showMessageDialog(
                        parent,
                        "Please enter a valid email address.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // UPDATE TEMPORARY DATA

            fullName = newName;
            email = newEmail;
            phone = newPhone;

            // UPDATE UI

            nameLabel.setText(fullName);

            emailLabel.setText(email);

            phoneLabel.setText(phone);

            topUserLabel.setText(
                    "👤  " + fullName
            );

            JOptionPane.showMessageDialog(
                    parent,
                    "Profile updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =============================================================
    // CHANGE PASSWORD
    // =============================================================

    private static void showChangePasswordDialog(
            JFrame parent
    ) {

        JPasswordField oldPassword =
                new JPasswordField();

        JPasswordField newPassword =
                new JPasswordField();

        JPasswordField confirmPassword =
                new JPasswordField();

        JPanel panel =
                new JPanel(
                        new GridLayout(
                                3,
                                2,
                                10,
                                12
                        )
                );

        panel.setBorder(
                new EmptyBorder(
                        10, 10, 5, 10
                )
        );

        panel.add(
                new JLabel("Current Password:")
        );

        panel.add(oldPassword);

        panel.add(
                new JLabel("New Password:")
        );

        panel.add(newPassword);

        panel.add(
                new JLabel("Confirm Password:")
        );

        panel.add(confirmPassword);

        int result =
                JOptionPane.showConfirmDialog(
                        parent,
                        panel,
                        "Change Password",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

        if (result == JOptionPane.OK_OPTION) {

            String oldPass =
                    new String(
                            oldPassword.getPassword()
                    );

            String newPass =
                    new String(
                            newPassword.getPassword()
                    );

            String confirmPass =
                    new String(
                            confirmPassword.getPassword()
                    );

            if (oldPass.isEmpty()
                    || newPass.isEmpty()
                    || confirmPass.isEmpty()) {

                JOptionPane.showMessageDialog(
                        parent,
                        "Please fill in all password fields.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (newPass.length() < 6) {

                JOptionPane.showMessageDialog(
                        parent,
                        "New password must contain at least 6 characters.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (!newPass.equals(confirmPass)) {

                JOptionPane.showMessageDialog(
                        parent,
                        "New password and confirmation password do not match.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    parent,
                    "Password changed successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =============================================================
    // INFORMATION LABEL
    // =============================================================

    private static JLabel createInfo(
            String title,
            String value
    ) {

        JLabel valueLabel =
                new JLabel(value);

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        valueLabel.setForeground(TEXT);

        return valueLabel;
    }

    // =============================================================
    // INFORMATION PANEL
    // =============================================================

    private static JPanel createInfoPanel(
            String title,
            JLabel valueLabel
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
                        12
                )
        );

        titleLabel.setForeground(GRAY);

        panel.add(titleLabel);

        panel.add(
                Box.createVerticalStrut(4)
        );

        panel.add(valueLabel);

        return panel;
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