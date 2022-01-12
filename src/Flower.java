public abstract class Flower {

    protected Position pos;
    protected int health;

    public abstract void interactWithBee(Bee bee);

    public Position getPosition() {
        return pos;
    }
}
