import inputhandlers.BookInputHandler;
import models.Book;
import models.User;
import services.BookController;
import user.UserController;
import user.UserRepository;

import java.util.Scanner;

public class Menu {
    private Scanner input;

    public void displayMenu() {
        this.input = new Scanner(System.in);

        int choice;
        int searchChoice;

        do {
            // Display the menu
            System.out.println("\n--- Library Management System Menu ---");
            System.out.println("1. Add a new book");
            System.out.println("2. Search for a book");
            System.out.println("3. Show all books");
            System.out.println("4. Upgrade quantity of a book");
            System.out.println("5. Register a new user");
            System.out.println("6. Show all registered users");
            System.out.println("7. Borrow a book");
            System.out.println("8. Return a book");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();



            // Handle user choice
            switch (choice) {
                case 1:
                    BookController.addBook(Book.getBookDetails());
                    break;

                case 2:
                    System.out.println("1. Search for a book by ISBN.");
                    System.out.println("2. Search for a book by author's name.");
                    searchChoice = input.nextInt();
                    input.nextLine();

                    switch (searchChoice) {
                        case 1:
                            BookController.searchByISBN();
                            break;
                        case 2:
                            BookController.searchByAuthor();
                            break;
                    }
                    break;
                case 3:
                    BookController.showAllBooks();
                    break;
                case 4:
                    BookController.upgradeBookQuantity();
                    break;
                case 5:
                    User u = new User();
                    UserRepository.addUser(u);
                    break;
                case 6:
                    UserRepository.showAllUsers();
                    break;
                case 7:
                    UserController.returnBook();
                    break;
                case 8:
                    UserController.borrowBook();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);
    }

}
