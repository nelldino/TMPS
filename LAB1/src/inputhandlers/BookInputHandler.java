package inputhandlers;

import services.BookFactory;
import models.Book;

import java.util.Scanner;

public class BookInputHandler {
    private static final Scanner input = new Scanner(System.in);

    public static Book getBookDetails() {
        System.out.println("Enter the title of the book: ");
        String title = input.nextLine();
        System.out.println("Enter the author of the book: ");
        String author = input.nextLine();
        System.out.println("Enter the ISBN of the book: ");
        String ISBN = input.nextLine();
        System.out.println("Enter the quantity of books: ");
        int quantity = input.nextInt();
        input.nextLine(); // Consume the newline

        System.out.println("Is this an E-Book or Printed Book? (1 for E-Book, 2 for Printed Book): ");
        int bookType = input.nextInt();
        input.nextLine(); // Consume the newline

        String extraDetail;
        if (bookType == 1) {
            System.out.println("Enter the file size of the E-Book: ");
            extraDetail = input.nextLine();
        } else {
            System.out.println("Enter the version type of the Printed Book: ");
            extraDetail = input.nextLine();
        }

        return BookFactory.createBook(bookType, title, author, ISBN, quantity, extraDetail);
    }
}
