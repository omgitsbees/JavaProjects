import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoListApp extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public TodoListApp() {
        // Set the title of the window
        setTitle("Todo List");

        // Set the size of the window
        setSize(400, 300);

        // Set the layout of the window
        setLayout(new BorderLayout());

        // Initialize the list model and task list
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Create the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        // Create the text field for input
        taskInput = new JTextField();
        inputPanel.add(taskInput, BorderLayout.CENTER);

        // Create the add button
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText().trim();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        // Create the remove button
        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });
        add(removeButton, BorderLayout.SOUTH);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new TodoListApp();
    }
}
