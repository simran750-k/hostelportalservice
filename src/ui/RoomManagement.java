package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.regex.Pattern;

public class RoomManagement {

    // ==========================================
    // COLORS
    // ==========================================

    private static final Color PRIMARY = new Color(30, 64, 175);
    private static final Color DARK_BLUE = new Color(15, 23, 42);
    private static final Color LIGHT_BG = new Color(241, 245, 249);
    private static final Color WHITE = Color.WHITE;
    private static final Color TEXT = new Color(30, 41, 59);
    private static final Color GRAY = new Color(100, 116, 139);
    private static final Color GREEN = new Color(22, 163, 74);
    private static final Color RED = new Color(220, 38, 38);
    private static final Color BORDER = new Color(203, 213, 225);

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Room Management");

        frame.setSize(1100, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // ==========================================
        // MAIN PANEL
        // ==========================================

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(LIGHT_BG);

        // ==========================================
        // SIDEBAR
        // ==========================================

        JPanel sidebar = new JPanel();

        sidebar.setBackground(DARK_BLUE);
        sidebar.setPreferredSize(new Dimension(230, 650));

        sidebar.setLayout(
                new BoxLayout(sidebar, BoxLayout.Y_AXIS)
        );

        // ==========================================
        // LOGO
        // ==========================================

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

        JLabel logoIcon = new JLabel("🏠");

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

        JLabel logoTitle = new JLabel("HOSTEL");

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

        JLabel logoSubtitle = new JLabel(
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
                new Color(148, 163, 184)
        );

        logoSubtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        logoPanel.add(logoIcon);
        logoPanel.add(Box.createVerticalStrut(5));
        logoPanel.add(logoTitle);
        logoPanel.add(logoSubtitle);

        sidebar.add(logoPanel);

        // ==========================================
        // SIDEBAR BUTTONS
        // ==========================================

        JButton dashboardButton =
                createSidebarButton("🏠  Dashboard");

        JButton residentButton =
                createSidebarButton("👥  Residents");

        JButton roomButton =
                createSidebarButton("🛏  Rooms");

        JButton paymentButton =
                createSidebarButton("💳  Payments");

        JButton complaintButton =
                createSidebarButton("📝  Complaints");

        JButton reportButton =
                createSidebarButton("📊  Reports");

        JButton notificationButton =
                createSidebarButton("🔔  Notifications");

        JButton profileButton =
                createSidebarButton("👤  Profile");

        JButton logoutButton =
                createSidebarButton("🚪  Logout");

        sidebar.add(dashboardButton);
        sidebar.add(residentButton);
        sidebar.add(roomButton);
        sidebar.add(paymentButton);
        sidebar.add(complaintButton);
        sidebar.add(reportButton);
        sidebar.add(notificationButton);
        sidebar.add(profileButton);

        sidebar.add(Box.createVerticalGlue());

        sidebar.add(logoutButton);

        sidebar.add(
                Box.createVerticalStrut(20)
        );

        // ==========================================
        // SIDEBAR NAVIGATION
        // ==========================================

        dashboardButton.addActionListener(e -> {
            admindashboard.main(null);
            frame.dispose();
        });

        residentButton.addActionListener(e -> {
            ResidentManagement.main(null);
            frame.dispose();
        });

        // Current page
        roomButton.addActionListener(e -> {
            // Already on Room Management
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

        logoutButton.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (choice == JOptionPane.YES_OPTION) {

                login.main(null);
                frame.dispose();
            }
        });

        // ==========================================
        // RIGHT PANEL
        // ==========================================

        JPanel rightPanel = new JPanel(
                new BorderLayout()
        );

        rightPanel.setBackground(LIGHT_BG);

        // ==========================================
        // TOP BAR
        // ==========================================

        JPanel topBar = new JPanel(
                new BorderLayout()
        );

        topBar.setBackground(WHITE);

        topBar.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 25, 15, 25
                )
        );

        JLabel pageTitle = new JLabel(
                "Room Management"
        );

        pageTitle.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        pageTitle.setForeground(TEXT);

        JLabel adminLabel = new JLabel(
                "👤  Admin"
        );

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

        // ==========================================
        // CONTENT
        // ==========================================

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

        JLabel heading = new JLabel(
                "Manage Rooms"
        );

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

        JLabel subtitle = new JLabel(
                "View and manage hostel room information."
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
                Box.createVerticalStrut(20)
        );

        // ==========================================
        // SEARCH + ADD ROOM
        // ==========================================

        JPanel actionPanel = new JPanel(
                new BorderLayout(15, 0)
        );

        actionPanel.setBackground(LIGHT_BG);

        actionPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        45
                )
        );

        actionPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JTextField searchField = new JTextField();

        searchField.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        searchField.setPreferredSize(
                new Dimension(350, 40)
        );

        searchField.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        BorderFactory.createEmptyBorder(
                                5, 10, 5, 10
                        )
                )
        );

        searchField.setToolTipText(
                "Search by room number, floor, type or status"
        );

        actionPanel.add(
                searchField,
                BorderLayout.WEST
        );

        JButton addButton = new JButton(
                "＋  Add Room"
        );

        addButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        addButton.setForeground(WHITE);
        addButton.setBackground(PRIMARY);

        addButton.setFocusPainted(false);

        addButton.setBorder(
                BorderFactory.createEmptyBorder(
                        10, 20, 10, 20
                )
        );

        actionPanel.add(
                addButton,
                BorderLayout.EAST
        );

        content.add(actionPanel);

        content.add(
                Box.createVerticalStrut(20)
        );

        // ==========================================
        // ROOM TABLE
        // ==========================================

        String[] columns = {
                "Room No.",
                "Floor",
                "Room Type",
                "Capacity",
                "Occupied",
                "Status"
        };

        Object[][] data = {

                {
                        "201",
                        "1st Floor",
                        "Double Sharing",
                        "2",
                        "2",
                        "Full"
                },

                {
                        "202",
                        "1st Floor",
                        "Double Sharing",
                        "2",
                        "1",
                        "Available"
                },

                {
                        "203",
                        "2nd Floor",
                        "Double Sharing",
                        "2",
                        "2",
                        "Full"
                },

                {
                        "204",
                        "2nd Floor",
                        "Double Sharing",
                        "2",
                        "2",
                        "Full"
                },

                {
                        "205",
                        "2nd Floor",
                        "Triple Sharing",
                        "3",
                        "2",
                        "Available"
                },

                {
                        "301",
                        "3rd Floor",
                        "Single",
                        "1",
                        "1",
                        "Full"
                }
        };

        DefaultTableModel model =
                new DefaultTableModel(
                        data,
                        columns
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };

        JTable table = new JTable(model);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        table.setRowHeight(40);

        table.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        table.setGridColor(
                new Color(226, 232, 240)
        );

        table.setBackground(WHITE);
        table.setForeground(TEXT);

        table.setSelectionBackground(
                new Color(219, 234, 254)
        );

        table.setSelectionForeground(TEXT);

        // ==========================================
        // SEARCH FUNCTION
        // ==========================================

        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(model);

        table.setRowSorter(sorter);

        searchField.getDocument().addDocumentListener(
                new DocumentListener() {

                    private void search() {

                        String text =
                                searchField
                                        .getText()
                                        .trim();

                        if (text.length() == 0) {

                            sorter.setRowFilter(null);

                        } else {

                            sorter.setRowFilter(
                                    RowFilter.regexFilter(
                                            "(?i)"
                                                    + Pattern.quote(text)
                                    )
                            );
                        }
                    }

                    @Override
                    public void insertUpdate(
                            DocumentEvent e
                    ) {
                        search();
                    }

                    @Override
                    public void removeUpdate(
                            DocumentEvent e
                    ) {
                        search();
                    }

                    @Override
                    public void changedUpdate(
                            DocumentEvent e
                    ) {
                        search();
                    }
                }
        );

        // ==========================================
        // TABLE HEADER
        // ==========================================

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        table.getTableHeader().setBackground(
                new Color(226, 232, 240)
        );

        table.getTableHeader().setForeground(TEXT);

        table.getTableHeader().setPreferredSize(
                new Dimension(0, 40)
        );

        // ==========================================
        // COLUMN WIDTHS
        // ==========================================

        table.getColumnModel()
                .getColumn(0)
                .setPreferredWidth(80);

        table.getColumnModel()
                .getColumn(1)
                .setPreferredWidth(100);

        table.getColumnModel()
                .getColumn(2)
                .setPreferredWidth(160);

        table.getColumnModel()
                .getColumn(3)
                .setPreferredWidth(80);

        table.getColumnModel()
                .getColumn(4)
                .setPreferredWidth(80);

        table.getColumnModel()
                .getColumn(5)
                .setPreferredWidth(100);

        JScrollPane tableScrollPane =
                new JScrollPane(table);

        tableScrollPane.setBorder(
                BorderFactory.createLineBorder(
                        new Color(226, 232, 240)
                )
        );

        tableScrollPane.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        content.add(tableScrollPane);

        content.add(
                Box.createVerticalStrut(15)
        );

        // ==========================================
        // EDIT + DELETE BUTTONS
        // ==========================================

        JPanel buttonPanel = new JPanel(
                new FlowLayout(
                        FlowLayout.RIGHT,
                        10,
                        5
                )
        );

        buttonPanel.setBackground(LIGHT_BG);

        buttonPanel.setMaximumSize(
                new Dimension(
                        Integer.MAX_VALUE,
                        50
                )
        );

        buttonPanel.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        JButton editButton = new JButton(
                "✏ Edit Room"
        );

        JButton deleteButton = new JButton(
                "🗑 Delete Room"
        );

        editButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        deleteButton.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        editButton.setForeground(TEXT);
        deleteButton.setForeground(RED);

        editButton.setBackground(WHITE);
        deleteButton.setBackground(WHITE);

        editButton.setFocusPainted(false);
        deleteButton.setFocusPainted(false);

        editButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(BORDER),
                        BorderFactory.createEmptyBorder(
                                8, 15, 8, 15
                        )
                )
        );

        deleteButton.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(254, 202, 202)
                        ),
                        BorderFactory.createEmptyBorder(
                                8, 15, 8, 15
                        )
                )
        );

        // ==========================================
        // ADD ROOM
        // ==========================================

        addButton.addActionListener(e -> {

            showRoomForm(
                    frame,
                    model,
                    -1,
                    null
            );

        });

        // ==========================================
        // EDIT ROOM
        // ==========================================

        editButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a room first.",
                        "No Room Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // Convert displayed row to model row
            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            showRoomForm(
                    frame,
                    model,
                    modelRow,
                    table
            );
        });

        // ==========================================
        // DELETE ROOM
        // ==========================================

        deleteButton.addActionListener(e -> {

            int selectedRow =
                    table.getSelectedRow();

            if (selectedRow == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Please select a room first.",
                        "No Room Selected",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int modelRow =
                    table.convertRowIndexToModel(
                            selectedRow
                    );

            String roomNumber =
                    model.getValueAt(
                            modelRow,
                            0
                    ).toString();

            int choice =
                    JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to delete Room "
                                    + roomNumber
                                    + "?",
                            "Delete Room",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE
                    );

            if (choice ==
                    JOptionPane.YES_OPTION) {

                model.removeRow(modelRow);

                JOptionPane.showMessageDialog(
                        frame,
                        "Room "
                                + roomNumber
                                + " deleted successfully.",
                        "Room Deleted",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        content.add(buttonPanel);

        // ==========================================
        // ADD CONTENT TO RIGHT PANEL
        // ==========================================

        JScrollPane contentScrollPane =
                new JScrollPane(content);

        contentScrollPane.setBorder(null);

        contentScrollPane.getVerticalScrollBar()
                .setUnitIncrement(16);

        rightPanel.add(
                contentScrollPane,
                BorderLayout.CENTER
        );

        // ==========================================
        // MAIN PANEL
        // ==========================================

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

    // ==========================================
    // ADD / EDIT ROOM FORM
    // ==========================================

    private static void showRoomForm(
            JFrame parent,
            DefaultTableModel model,
            int editRow,
            JTable table
    ) {

        boolean editing =
                editRow != -1;

        JDialog dialog =
                new JDialog(
                        parent,
                        editing
                                ? "Edit Room"
                                : "Add Room",
                        true
                );

        dialog.setSize(430, 500);
        dialog.setLocationRelativeTo(parent);
        dialog.setResizable(false);

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout()
                );

        mainPanel.setBackground(WHITE);

        // ==========================================
        // FORM HEADER
        // ==========================================

        JPanel header =
                new JPanel(
                        new BorderLayout()
                );

        header.setBackground(PRIMARY);

        header.setBorder(
                BorderFactory.createEmptyBorder(
                        15, 20, 15, 20
                )
        );

        JLabel title =
                new JLabel(
                        editing
                                ? "Edit Room"
                                : "Add New Room"
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        20
                )
        );

        title.setForeground(WHITE);

        header.add(
                title,
                BorderLayout.WEST
        );

        mainPanel.add(
                header,
                BorderLayout.NORTH
        );

        // ==========================================
        // FORM
        // ==========================================

        JPanel form =
                new JPanel(
                        new GridBagLayout()
                );

        form.setBackground(WHITE);

        form.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 25, 10, 25
                )
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets =
                new Insets(7, 5, 7, 5);

        gbc.fill =
                GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1;

        // ==========================================
        // ROOM NUMBER
        // ==========================================

        JLabel roomLabel =
                new JLabel("Room Number:");

        JTextField roomField =
                new JTextField();

        // ==========================================
        // FLOOR
        // ==========================================

        JLabel floorLabel =
                new JLabel("Floor:");

        JComboBox<String> floorBox =
                new JComboBox<>(
                        new String[]{
                                "1st Floor",
                                "2nd Floor",
                                "3rd Floor",
                                "4th Floor"
                        }
                );

        // ==========================================
        // ROOM TYPE
        // ==========================================

        JLabel typeLabel =
                new JLabel("Room Type:");

        JComboBox<String> typeBox =
                new JComboBox<>(
                        new String[]{
                                "Single",
                                "Double Sharing",
                                "Triple Sharing"
                        }
                );

        // ==========================================
        // CAPACITY
        // ==========================================

        JLabel capacityLabel =
                new JLabel("Capacity:");

        JTextField capacityField =
                new JTextField();

        // ==========================================
        // OCCUPIED
        // ==========================================

        JLabel occupiedLabel =
                new JLabel("Occupied:");

        JTextField occupiedField =
                new JTextField();

        // ==========================================
        // FILL EDIT DATA
        // ==========================================

        if (editing) {

            roomField.setText(
                    model.getValueAt(
                            editRow,
                            0
                    ).toString()
            );

            floorBox.setSelectedItem(
                    model.getValueAt(
                            editRow,
                            1
                    ).toString()
            );

            typeBox.setSelectedItem(
                    model.getValueAt(
                            editRow,
                            2
                    ).toString()
            );

            capacityField.setText(
                    model.getValueAt(
                            editRow,
                            3
                    ).toString()
            );

            occupiedField.setText(
                    model.getValueAt(
                            editRow,
                            4
                    ).toString()
            );
        }

        // ==========================================
        // ADD FORM COMPONENTS
        // ==========================================

        addFormRow(
                form,
                gbc,
                0,
                roomLabel,
                roomField
        );

        addFormRow(
                form,
                gbc,
                1,
                floorLabel,
                floorBox
        );

        addFormRow(
                form,
                gbc,
                2,
                typeLabel,
                typeBox
        );

        addFormRow(
                form,
                gbc,
                3,
                capacityLabel,
                capacityField
        );

        addFormRow(
                form,
                gbc,
                4,
                occupiedLabel,
                occupiedField
        );

        mainPanel.add(
                form,
                BorderLayout.CENTER
        );

        // ==========================================
        // BUTTON PANEL
        // ==========================================

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                10
                        )
                );

        buttonPanel.setBackground(WHITE);

        JButton cancelButton =
                new JButton("Cancel");

        JButton saveButton =
                new JButton(
                        editing
                                ? "Update Room"
                                : "Save Room"
                );

        cancelButton.setFocusPainted(false);
        saveButton.setFocusPainted(false);

        cancelButton.setBackground(
                new Color(226, 232, 240)
        );

        saveButton.setBackground(PRIMARY);
        saveButton.setForeground(WHITE);

        // ==========================================
        // CANCEL
        // ==========================================

        cancelButton.addActionListener(e ->
                dialog.dispose()
        );

        // ==========================================
        // SAVE / UPDATE
        // ==========================================

        saveButton.addActionListener(e -> {

            String roomNumber =
                    roomField.getText().trim();

            String floor =
                    floorBox
                            .getSelectedItem()
                            .toString();

            String roomType =
                    typeBox
                            .getSelectedItem()
                            .toString();

            String capacityText =
                    capacityField
                            .getText()
                            .trim();

            String occupiedText =
                    occupiedField
                            .getText()
                            .trim();

            // ======================================
            // VALIDATION
            // ======================================

            if (roomNumber.isEmpty()
                    || capacityText.isEmpty()
                    || occupiedText.isEmpty()) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Please fill in all fields.",
                        "Validation Error",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int capacity;
            int occupied;

            try {

                capacity =
                        Integer.parseInt(
                                capacityText
                        );

                occupied =
                        Integer.parseInt(
                                occupiedText
                        );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Capacity and Occupied must be numbers.",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (capacity <= 0) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Capacity must be greater than 0.",
                        "Invalid Capacity",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (occupied < 0) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Occupied cannot be negative.",
                        "Invalid Occupied",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (occupied > capacity) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Occupied students cannot be greater than capacity.",
                        "Invalid Occupied",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // ======================================
            // AUTOMATIC STATUS
            // ======================================

            String status;

            if (occupied >= capacity) {
                status = "Full";
            } else {
                status = "Available";
            }

            // ======================================
            // CHECK DUPLICATE ROOM NUMBER
            // ======================================

            if (!editingRoomNumberExists(
                    model,
                    roomNumber,
                    editRow
            )) {

                JOptionPane.showMessageDialog(
                        dialog,
                        "Room number already exists.",
                        "Duplicate Room",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            // ======================================
            // ADD NEW ROOM
            // ======================================

            if (!editing) {

                model.addRow(
                        new Object[]{
                                roomNumber,
                                floor,
                                roomType,
                                capacity,
                                occupied,
                                status
                        }
                );

                JOptionPane.showMessageDialog(
                        dialog,
                        "Room added successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );

            }

            // ======================================
            // UPDATE ROOM
            // ======================================

            else {

                model.setValueAt(
                        roomNumber,
                        editRow,
                        0
                );

                model.setValueAt(
                        floor,
                        editRow,
                        1
                );

                model.setValueAt(
                        roomType,
                        editRow,
                        2
                );

                model.setValueAt(
                        capacity,
                        editRow,
                        3
                );

                model.setValueAt(
                        occupied,
                        editRow,
                        4
                );

                model.setValueAt(
                        status,
                        editRow,
                        5
                );

                JOptionPane.showMessageDialog(
                        dialog,
                        "Room updated successfully.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

            dialog.dispose();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(saveButton);

        mainPanel.add(
                buttonPanel,
                BorderLayout.SOUTH
        );

        dialog.add(mainPanel);

        dialog.setVisible(true);
    }

    // ==========================================
    // ADD FORM ROW
    // ==========================================

    private static void addFormRow(
            JPanel panel,
            GridBagConstraints gbc,
            int row,
            JLabel label,
            JComponent component
    ) {

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0.3;

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(TEXT);

        panel.add(
                label,
                gbc
        );

        gbc.gridx = 1;
        gbc.weightx = 0.7;

        component.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        13
                )
        );

        panel.add(
                component,
                gbc
        );
    }

    // ==========================================
    // DUPLICATE ROOM CHECK
    // ==========================================

    private static boolean editingRoomNumberExists(
            DefaultTableModel model,
            String roomNumber,
            int editRow
    ) {

        for (int i = 0; i < model.getRowCount(); i++) {

            if (i == editRow) {
                continue;
            }

            String existingRoom =
                    model.getValueAt(
                            i,
                            0
                    ).toString();

            if (existingRoom.equalsIgnoreCase(
                    roomNumber
            )) {
                return false;
            }
        }

        return true;
    }

    // ==========================================
    // SIDEBAR BUTTON METHOD
    // ==========================================

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