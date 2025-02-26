package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label helloLabel = new Label("Kaspi Bank");

        StackPane root = new StackPane();
        root.getChildren().add(helloLabel);

        Scene scene = new Scene(root, 400, 300);
        root.setStyle("-fx-background-color: white;");

        primaryStage.setTitle("Hello World JavaFX");
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

