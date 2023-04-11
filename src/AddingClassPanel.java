import javax.swing.*;
import java.awt.*;

public class AddingClassPanel {
    private JPanel addingClassPanel;
    private JLabel classNameLabel;
    JTextField classNameText;
    private JLabel classNumberLabel;
    JFormattedTextField classGroupNumbersText;

    AddingClassPanel(){
        addingClassPanel = new JPanel();
        addingClassPanel.setLayout(new GridLayout(4, 1));
        classNameLabel = new JLabel("Group name: ");
        classNameText = new JTextField();
        classNumberLabel = new JLabel("Max capacity of group: ");
        classGroupNumbersText = new JFormattedTextField();
        classGroupNumbersText.setPreferredSize(new Dimension(100,25));
        classNameText.setPreferredSize(new Dimension(100,25));

        addingClassPanel.add(classNameLabel);
        addingClassPanel.add(classNameText);
        addingClassPanel.add(classNumberLabel);
        addingClassPanel.add(classGroupNumbersText);

        JOptionPane.showInternalConfirmDialog(null, addingClassPanel, "Add Class to Gradebook", JOptionPane.OK_CANCEL_OPTION);
        //Class class1 = new Class(classNameText.getText(), Integer.parseInt(classGroupNumbersText.getText()));
        //System.out.println(class1.groupName +" "+ class1.maxStudentCount);

    }
}
