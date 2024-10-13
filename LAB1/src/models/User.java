package models;

import java.util.List;
import java.util.Scanner;

public class User {
    public String userId;
    public String userName;
    public Book[] borrowedBooks = new Book[3];
    public int booksCount = 0;

    Scanner input = new Scanner(System.in);
    public User(){
        System.out.println("Enter models.User's name: ");
        this.userName= input.nextLine();

        System.out.println("Enter models.User's ID number: ");
        this.userId = input.nextLine();
    }


}
