import java.util.ArrayList;
import java.util.Random;

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
    public void move() {
        pos.movePosition(vector);
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
