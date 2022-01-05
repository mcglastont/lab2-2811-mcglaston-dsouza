public abstract class Bee {

    private Position pos;
    private int health;
    private Flower[] brain;

    public abstract void move();

    public abstract void interact();

    public double[] getPosition() {
        return pos.getPosition();
    }

}
