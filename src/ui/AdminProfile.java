package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminProfile {

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

    // =========================================================
    // PROFILE DATA - TEMPORARY
    // =========================================================

    private static String fullName = "Hostel Administrator";
    private static String username = "admin";
    private static String email = "admin@hostel.com";
    private static String phone = "98XXXXXXXX";
    private static String role = "System Administrator";
    private static String accountStatus = "Active";

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

        JFrame frame = new JFrame("Admin Profile");

        frame.setSize(1150, 680);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);

        sidebar.setPreferredSize(
                new Dimension(230, 680)
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
                new JLabel("SERVICE PORTAL");

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

        JButton notificationButton =
                createSidebarButton(
                        "🔔  Notifications"
                );

        JButton profileButton =
                createSidebarButton(
                        "👤  Profile"
                );

        profileButton.setBackground(PRIMARY);

        profileButton.setForeground(WHITE);

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
                createSidebarButton(
                        "🚪  Logout"
                );

        sidebar.add(logoutButton);

        sidebar.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // RIGHT PANEL
        // =====================================================

        JPanel rightPanel =
                new JPanel(
                        new BorderLayout()
                );

        rightPanel.setBackground(LIGHT_BG);

        // =====================================================
        // TOP BAR
        // =====================================================

        JPanel topBar =
                new JPanel(
                        new BorderLayout()
                );

        topBar.setBackground(WHITE);

        topBar.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 15, 25
                )
        );

        JLabel pageTitle =
                new JLabel("Admin Profile");

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
                        25, 30, 30, 30
                )
        );

        // =====================================================
        // HEADING
        // =====================================================

        JLabel heading =
                new JLabel("My Profile");

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
                        "View and manage your administrator account."
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
                Box.createVerticalStrut(25)
        );

        // =====================================================
        // PROFILE CARD
        // =====================================================

        JPanel profileCard =
                new JPanel(
                        new BorderLayout(25, 0)
                );

        profileCard.setBackground(WHITE);

        profileCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                25, 25, 25, 25
                        )
                )
        );

        profileCard.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        230
                )
        );

        profileCard.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        // =====================================================
        // AVATAR
        // =====================================================

        JPanel avatarPanel =
                new JPanel();

        avatarPanel.setBackground(WHITE);

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

        JLabel roleLabel =
                new JLabel("Administrator");

        roleLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        roleLabel.setForeground(PRIMARY);

        roleLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        avatarPanel.add(avatar);

        avatarPanel.add(
                Box.createVerticalStrut(5)
        );

        avatarPanel.add(roleLabel);

        profileCard.add(
                avatarPanel,
                BorderLayout.WEST
        );

        // =====================================================
        // INFORMATION
        // =====================================================

        JPanel infoPanel =
                new JPanel();

        infoPanel.setBackground(WHITE);

        infoPanel.setLayout(
                new GridLayout(
                        3,
                        2,
                        25,
                        18
                )
        );

        JLabel nameValue =
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

        JLabel roleValue =
                createInfo(
                        "Role",
                        role
                );

        JLabel statusValue =
                createInfo(
                        "Account Status",
                        accountStatus
                );

        infoPanel.add(
                createInfoPanel(
                        "Full Name",
                        nameValue
                )
        );

        infoPanel.add(
                createInfoPanel(
                        "Username",
                        usernameValue
                )
        );

        infoPanel.add(
                createInfoPanel(
                        "Email",
                        emailValue
                )
        );

        infoPanel.add(
                createInfoPanel(
                        "Phone",
                        phoneValue
                )
        );

        infoPanel.add(
                createInfoPanel(
                        "Role",
                        roleValue
                )
        );

        infoPanel.add(
                createInfoPanel(
                        "Account Status",
                        statusValue
                )
        );

        profileCard.add(
                infoPanel,
                BorderLayout.CENTER
        );

        content.add(profileCard);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // ACCOUNT SETTINGS
        // =====================================================

        JPanel settingsCard =
                new JPanel();

        settingsCard.setBackground(WHITE);

        settingsCard.setLayout(
                new BoxLayout(
                        settingsCard,
                        BoxLayout.Y_AXIS
                )
        );

        settingsCard.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        new EmptyBorder(
                                20, 25, 20, 25
                        )
                )
        );

        settingsCard.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        150
                )
        );

        settingsCard.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel settingsTitle =
                new JLabel(
                        "Account Settings"
                );

        settingsTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        settingsTitle.setForeground(TEXT);

        settingsTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        settingsCard.add(settingsTitle);

        settingsCard.add(
                Box.createVerticalStrut(15)
        );

        JPanel buttonsPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.LEFT,
                                10,
                                0
                        )
                );

        buttonsPanel.setBackground(WHITE);

        JButton editButton =
                createActionButton(
                        "✏  Edit Profile",
                        PRIMARY
                );

        JButton passwordButton =
                createActionButton(
                        "🔐  Change Password",
                        RED
                );

        buttonsPanel.add(editButton);
        buttonsPanel.add(passwordButton);

        settingsCard.add(buttonsPanel);

        content.add(settingsCard);

        // =====================================================
        // EDIT PROFILE BUTTON
        // =====================================================

        editButton.addActionListener(e -> {

            showEditProfileDialog(
                    frame,
                    nameValue,
                    emailValue,
                    phoneValue
            );
        });

        // =====================================================
        // CHANGE PASSWORD BUTTON
        // =====================================================

        passwordButton.addActionListener(e -> {

            showChangePasswordDialog(frame);

        });

        // =====================================================
        // SCROLL
        // =====================================================

        JScrollPane scrollPane =
                new JScrollPane(content);

        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        rightPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

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

        notificationButton.addActionListener(e -> {

            frame.dispose();
            AdminNotifications.main(null);

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
    // EDIT PROFILE DIALOG
    // =========================================================

    private static void showEditProfileDialog(
            JFrame frame,
            JLabel nameLabel,
            JLabel emailLabel,
            JLabel phoneLabel
    ) {

        JDialog dialog =
                new JDialog(
                        frame,
                        "Edit Profile",
                        true
                );

        dialog.setSize(450, 430);

        dialog.setLocationRelativeTo(frame);

        dialog.setResizable(false);

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setBorder(
                new EmptyBorder(
                        25, 30, 25, 30
                )
        );

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "Edit Administrator Profile"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21
                )
        );

        title.setForeground(TEXT);

        title.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        panel.add(title);

        panel.add(
                Box.createVerticalStrut(20)
        );

        // Full Name

        JLabel nameTitle =
                createFormLabel(
                        "Full Name"
                );

        JTextField nameField =
                createTextField(
                        fullName
                );

        panel.add(nameTitle);

        panel.add(nameField);

        panel.add(
                Box.createVerticalStrut(15)
        );

        // Username

        JLabel usernameTitle =
                createFormLabel(
                        "Username"
                );

        JTextField usernameField =
                createTextField(
                        username
                );

        usernameField.setEditable(false);

        usernameField.setBackground(
                new Color(241, 245, 249)
        );

        panel.add(usernameTitle);

        panel.add(usernameField);

        panel.add(
                Box.createVerticalStrut(15)
        );

        // Email

        JLabel emailTitle =
                createFormLabel(
                        "Email"
                );

        JTextField emailField =
                createTextField(
                        email
                );

        panel.add(emailTitle);

        panel.add(emailField);

        panel.add(
                Box.createVerticalStrut(15)
        );

        // Phone

        JLabel phoneTitle =
                createFormLabel(
                        "Phone"
                );

        JTextField phoneField =
                createTextField(
                        phone
                );

        panel.add(phoneTitle);

        panel.add(phoneField);

        panel.add(
                Box.createVerticalStrut(20)
        );

        // Buttons

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttonPanel.setBackground(WHITE);

        JButton cancelButton =
                new JButton("Cancel");

        JButton saveButton =
                createActionButton(
                        "💾 Save Changes",
                        PRIMARY
                );

        cancelButton.setFocusPainted(false);

        buttonPanel.add(cancelButton);

        buttonPanel.add(saveButton);

        panel.add(buttonPanel);

        // Cancel

        cancelButton.addActionListener(e -> {

            dialog.dispose();

        });

        // Save

        saveButton.addActionListener(e -> {

            String newName =
                    nameField
                            .getText()
                            .trim();

            String newEmail =
                    emailField
                            .getText()
                            .trim();

            String newPhone =
                    phoneField
                            .getText()
                            .trim();

            if (newName.isEmpty()
                    || newEmail.isEmpty()
                    || newPhone.isEmpty()) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please fill in all fields.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (!newEmail.contains("@")
                    || !newEmail.contains(".")) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please enter a valid email address.",
                        "Invalid Email",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (!newPhone.matches(
                    "[0-9+\\- ]{7,15}"
            )) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please enter a valid phone number.",
                        "Invalid Phone",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // Update temporary data

            fullName = newName;
            email = newEmail;
            phone = newPhone;

            // Update display

            nameLabel.setText(fullName);

            emailLabel.setText(email);

            phoneLabel.setText(phone);

            JOptionPane.showMessageDialog(
                    dialog,
                    "Profile updated successfully.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dialog.dispose();
        });

        dialog.add(panel);

        dialog.setVisible(true);
    }

    // =========================================================
    // CHANGE PASSWORD DIALOG
    // =========================================================

    private static void showChangePasswordDialog(
            JFrame frame
    ) {

        JDialog dialog =
                new JDialog(
                        frame,
                        "Change Password",
                        true
                );

        dialog.setSize(430, 380);

        dialog.setLocationRelativeTo(frame);

        dialog.setResizable(false);

        JPanel panel =
                new JPanel();

        panel.setBackground(WHITE);

        panel.setBorder(
                new EmptyBorder(
                        25, 30, 25, 30
                )
        );

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel title =
                new JLabel(
                        "Change Password"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21
                )
        );

        title.setForeground(TEXT);

        title.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        panel.add(title);

        panel.add(
                Box.createVerticalStrut(20)
        );

        // Current password

        JLabel currentTitle =
                createFormLabel(
                        "Current Password"
                );

        JPasswordField currentPassword =
                createPasswordField();

        panel.add(currentTitle);

        panel.add(currentPassword);

        panel.add(
                Box.createVerticalStrut(15)
        );

        // New password

        JLabel newTitle =
                createFormLabel(
                        "New Password"
                );

        JPasswordField newPassword =
                createPasswordField();

        panel.add(newTitle);

        panel.add(newPassword);

        panel.add(
                Box.createVerticalStrut(15)
        );

        // Confirm password

        JLabel confirmTitle =
                createFormLabel(
                        "Confirm New Password"
                );

        JPasswordField confirmPassword =
                createPasswordField();

        panel.add(confirmTitle);

        panel.add(confirmPassword);

        panel.add(
                Box.createVerticalStrut(20)
        );

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        buttonPanel.setBackground(WHITE);

        JButton cancelButton =
                new JButton("Cancel");

        JButton changeButton =
                createActionButton(
                        "🔐 Change Password",
                        PRIMARY
                );

        cancelButton.setFocusPainted(false);

        buttonPanel.add(cancelButton);

        buttonPanel.add(changeButton);

        panel.add(buttonPanel);

        // Cancel

        cancelButton.addActionListener(e -> {

            dialog.dispose();

        });

        // Change Password

        changeButton.addActionListener(e -> {

            String current =
                    new String(
                            currentPassword
                                    .getPassword()
                    );

            String newPass =
                    new String(
                            newPassword
                                    .getPassword()
                    );

            String confirm =
                    new String(
                            confirmPassword
                                    .getPassword()
                    );

            if (current.isEmpty()
                    || newPass.isEmpty()
                    || confirm.isEmpty()) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please fill in all password fields.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (newPass.length() < 6) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "New password must contain at least 6 characters.",
                        "Weak Password",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (!newPass.equals(confirm)) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "New password and confirmation do not match.",
                        "Password Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            JOptionPane.showMessageDialog(
                    dialog,
                    "Password changed successfully.\n"
                            + "Database connection will be added later.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            dialog.dispose();
        });

        dialog.add(panel);

        dialog.setVisible(true);
    }

    // =========================================================
    // CREATE INFO
    // =========================================================

    private static JLabel createInfo(
            String title,
            String value
    ) {

        JLabel label =
                new JLabel(value);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(TEXT);

        return label;
    }

    // =========================================================
    // CREATE INFO PANEL
    // =========================================================

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

    // =========================================================
    // FORM LABEL
    // =========================================================

    private static JLabel createFormLabel(
            String text
    ) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        label.setForeground(TEXT);

        label.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return label;
    }

    // =========================================================
    // TEXT FIELD
    // =========================================================

    private static JTextField createTextField(
            String value
    ) {

        JTextField field =
                new JTextField(value);

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        field.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return field;
    }

    // =========================================================
    // PASSWORD FIELD
    // =========================================================

    private static JPasswordField createPasswordField() {

        JPasswordField field =
                new JPasswordField();

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        field.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        38
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                BORDER
                        ),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        field.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        return field;
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
                        12
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
                                8, 12, 8, 12
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