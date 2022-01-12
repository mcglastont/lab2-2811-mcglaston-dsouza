import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Sunflower extends Flower{
    private Pane flowerBox;

    public Sunflower(Position pos) {
        this.pos = pos;
        this.health = 300;
        ImageView flowerImage = new ImageView(new Image("file:images/Sunflower.jpg")); // draws flower
        flowerImage.setPreserveRatio(true);    // ensure ratio preserved when scaling the flower
        flowerImage.setFitWidth(50.0);         // scale flower to be a reasonable size
        Label flowerLabel = new Label();
        flowerLabel.setText("Sun flower");
        flowerLabel.setStyle("-fx-text-fill: blue;");
        flowerBox = new VBox();
        flowerBox.getChildren().add(flowerImage);
        flowerBox.getChildren().add(flowerLabel);
    }

    @Override
    public void interactWithBee(Bee bee) {
        if (bee instanceof Honeybee) health += 5;
        else if (bee instanceof Hornet) health -= 4;
    }

    public Pane getFlowerBox() {
        return flowerBox;
    }
}
