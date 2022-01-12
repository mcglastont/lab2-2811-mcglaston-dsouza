import java.util.ArrayList;
import java.util.Random;

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
        pos.movePosition(vector);
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