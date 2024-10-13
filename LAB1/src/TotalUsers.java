//import models.Book;
//import inputhandlers.User;
//
//import java.util.Objects;
//import java.util.Scanner;
//
//public class TotalUsers {
//    static Scanner input = new Scanner(System.in);
//    static User[] theUsers = new User[50];
//
//    public static int count = 0;
//
//    //METHOD 1
//    // To add a new user
//    public static void addUser(User u) {
//        for (int i = 0; i < count; i++) {
//            if (u.userId.equalsIgnoreCase(theUsers[i].userId)) {
//                System.out.println("inputhandlers.User with ID" + u.userId + "is already registered.");
//            }
//            return;
//        }
//        if (count <= 50) {
//            theUsers[count] = u;
//            count++;
//        }
//    }
//
//    //METHOD 2
//    //Displaying all the users
//    public static void showAllUsers() {
//        System.out.println("Name\t\tID");
//        for (int i = 0; i < count; i++) {
//            System.out.println(theUsers[i].userName + "\t\t"
//                    + theUsers[i].userId);
//        }
//    }
//
//
//    //METHOD 3
//    //To check all user
//    public static int isUser(){
//        System.out.println("Enter ID number: ");
//
//        String userId = input.nextLine();
//        for (int i= 0; i<count; i++){
//            if (theUsers[i].userId.equalsIgnoreCase(userId)){
//                return i;
//            }
//        }
//        System.out.println("User is not registered.");
//        System.out.println("Get registered first.");
//        return -1;
//    }
//
//    //METHOD 4
//    // To return a book
//    public static void returnBook() {
//        int userIndex = TotalUsers.isUser();
//        if (userIndex != -1) {
//            System.out.println("Checking out.");
//
//            TotalBooks.showAllBooks();
//
//            System.out.println("Enter the ISBN of the book you want to borrow: ");
//            String ISBN = input.nextLine();
//
//            Book b = TotalBooks.checkoutBook();
//            if (b != null) {
//                if (theUsers[userIndex].booksCount < 3) {
//                    System.out.println("Adding book to user's borrowed list.");
//
//                    theUsers[userIndex].borrowedBooks[theUsers[userIndex].booksCount] = b;
//                    theUsers[userIndex].booksCount++;
//
//                    b.bookQuantity--;
//                    return;
//                } else {
//                    System.out.println("inputhandlers.User cannot borrow more than 3 books.");
//                }
//            } else {
//                System.out.println("models.Book is not available or doesn't exist.");
//            }
//        } else {
//            System.out.println("inputhandlers.User not found.");
//        }
//    }
//
//    public static void borrowBook() {
//        int userIndex = TotalUsers.isUser();
//        if (userIndex != -1) {
//            User u = theUsers[userIndex];
//
//            System.out.println("Borrowed books:");
//            System.out.println("ISBN\t\tTitle\t\tAuthor");
//
//            for (int i = 0; i < u.booksCount; i++) {
//                if (u.borrowedBooks[i] != null) {
//                    System.out.println(u.borrowedBooks[i].ISBN + "\t\t"
//                            + u.borrowedBooks[i].title + "\t\t"
//                            + u.borrowedBooks[i].author);
//                }
//            }
//
//            System.out.println("Enter the ISBN of the book to be returned: ");
//            String ISBN = input.nextLine();
//
//            for (int i = 0; i < u.booksCount; i++) {
//                if (u.borrowedBooks[i] != null && Objects.equals(ISBN, u.borrowedBooks[i].ISBN)) {
//
//                    TotalBooks.checkInBook(u.borrowedBooks[i]);
//
//                    u.borrowedBooks[i] = null;
//
//
//                    for (int j = i; j < u.booksCount - 1; j++) {
//                        u.borrowedBooks[j] = u.borrowedBooks[j + 1];
//                    }
//                    u.booksCount--;
//
//                    System.out.println("models.Book successfully returned.");
//                    return;
//                }
//            }
//
//            System.out.println("No book with ISBN " + ISBN + " was found in the user's borrowed list.");
//        } else {
//            System.out.println("inputhandlers.User not found.");
//        }
//    }
//
//}