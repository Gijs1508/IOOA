package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    Button startBtn;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameWindow gameWindow = new GameWindow();
        primaryStage.setTitle("Leg een ei");

        startBtn = new Button("Start spel");
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.setScene(gameWindow.showWindow());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(startBtn);

        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
