import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class SearchStudentWindow extends JFrame{
    SearchStudentWindow(StudentManagementSystem manager){
        JLabel title = new JLabel("Search Existing Student Record");
        title.setBounds(20,5,300,30);
        title.setFont(new Font("Montserrat",Font.BOLD,18));

        JLabel roll_tag = new JLabel("Enter Student's Roll Number : ");
        roll_tag.setBounds(20,40,300,25);
        roll_tag.setFont(new Font("Montserrat",Font.PLAIN,17));

        JTextField roll_input = new JTextField();
        roll_input.setBounds(20,75,300,25);
        roll_input.setHorizontalAlignment(SwingConstants.CENTER);

        JButton submit = new JButton("Search Details");
        submit.setBounds(20,110,140,35);
        submit.setFont(new Font("Montserrat",Font.PLAIN,16));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int target = Integer.parseInt(roll_input.getText());
                try {
                    ResultSet output = manager.SearchStudent(target);
                    if (output==null){
                        JOptionPane.showMessageDialog(null,"No record found for the given roll number","Error!",JOptionPane.ERROR);
                    }
                    else {
                        String [] details = new String[5];
                        while (output.next()){
                            details[0] = output.getString("name");
                            details[1] = String.valueOf(output.getInt("roll_number"));
                            details[2] = output.getString("grade");
                            details[3] = output.getString("gender");
                            details[4] = String.valueOf(output.getLong("phone_number"));
                        }
                        Font head_font = new Font("Montserrat",Font.BOLD,14);
                        JFrame outputFrame = new JFrame();
                        JLabel name = new JLabel("Student's Name: "+details[0]);
                        JLabel roll = new JLabel("Student's Roll Number: "+details[1]);
                        JLabel grade = new JLabel("Student's Grade: "+details[2]);
                        JLabel gender = new JLabel("Student's Gender: "+details[3]);
                        JLabel phone = new JLabel("Student's Phone Number: "+details[4]);
                        outputFrame.setTitle("Your Name's Details");

                        name.setBounds(20,20,300,25);
                        roll.setBounds(20,50,350,25);
                        grade.setBounds(20,80,250,25);
                        gender.setBounds(170,80,250,25);
                        phone.setBounds(20,110,300,25);

                        name.setFont(head_font);
                        roll.setFont(head_font);
                        grade.setFont(head_font);
                        gender.setFont(head_font);
                        phone.setFont(head_font);

                        JButton done = new JButton("Ok, Done!");
                        done.setBounds(140,140,100,25);
                        done.setFont(head_font);
                        done.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                outputFrame.dispose();
                            }
                        });

                        outputFrame.add(name);
                        outputFrame.add(roll);
                        outputFrame.add(grade);
                        outputFrame.add(gender);
                        outputFrame.add(phone);
                        outputFrame.add(done);
                        outputFrame.setLayout(null);
                        outputFrame.setSize(400,220);
                        outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        outputFrame.setVisible(true);
                    }
                    
                } catch (Exception exeSearch) {
                    exeSearch.printStackTrace();
                }
            }
        });

        JButton reset = new JButton("Reset Details");
        reset.setBounds(180,110,140,35);
        reset.setFont(new Font("Montserrat",Font.PLAIN,16));
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                roll_input.setText("");
            }
        });

        this.add(reset);
        this.add(submit);
        this.add(roll_input);
        this.add(roll_tag);
        this.add(title);
        this.setTitle("Search Student Record");
        this.setLayout(null);
        this.setSize(350,200);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        SearchStudentWindow s1 = new SearchStudentWindow(null);
        s1.setTitle(null);
    }
}
