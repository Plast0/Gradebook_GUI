import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.NoRouteToHostException;

public class GUI implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JPanel topPanel;
    private static JPanel buttonPanel;
    private static JLabel labelClass;
    private static JLabel labelStudents;
    private static JList groupsList;
    private static JList studentsList;
    private static JTable classTable;
    private static JTable studentsTable;
    private static JButton addClassButton;
    private static JButton addStudentButton;
    private static JButton removeClassButton;
    private static JButton removeStudentButton;
    DefaultTableModel model;
    DefaultTableModel modelStudent;

    ClassContainer gradebook;

    Student student;

    public GUI() {

        frame = new JFrame();
        labelClass = new JLabel("Classes");
        labelStudents = new JLabel("Students");
        groupsList = new JList<>();
        studentsList = new JList();
        panel = new JPanel();
        topPanel = new JPanel();
        buttonPanel = new JPanel();
        classTable = new JTable();
        studentsTable = new JTable();
        addClassButton = new JButton("Add Class");
        removeClassButton = new JButton("Remove Class");
        addStudentButton = new JButton("Add student");
        removeStudentButton = new JButton("Remove student");
        gradebook = new ClassContainer();

        model = new DefaultTableModel();
        Object[] columns = { "Class name"};
        model.setColumnIdentifiers(columns);
        classTable.setModel(model);

        modelStudent = new DefaultTableModel();
        Object[] columns2 = {"Student name", "Student surname", "Condition", "Year", "Sum of points"};
        modelStudent.setColumnIdentifiers(columns2);
        studentsTable.setModel(modelStudent);

        frame.setSize(700,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Gradebook");
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);

        panel.setLayout(new GridLayout(1, 2,25,0));
        topPanel.setLayout(new GridLayout(1,2,25,0));
        buttonPanel.setLayout(new GridLayout(1,4,5,5));

        topPanel.add(labelClass);
        topPanel.add(labelStudents);
        classTable.setBounds(25,50,150,100 );
        classTable.setAutoCreateRowSorter(true);
        panel.add(classTable);
        studentsTable.setBounds(25,50,150,100);
        studentsTable.setAutoCreateRowSorter(true);
        panel.add(studentsTable);
        //addClassButton.setBounds(10,80,25,25);
        addClassButton.addActionListener(this);
        removeClassButton.addActionListener(this);
        buttonPanel.add(addClassButton);
        buttonPanel.add(removeClassButton);
        addStudentButton.addActionListener(this);
        buttonPanel.add(addStudentButton);
        buttonPanel.add(removeStudentButton);
        classTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(classTable.getSelectedRow() > -1 ){
                    System.out.println(gradebook.classMap.toString());
                }
            }
        });

        frame.setVisible(true);
        frame.setResizable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addStudentButton){
            System.out.println("add Student Button");
            int i = classTable.getSelectedRow();
            if(i>=0){
            AddingStudentPanel addingStudentPanel = new AddingStudentPanel();
            Student student = new Student(addingStudentPanel.nameText.getText(), addingStudentPanel.surnameText.getText(),StudentCondition.PRESENT,Integer.parseInt(addingStudentPanel.dateText.getText()),0);

            System.out.println(student.toString());
            modelStudent.addRow(new Object[]{student.name, student.surname, student.condition, student.dateOfBirth, student.pointsSum});
            }
        } else if (e.getSource() == addClassButton) {
            System.out.println("add class button");
            AddingClassPanel addingClassPanel = new AddingClassPanel();
            Class class1 = new Class(addingClassPanel.classNameText.getText(), Integer.parseInt(addingClassPanel.classGroupNumbersText.getText()));

            if(gradebook.classMap.containsKey(addingClassPanel.classNameText.getText())){
                System.out.println("This class has already been added.");
            }else{
                model.addRow(new Object[]{class1.groupName});
                gradebook.addClass(addingClassPanel.classNameText.getText(),class1);
            }

        } else if (e.getSource() == removeClassButton) {
            int i = classTable.getSelectedRow();
            if(i >= 0){
                String groupName= model.getValueAt(0,0).toString();
                gradebook.removeClas(groupName);
                model.removeRow(i);
                gradebook.summary();
        }else{
                JOptionPane.showMessageDialog(null,"Delete error");
            }

        }
    }
}
