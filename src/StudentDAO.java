import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student s) {
        String sql = "INSERT INTO students (name, email, course, marks) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getMarks());
            ps.executeUpdate();
            System.out.println("Student added!");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("course"),
                        rs.getInt("marks")
                ));
            }
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
        return list;
    }

    public void updateMarks(int id, int newMarks) {
        String sql = "UPDATE students SET marks = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newMarks);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Marks updated!");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student deleted!");
        } catch (SQLException e) { System.out.println("Error: " + e.getMessage()); }
    }
}