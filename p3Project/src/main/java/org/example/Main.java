package org.example;

import org.example.exceptions.InvalidEmailException;
import org.example.exceptions.InvalidGenderException;
import org.example.exceptions.InvalidISBNException;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidGenderException, InvalidEmailException, InvalidISBNException {
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<BookStore> bookstores = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/BookStoreDatabase?user=root";
        String username = "root";
        String password = "Password123";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully");
        } catch (SQLException e) {
            System.out.println("Connection could not be established");
            e.printStackTrace();
        }

        try {
            int mode = Integer.parseInt(args[0]);
            if (mode == 1) {
                System.out.println("Hello!");
            }
            if (mode == 2) {
                System.out.println("Author, Book, Bookstore, Main");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No mode argument provided");
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add an Author");
            System.out.println("2. Add a Book");
            System.out.println("3. Add an BookStore");
            System.out.println("4. List current added Authors");
            System.out.println("5. List current added Books ");
            System.out.println("6. List current added BookStores");
            System.out.println("7. Exit");
            System.out.println("8. Query authors");
            int option = sc.nextInt();
            if (option < 1 || option > 8)
                throw new IllegalArgumentException("Invalid option entered");

            switch (option) {
                case 1:
                    System.out.println("Enter the name, email and gender of the author:");
                    String name = sc.next();
                    String email = sc.next();
                    if (!email.contains("@")) {
                        throw new InvalidEmailException("Invalid email: " + email);
                    }
                    String gender = sc.next();
                    if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
                        throw new InvalidGenderException("Invalid gender: " + gender);
                    }
                    authors.add(new Author(name, email, gender));
                    break;
                case 2:
                    System.out.println("Enter the name, author, price and ISBN of the book:");
                    String bookName = sc.next();
                    String AuthorName = sc.next();
                    int price = 0;
                    try {
                        price = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number.");
                    }
                    int ISBN = sc.nextInt();
                    if (Integer.toString(ISBN).length() != 10) {
                        throw new InvalidISBNException("Invalid ISBN: " + ISBN);
                    }

                    books.add(new Book(bookName, AuthorName, price, ISBN));
                    break;
                case 3:
                    System.out.println("Enter the name and location of the bookstore:");
                    String bookstoreName = sc.next();
                    String bookstoreLocation = sc.next();
                    bookstores.add(new BookStore(bookstoreName, bookstoreLocation));
                    break;
                case 4:
                    System.out.println("List of authors:");
                    for (Author author : authors) {
                        System.out.println("Name:" + author.getName());
                    }
                    break;
                case 5:
                    System.out.println("List of books:");
                    for (Book book : books) {
                        System.out.println("Name:" + book.getTitle());
                    }
                    break;
                case 6:
                    System.out.println("List of authors:");
                    for (BookStore bookstore : bookstores) {
                        System.out.println("Name:" + bookstore.getName());
                    }
                    break;
                case 7:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                case 8:
                    System.out.println("Authors:");
                    try {
                        // create a connection
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookStoreDatabase?user=root", "root", "Password123");
                        // create a statement
                        Statement stmt = con.createStatement();
                        // execute a query
                        ResultSet rs = stmt.executeQuery("SELECT name FROM Authors");
                        // iterate through the result and print the title
                        while (rs.next()) {
                            System.out.println(rs.getString("name"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
            for (Author author : authors) {
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String sql = "INSERT INTO Authors (Authors.name, email, gender) VALUES (?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, String.valueOf(author.getName()));
                    statement.setString(2, String.valueOf(author.getEmail()));
                    statement.setString(3, String.valueOf(author.getGender()));

                    int insert = statement.executeUpdate();
                    if (insert > 0) {
                        System.out.println("A new row was inserted successfully");
                    }
                } catch (SQLException e) {
                    System.out.println("Insert unsuccessful");
                    e.printStackTrace();
                }
            }
            for (Book book : books) {
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String sql = "INSERT INTO Books (title, AuthorName, price, ISBN) VALUES (?, ?, ?,?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, String.valueOf(book.getTitle()));
                    statement.setString(2, String.valueOf(book.getAuthorName()));
                    statement.setString(3, String.valueOf(book.getPrice()));
                    statement.setString(4, String.valueOf(book.getISBN()));

                    int insert = statement.executeUpdate();
                    if (insert > 0) {
                        System.out.println("A new row was inserted successfully");
                    }
                } catch (SQLException e) {
                    System.out.println("Insert unsuccessful");
                    e.printStackTrace();
                }

            }
            for (BookStore bookStore : bookstores) {
                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
                    String sql = "INSERT INTO BookStores (city, BookStores.name) VALUES (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, String.valueOf(bookStore.getCity()));
                    statement.setString(2, String.valueOf(bookStore.getName()));

                    int insert = statement.executeUpdate();
                    if (insert > 0) {
                        System.out.println("A new row was inserted successfully");
                    }
                } catch (SQLException e) {
                    System.out.println("Insert unsuccessful");
                    e.printStackTrace();
                }
            }
        }
    }
}




