import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UI_Interface extends JFrame{
    UI_Interface(StudentManagementSystem manager){
        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(170,0,500,45);
        heading.setFont(new Font("Montserrat", Font.BOLD, 25));

        JLabel subhead = new JLabel("How can we help you today ? ");
        subhead.setBounds(230,50,500,30);
        subhead.setFont(new Font("Montserrat",Font.PLAIN,18));

        JButton addStudent = new JButton("Add a student");
        addStudent.setBounds(20,100,125,125);
        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentWindow add = new AddStudentWindow(manager);
                add.setTitle("Add New Student");
            }
        });

        JButton removeStudent = new JButton("Remove Student");
        removeStudent.setBounds(165,100,125,125);
        removeStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                DeleteStudentWindow remove = new DeleteStudentWindow(manager);
                remove.setTitle("Remove Student Record");
            }
        });

        JButton searchStudent = new JButton("Search Student");
        searchStudent.setBounds(310,100,125,125);
        searchStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                SearchStudentWindow search = new SearchStudentWindow(manager);
                search.setTitle("Search Student Record");
            }
        });

        JButton displayStudent = new JButton("Display Student");
        displayStudent.setBounds(455,100,125,125);
        displayStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                DisplayStudentWindow display = new DisplayStudentWindow(manager);
                display.getClass();
            }
        });

        JButton quit = new JButton("Quit");
        quit.setBounds(600,100,125,125);

        this.add(quit);
        this.add(searchStudent);
        this.add(displayStudent);
        this.add(removeStudent);
        this.add(addStudent);
        this.add(subhead);
        this.add(heading);
        this.setSize(750,300);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
    }
    public static void main(String[] args) {
        UI_Interface u1 = new UI_Interface(null);
        u1.setTitle("Student Management System");
    }
}
