package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Complaint {

    // ================= COLORS =================
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color ORANGE = new Color(234, 88, 12);
    private static final Color GREEN = new Color(22, 163, 74);

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

        JFrame frame = new JFrame("My Complaints");

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

        // Current page

        complaintButton.setBackground(
                PRIMARY
        );

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

        notificationButton.addActionListener(e -> {

            frame.dispose();

            Notifications.main(null);
        });

        profileButton.addActionListener(e -> {

            frame.dispose();

            Profile.main(null);
        });

        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
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

        JPanel rightSide = new JPanel(
                new BorderLayout()
        );

        rightSide.setBackground(
                LIGHT_BG
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        JPanel topBar = new JPanel(
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

        JLabel pageTitle = new JLabel(
                "My Complaints"
        );

        pageTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        pageTitle.setForeground(TEXT);

        JLabel user = new JLabel(
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

        JPanel content = new JPanel();

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

        JLabel heading = new JLabel(
                "Submit a Complaint"
        );

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        heading.setForeground(TEXT);

        heading.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JLabel subtitle = new JLabel(
                "Report an issue or problem to the hostel administration."
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

        content.add(heading);

        content.add(
                Box.createVerticalStrut(3)
        );

        content.add(subtitle);

        content.add(
                Box.createVerticalStrut(14)
        );

        // =========================================================
        // FORM CARD
        // =========================================================

        JPanel formCard = new JPanel();

        formCard.setBackground(WHITE);

        formCard.setLayout(
                new GridBagLayout()
        );

        formCard.setBorder(
                new EmptyBorder(
                        15, 20, 15, 20
                )
        );

        formCard.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        formCard.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        195
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        // =========================================================
        // CATEGORY
        // =========================================================

        JLabel categoryLabel =
                new JLabel(
                        "Category"
                );

        categoryLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        categoryLabel.setForeground(TEXT);

        String[] categories = {

                "Select Category",
                "Room Maintenance",
                "Electricity",
                "Water Supply",
                "Cleanliness",
                "Internet",
                "Other"
        };

        JComboBox<String> categoryBox =
                new JComboBox<>(
                        categories
                );

        categoryBox.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        // ================= CONSTRAINTS =================

        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0;

        gbc.fill =
                GridBagConstraints.NONE;

        gbc.anchor =
                GridBagConstraints.WEST;

        gbc.insets =
                new Insets(
                        5, 5, 5, 15
                );

        formCard.add(
                categoryLabel,
                gbc
        );

        gbc.gridx = 1;

        gbc.weightx = 1;

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        formCard.add(
                categoryBox,
                gbc
        );

        // =========================================================
        // SUBJECT
        // =========================================================

        JLabel subjectLabel =
                new JLabel(
                        "Subject"
                );

        subjectLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        subjectLabel.setForeground(TEXT);

        JTextField subjectField =
                new JTextField();

        subjectField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        subjectField.setPreferredSize(
                new Dimension(
                        400,
                        30
                )
        );

        subjectField.setEnabled(true);

        subjectField.setEditable(true);

        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0;

        gbc.fill =
                GridBagConstraints.NONE;

        formCard.add(
                subjectLabel,
                gbc
        );

        gbc.gridx = 1;

        gbc.weightx = 1;

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        formCard.add(
                subjectField,
                gbc
        );

        // =========================================================
        // DESCRIPTION
        // =========================================================

        JLabel descriptionLabel =
                new JLabel(
                        "Description"
                );

        descriptionLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        descriptionLabel.setForeground(TEXT);

        JTextArea descriptionArea =
                new JTextArea();

        descriptionArea.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        descriptionArea.setLineWrap(true);

        descriptionArea.setWrapStyleWord(true);

        descriptionArea.setEditable(true);

        descriptionArea.setEnabled(true);

        descriptionArea.setRows(3);

        descriptionArea.setColumns(30);

        JScrollPane descriptionScroll =
                new JScrollPane(
                        descriptionArea
                );

        descriptionScroll.setPreferredSize(
                new Dimension(
                        400,
                        55
                )
        );

        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0;

        gbc.fill =
                GridBagConstraints.NONE;

        formCard.add(
                descriptionLabel,
                gbc
        );

        gbc.gridx = 1;

        gbc.weightx = 1;

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        formCard.add(
                descriptionScroll,
                gbc
        );

        // =========================================================
        // SUBMIT BUTTON
        // =========================================================

        JButton submitButton =
                new JButton(
                        "Submit Complaint"
                );

        submitButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        submitButton.setForeground(WHITE);

        submitButton.setBackground(
                PRIMARY
        );

        submitButton.setFocusPainted(false);

        submitButton.setBorderPainted(false);

        submitButton.setPreferredSize(
                new Dimension(
                        180,
                        33
                )
        );

        submitButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 1;

        gbc.fill =
                GridBagConstraints.NONE;

        gbc.anchor =
                GridBagConstraints.EAST;

        formCard.add(
                submitButton,
                gbc
        );

        // =========================================================
        // SUBMIT ACTION
        // =========================================================

        submitButton.addActionListener(e -> {

            String category =
                    (String)
                            categoryBox.getSelectedItem();

            String subject =
                    subjectField
                            .getText()
                            .trim();

            String description =
                    descriptionArea
                            .getText()
                            .trim();

            // CATEGORY VALIDATION

            if (category.equals(
                    "Select Category"
            )) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a complaint category.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // SUBJECT VALIDATION

            if (subject.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a subject.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                subjectField.requestFocus();

                return;
            }

            // DESCRIPTION VALIDATION

            if (description.isEmpty()) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please enter a description.",
                        "Validation",
                        JOptionPane.WARNING_MESSAGE
                );

                descriptionArea.requestFocus();

                return;
            }

            // SUCCESS

            JOptionPane.showMessageDialog(
                    frame,
                    "Complaint submitted successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            // CLEAR FORM

            categoryBox.setSelectedIndex(0);

            subjectField.setText("");

            descriptionArea.setText("");
        });

        content.add(formCard);

        content.add(
                Box.createVerticalStrut(15)
        );

        // =========================================================
        // MY COMPLAINTS
        // =========================================================

        JLabel complaintsTitle =
                new JLabel(
                        "My Complaints"
                );

        complaintsTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        19
                )
        );

        complaintsTitle.setForeground(TEXT);

        complaintsTitle.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(
                complaintsTitle
        );

        content.add(
                Box.createVerticalStrut(7)
        );

        // =========================================================
        // TABLE
        // =========================================================

        String[] columns = {

                "Complaint ID",
                "Subject",
                "Category",
                "Date",
                "Status",
                "Admin Response"
        };

        Object[][] data = {

                {
                        "CMP-002",
                        "Water leakage",
                        "Water Supply",
                        "25 Sep 2026",
                        "Pending",
                        "Under review"
                },

                {
                        "CMP-001",
                        "Room light not working",
                        "Electricity",
                        "20 Sep 2026",
                        "Resolved",
                        "Electrician fixed the issue"
                }
        };

        JTable table =
                new JTable(
                        data,
                        columns
                );

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        table.setRowHeight(32);

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        11
                )
        );

        table.getTableHeader().setBackground(
                new Color(
                        226, 232, 240
                )
        );

        table.getTableHeader().setForeground(
                TEXT
        );

        table.setGridColor(
                new Color(
                        226, 232, 240
                )
        );

        table.setEnabled(false);

        // =========================================================
        // COLUMN WIDTHS
        // =========================================================

        table.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(75);

        table.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(130);

        table.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(110);

        table.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(95);

        table.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(80);

        table.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(190);

        JScrollPane tableScroll =
                new JScrollPane(
                        table
                );

        tableScroll.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        tableScroll.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        105
                )
        );

        content.add(tableScroll);

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