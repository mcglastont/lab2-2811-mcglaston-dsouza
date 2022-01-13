import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Sean D'Souza
 * Date:       1/5/2022
 */

/**
 * This class is a type of flower.
 * It is healed by Hornets and hurt by Honeybees.
 */
public class BlackRose extends Flower {

    private final int HEALTH_CAP = 300;

    public BlackRose(Position pos) {
        this.pos = pos;
        this.health = 150;
        ImageView flowerImage = new ImageView(new Image("file:images/BlackRose.jpg")); // draws flower
        flowerImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the flower
        flowerImage.setFitWidth(50.0);         // scale flower to be a reasonable size
        Label flowerLabel = new Label();
        flowerLabel.setText("Black Rose");
        flowerLabel.setStyle("-fx-text-fill: blue;");
        flowerBox = new VBox();
        flowerBox.getChildren().add(flowerImage);
        flowerBox.getChildren().add(flowerLabel);
    }

    @Override
    public void interactWithBee(Bee bee) {
        if (bee instanceof Hornet) health += 6;
        else if (bee instanceof Honeybee) health -= 5;
    }

    public Pane getFlowerBox() {
        return flowerBox;
    }

}
