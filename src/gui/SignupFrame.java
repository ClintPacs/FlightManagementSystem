package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignupFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField fullNameField;
    private JTextField emailField;

    public SignupFrame() {
        setTitle("Sign Up");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel fullNameLabel = new JLabel("Full Name:");
        fullNameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        JButton signupButton = new JButton("Sign Up");

        signupButton.addActionListener(this::signupAction);

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(fullNameLabel);
        add(fullNameField);
        add(emailLabel);
        add(emailField);
        add(signupButton);

        setVisible(true);
    }

    private void signupAction(ActionEvent e) {
        // Handle sign up (save user details, etc.)
        new LoginFrame();  // Redirect to login after successful signup
        this.dispose();
    }
}
