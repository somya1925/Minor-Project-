// UserDatabase.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private String filename;

    public UserDatabase(String filename) {
        this.filename = filename;
    }

    public void addUser(User user) {
        List<User> users = getUsers();
        users.add(user);
        saveUsers(users);
    }

    public List<User> getUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // If the file doesn't exist or an error occurs, return an empty list
            return new ArrayList<>();
        }
    }

    private void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
