public abstract class Bee {

    private Position pos;
    private int health;
    private Flower[] brain;

    public abstract void move();

    public abstract void interactWithFlower(Flower flower);

    public Position getPosition() {
        return pos;
    }

}
