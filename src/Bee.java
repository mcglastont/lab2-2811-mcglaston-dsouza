import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public abstract class Bee {

    protected Position pos;
    protected int health;
    protected ArrayList<Flower> brain;
    protected double[] vector;
    private final Random r = new Random();
    private Pane beeBox;

    public abstract void move(Pane theGarden);

    public abstract void interactWithFlower(Flower flower);

    public abstract void interactWithBee(Bee bee);

    public Position getPosition() {
        return pos;
    }

    public int getHealth() {
        return health;
    }

    protected double[] randomizeVector(double magnitude) {
        return new double[]{r.nextDouble() * magnitude, r.nextDouble() * magnitude};
    }

    public Pane getBeeBox() {
        return beeBox;
    }

    public abstract void setUp(Double x, Double y);

}
