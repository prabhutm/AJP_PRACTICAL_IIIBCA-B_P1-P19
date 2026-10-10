import java.sql.*;
import java.util.Scanner;
public class BooksDataManipulationApp {
private static final String URL = "jdbc:mysql://localhost:3306/bm";
private static final String USER = "root";
private static final String PASSWORD = "root";
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

while (true) {
System.out.println("1. Add a new author");
System.out.println("2. Edit an existing author");
System.out.println("3. Add a new title for an author");
System.out.println("4. Link an author with a title");
System.out.println("5. Exit");
System.out.println("Enter your Choice:");
int choice = scanner.nextInt();
scanner.nextLine();
switch (choice) {
case 1:
addNewAuthor(connection, scanner);
break;
case 2:
editAuthor(connection, scanner);
break;
case 3:
addNewTitleForAuthor(connection, scanner);
break;
case 4:
linkAuthorWithTitle(connection, scanner);
break;
case 5:
System.out.println("Exiting...");
return;
default:
System.out.println("Invalid choice. Please try again.");
}
}
} catch (SQLException e) {
e.printStackTrace();
}
}
private static void addNewAuthor(Connection connection, Scanner scanner) throws
SQLException {
System.out.print("Enter author's first name: ");
String firstName = scanner.nextLine();
System.out.print("Enter author's last name: ");
String lastName = scanner.nextLine();
String query = "INSERT INTO Authors (first_name, last_name) VALUES (?, ?)";
try (PreparedStatement pstmt = connection.prepareStatement(query)) {
pstmt.setString(1, firstName);
pstmt.setString(2, lastName);
pstmt.executeUpdate();
System.out.println("Author added successfully.");
}
}

private static void editAuthor(Connection connection, Scanner scanner) throws SQLException {
System.out.print("Enter author ID to edit: ");
int authorId = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("Enter new first name: ");
String firstName = scanner.nextLine();
System.out.print("Enter new last name: ");
String lastName = scanner.nextLine();
StringBuilder query = new StringBuilder("UPDATE Authors SET ");
boolean first = true;
if (!firstName.isEmpty()) {
query.append("first_name = ? ");
first = false;
}
if (!lastName.isEmpty()) {
if (!first) query.append(", ");
query.append("last_name = ? ");
}
query.append("WHERE author_id = ?");
try (PreparedStatement pstmt = connection.prepareStatement(query.toString())) {
int paramIndex = 1;
if (!firstName.isEmpty()) {
pstmt.setString(paramIndex++, firstName);
}
if (!lastName.isEmpty()) {
pstmt.setString(paramIndex++, lastName);
}
pstmt.setInt(paramIndex, authorId);
int rowsAffected = pstmt.executeUpdate();
if (rowsAffected > 0) {
System.out.println("Author updated successfully.");
} else {
System.out.println("Author not found.");
}
}
}
private static void addNewTitleForAuthor(Connection connection, Scanner scanner) throws
SQLException {
System.out.print("Enter title: ");
String title = scanner.nextLine();
System.out.print("Enter year: ");
int year = scanner.nextInt();
scanner.nextLine(); // Consume newline
System.out.print("Enter ISBN: ");
String isbn = scanner.nextLine();
System.out.print("Enter author ID: ");
int authorId = scanner.nextInt();

String bookQuery = "INSERT INTO Books (title, year, isbn, author_id) VALUES (?, ?, ?, ?)";
try (PreparedStatement pstmt = connection.prepareStatement(bookQuery)) {
pstmt.setString(1, title);
pstmt.setInt(2, year);
pstmt.setString(3, isbn);
pstmt.setInt(4, authorId);
pstmt.executeUpdate();
System.out.println("Book added successfully.");
}
}
private static void linkAuthorWithTitle(Connection connection, Scanner scanner) throws
SQLException {
System.out.print("Enter author ID: ");
int authorId = scanner.nextInt();
System.out.print("Enter book ID: ");
int bookId = scanner.nextInt();
String linkQuery = "INSERT INTO AuthorISBN (author_id, book_id) VALUES (?, ?)";
try (PreparedStatement pstmt = connection.prepareStatement(linkQuery)) {
pstmt.setInt(1, authorId);
pstmt.setInt(2, bookId);
pstmt.executeUpdate();
System.out.println("Author linked with title successfully.");
} catch (SQLException e) {
System.out.println("Error linking author with title: " + e.getMessage());
}
}
}