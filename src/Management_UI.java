import javax.swing.*;
import java.sql.*;
class Student {
    public String name;
    public int roll_number;
    public String grade;
    public String gender;
    public long phone_number;
    Student(){
        this.name = null;
        this.roll_number = 0;
        this.grade = null;
        this.gender = null;
        this.phone_number = 0;
    }
    Student(String name,int roll_number,String grade,String gender,long phone_number){
        this.name = name;
        this.roll_number = roll_number;
        this.grade = grade;
        this.gender = gender;
        this.phone_number = phone_number;
    }
}
class StudentManagementSystem{
    public Connection con;
    public Statement stat;
    StudentManagementSystem(Connection con,Statement stat){
        this.con = con;
        this.stat = stat;
    }
    public void AddStudent(Student s1) throws Exception{
        String query = "INSERT INTO students VALUES (?,?,?,?,?)";
        PreparedStatement insert = con.prepareStatement(query);
        insert.setString(1, s1.name);
        insert.setInt(2,s1.roll_number);
        insert.setString(3,s1.gender);
        insert.setString(4,s1.grade);
        insert.setLong(5,s1.phone_number);
        insert.executeUpdate();
    }
    public void RemoveStudent(int target) throws Exception{
        String query = "DELETE FROM students WHERE roll_number = ?";
        PreparedStatement delete = con.prepareStatement(query);
        delete.setInt(1,target);
        delete.executeUpdate();
    }
    public String[] SearchStudent(int target) throws Exception {
        String[] details = new String[5];
        String query = "SELECT * FROM students WHERE roll_number = ?";
        PreparedStatement search = con.prepareStatement(query);
        search.setInt(1,target);
        ResultSet output = search.executeQuery();
        while (output.next()){
            details[0] = output.getString("name");
            details[1] = String.valueOf(output.getInt("roll_number"));
            details[2] = output.getString("gender");
            details[3] = output.getString("grade");
            details[4] = String.valueOf(output.getInt("phone_number"));
        }
        return details;
    }
    public ResultSet DisplayStudent() throws Exception {
        String query = "SELECT * FROM students";
        PreparedStatement display = con.prepareStatement(query);
        ResultSet output = display.executeQuery();
        return output;
    }
}
class UI extends JFrame {
    UI() {
        this.setSize(500,500);
        this.setVisible(true);
    }
}
public class ManagementUI{
    public static void main(String[] args) {
        UI u1 = new UI();
    }
}