package com.smartlibrary;
import java.sql.*;

public class DatabaseHelper {

    private static final String DB_URL = "jdbc:sqlite:smartlibrary.db";

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            System.out.println("✔ SQLite bağlantısı başarılı.");
            return conn;
        } catch (SQLException e) {
            System.out.println("❌ SQLite bağlantı hatası → " + e.getMessage());
            return null; // eski hatanın kaynak noktası buydu, artık kontrollü
        }
    }

    public static void createTable() {
        String sql =
                "CREATE TABLE IF NOT EXISTS books (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "name TEXT NOT NULL," +
                        "author TEXT NOT NULL);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("📌 Tablo kontrol edildi/oluşturuldu.");
        } catch (SQLException e) {
            System.out.println("❌ Tablo oluşturma hatası: " + e.getMessage());
        }
    }

    public static void addBook(String name, String author) {
        String sql = "INSERT INTO books(name, author) VALUES(?,?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, author);
            pstmt.executeUpdate();
            System.out.println("📗 Kitap eklendi → " + name + " (" + author + ")");

        } catch (SQLException e) {
            System.out.println("❌ Ekleme hatası: " + e.getMessage());
        }
    }

    public static void listBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n📚 Kayıtlı Kitaplar:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " - " +
                                rs.getString("author")
                );
            }

        } catch (SQLException e) {
            System.out.println("❌ Listeleme hatası: " + e.getMessage());
        }
    }

    public static void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();

            if (result > 0)
                System.out.println("🗑 Kitap silindi → ID: " + id);
            else
                System.out.println("⚠ ID bulunamadı: " + id);

        } catch (SQLException e) {
            System.out.println("❌ Silme hatası: " + e.getMessage());
        }
    }
}
