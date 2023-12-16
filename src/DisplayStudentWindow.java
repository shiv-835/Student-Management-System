import javax.swing.*;
import java.awt.*;
public class DisplayStudentWindow{
    DisplayStudentWindow(StudentManagementSystem manager){
        try {
            PairOut out = manager.DisplayStudent();
            if (out.rs == null){
                JOptionPane.showMessageDialog(null,"Nothing to show here","Error!",JOptionPane.ERROR);
            }
            else {
                JFrame DisplayWindow = new JFrame();
                int height = 150;
                Font head_font = new Font("Montserrat",Font.BOLD,14);
                Font head_font1 = new Font("Montserrat",Font.PLAIN,14);
                JLabel name = new JLabel("Name");
                JLabel roll = new JLabel("Roll Number");
                JLabel grade = new JLabel("Grade");
                JLabel gender = new JLabel("Gender");
                JLabel phone = new JLabel("Phone Number");
                DisplayWindow.setTitle("Table Details");
                
                name.setBounds(20,20,300,25);
                roll.setBounds(150,20,350,25);
                grade.setBounds(340,20,250,25);
                gender.setBounds(470,20,250,25);
                phone.setBounds(620,20,300,25);

                name.setFont(head_font);
                roll.setFont(head_font);
                grade.setFont(head_font);
                gender.setFont(head_font);
                phone.setFont(head_font);

                int label_height = 40;
                int row_counter = 0;
                JLabel [][] outLabels = new JLabel[out.count][5];
                while (out.rs.next()){
                    outLabels[row_counter][0] = new JLabel(out.rs.getString("name"));
                    outLabels[row_counter][1] = new JLabel(String.valueOf(out.rs.getInt("roll_number")));
                    outLabels[row_counter][2] = new JLabel(out.rs.getString("grade"));
                    outLabels[row_counter][3] = new JLabel(out.rs.getString("gender"));
                    outLabels[row_counter][4] = new JLabel(String.valueOf(out.rs.getLong("phone_number")));
                    outLabels[row_counter][0].setBounds(20,label_height,300,25);
                    outLabels[row_counter][1].setBounds(150,label_height,350,25);
                    outLabels[row_counter][2].setBounds(340,label_height,250,25);
                    outLabels[row_counter][3].setBounds(470,label_height,250,25);
                    outLabels[row_counter][4].setBounds(620,label_height,300,25);
                    label_height += 20;
                    row_counter++;
                    height += 20;
                }
                for (int i=0;i<out.count;i++){
                    for (int j=0;j<5;j++){
                        DisplayWindow.add(outLabels[i][j]);
                        outLabels[i][j].setFont(head_font1);
                    }
                }
                DisplayWindow.add(name);
                DisplayWindow.add(roll);
                DisplayWindow.add(grade);
                DisplayWindow.add(gender);
                DisplayWindow.add(phone);
                DisplayWindow.setLayout(null);
                DisplayWindow.setSize(800,height);
                DisplayWindow.setVisible(true);
            }
        }
        catch(Exception disExec){
            disExec.printStackTrace();
        }
    }
}
