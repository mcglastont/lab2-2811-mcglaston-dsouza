public class Sunflower extends Flower{

    public Sunflower(Position pos) {
        this.pos = pos;
        this.health = 300;
    }

    @Override
    public void interactWithBee(Bee bee) {
        if (bee instanceof Honeybee) health += 5;
        else if (bee instanceof Hornet) health -= 4;
    }
}
