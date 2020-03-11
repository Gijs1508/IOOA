package sample;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class GameWindow {
    public Scene showWindow() throws IOException {
        // Maak de ren
//        StackPane layout = new StackPane();
//        layout.setStyle("-fx-background-color: chartreuse");
        Parent ren = FXMLLoader.load(getClass().getResource("Game.fxml"));

        // Maak het hok
//        Label hok = new Label();
//        hok.setStyle("-fx-background-color: saddlebrown");
//        hok.setPadding(new Insets(5, 5, 5, 5));
//        hok.setScaleX(21.5);
//        hok.setScaleY(14.3);
//        layout.getChildren().add(hok);

        Scene scene = new Scene(ren, 700, 700);
        return scene;
    }
}
