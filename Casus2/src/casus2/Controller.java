package casus2;


import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Animation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public Pane player;
    private static final double W = 700, H= 700;

    boolean goForward, goBackward, goLeft, goRight, placeEgg;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("hoi");
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.001),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                // Call update method for every 0.001 sec.
                                checkInputs();
                            }
                        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void checkInputs(){
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goForward) dy -= 1;
                if (goBackward) dy += 1;
                if (goLeft)  dx -= 1;
                if (goRight)  dx += 1;
                if (placeEgg) placeAnEgg();

                movePlayerBy(dx, dy);
            }
        };
        timer.start();
    }

    private void placeAnEgg() {
    }

    @FXML
    public void handleOnKeyPressed(KeyEvent event) {

        switch(event.getCode()){
            case W: goForward = true; break;
            case S: goBackward = true; break;
            case A: goLeft = true; break;
            case D: goRight = true; break;
        }
    }

    @FXML
    public void handleOnKeyReleased(KeyEvent event) {
        switch(event.getCode()){
            case W: goForward = false; break;
            case S: goBackward = false; break;
            case A: goLeft = false; break;
            case D: goRight = false; break;
        }
    }

    public void movePlayerBy(int dx, int dy){
        if (dx == 0 && dy == 0) return;

        final double cx = player.getBoundsInLocal().getWidth()  / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        double x = cx + player.getLayoutX() + dx;
        double y = cy + player.getLayoutY() + dy;

        movePlayerTo(x, y);
    }

    private void movePlayerTo(double x, double y) {
        final double cx = player.getBoundsInLocal().getWidth()  / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
                x + cx <= W &&
                y - cy >= 0 &&
                y + cy <= H) {
            player.relocate(x - cx, y - cy);
        }
    }
}
