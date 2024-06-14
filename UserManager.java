import java.io.IOException;
import java.util.List;

public class UserManager {
    public static void main(String[] args) {
        // Example usage in a standalone Java application

        // Create User objects
        User user1 = new User("john_doe", "password123");
        User user2 = new User("jane_smith", "letmein");

        // Create a UserDatabase object
        UserDatabase userDatabase = new UserDatabase("users.dat");

        // Add users to the database
        userDatabase.addUser(user1);
        userDatabase.addUser(user2);

        // Retrieve and print users from the database
        List<User> users = userDatabase.getUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
