import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * This class is a type of bee.
 * Honeybees are damaged by hornets.
 * They are healed by sunflowers but damaged by Black Roses.
 * They have a lot of health.
 */
public class Honeybee extends Bee {

    private final int HEALTH_CAP = 225;
    private static final Random r = new Random();

    public Honeybee(Position pos, ProgressBar lifeForce) {
        this.pos = pos;
        this.health = 225;
        this.brain = new ArrayList<>();
        this.vector = randomizeVector(0.02);
        ImageView beeImage = new ImageView(new Image("file:images/Honeybee.jpg")); // draws bee
        beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        beeImage.setFitWidth(50.0);         // scale bee to be a reasonable size
        Label beeLabel = new Label();
        beeLabel.setText("Honeybee");
        beeLabel.setStyle("-fx-text-fill: blue;");
        beeBox = new VBox();
        beeBox.getChildren().add(beeImage);
        beeBox.getChildren().add(beeLabel);
        beeBox.getChildren().add(lifeForce);
    }

    @Override
    public void interactWithFlower(Flower flower) {
        if (!brain.contains(flower)) brain.add(flower);
        if (flower instanceof Sunflower) {
            health += 2;
        } else if (flower instanceof BlackRose) {
            health += -2;
        }
        health = Math.min(Math.max(health, 0), HEALTH_CAP);
        if (r.nextDouble() < 0.02) randomizeVector(0.02);
    }

    @Override
    public void interactWithBee(Bee bee) {
        if (bee instanceof Hornet) health -= 5;
    }

    public Pane getBeeBox() {
        return beeBox;
    }
}
