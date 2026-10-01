package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {

    // =========================================================
    // COLORS
    // =========================================================

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

    // =========================================================
    // PAYMENT VARIABLES
    // =========================================================

    private double amountPaid;
    private double remainingAmount;

    private JFrame frame;

    private JLabel totalFeeLabel;
    private JLabel paidLabel;
    private JLabel remainingLabel;
    private JLabel statusLabel;

    private DefaultTableModel tableModel;
    private JTable paymentTable;

    private int paymentCounter = 3;

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Payment();
        });
    }

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Payment() {

        amountPaid =
                ResidentPaymentData.getAmountPaid();

        remainingAmount =
                ResidentPaymentData.getRemainingAmount();

        frame = new JFrame(
                "Hostel Service Portal - Payment"
        );

        frame.setSize(1250, 780);

        frame.setMinimumSize(
                new Dimension(1100, 700)
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.setLocationRelativeTo(null);

        frame.setLayout(
                new BorderLayout()
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);

        sidebar.setPreferredSize(
                new Dimension(230, 780)
        );

        sidebar.setLayout(
                new BorderLayout()
        );

        // ---------------- LOGO ----------------

        JPanel logoPanel = new JPanel();

        logoPanel.setBackground(DARK_BLUE);

        logoPanel.setBorder(
                new EmptyBorder(
                        25,
                        20,
                        20,
                        20
                )
        );

        logoPanel.setLayout(
                new BoxLayout(
                        logoPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel logo = new JLabel("HOSTEL");

        logo.setForeground(Color.WHITE);

        logo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        JLabel portal =
                new JLabel("SERVICE PORTAL");

        portal.setForeground(
                new Color(180, 190, 210)
        );

        portal.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        11
                )
        );

        logoPanel.add(logo);

        logoPanel.add(
                Box.createVerticalStrut(2)
        );

        logoPanel.add(portal);

        sidebar.add(
                logoPanel,
                BorderLayout.NORTH
        );

        // ---------------- MENU ----------------

        JPanel menuPanel = new JPanel();

        menuPanel.setBackground(DARK_BLUE);

        menuPanel.setBorder(
                new EmptyBorder(
                        10,
                        10,
                        10,
                        10
                )
        );

        menuPanel.setLayout(
                new BoxLayout(
                        menuPanel,
                        BoxLayout.Y_AXIS
                )
        );

        JButton dashboardBtn =
                createMenuButton(
                        "Dashboard",
                        false
                );

        JButton roomBtn =
                createMenuButton(
                        "My Room",
                        false
                );

        JButton paymentBtn =
                createMenuButton(
                        "Payment",
                        true
                );

        JButton complaintBtn =
                createMenuButton(
                        "Complaint",
                        false
                );

        JButton notificationBtn =
                createMenuButton(
                        "Notifications",
                        false
                );

        JButton profileBtn =
                createMenuButton(
                        "Profile",
                        false
                );

        menuPanel.add(dashboardBtn);

        menuPanel.add(
                Box.createVerticalStrut(8)
        );

        menuPanel.add(roomBtn);

        menuPanel.add(
                Box.createVerticalStrut(8)
        );

        menuPanel.add(paymentBtn);

        menuPanel.add(
                Box.createVerticalStrut(8)
        );

        menuPanel.add(complaintBtn);

        menuPanel.add(
                Box.createVerticalStrut(8)
        );

        menuPanel.add(notificationBtn);

        menuPanel.add(
                Box.createVerticalStrut(8)
        );

        menuPanel.add(profileBtn);

        sidebar.add(
                menuPanel,
                BorderLayout.CENTER
        );

        // ---------------- LOGOUT ----------------

        JPanel logoutPanel = new JPanel();

        logoutPanel.setBackground(DARK_BLUE);

        logoutPanel.setBorder(
                new EmptyBorder(
                        10,
                        10,
                        25,
                        10
                )
        );

        logoutPanel.setLayout(
                new BorderLayout()
        );

        JButton logoutBtn =
                createMenuButton(
                        "Logout",
                        false
                );

        logoutPanel.add(
                logoutBtn,
                BorderLayout.CENTER
        );

        sidebar.add(
                logoutPanel,
                BorderLayout.SOUTH
        );

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(
                LIGHT_BG
        );

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
                        1000,
                        70
                )
        );

        topBar.setBorder(
                BorderFactory.createMatteBorder(
                        0,
                        0,
                        1,
                        0,
                        new Color(
                                225,
                                228,
                                235
                        )
                )
        );

        JLabel title =
                new JLabel("Payment");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        title.setForeground(TEXT);

        title.setBorder(
                new EmptyBorder(
                        0,
                        30,
                        0,
                        0
                )
        );

        JLabel residentLabel =
                new JLabel("John Doe");

        residentLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        residentLabel.setForeground(GRAY);

        residentLabel.setBorder(
                new EmptyBorder(
                        0,
                        25,
                        0,
                        25
                )
        );

        topBar.add(
                title,
                BorderLayout.WEST
        );

        topBar.add(
                residentLabel,
                BorderLayout.EAST
        );

        mainPanel.add(
                topBar,
                BorderLayout.NORTH
        );

        // =====================================================
        // CONTENT
        // =====================================================

        JPanel content = new JPanel();

        content.setBackground(
                LIGHT_BG
        );

        content.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        content.setLayout(
                new BoxLayout(
                        content,
                        BoxLayout.Y_AXIS
                )
        );

        // =====================================================
        // HEADING
        // =====================================================

        JLabel heading =
                new JLabel("My Payments");

        heading.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        25
                )
        );

        heading.setForeground(TEXT);

        content.add(heading);

        content.add(
                Box.createVerticalStrut(5)
        );

        JLabel subHeading =
                new JLabel(
                        "View your hostel fee and make payments."
                );

        subHeading.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        subHeading.setForeground(GRAY);

        content.add(subHeading);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // SUMMARY
        // =====================================================

        JPanel summaryPanel =
                new JPanel(
                        new GridLayout(
                                1,
                                4,
                                15,
                                0
                        )
                );

        summaryPanel.setBackground(
                LIGHT_BG
        );

        summaryPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        125
                )
        );

        totalFeeLabel =
                new JLabel(
                        formatMoney(
                                ResidentPaymentData
                                        .getTotalFee()
                        )
                );

        paidLabel =
                new JLabel(
                        formatMoney(
                                amountPaid
                        )
                );

        remainingLabel =
                new JLabel(
                        formatMoney(
                                remainingAmount
                        )
                );

        statusLabel =
                new JLabel(
                        ResidentPaymentData
                                .getPaymentStatus()
                );

        summaryPanel.add(
                createSummaryCard(
                        "TOTAL HOSTEL FEE",
                        totalFeeLabel,
                        PRIMARY
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "AMOUNT PAID",
                        paidLabel,
                        GREEN
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "REMAINING",
                        remainingLabel,
                        ORANGE
                )
        );

        summaryPanel.add(
                createSummaryCard(
                        "PAYMENT STATUS",
                        statusLabel,
                        getStatusColor()
                )
        );

        content.add(summaryPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // PAY NOW
        // =====================================================

        JPanel payPanel =
                new JPanel(
                        new BorderLayout()
                );

        payPanel.setBackground(WHITE);

        payPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        228,
                                        235
                                )
                        ),
                        new EmptyBorder(
                                20,
                                25,
                                20,
                                25
                        )
                )
        );

        payPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        105
                )
        );

        JPanel payText =
                new JPanel();

        payText.setBackground(WHITE);

        payText.setLayout(
                new BoxLayout(
                        payText,
                        BoxLayout.Y_AXIS
                )
        );

        JLabel payTitle =
                new JLabel(
                        "Pay Your Hostel Fee"
                );

        payTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        payTitle.setForeground(TEXT);

        JLabel payDescription =
                new JLabel(
                        "Your current outstanding amount is "
                                + formatMoney(
                                remainingAmount
                        )
                );

        payDescription.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        payDescription.setForeground(GRAY);

        payText.add(payTitle);

        payText.add(
                Box.createVerticalStrut(5)
        );

        payText.add(payDescription);

        JButton payNowButton =
                new JButton("PAY NOW");

        payNowButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        payNowButton.setForeground(WHITE);

        payNowButton.setBackground(
                PRIMARY
        );

        payNowButton.setFocusPainted(false);

        payNowButton.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        payNowButton.setBorder(
                new EmptyBorder(
                        12,
                        25,
                        12,
                        25
                )
        );

        payNowButton.addActionListener(
                e -> openPaymentDialog()
        );

        payPanel.add(
                payText,
                BorderLayout.WEST
        );

        payPanel.add(
                payNowButton,
                BorderLayout.EAST
        );

        content.add(payPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // =====================================================
        // PAYMENT HISTORY
        // =====================================================

        JPanel historyPanel =
                new JPanel(
                        new BorderLayout()
                );

        historyPanel.setBackground(
                WHITE
        );

        historyPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        228,
                                        235
                                )
                        ),
                        new EmptyBorder(
                                20,
                                20,
                                20,
                                20
                        )
                )
        );

        JLabel historyTitle =
                new JLabel(
                        "Payment History"
                );

        historyTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        historyTitle.setForeground(TEXT);

        historyPanel.add(
                historyTitle,
                BorderLayout.NORTH
        );

        String[] columns = {
                "Payment ID",
                "Month",
                "Amount",
                "Payment Date",
                "Method",
                "Status"
        };

        tableModel =
                new DefaultTableModel(
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

        tableModel.addRow(
                new Object[]{
                        "PAY-001",
                        "August 2026",
                        "Rs. 8,000",
                        "01 Aug 2026",
                        "eSewa",
                        "PAID"
                }
        );

        tableModel.addRow(
                new Object[]{
                        "PAY-002",
                        "September 2026",
                        "Rs. 8,000",
                        "01 Sep 2026",
                        "eSewa",
                        "PAID"
                }
        );

        paymentTable =
                new JTable(tableModel);

        paymentTable.setRowHeight(35);

        paymentTable.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        paymentTable.getTableHeader()
                .setFont(
                        new Font(
                                "Segoe UI",
                                Font.BOLD,
                                13
                        )
                );

        paymentTable.getTableHeader()
                .setBackground(
                        new Color(
                                240,
                                243,
                                248
                        )
                );

        paymentTable.getTableHeader()
                .setForeground(TEXT);

        paymentTable.setGridColor(
                new Color(
                        225,
                        228,
                        235
                )
        );

        JScrollPane tableScroll =
                new JScrollPane(
                        paymentTable
                );

        tableScroll.setPreferredSize(
                new Dimension(
                        900,
                        180
                )
        );

        historyPanel.add(
                tableScroll,
                BorderLayout.CENTER
        );

        content.add(historyPanel);

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
        // FRAME
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
            frame.dispose();
            residentdashboard.main(null);
        });

        roomBtn.addActionListener(e -> {
            frame.dispose();
            RoomDetails.main(null);
        });

        paymentBtn.addActionListener(e -> {
            // Already on Payment
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

        frame.setVisible(true);
    }

    // =========================================================
    // PAYMENT DIALOG
    // =========================================================

    private void openPaymentDialog() {

        remainingAmount =
                ResidentPaymentData
                        .getRemainingAmount();

        if (remainingAmount <= 0) {

            JOptionPane.showMessageDialog(
                    frame,
                    "You have no remaining hostel fee.",
                    "Payment Complete",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        JDialog dialog =
                new JDialog(
                        frame,
                        "Make Payment",
                        true
                );

        dialog.setSize(
                500,
                480
        );

        dialog.setLocationRelativeTo(
                frame
        );

        dialog.setLayout(
                new BorderLayout()
        );

        // =====================================================
        // HEADER
        // =====================================================

        JPanel header =
                new JPanel();

        header.setBackground(
                PRIMARY
        );

        header.setBorder(
                new EmptyBorder(
                        18,
                        20,
                        18,
                        20
                )
        );

        JLabel headerLabel =
                new JLabel(
                        "Make Hostel Fee Payment"
                );

        headerLabel.setForeground(
                WHITE
        );

        headerLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        header.add(headerLabel);

        dialog.add(
                header,
                BorderLayout.NORTH
        );

        // =====================================================
        // FORM
        // =====================================================

        JPanel form =
                new JPanel(
                        new GridBagLayout()
                );

        form.setBackground(
                WHITE
        );

        form.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(
                        8,
                        8,
                        8,
                        8
                );

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        // ---------------- DUE ----------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        JLabel dueLabel =
                new JLabel("Amount Due:");

        dueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        form.add(
                dueLabel,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        JLabel dueValue =
                new JLabel(
                        formatMoney(
                                remainingAmount
                        )
                );

        dueValue.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        dueValue.setForeground(
                ORANGE
        );

        form.add(
                dueValue,
                gbc
        );

        // ---------------- PAYMENT AMOUNT ----------------

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;

        JLabel amountLabel =
                new JLabel(
                        "Payment Amount:"
                );

        amountLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        form.add(
                amountLabel,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        JTextField amountField =
                new JTextField(
                        String.valueOf(
                                (int) remainingAmount
                        )
                );

        amountField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        amountField.setPreferredSize(
                new Dimension(
                        200,
                        38
                )
        );

        form.add(
                amountField,
                gbc
        );

        // ---------------- METHOD ----------------

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;

        JLabel methodLabel =
                new JLabel(
                        "Payment Method:"
                );

        methodLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        form.add(
                methodLabel,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 1;

        String[] methods = {
                "eSewa",
                "Khalti",
                "Cash / Manual"
        };

        JComboBox<String> methodBox =
                new JComboBox<>(methods);

        methodBox.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        methodBox.setPreferredSize(
                new Dimension(
                        200,
                        38
                )
        );

        form.add(
                methodBox,
                gbc
        );

        // ---------------- INFO ----------------

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        JLabel info =
                new JLabel(
                        "<html><center>"
                                + "Choose your payment method and "
                                + "confirm the payment.<br>"
                                + "Online gateway integration will "
                                + "be connected later."
                                + "</center></html>"
                );

        info.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        12
                )
        );

        info.setForeground(
                GRAY
        );

        info.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        form.add(
                info,
                gbc
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                10
                        )
                );

        buttonPanel.setBackground(
                WHITE
        );

        JButton cancelButton =
                new JButton("Cancel");

        JButton confirmButton =
                new JButton(
                        "Confirm Payment"
                );

        confirmButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        confirmButton.setForeground(
                WHITE
        );

        confirmButton.setBackground(
                PRIMARY
        );

        confirmButton.setFocusPainted(
                false
        );

        buttonPanel.add(
                cancelButton
        );

        buttonPanel.add(
                confirmButton
        );

        cancelButton.addActionListener(
                e -> dialog.dispose()
        );

        // =====================================================
        // CONFIRM PAYMENT
        // =====================================================

        confirmButton.addActionListener(e -> {

            String amountText =
                    amountField
                            .getText()
                            .trim();

            if (amountText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please enter the payment amount.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                amountField.requestFocus();

                return;
            }

            double paymentAmount;

            try {

                paymentAmount =
                        Double.parseDouble(
                                amountText
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please enter a valid amount.",
                        "Invalid Amount",
                        JOptionPane.ERROR_MESSAGE
                );

                amountField.requestFocus();

                return;
            }

            if (paymentAmount <= 0) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Payment amount must be greater than zero.",
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (paymentAmount >
                    remainingAmount) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Payment cannot be greater than "
                                + formatMoney(
                                remainingAmount
                        ),
                        "Invalid Amount",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            String method =
                    (String)
                            methodBox
                                    .getSelectedItem();

            int confirmation =
                    JOptionPane.showConfirmDialog(
                            dialog,
                            "<html>"
                                    + "<b>Confirm Payment</b><br><br>"
                                    + "Amount: "
                                    + formatMoney(
                                    paymentAmount
                            )
                                    + "<br>"
                                    + "Method: "
                                    + method
                                    + "<br><br>"
                                    + "Do you want to continue?"
                                    + "</html>",
                            "Confirm Payment",
                            JOptionPane.YES_NO_OPTION
                    );

            if (confirmation !=
                    JOptionPane.YES_OPTION) {

                return;
            }

            processPayment(
                    paymentAmount,
                    method,
                    dialog
            );
        });

        dialog.add(
                form,
                BorderLayout.CENTER
        );

        dialog.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        dialog.setVisible(true);
    }

    // =========================================================
    // PROCESS PAYMENT
    // =========================================================

    private void processPayment(
            double paymentAmount,
            String method,
            JDialog dialog
    ) {

        String paymentId =
                String.format(
                        "PAY-%03d",
                        paymentCounter++
                );

        String date =
                new SimpleDateFormat(
                        "dd MMM yyyy"
                ).format(
                        new Date()
                );

        // =====================================================
        // UPDATE SHARED DATA
        // =====================================================

        ResidentPaymentData.addPayment(
                paymentAmount
        );

        amountPaid =
                ResidentPaymentData
                        .getAmountPaid();

        remainingAmount =
                ResidentPaymentData
                        .getRemainingAmount();

        String status =
                ResidentPaymentData
                        .getPaymentStatus();

        // =====================================================
        // ADD TO TABLE
        // =====================================================

        tableModel.addRow(
                new Object[]{
                        paymentId,
                        "October 2026",
                        formatMoney(
                                paymentAmount
                        ),
                        date,
                        method,
                        "PAID"
                }
        );

        // =====================================================
        // UPDATE LABELS
        // =====================================================

        paidLabel.setText(
                formatMoney(
                        amountPaid
                )
        );

        remainingLabel.setText(
                formatMoney(
                        remainingAmount
                )
        );

        statusLabel.setText(
                status
        );

        statusLabel.setForeground(
                getStatusColor()
        );

        dialog.dispose();

        showReceipt(
                paymentId,
                paymentAmount,
                method,
                date,
                status
        );
    }

    // =========================================================
    // RECEIPT
    // =========================================================

    private void showReceipt(
            String paymentId,
            double amount,
            String method,
            String date,
            String status
    ) {

        String receipt =
                "<html>"
                        + "<div style='width:350px;'>"

                        + "<h2 style='color:#2563EB;'>"
                        + "Payment Successful"
                        + "</h2>"

                        + "<hr>"

                        + "<b>Payment ID:</b> "
                        + paymentId
                        + "<br><br>"

                        + "<b>Resident:</b> John Doe"
                        + "<br><br>"

                        + "<b>Room:</b> 204"
                        + "<br><br>"

                        + "<b>Amount Paid:</b> "
                        + formatMoney(amount)
                        + "<br><br>"

                        + "<b>Payment Method:</b> "
                        + method
                        + "<br><br>"

                        + "<b>Payment Date:</b> "
                        + date
                        + "<br><br>"

                        + "<b>Status:</b> "
                        + status
                        + "<br><br>"

                        + "<b>Remaining Amount:</b> "
                        + formatMoney(
                        remainingAmount
                )

                        + "<hr>"

                        + "<center>"
                        + "Thank you for your payment!"
                        + "</center>"

                        + "</div>"
                        + "</html>";

        JOptionPane.showMessageDialog(
                frame,
                receipt,
                "Payment Receipt",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private JPanel createSummaryCard(
            String title,
            JLabel valueLabel,
            Color accent
    ) {

        JPanel card = new JPanel();

        card.setBackground(
                WHITE
        );

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(
                                        225,
                                        228,
                                        235
                                )
                        ),
                        new EmptyBorder(
                                15,
                                18,
                                15,
                                18
                        )
                )
        );

        card.setLayout(
                new BoxLayout(
                        card,
                        BoxLayout.Y_AXIS
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

        titleLabel.setForeground(
                GRAY
        );

        card.add(titleLabel);

        card.add(
                Box.createVerticalStrut(12)
        );

        valueLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        21
                )
        );

        valueLabel.setForeground(
                accent
        );

        card.add(valueLabel);

        return card;
    }

    // =========================================================
    // MENU BUTTON
    // =========================================================

    private JButton createMenuButton(
            String text,
            boolean active
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
                Color.WHITE
        );

        if (active) {
            button.setBackground(
                    PRIMARY
            );
        } else {
            button.setBackground(
                    DARK_BLUE
            );
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

        button.setFocusPainted(
                false
        );

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
    // STATUS COLOR
    // =========================================================

    private Color getStatusColor() {

        String status =
                ResidentPaymentData
                        .getPaymentStatus();

        if (status.equals("PAID")) {
            return GREEN;
        }

        if (status.equals("PENDING")) {
            return RED;
        }

        return ORANGE;
    }

    // =========================================================
    // MONEY FORMAT
    // =========================================================

    private String formatMoney(
            double amount
    ) {

        return String.format(
                "Rs. %,.0f",
                amount
        );
    }
}