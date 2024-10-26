package controllers;

import models.Book;
import inputhandlers.UserInputHandler;
import services.UserRepository;

import java.util.Objects;
import java.util.Scanner;

import static services.UserRepository.theUsers;

public class UserController {
    static Scanner input = new Scanner(System.in);
//    static UserInputHandler[] theUsers = new UserInputHandler[50]; // Array to hold users
    public static int count = 0;


    public static void borrowBook() {
        int userIndex = UserRepository.isUser();
        if (userIndex != -1) {
//          System.out.println("Checking out a book for user " + theUsers[userIndex].userName);
            BookController.showAllBooks();
            System.out.println("Enter the ISBN of the book you want to borrow: ");
            String ISBN = input.nextLine();
            Book b = BookController.checkoutBook();
            if (b != null) {
                if (theUsers[userIndex].booksCount < 3) {
                    System.out.println("Adding book to user's borrowed list.");
                    theUsers[userIndex].borrowedBooks[theUsers[userIndex].booksCount] = b;
                    theUsers[userIndex].booksCount++;
                    b.bookQuantity--;
                    System.out.println("Book successfully borrowed.");
                } else {
                    System.out.println("User cannot borrow more than 3 books.");
                }
            } else {
                System.out.println("Book is not available or doesn't exist.");
            }
        }
    }

    // METHOD 5: Return a book
    public static void returnBook() {
        int userIndex = UserRepository.isUser();
        if (userIndex != -1) {
            UserInputHandler u = theUsers[userIndex];
            System.out.println("Borrowed books for user " + u.userName + ":");
            System.out.println("ISBN\t\tTitle\t\tAuthor");

            for (int i = 0; i < u.booksCount; i++) {
                if (u.borrowedBooks[i] != null) {
                    System.out.println(u.borrowedBooks[i].ISBN + "\t\t"
                            + u.borrowedBooks[i].title + "\t\t"
                            + u.borrowedBooks[i].author);
                }
            }

            System.out.println("Enter the ISBN of the book to be returned: ");
            String ISBN = input.nextLine();

            for (int i = 0; i < u.booksCount; i++) {
                if (u.borrowedBooks[i] != null && Objects.equals(ISBN, u.borrowedBooks[i].ISBN)) {
                    BookController.checkInBook(u.borrowedBooks[i]);
                    u.borrowedBooks[i] = null;

                    // Shift borrowed books after returning
                    for (int j = i; j < u.booksCount - 1; j++) {
                        u.borrowedBooks[j] = u.borrowedBooks[j + 1];
                    }
                    u.booksCount--;

                    System.out.println("Book successfully returned.");
                    return;
                }
            }

            System.out.println("No book with ISBN " + ISBN + " was found in the user's borrowed list.");
        }
    }
}
