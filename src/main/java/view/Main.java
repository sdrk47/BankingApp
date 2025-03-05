package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Registration");

        loginButton.setOnAction(e -> new LoginPage().start(new Stage()));
        registerButton.setOnAction(e -> new RegisterPage().start(new Stage()));

        VBox root = new VBox(10, loginButton, registerButton);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Main Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


