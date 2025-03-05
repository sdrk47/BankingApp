package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginPage {
    public void start(Stage stage) {
        Label loginLabel = new Label("Login:");
        TextField loginField = new TextField();
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        Label statusLabel = new Label();

        loginButton.setOnAction(e -> {
            String username = loginField.getText();
            String password = passwordField.getText();
            if (authenticate(username, password)) {
                stage.close();
                new Dashboard().start(new Stage(), username);
            } else {
                statusLabel.setText("Incorrect login or password");
            }
        });

        VBox root = new VBox(10, loginLabel, loginField, passwordLabel, passwordField, loginButton, statusLabel);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 250);
        stage.setTitle("Authorization");
        stage.setScene(scene);
        stage.show();
    }

    private boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
