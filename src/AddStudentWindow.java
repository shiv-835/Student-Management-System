import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddStudentWindow extends JFrame{
    Font heads = new Font("Montserrat",Font.PLAIN,16);
    AddStudentWindow(StudentManagementSystem manager){
        JLabel title = new JLabel("Add New Student's Record");
        title.setBounds(130,0,500,25);
        title.setFont(new Font("Montserrat",Font.BOLD,18));

        JLabel name_tag = new JLabel("Student's Name :");
        name_tag.setBounds(20,40,150,25);
        name_tag.setFont(heads);

        JTextField name_input = new JTextField();
        name_input.setBounds(170,40,300,25);

        JLabel roll_tag = new JLabel("Student's Roll Number :");
        roll_tag.setBounds(20,80,190,25);
        roll_tag.setFont(heads);

        JTextField roll_input = new JTextField();
        roll_input.setBounds(210,80,260,25);

        JLabel grade_tag = new JLabel("Student's Grade :");
        grade_tag.setBounds(20,120,150,25);
        grade_tag.setFont(heads);

        String[] grades = {"A+","A","B+","B","C+","C","D","E","F"};
        JComboBox <String> grade_input = new JComboBox<>(grades);
        grade_input.setBounds(160,120,75,25);

        JLabel gender_tag = new JLabel("Student's Gender :");
        gender_tag.setBounds(240,120,150,25);
        gender_tag.setFont(heads);

        String[] gender = {"Male","Female","Other"};
        JComboBox <String> gender_input = new JComboBox<>(gender);
        gender_input.setBounds(390,120,100,25);

        JLabel phone_tag = new JLabel("Student's Contact Number : ");
        phone_tag.setBounds(20,160,250,25);
        phone_tag.setFont(heads);

        JTextField phone_input = new JTextField();
        phone_input.setBounds(245,160,240,25);

        JButton submit = new JButton("Add Record");
        submit.setBounds(130,205,120,35);
        submit.setFont(heads);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (!phone_input.getText().matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(new JFrame(), "Phone Number should be numeric and of length 10", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Student s1 = new Student(name_input.getText(),Integer.parseInt(roll_input.getText()),(String)grade_input.getSelectedItem(),(String)gender_input.getSelectedItem(),Long.parseLong(phone_input.getText()));
                try {
                    manager.AddStudent(s1);
                }
                catch(Exception exe){
                    exe.printStackTrace();
                }
            }
        });

        JButton reset = new JButton("Reset Fields");
        reset.setBounds(270,205,120,35);
        reset.setFont(heads);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name_input.setText("");
                roll_input.setText("");
                phone_input.setText("");
            }
        });

        this.add(reset);
        this.add(submit);
        this.add(phone_input);
        this.add(phone_tag);
        this.add(gender_tag);
        this.add(gender_input);
        this.add(grade_input);
        this.add(grade_tag);
        this.add(roll_tag);
        this.add(roll_input);
        this.add(name_tag);
        this.add(name_input);
        this.add(title);
        this.setLayout(null);
        this.setSize(500,300);
        this.setVisible(true);
        this.setTitle("Add New Student");
    }
    public static void main(String[] args) {
        AddStudentWindow s1 = new AddStudentWindow(null);
        s1.setTitle("Add New Student");
    }
}
