import java.util.ArrayList;
import java.util.Random;

public class Honeybee extends Bee {

    private Position pos;
    private int health;
    private final int HEALTH_CAP = 150;
    private ArrayList<Flower> brain;
    private double[] vector;
    private static final Random r = new Random();

    public Honeybee(Position pos) {
        this.pos = pos;
        this.health = 125;
        this.brain = new ArrayList<>();
        this.vector = new double[]{r.nextDouble() * 0.02, r.nextDouble() * 0.02};
        // vector[0] = x-vector, vector[1] = y-vector
    }

    @Override
    public void move() {
        pos.movePosition(vector);
        health -= 1;
    }

    @Override
    public void interactWithFlower(Flower flower) {
        if (flower instanceof Sunflower) {
            health += 2;
        } else if (flower instanceof BlackRose) {
            health += -2;
        }
        health = Math.min(Math.max(health, 0), HEALTH_CAP);
    }

    public Position getPosition() {
        return pos;
    }

    public int getHealth() {
        return health;
    }
}
