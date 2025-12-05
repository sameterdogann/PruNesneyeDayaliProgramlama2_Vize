package repository;

import database.Database;
import model.Loan;
import java.sql.*;
import java.util.ArrayList;
// Kitap (Loan) islemleri-Depo
public class LoanRepository {

    public void add(Loan loan) {
        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO loans(bookId,studentId,dateBorrowed) VALUES(?,?,?)"
            );
            ps.setInt(1, loan.getBookId());
            ps.setInt(2, loan.getStudentId());
            ps.setString(3, loan.getDateBorrowed());
            ps.executeUpdate();
            System.out.println("Ödünç verildi!");
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    public ArrayList<Loan> getAll() {
        ArrayList<Loan> list = new ArrayList<>();
        try (Connection conn = Database.connect()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM loans");
            while (rs.next())
                list.add(new Loan(rs.getInt("id"), rs.getInt("bookId"), rs.getInt("studentId"),
                        rs.getString("dateBorrowed"), rs.getString("dateReturned")));
        } catch (Exception e) { System.out.println(e.getMessage()); }
        return list;
    }

    public void returnBook(int id, String dateReturned) {
        try (Connection conn = Database.connect()) {
            PreparedStatement ps = conn.prepareStatement("UPDATE loans SET dateReturned=? WHERE id=?");
            ps.setString(1, dateReturned);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Kitap teslim alındı!");
        } catch (Exception e) { System.out.println(e.getMessage()); }
    }
}
