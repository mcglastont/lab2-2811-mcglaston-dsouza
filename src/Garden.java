import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
    private List<ProgressBar> lifeForce;

    @FXML
    private Pane theGarden;                 // capture the pane we are drawing on from JavaFX

    @FXML
    public void initialize() {              // executed after scene is loaded but before any methods
        theGarden.setStyle("-fx-background-color: linear-gradient(to bottom right, derive(forestgreen, 20%), derive(forestgreen, -40%));");

        //Start by generating the bees and randomly placing them in the garden

        theGarden.setFocusTraversable(true); // ensure garden pane will receive keypresses
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
