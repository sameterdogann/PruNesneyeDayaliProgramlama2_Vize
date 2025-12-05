package repository;

import database.Database;
import model.Student;
import java.sql.*;
import java.util.ArrayList;

public class StudentRepository {

    public void add(Student s) {
        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO students(name,department) VALUES(?,?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getDepartment());
            ps.executeUpdate();
            System.out.println("Öğrenci eklendi.");
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> list = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next())
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("department")));
        } catch (Exception e) { System.out.println(e.getMessage()); }
        return list;
    }
}
