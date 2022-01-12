import javafx.geometry.Point2D;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

public class Hornet extends Bee {
    private Pane beeBox;

    private final int HEALTH_CAP = 100;
    private static final Random r = new Random();

    public Hornet(Position pos, ProgressBar lifeForce) {
        this.pos = pos;
        this.health = 100;
        this.brain = new ArrayList<>();
        this.vector = randomizeVector(15);
        ImageView beeImage = new ImageView(new Image("file:images/Hornet.jpg")); // draws bee
        beeImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the bee
        beeImage.setFitWidth(50.0);         // scale bee to be a reasonable size
        Label beeLabel = new Label();
        beeLabel.setText("Hornet");
        beeLabel.setStyle("-fx-text-fill: blue;");
        beeBox = new VBox();
        beeBox.getChildren().add(beeImage);
        beeBox.getChildren().add(beeLabel);
        beeBox.getChildren().add(lifeForce);
    }

    @Override
    public void move(Pane theGarden) {
        pos.movePosition(vector);
        health -= 1;
        beeBox.setLayoutX(pos.getX());
        beeBox.setLayoutY(pos.getY());
    }

    @Override
    public void interactWithFlower(Flower flower) {
        if (flower instanceof Sunflower) {
            health += 1;
        } else if (flower instanceof BlackRose) {
            health += 3;
        }
        health = Math.min(Math.max(health, 0), HEALTH_CAP);
        if (r.nextDouble() < 0.02) randomizeVector(0.03);
    }

    @Override
    public void interactWithBee(Bee bee) {
        if (bee instanceof Hornet) health -= 2;
    }

    public Pane getBeeBox() {
        return beeBox;
    }

    @Override
    public void setUp(Double x, Double y) {
        beeBox.setLayoutX(x);
        beeBox.setLayoutY(y);
    }
}