/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Terry McGlaston
 * Date:       1/5/2022
 */

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This class represents the collection of all Bees and Flowers, as well as the space that they interact in.
 * Each time the update() method is called, the garden advances in time, allowing bees to move around and tire out.
 *
 */
public class Garden {
    //variables
    private List<Bee> listOfBees;
    private List<Flower> listOfFlowers;
    private List<ProgressBar> lifeForce;
    private final Random r = new Random();

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
            double radius = 0.15;
            List<Bee> nearbyBees = listOfBees.stream().filter(e -> b.getPosition().distance(e.getPosition()) <= radius)
                    .collect(Collectors.toList());
            nearbyBees.remove(b);
            for (Bee e : nearbyBees) {
                e.interactWithBee(b);
                b.interactWithBee(e);
            }
        }
        listOfBees = listOfBees.stream().filter(b -> b.getHealth() > 0).collect(Collectors.toList()); // removes dead bees

        /*
        This method randomly updates the status of each flower in the given list
        of flowers.
         */
        for (Flower f: listOfFlowers) {
            double radius = 0.2;
            List<Bee> nearbyBees = listOfBees.stream().filter(b -> f.getPosition().distance(b.getPosition()) <= radius)
                    .collect(Collectors.toList());
            for (Bee b : nearbyBees) {
                b.interactWithFlower(f);
                f.interactWithBee(b);
            }
        }
        listOfFlowers = listOfFlowers.stream().filter(f -> f.getHealth() > 0).collect(Collectors.toList());
    }

    public void randomlyPopulate() {
        int honeybees = r.nextInt(3) + 6;
        for (int i = 0; i < honeybees; i++) {
            listOfBees.add(new Honeybee(randomPosition()));
        }
        int hornets = r.nextInt(2) + 4;
        for (int i = 0; i < hornets; i++) {
            listOfBees.add(new Hornet(randomPosition()));
        }
        int sunflowers = r.nextInt(7) + 1;
        for (int i = 0; i < sunflowers; i++) {
            listOfFlowers.add(new Sunflower(randomPosition()));
        }
        int blackroses = r.nextInt(3) + 1;
        for (int i = 0; i < blackroses; i++) {
            listOfFlowers.add(new BlackRose(randomPosition()));
        }
    }

    private Position randomPosition() {
        return new Position(r.nextDouble(), r.nextDouble());
    }

    public void addFlower() {

    }
}
