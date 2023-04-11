import javax.swing.*;
import java.awt.*;

public class AddingStudentPanel {
    JPanel addingStudentPanel;
    JTextField nameText;
    JTextField surnameText;
    JTextField dateText;
    JLabel nameLabel;
    JLabel surnameLabel;
    JLabel dateLabel;
    public AddingStudentPanel() {

        addingStudentPanel = new JPanel();
        addingStudentPanel.setLayout(new GridLayout(6,1));
        nameText = new JTextField();
        surnameText =new JTextField();
        dateText = new JTextField();
        nameLabel = new JLabel("Student name: ");
        surnameLabel = new JLabel("Student surname: ");
        dateLabel = new JLabel("Year of birth: ");

        nameText.setPreferredSize(new Dimension(100, 25));
        surnameText.setPreferredSize(new Dimension(100,25));
        dateText.setPreferredSize(new Dimension(100,25));

        addingStudentPanel.add(nameLabel);
        addingStudentPanel.add(nameText);
        addingStudentPanel.add(surnameLabel);
        addingStudentPanel.add(surnameText);
        addingStudentPanel.add(dateLabel);
        addingStudentPanel.add(dateText);

        int result = JOptionPane.showConfirmDialog(null,  addingStudentPanel,"Adding students data",JOptionPane.OK_CANCEL_OPTION );
        //Student student = new Student(nameText.getText(), surnameText.getText(),StudentCondition.PRESENT,Integer.parseInt(dateText.getText()),0);
        //System.out.println(student.toString());
    }
}
