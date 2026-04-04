package ma.ensah;

import java.util.HashMap;
import java.util.Map;

public class UserStore {

     
    private static Map<String, String> users = new HashMap<>();
 
    static {
        users.put("admin", "1234");
        users.put("hiba", "password");
    }

    public static boolean userExists(String username) {
        return users.containsKey(username);
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static boolean register(String username, String password) {
        if (users.containsKey(username)) {
            return false;  
        }
        users.put(username, password);
        return true;
    }

    public static int getUserCount() {
        return users.size();
    }
}