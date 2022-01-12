import javafx.scene.layout.Pane;

/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Sean D'Souza
 * Date:       1/5/2022
 */

/**
 * This class is the abstract implementation for a Flower object.
 * It has a position in the garden which does not change.
 * Flowers can be healed or damaged by different types of Bees
 */
public abstract class Flower {

    protected Position pos;
    protected int health;
    private Pane flowerBox;

    public abstract void interactWithBee(Bee bee);

    public Position getPosition() {
        return pos;
    }

    public abstract Pane getFlowerBox();

    public int getHealth() {
        return health;
    }
}
