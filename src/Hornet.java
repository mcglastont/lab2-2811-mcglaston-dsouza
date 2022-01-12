/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Sean D'Souza
 * Date:       1/5/2022
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is a type of Bee.
 * Hornets are damaged by each other.
 * They are slightly healed by Sunflowers, and are greatly healed by Black Roses.
 * They have less health than Honeybees, but move slightly faster.
 */
public class Hornet extends Bee {

    private final int HEALTH_CAP = 100;
    private static final Random r = new Random();

    public Hornet(Position pos) {
        this.pos = pos;
        this.health = 100;
        this.brain = new ArrayList<>();
        this.vector = randomizeVector(0.03);
    }

    @Override
    public void move() {
        super.move();
        health -= 1;
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
}