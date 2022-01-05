import java.util.ArrayList;
import java.util.Random;

public class Honeybee extends Bee {

    private Position pos;
    private int health;
    private ArrayList<Flower> brain;
    private double[] vector;
    private static final Random r = new Random();

    public Honeybee(Position pos, int health) {
        this.pos = pos;
        this.health = health;
        this.brain = new ArrayList<>();
        this.vector = new double[]{r.nextDouble() * 0.02, r.nextDouble() * 0.02};
        // vector[0] = x-vector, vector[1] = y-vector
    }

    @Override
    public void move() {
        if (brain.size() == 0) {
            pos.movePosition(vector);
        }
    }

    @Override
    public void interact() {

    }

    public double[] getPosition() {
        return pos.getPosition();
    }
}
