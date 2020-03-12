package casus2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Pane player;
    public Pane mainPane;
    public Label eierenText;
    public Pane henHouse;
    private static final double W = 700, H= 700;
    private static double movSpeed = 3;
    private int eieren = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("hoi");
        eierenText.setText(String.format("Aantal eieren: %s", eieren));
        System.out.println(mainPane.getScaleX());
    }

    private void placeAnEgg(double x, double y) {
        if(isInTheHenHouse()){
            eieren += 1;
            eierenText.setText(String.format("Aantal eieren: %s", eieren));
            Ei ei = new Ei(x, y);
            mainPane.getChildren().add(ei);
        }
    }

    private boolean isInTheHenHouse(){
        double posX = henHouse.getLayoutX();
        double posY = henHouse.getLayoutY();
        double width = henHouse.getPrefWidth();
        double height = henHouse.getPrefHeight();
        Point2D hhLeftTop = (new Point2D(posX, posY));
        Point2D hhRightTop = (new Point2D(posX + width, posY));
        Point2D hhRightBottom = (new Point2D(posX + width, posY + height));
        Point2D playerPos = (new Point2D(player.getLayoutX(), player.getLayoutY()));

        if(((playerPos.getX() + 10) >= hhLeftTop.getX()) && (playerPos.getX() <= (hhRightTop.getX() - 30)) &&
                ((playerPos.getY() + 10) >= hhLeftTop.getY()) && playerPos.getY() <= (hhRightBottom.getY() - 35)){
            return true;
        } else {
            createAlert();
            return false;
        }
    }

    private boolean isOnScreen(){
        Point2D hhLeftTop = (new Point2D(0, 0));
        Point2D hhRightTop = (new Point2D(700, 0));
        Point2D hhRightBottom = (new Point2D(700, 700));
        Point2D playerPos = (new Point2D(player.getLayoutX(), player.getLayoutY()));

        if((playerPos.getX() >= hhLeftTop.getX()) && (playerPos.getX() <= hhRightTop.getX()) &&
                (playerPos.getY() >= hhLeftTop.getY()) && (playerPos.getY() <= hhRightBottom.getY())){
            return true;
        } else {
            return false;
        }
    }

    @FXML
    public void handleOnKeyPressed(KeyEvent event) {
        switch(event.getCode()){
            case W: movePlayerTo(0, -movSpeed); break;
            case S: movePlayerTo(0, movSpeed); break;
            case A: movePlayerTo(-movSpeed, 0); break;
            case D: movePlayerTo(movSpeed, 0); break;
            case SPACE: placeAnEgg(player.getLayoutX(), player.getLayoutY());
        }
    }

    @FXML
    public void handleOnKeyReleased(KeyEvent event) {
        switch(event.getCode()){
            case W: case S: case A: case D: movePlayerTo(0, 0); break;
        }
    }

    public void createAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!!!");
        alert.setHeaderText("Let op");
        alert.setContentText("Je mag alleen in de hen (het bruine vlak) een ei plaatsen!");
        alert.showAndWait();
    }

    public void movePlayerTo(double x, double y){
        double posX = player.getLayoutX();
        double posY = player.getLayoutY();
        if(isOnScreen()){
            player.relocate(posX + x, posY + y);
        } else {
            if(posX <= 0)
                player.relocate(posX + 1, posY);
            if(posX >= 700)
                player.relocate(posX - 1, posY);
            if(posY <= 0)
                player.relocate(posX, posY + 1);
            if(posY >= 700)
                player.relocate(posX, posY - 1);
        }
    }
}
