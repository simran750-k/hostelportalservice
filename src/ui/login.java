package ui;

import DAO.AdminDAO;
import DAO.ResidentDAO ;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class login {

    // ==============================
    // COLORS
    // ==============================

    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);

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

        // ==============================
        // MAIN FRAME
        // ==============================

        JFrame frame = new JFrame("Hostel Service Portal");

        frame.setSize(900, 620);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setResizable(false);

        // ==============================
        // MAIN PANEL
        // ==============================

        JPanel mainPanel =
                new JPanel(new GridLayout(1, 2));

        // =========================================================
        // LEFT SIDE
        // =========================================================

        JPanel leftPanel =
                new JPanel(new GridBagLayout());

        leftPanel.setBackground(DARK_BLUE);

        JPanel leftContent =
                new JPanel();

        leftContent.setBackground(DARK_BLUE);

        leftContent.setLayout(
                new BoxLayout(
                        leftContent,
                        BoxLayout.Y_AXIS
                )
        );

        // ==============================
        // HOUSE ICON
        // ==============================

        JLabel logo =
                new JLabel("🏠");

        logo.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        55
                )
        );

        logo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ==============================
        // HOSTEL TITLE
        // ==============================

        JLabel portalTitle =
                new JLabel("HOSTEL");

        portalTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        34
                )
        );

        portalTitle.setForeground(WHITE);

        portalTitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ==============================
        // SERVICE PORTAL
        // ==============================

        JLabel portalTitle2 =
                new JLabel("SERVICE PORTAL");

        portalTitle2.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        portalTitle2.setForeground(
                new Color(147, 197, 253)
        );

        portalTitle2.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ==============================
        // DESCRIPTION
        // ==============================

        JLabel description =
                new JLabel(
                        "<html><div style='text-align:center; width:300px;'>"
                                + "Manage your hostel services<br>"
                                + "easily and efficiently."
                                + "</div></html>"
                );

        description.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
                )
        );

        description.setForeground(
                new Color(203, 213, 225)
        );

        description.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        description.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ==============================
        // ADD LEFT CONTENT
        // ==============================

        leftContent.add(logo);

        leftContent.add(
                Box.createVerticalStrut(20)
        );

        leftContent.add(portalTitle);

        leftContent.add(portalTitle2);

        leftContent.add(
                Box.createVerticalStrut(25)
        );

        leftContent.add(description);

        leftPanel.add(leftContent);

        // =========================================================
        // RIGHT SIDE
        // =========================================================

        JPanel rightPanel =
                new JPanel(new GridBagLayout());

        rightPanel.setBackground(LIGHT_BG);

        // ==============================
        // LOGIN CARD
        // ==============================

        JPanel loginPanel =
                new JPanel();

        loginPanel.setBackground(WHITE);

        loginPanel.setLayout(
                new BoxLayout(
                        loginPanel,
                        BoxLayout.Y_AXIS
                )
        );

        loginPanel.setBorder(
                new EmptyBorder(
                        35,
                        45,
                        35,
                        45
                )
        );

        loginPanel.setPreferredSize(
                new Dimension(
                        360,
                        470
                )
        );

        // =========================================================
        // WELCOME
        // =========================================================

        JLabel welcome =
                new JLabel("Welcome Back!");

        welcome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        27
                )
        );

        welcome.setForeground(TEXT);

        welcome.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        // ==============================
        // SUBTITLE
        // ==============================

        JLabel subtitle =
                new JLabel("Login to continue");

        subtitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        subtitle.setForeground(GRAY);

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginPanel.add(welcome);

        loginPanel.add(
                Box.createVerticalStrut(5)
        );

        loginPanel.add(subtitle);

        // =========================================================
        // USERNAME
        // =========================================================

        loginPanel.add(
                Box.createVerticalStrut(30)
        );

        JLabel usernameLabel =
                new JLabel("Username");

        usernameLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        usernameLabel.setForeground(TEXT);

        usernameLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JTextField usernameField =
                new JTextField();

        usernameField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        usernameField.setMaximumSize(
                new Dimension(
                        260,
                        40
                )
        );

        usernameField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        203,
                                        213,
                                        225
                                )
                        ),
                        new EmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );

        loginPanel.add(usernameLabel);

        loginPanel.add(
                Box.createVerticalStrut(7)
        );

        loginPanel.add(usernameField);

        // =========================================================
        // PASSWORD
        // =========================================================

        loginPanel.add(
                Box.createVerticalStrut(18)
        );

        JLabel passwordLabel =
                new JLabel("Password");

        passwordLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        passwordLabel.setForeground(TEXT);

        passwordLabel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JPasswordField passwordField =
                new JPasswordField();

        passwordField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        passwordField.setMaximumSize(
                new Dimension(
                        260,
                        40
                )
        );

        passwordField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        203,
                                        213,
                                        225
                                )
                        ),
                        new EmptyBorder(
                                5,
                                10,
                                5,
                                10
                        )
                )
        );

        loginPanel.add(passwordLabel);

        loginPanel.add(
                Box.createVerticalStrut(7)
        );

        loginPanel.add(passwordField);

        // =========================================================
        // LOGIN TYPE
        // =========================================================

        loginPanel.add(
                Box.createVerticalStrut(18)
        );

        JLabel loginAs =
                new JLabel(
                        "Login as",
                        SwingConstants.CENTER
                );

        loginAs.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        loginAs.setForeground(TEXT);

        loginAs.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginPanel.add(loginAs);

        // ==============================
        // RADIO BUTTONS
        // ==============================

        JPanel radioPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                10,
                                5
                        )
                );

        radioPanel.setBackground(WHITE);

        radioPanel.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        JRadioButton adminRadio =
                new JRadioButton("Admin");

        JRadioButton residentRadio =
                new JRadioButton("Resident");

        adminRadio.setBackground(WHITE);

        residentRadio.setBackground(WHITE);

        adminRadio.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        residentRadio.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        ButtonGroup group =
                new ButtonGroup();

        group.add(adminRadio);

        group.add(residentRadio);

        radioPanel.add(adminRadio);

        radioPanel.add(residentRadio);

        loginPanel.add(radioPanel);

        // =========================================================
        // LOGIN BUTTON
        // =========================================================

        loginPanel.add(
                Box.createVerticalStrut(15)
        );

        JButton loginButton =
                new JButton("LOGIN");

        loginButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        loginButton.setForeground(WHITE);

        loginButton.setBackground(PRIMARY);

        loginButton.setFocusPainted(false);

        loginButton.setEnabled(true);

        loginButton.setFocusable(true);

        loginButton.setBorderPainted(false);

        loginButton.setMaximumSize(
                new Dimension(
                        210,
                        42
                )
        );

        loginButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        loginButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        loginPanel.add(loginButton);

        // =========================================================
        // LOGIN FUNCTIONALITY
        // =========================================================

        loginButton.addActionListener(e -> {

            String username =
                    usernameField
                            .getText()
                            .trim();

            String password =
                    new String(
                            passwordField
                                    .getPassword()
                    );

            // ==============================
            // EMPTY FIELD CHECK
            // ==============================

            if (username.isEmpty()
                    || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter username and password.",
                        "Login Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // ==============================
            // ADMIN LOGIN
            // ==============================

            if (adminRadio.isSelected()) {

                AdminDAO dao =
                        new AdminDAO();

                if (dao.login(
                        username,
                        password
                )) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Admin Login Successful",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    admindashboard.main(null);

                    frame.dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Admin Login",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            // ==============================
            // RESIDENT LOGIN
            // ==============================

            else if (residentRadio.isSelected()) {

                ResidentDAO dao =
                        new ResidentDAO();

                if (dao.login(
                        username,
                        password
                )) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Resident Login Successful",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    residentdashboard.main(null);

                    frame.dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Resident Login",
                            "Login Failed",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            // ==============================
            // NO LOGIN TYPE
            // ==============================

            else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select Admin or Resident.",
                        "Login Type Required",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        // =========================================================
        // ADD PANELS
        // =========================================================

        mainPanel.add(leftPanel);

        mainPanel.add(rightPanel);

        // Center login card
        rightPanel.add(loginPanel);

        // Add main panel
        frame.add(mainPanel);

        // Show window
        frame.setVisible(true);
    }
}