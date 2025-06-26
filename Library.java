import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Book findBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId)
                return b;
        }
        return null;
    }

    public User findUser(int userId) {
        for (User u : users) {
            if (u.id == userId)
                return u;
        }
        return null;
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);
        if (book != null && user != null) {
            user.borrowBook(book);
        } else {
            System.out.println("Book or User not found!");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);
        if (book != null && user != null) {
            user.returnBook(book);
        } else {
            System.out.println("Book or User not found!");
        }
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books)
            System.out.println(b);
    }

    public void showAllUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }
        for (User u : users)
            System.out.println(u);
    }

    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println(" Welcome to Library Management System");

        do {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Show All Users");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine(); // flush
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(bid, title, author));
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    lib.addUser(new User(uid, name));
                    break;

                case 3:
                    System.out.print("Enter Book ID to Issue: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    lib.issueBook(bookId, userId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    int returnBookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt();
                    lib.returnBook(returnBookId, returnUserId);
                    break;

                case 5:
                    lib.showAllBooks();
                    break;

                case 6:
                    lib.showAllUsers();
                    break;

                case 0:
                    System.out.println("Exiting Library System. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice... Try again...");
            }
        } while (choice != 0);

        sc.close();
    }
}

// This code implements a simple Library Management System in Java.
// It allows adding books and users, issuing and returning books, and displaying
// all books and users
