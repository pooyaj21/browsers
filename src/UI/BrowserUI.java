package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logic.*;

public class BrowserUI extends JFrame {
    private User user;

    private JTextArea textArea;
    private JTextField tabNameField;
    private JTextField groupNameField;
    private JComboBox<String> tabComboBox;
    private JComboBox<String> groupComboBox;

    public BrowserUI(User user) {
        this.user = user;

        setTitle("Browser UI");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JLabel tabNameLabel = new JLabel("Tab Name:");
        tabNameField = new JTextField(15);

        JLabel groupNameLabel = new JLabel("Group Name:");
        groupNameField = new JTextField(15);

        JButton addTabButton = new JButton("Add Tab");
        addTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tabName = tabNameField.getText().trim();
                if (!tabName.isEmpty()) {
                    Browser.getInstance().createTab(user, tabName);
                    displayUserInfo();
                    tabNameField.setText("");
                    updateTabComboBox();
                }
            }
        });

        tabComboBox = new JComboBox<>();
        updateTabComboBox();

        groupComboBox = new JComboBox<>();
        updateGroupComboBox();

        JButton createGroupButton = new JButton("Create Group");
        createGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String groupName = groupNameField.getText().trim();
                if (!groupName.isEmpty()) {
                    Browser.getInstance().createGroup(user, groupName);
                    updateGroupComboBox();
                    displayUserInfo();
                    groupNameField.setText("");
                }
            }
        });

        JButton addTabToGroupButton = new JButton("Add Tab to Group");
        addTabToGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tabIndex = tabComboBox.getSelectedIndex();
                int groupIndex = groupComboBox.getSelectedIndex();
                if (tabIndex >= 0 && groupIndex >= 0) {
                    Browser.getInstance().addTabToGroup(user.getTabs().get(tabIndex), user.getGroups().get(groupIndex));
                    displayUserInfo();
                }
            }
        });
        JPanel inputPanel = new JPanel(new GridLayout(4, 3));
        inputPanel.add(tabNameLabel);
        inputPanel.add(tabNameField);
        inputPanel.add(addTabButton);
        inputPanel.add(groupNameLabel);
        inputPanel.add(groupNameField);
        inputPanel.add(createGroupButton);
        inputPanel.add(tabComboBox);
        inputPanel.add(groupComboBox);
        inputPanel.add(addTabToGroupButton);

        JPanel buttonPanel = new JPanel();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void displayUserInfo() {
        textArea.setText(user.toString());
    }

    private void updateTabComboBox() {
        tabComboBox.removeAllItems();
        for (Tab tab : user.getTabs()) {
            tabComboBox.addItem(tab.getName());
        }
    }

    private void updateGroupComboBox() {
        groupComboBox.removeAllItems();
        for (Group group : user.getGroups()) {
            groupComboBox.addItem(group.getName());
        }
    }

    public static void main(String[] args) {
        User user = new User("Pooya J");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BrowserUI(user).setVisible(true);
            }
        });
    }
}
