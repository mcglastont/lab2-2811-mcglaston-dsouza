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
 * This class is a type of bee.
 * Honeybees are damaged by hornets.
 * They are healed by sunflowers but damaged by Black Roses.
 * They have a lot of health.
 */
public class Honeybee extends Bee {

    private final int HEALTH_CAP = 225;

    private static final Random r = new Random();

    public Honeybee(Position pos) {
        this.pos = pos;
        this.health = 225;
        this.brain = new ArrayList<>();
        this.vector = randomizeVector(0.02);
    }

    @Override
    public void move () {
        super.move();
        health -= 1;
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
}
