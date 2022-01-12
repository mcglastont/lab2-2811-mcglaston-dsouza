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

    private static final int HEALTH_CAP = 300;

    public BlackRose(Position pos) {
        this.pos = pos;
        this.health = 300;
    }

    @Override
    public void interactWithBee(Bee bee) {
        if (bee instanceof Hornet) health += 5;
        else if (bee instanceof Honeybee) health -= 2;
    }

}
