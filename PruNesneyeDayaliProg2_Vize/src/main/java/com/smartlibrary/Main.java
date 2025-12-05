package com.smartlibrary;

public class Main {
    public static void main(String[] args) {

        DatabaseHelper.createTable();

        DatabaseHelper.addBook("1984", "George Orwell");
        DatabaseHelper.addBook("Suç ve Ceza", "Dostoyevski");

        DatabaseHelper.listBooks();

        DatabaseHelper.deleteBook(1);

        DatabaseHelper.listBooks();
    }
}
