package controllers;

import models.Book;
import models.PrintedBook;

import java.util.Objects;
import java.util.Scanner;

public class BookController {
    //create space to store 50 books
    static Book[] theBooks = new Book[50];
    public static int count;

    static Scanner input = new Scanner(System.in);

    //METHOD 1
    // To compare books
    public static int compareBookObjects(Book b1, Book b2) {

        //if the tile of the books matches
        if (b1.title.equalsIgnoreCase(b2.title)) {
            System.out.println("Book with this title already exists.");
            return 0;
        }
        //if the ISBN of the books matches
        if (Objects.equals(b1.ISBN, b2.ISBN)) {
            System.out.println("Book with this ISBN already exists.");
            return 0;
        }
        return 1;
    }

    //METHOD 2
    //To add new books
    public static void addBook(Book b) {
        for (int i = 0; i < count; i++) {
            if (compareBookObjects(b, theBooks[i]) == 0)
                return;
        }
        if (count < 50) {
            theBooks[count] = b;
            count++;
        } else {
            System.out.println("No more space for books :((");
        }
    }

    //METHOD 3
    //To search books by ISBN
    public static void searchByISBN() {
        System.out.println("Search by ISBN");

        System.out.println("Enter the ISBN of the book: ");
        String ISBN = input.nextLine();

        boolean bookFound = false;

        System.out.println("ISBN\t\tTitle\t\tAuthor\t\tAvailable Quantity\t\tTotal Quantity");

        for (int i = 0; i < count; i++) {
            //compare the inout ISBN with the ISBN of the books from the list
            if (Objects.equals(ISBN, theBooks[i].ISBN)) {
                System.out.println(
                        theBooks[i].ISBN + "\t\t"
                                + theBooks[i].title + "\t\t"
                                + theBooks[i].author + "\t\t"
                                + theBooks[i].bookQuantity + "\t\t"
                                + theBooks[i].bookQuantityCopy);
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("No book for ISBN" + ISBN + " was found.");
        }
    }

    //METHOD 4
    // To search a book by author's name
    public static void searchByAuthor() {
        System.out.println("Search by Author");

        System.out.println("Enter the author of the book: ");
        String author = input.nextLine();

        boolean bookFound = false;

        System.out.println("ISBN\t\tTitle\t\tAuthor\t\tAvailable Quantity\t\tTotal Quantity\t\tType");

        for (int i = 0; i < count; i++) {
            //compare the input author with the author of the books from the list
            if (author.equalsIgnoreCase(theBooks[i].author)) {
//                String versionType = (book).getType();
                System.out.println(
                        theBooks[i].ISBN + "\t\t"
                                + theBooks[i].title + "\t\t"
                                + theBooks[i].author + "\t\t"
                                + theBooks[i].bookQuantity + "\t\t"
                                + theBooks[i].bookQuantityCopy +"\t\t"
                                + theBooks[i].getType());
                bookFound = true;
                break;
            }
        }
        if (!bookFound) {
            System.out.println("No book by" + author + "was found.");
        }
    }

    //METHOD 5
    // To display all the books

    public static void showAllBooks() {
        System.out.println("Showing all the books");
        System.out.println("ISBN\tTitle\tAuthor\tAvailable Quantity\tTotal Quantity\tType");
        for (int i = 0; i < count; i++) {
            Book book = theBooks[i];
            String versionType = "";
            if (book instanceof PrintedBook) {
                versionType = (book).getType();
                System.out.println(
                        theBooks[i].ISBN + "\t\t"
                                + theBooks[i].title + "\t\t"
                                + theBooks[i].author + "\t\t"
                                + theBooks[i].bookQuantity + "\t\t\t\t\t\t"
                                + theBooks[i].bookQuantityCopy + "\t\t"
                                + theBooks[i].getType());

            }
            else {
                versionType = (book).getType();
                System.out.println(
                        theBooks[i].ISBN + "\t\t"
                                + theBooks[i].title + "\t\t"
                                + theBooks[i].author + "\t\t"
                                + theBooks[i].bookQuantity + "\t\t\t\t\t\t"
                                + theBooks[i].bookQuantityCopy + "\t\t"
                                + theBooks[i].getType());
            }
        }

    }

    //METHOD 6
    // To edit a book

    public static void upgradeBookQuantity() {
        System.out.println("Upgrade quantity of a book");
        System.out.println("Enter the ISBN of the book: ");
        String ISBN = input.nextLine();

        for (int i = 0; i < count; i++) {
            if (Objects.equals(ISBN, theBooks[i].ISBN)) {
                System.out.println("Enter the number of books to be added: ");
                int addQuantity = input.nextInt();
                theBooks[i].bookQuantity += addQuantity;
                theBooks[i].bookQuantityCopy += addQuantity;

                return;
            }
        }
    }
    public static int isAvailable(String ISBN){
        for (int i=0; i<count; i++){
            if(Objects.equals(ISBN, theBooks[i].ISBN)){
                if (theBooks[i].bookQuantityCopy>0){
                    System.out.println("models.Book is available.");
                    return i;
                }
                System.out.println("models.Book is unavailable.");
            }
        }
        System.out.println("No book with ISBN" +ISBN+ "is available in the library.");
        return -1;
    }

    //METHOD 8
    //To remove the book from the library
    public static Book checkoutBook(){
        System.out.println("Enter the ISBN of the book to be checked out: ");
        String ISBN = input.nextLine();

        int bookIndex = isAvailable(ISBN);

        if (bookIndex != -1){
            theBooks[bookIndex].bookQuantityCopy--;
            return theBooks[bookIndex];
        }
        return null;
    }

    //METHOD 9
    //To adda book to the library
    public static void checkInBook(Book b){
        for (int i = 0 ; i<count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].bookQuantityCopy++;
                return;
            }
        }
    }
}