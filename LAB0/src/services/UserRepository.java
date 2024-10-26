package services;

import inputhandlers.UserInputHandler;

import java.util.Scanner;

public class UserRepository {
    static Scanner input = new Scanner(System.in);
    public static UserInputHandler[] theUsers = new UserInputHandler[50];
    public static int count = 0;

    public static void addUser(UserInputHandler u) {
        // Check if user with the same ID already exists
        for (int i = 0; i < count; i++) {
            if (u.userId.equalsIgnoreCase(theUsers[i].userId)) {
                System.out.println("User with ID " + u.userId + " is already registered.");
                return;
            }
        }
        // Add the new user if not a duplicate
        if (count < 50) {
            theUsers[count] = u;
            count++;
            System.out.println("User " + u.userName + " successfully registered.");
        } else {
            System.out.println("No more space for users.");
        }
    }

    // METHOD 2: Displaying all the users
    public static void showAllUsers() {
        if (count == 0) {
            System.out.println("No users registered.");
        } else {
            System.out.println("Name\t\tID");
            for (int i = 0; i < count; i++) {
                System.out.println(theUsers[i].userName + "\t\t" + theUsers[i].userId);
            }
        }
    }

    // METHOD 3: Check if user exists by user ID
    public static int isUser() {
        System.out.println("Enter user's ID: ");
        String userId = input.nextLine();

        // Check if a user with the given ID exists
        for (int i = 0; i < count; i++) {
            if (theUsers[i].userId.equalsIgnoreCase(userId)) {
                return i; // Return the index of the found user
            }
        }

        System.out.println("User is not registered.");
        return -1; // Return -1 if no user is found
    }
}