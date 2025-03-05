package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterPage {
    public void start(Stage stage) {
        Label loginLabel = new Label("Set Login:");
        TextField loginField = new TextField();
        Label passwordLabel = new Label("Set Password:");
        PasswordField passwordField = new PasswordField();
        Button registerButton = new Button("Register");
        Label statusLabel = new Label();

        registerButton.setOnAction(e -> {
            String username = loginField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText("Login and password can not be empty!");
            } else if (registerUser(username, password)) {
                statusLabel.setText("Registration succeeded");
            } else {
                statusLabel.setText("User already exists");
            }
        });

        VBox root = new VBox(10, loginLabel, loginField, passwordLabel, passwordField, registerButton, statusLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Registration");
        stage.setScene(scene);
        stage.show();
    }

    private boolean registerUser(String username, String password) {
        try {
            if (userExists(username)) {
                return false;
            }
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(username + ":" + password + "\n");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
