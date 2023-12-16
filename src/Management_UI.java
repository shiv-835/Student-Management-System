import java.sql.*;
import java.io.*;
import javax.swing.JOptionPane;
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
class PairOut {
    public int count;
    public ResultSet rs;
    PairOut(int count,ResultSet rs){
        this.count = count;
        this.rs = rs;
    }
}
class StudentManagementSystem{
    public Connection con;
    StudentManagementSystem(Connection con){
        this.con = con;
    }
    public void AddStudent(Student s1){
        String query = "INSERT INTO students (name,roll_number,gender,grade,phone_number)VALUES (?,?,?,?,?)";
        try{
            PreparedStatement insert = con.prepareStatement(query);
            insert.setString(1, s1.name);
            insert.setInt(2,s1.roll_number);
            insert.setString(3,s1.gender);
            insert.setString(4,s1.grade);
            insert.setLong(5,s1.phone_number);
            insert.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "Error: Roll Number already exists");
        }catch (Exception execption){
            System.out.println("Error in adding student");
        }
    }
    public void RemoveStudent(int target) throws Exception{
        try{
            String query = "DELETE FROM students WHERE roll_number = ?";
            PreparedStatement delete = con.prepareStatement(query);
            delete.setInt(1,target);
            int rowsAffected = delete.executeUpdate();
            if (rowsAffected != 0) {
                JOptionPane.showMessageDialog(null, "Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Record not found for deletion!");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet SearchStudent(int target) throws Exception {
        String query = "SELECT * FROM students WHERE roll_number = ?";
        PreparedStatement search = con.prepareStatement(query);
        search.setInt(1,target);
        ResultSet output = search.executeQuery();
        return output;
    }
    public PairOut DisplayStudent() throws Exception {
        int item_count = 0;
        String query = "SELECT * FROM students";
        PreparedStatement display = con.prepareStatement(query);
        ResultSet output = display.executeQuery();
        query = "SELECT COUNT(*) AS record_count FROM students";
        display = con.prepareStatement(query);
        ResultSet itemcount = display.executeQuery();
        while(itemcount.next()){
            item_count = itemcount.getInt("record_count");;
        }
        PairOut outputPair = new PairOut(item_count, output);
        return outputPair;
    }
}
class Management_UI{
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_system", "root", "Shiv1209$");
            StudentManagementSystem manager = new StudentManagementSystem(con);
            UI_Interface mainWindow = new UI_Interface(manager);
            mainWindow.setTitle("Main Window");
        }
        catch (Exception e) {
            // TODO: handle exception
        }

    }
}