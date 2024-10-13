package inputhandlers;

import models.Book;

import java.util.Scanner;

public class UserInputHandler {
    public String userId;
    public String userName;
    public Book[] borrowedBooks = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);
    public UserInputHandler(){
        System.out.println("Enter User's name: ");
        this.userName= input.nextLine();

        System.out.println("Enter User's ID number: ");
        this.userId = input.nextLine();
    }


}
