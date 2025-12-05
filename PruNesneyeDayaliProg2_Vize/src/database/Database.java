package database;

import java.sql.*;

public class Database {

    public static Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:smartlibrary.db");
            System.out.println("SQLite Bağlantısı başarılı.");
        } catch (Exception e) {
            System.out.println("SQLite bağlantı hatası: " + e.getMessage());
        }

        return conn;
    }

    public static void createTables() {
        String bookTable = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "author TEXT," +
                "year INTEGER)";

        String studentTable = "CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "department TEXT)";

        String loanTable = "CREATE TABLE IF NOT EXISTS loans (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "bookId INTEGER," +
                "studentId INTEGER," +
                "dateBorrowed TEXT," +
                "dateReturned TEXT)";

        try (Connection conn = connect(); Statement st = conn.createStatement()) {
            st.execute(bookTable);
            st.execute(studentTable);
            st.execute(loanTable);
            System.out.println("Tablolar başarıyla oluşturuldu.");
        } catch (Exception e) {
            System.out.println("Tablo oluşturma hatası -> " + e.getMessage());
        }
    }
}
