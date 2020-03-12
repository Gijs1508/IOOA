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
    // Pane van de speler
    public Pane player;
    // Het scherm (in principe de scene)
    public AnchorPane mainPane;
    // De label waar de tekst in zit waar de hoeveelheid eieren getoond wordt
    public Label eierenText;
    // Pane van het kippenhok
    public Pane henHouse;
    // De beweegsnelheid
    private static double movSpeed = 3;
    private int eieren = 0;

    @Override
    // Als het programma wordt aangeroepen, wordt deze functie uitgevoerd
    public void initialize(URL location, ResourceBundle resources) {
        eierenText.setText(String.format("Aantal eieren: %s", eieren));
    }

    // functie om een ei te plaatsen
    private void placeAnEgg(double x, double y) {
        if(isInTheHenHouse()){
            eieren += 1;
            eierenText.setText(String.format("Aantal eieren: %s", eieren));
            Ei ei = new Ei(x, y);
            mainPane.getChildren().add(ei);
        }
    }

    // check of de kip in het kippenhok is
    private boolean isInTheHenHouse(){
        // afstand tussen de linkerkant van het scherm en het hok
        double posX = henHouse.getLayoutX();
        // afstand tussen de bovenkant van het scherm en het hok
        double posY = henHouse.getLayoutY();
        // breedte van het hok
        double width = henHouse.getPrefWidth();
        // hoogte van het hok
        double height = henHouse.getPrefHeight();

        // Coordinaten van linkerbovenhoek van het hok
        Point2D hhLeftTop = (new Point2D(posX, posY));
        // Coordinaten van rechterbovenhoek van het hok
        Point2D hhRightTop = (new Point2D(posX + width, posY));
        // Coordinaten van rechteronderhoek van het hok
        Point2D hhRightBottom = (new Point2D(posX + width, posY + height));
        // Positie van de speler
        Point2D playerPos = (new Point2D(player.getLayoutX(), player.getLayoutY()));

        // check of de positie van de kip in het hok zit
        if(((playerPos.getX() + 10) >= hhLeftTop.getX()) && (playerPos.getX() <= (hhRightTop.getX() - 30)) &&
                ((playerPos.getY() + 10) >= hhLeftTop.getY()) && playerPos.getY() <= (hhRightBottom.getY() - 35)){
            return true;
        } else {
            // geef een melding als het niet zo is
            createAlert();
            return false;
        }
    }

    // bijna hetzelfde als isInTheHenHouse, maar dan om te checken of de kip in het scherm is
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

    // Kijk of er een toets ingedrukt wordt
    @FXML
    public void handleOnKeyPressed(KeyEvent event) {
        // Beweeg de kip in de betreffende richting
        switch(event.getCode()){
            case W: movePlayerTo(0, -movSpeed); break;
            case S: movePlayerTo(0, movSpeed); break;
            case A: movePlayerTo(-movSpeed, 0); break;
            case D: movePlayerTo(movSpeed, 0); break;
            case SPACE: placeAnEgg(player.getLayoutX(), player.getLayoutY());
        }
    }

    // Kijk of er een toets losgelaten wordt
    @FXML
    public void handleOnKeyReleased(KeyEvent event) {
        // Stop de beweging van de kip
        switch(event.getCode()){
            case W: case S: case A: case D: movePlayerTo(0, 0); break;
        }
    }

    // Maak de melding aan
    public void createAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("!!!");
        alert.setHeaderText("Let op");
        alert.setContentText("Je mag alleen in de hen (het bruine vlak) een ei plaatsen!");
        alert.showAndWait();
    }

    // Beweeg de kip
    public void movePlayerTo(double x, double y){
        // X positie van de kip
        double posX = player.getLayoutX();
        // Y positie van de kip
        double posY = player.getLayoutY();

        // check of de kip op het scherm is
        if(isOnScreen()){
            // Beweeg in de gegeven richting
            player.relocate(posX + x, posY + y);
            // als de kip tegen de randen van het scherm botst, beweeg m dan iets terug
            // zodat de kip niet vast komt te zitten
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
