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
