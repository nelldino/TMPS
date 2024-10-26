package services;

import models.Book;
import models.EBook;
import models.PrintedBook;


public class BookFactory {
    public static Book createBook(int bookType, String title, String author, String ISBN, int quantity, String extraDetail) {
        if (bookType == 1) {
            return new EBook(title, author, ISBN, quantity, extraDetail); // File Size for E-Book
        } else {
            return new PrintedBook(title, author, ISBN, quantity, extraDetail); // Version Type for Printed Book
        }
    }
}
