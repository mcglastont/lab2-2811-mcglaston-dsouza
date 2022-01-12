import javafx.scene.layout.Pane;

public abstract class Flower {

    protected Position pos;
    protected int health;
    private Pane flowerBox;

    public abstract void interactWithBee(Bee bee);

    public Position getPosition() {
        return pos;
    }

    public abstract Pane getFlowerBox();
}
