package casus2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("casus2.fxml"));
        Scene root = new Scene(loader.load(), 750, 750);
        root.getRoot().requestFocus();
        primaryStage.setTitle("Kip");
        Image image = new Image("/images/kip.png");
        primaryStage.getIcons().add(image);
        primaryStage.setScene(root);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
