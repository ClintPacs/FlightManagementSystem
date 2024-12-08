package services;

import models.User;

import java.io.*;
import java.util.*;

public class UserService {

    private static final String USER_FILE = "resources/users.csv";

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String username = data[0];
                String password = data[1];
                String fullName = data[2];
                String email = data[3];
                users.add(new User(username, password, fullName, email));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
