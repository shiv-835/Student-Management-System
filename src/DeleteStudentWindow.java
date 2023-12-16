import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DeleteStudentWindow extends JFrame{
    DeleteStudentWindow(StudentManagementSystem manager){
        JLabel title = new JLabel("Delete Existing Student Record");
        title.setBounds(20,5,300,30);
        title.setFont(new Font("Montserrat",Font.BOLD,18));

        JLabel roll_tag = new JLabel("Enter Student's Roll Number : ");
        roll_tag.setBounds(20,40,300,25);
        roll_tag.setFont(new Font("Montserrat",Font.PLAIN,17));

        JTextField roll_input = new JTextField();
        roll_input.setBounds(20,75,300,25);
        roll_input.setHorizontalAlignment(SwingConstants.CENTER);

        JButton submit = new JButton("Delete Details");
        submit.setBounds(20,110,140,35);
        submit.setFont(new Font("Montserrat",Font.PLAIN,16));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int target = Integer.parseInt(roll_input.getText());
                try {
                    manager.RemoveStudent(target);
                } catch (Exception exeDelete) {
                    exeDelete.printStackTrace();
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
        this.setTitle("Delete Student Record");
        this.setLayout(null);
        this.setSize(350,200);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        DeleteStudentWindow d1 = new DeleteStudentWindow(null);
        d1.setTitle(null);
    }
}
