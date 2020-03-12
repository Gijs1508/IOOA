package casus2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Ei extends AnchorPane {
    public Ei(double x, double y){
        Image eiImg = new Image("/images/egg.png");
        ImageView showEi = new ImageView(eiImg);
        showEi.setFitWidth(30);
        showEi.setFitHeight(30);
        this.setLayoutX(x);
        this.setLayoutY(y);
        this.getChildren().add(showEi);
    }
}
