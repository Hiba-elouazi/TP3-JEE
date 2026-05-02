package model;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // In-memory store — same behaviour as your original UserStore
    private static final List<User> users = new ArrayList<>();

    // Authenticate: returns true if username + password match
    public static boolean authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) &&
                user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Register a new user
    public static void register(String username, String password) {
        users.add(new User(username, password));
    }

    // Check if a username is already taken
    public static boolean userExists(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    // Return total number of registered users
    public static int getUserCount() {
        return users.size();
    }
}