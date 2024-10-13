package user;

import models.User;

public class UserRepository {
    static User[] theUsers = new User[50];
    public static int count = 0;

    public static void addUser(User u) {
        for (int i = 0; i < count; i++) {
            if (u.userId.equalsIgnoreCase(theUsers[i].userId)) {
                System.out.println("User with ID " + u.userId + " is already registered.");
                return;
            }
        }
        if (count < 50) {
            theUsers[count] = u;
            count++;
        } else {
            System.out.println("User limit reached.");
        }
    }

    public static User findUserById(String userId) {
        for (int i = 0; i < count; i++) {
            if (theUsers[i].userId.equalsIgnoreCase(userId)) {
                return theUsers[i];
            }
        }
        return null;
    }

    public static void showAllUsers() {
        System.out.println("Name\t\tID");
        for (int i = 0; i < count; i++) {
            System.out.println(theUsers[i].userName + "\t\t" + theUsers[i].userId);
        }
    }
}