import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
This is the class that handles the garden and how it functions.
 */
public class Garden {
    //variables
    private List<Bee> listOfBees;
    private List<Flower> listOfFlowers;

    //methods
    public Garden (List<Bee> listOfBees, List<Flower> listOfFlowers) {
        this.listOfBees = listOfBees;
        this.listOfFlowers = listOfFlowers;
    }

    public void update() {
        /*
        This method randomly updates the position  and status of each bee in the
        given list of bees.
        */
        for (Bee b: listOfBees) {
            b.move();
        }

        /*
        This method randomly updates the status of each flower in the given list
        of flowers.
         */
        for (Flower f: listOfFlowers) {
            double radius = 0.3;
            List<Bee> nearbyBees = listOfBees.stream().filter(b -> f.getPos().distance(b.getPosition()) <= radius).collect(Collectors.toList());
            for (Bee b : nearbyBees){
                b.interactWithFlower(f);
            }
        }
    }

    public void addFlower() {

    }
}
