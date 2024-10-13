package inputhandlers;

import models.Book;
import models.EBook;
import models.PrintedBook;

import java.util.Scanner;

public class BookInputHandler {
    private static Scanner input = new Scanner(System.in);

//    public static Book getBookDetails() {
//        System.out.println("Enter the title of the book: ");
//        String title = input.nextLine();
//        System.out.println("Enter the author of the book: ");
//        String author = input.nextLine();
//        System.out.println("Enter the ISBN of the book: ");
//        String ISBN = input.nextLine();
//        System.out.println("Enter the quantity of books: ");
//        int quantity = input.nextInt();
//        input.nextLine(); // Consume the newline
//
//        System.out.println("Is this an E-Book or Printed Book? (1 for E-Book, 2 for Printed Book): ");
//        int bookType = input.nextInt();
//        input.nextLine(); // Consume the newline
//
//        return createBook(bookType, title, author, ISBN, quantity);
//    }
//
//    private static Book createBook(int bookType, String title, String author, String ISBN, int quantity) {
//        if (bookType == 1) { // E-Book
//            System.out.println("Enter the file size of the E-Book: ");
//            String fileSize = input.nextLine();
//            return new EBook(title, author, ISBN, quantity, fileSize);
//        } else { // Printed Book
//            System.out.println("Enter the version type of the Printed Book: ");
//            String versionType = input.nextLine();
//            return new PrintedBook(title, author, ISBN, quantity, versionType);
//        }
//    }
}
