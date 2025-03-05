package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Dashboard {
    public void start(Stage stage, String username) {
        Label welcomeLabel = new Label("Hello, " + username + "!");
        Label balanceLabel = new Label(String.format("Your balance : %d", 1000000));
        Label messageLabel = new Label("Welcome to the system");
        Button logoutButton = new Button("Logout");

        logoutButton.setOnAction(e -> {
            stage.close();
            new LoginPage().start(new Stage());
        });

        VBox root = new VBox(10, welcomeLabel, messageLabel, balanceLabel, logoutButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("Main Page");
        stage.setScene(scene);
        stage.show();
    }
}

