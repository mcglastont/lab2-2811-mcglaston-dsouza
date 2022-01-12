/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Sean D'Souza
 * Date:       1/5/2022
 */

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * This class is the abstract implementation of a Bee object.
 * Both Honeybees and Hornets extend from this class.
 * Bees can move around in the garden, and have a health amount.
 * When their health reaches zero, they "die" and are removed from the garden.
 */
public abstract class Bee {

    protected Position pos;
    protected int health;
    protected ArrayList<Flower> brain;
    protected double[] vector;
    private final Random r = new Random();

    public void move() {
        pos.movePosition(vector);
        double margin = 0.01;
        if (abs(0.5 - pos.getX()) < margin)
            vector[0] = abs(vector[0]) * (vector[0] < 0.5 ? 1 : -1);
        if (abs(0.5 - pos.getY()) < margin)
            vector[1] = abs(vector[1]) * (vector[1] < 0.5 ? 1 : -1);
    }

    public abstract void interactWithFlower(Flower flower);

    public abstract void interactWithBee(Bee bee);

    public Position getPosition() {
        return pos;
    }

    public int getHealth() {
        return health;
    }

    protected double[] randomizeVector(double magnitude) {
        double angle = Math.toRadians(r.nextDouble() * 360);
        return new double[]{Math.cos(angle) * magnitude, Math.sin(angle) * magnitude};
    }

}
