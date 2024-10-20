package ToDoListManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList extends JFrame {

    private JLabel task;
    private JTextField taskField;
    private JButton addTask;
    private JList taskList;
    private DefaultListModel<String> tList;
    private JPanel inputPanel, buttonPanel;
    private JButton removeTask;
    private JButton clearAll;

    public ToDoList() {
        initializeComponent();
        setUp();

    }

    private void initializeComponent() {
        this.setLayout(new BorderLayout());
        this.setSize(400,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.task = new JLabel("Task:");

        this.taskField = new JTextField();
        this.taskField.setEditable(true);
        this.taskField.setPreferredSize(new Dimension(200, 40));

        this.addTask = new JButton("Add Task");

        tList = new DefaultListModel<>();
        this.taskList = new JList(tList);

        this.removeTask = new JButton("Remove Task");
        this.clearAll = new JButton("Clear All");

        this.inputPanel = new JPanel(new FlowLayout());
        this.buttonPanel = new JPanel(new FlowLayout());

    }

    private void setUp() {
        this.inputPanel.add(task);
        this.inputPanel.add(taskField);
        this.inputPanel.add(addTask);


        this.add(inputPanel, BorderLayout.NORTH);
        setAddTaskButton();

        this.add(taskList, BorderLayout.CENTER);

        this.buttonPanel.add(removeTask);
        this.buttonPanel.add(clearAll);

        this.add(buttonPanel, BorderLayout.SOUTH);
        setRemoveTask();
        setClearAll();


        this.setVisible(true);
    }

    private void setAddTaskButton() {
        this.addTask.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText();
                if (task != null) {
                    tList.addElement(task);
                    taskField.setText("");
                }
            }
        });
    }

    private void setRemoveTask() {
        this.removeTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = taskList.getSelectedIndex();
                tList.remove(i);
            }
        });
    }

    private void setClearAll() {
        this.clearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tList.removeAllElements();
            }
        });
    }

}
