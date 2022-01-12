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

import java.util.ArrayList;
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

        //initiate the list of bees, flowers, and life force bars
        listOfBees = new ArrayList<>();
        listOfFlowers = new ArrayList<>();
        lifeForce = new ArrayList<>();

        //call the helper methods that will generate the bees and flowers in the garden
        randomlyPopulate();


        theGarden.setFocusTraversable(true); // ensure garden pane will receive key presses
    }

    public void update() {
        /*
        This method randomly updates the position  and status of each bee in the
        given list of bees.
        */
        for (Bee b: listOfBees) {
            b.move(theGarden);
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
    }

    public void randomlyPopulate() {
        int honeybees = r.nextInt(3) + 6;
        for (int i = 0; i < honeybees; i++) {
            ProgressBar healthBar = new ProgressBar();

            healthBar.setMinHeight(4);
            healthBar.setPrefHeight(4);
            healthBar.setMaxHeight(4);
            healthBar.setPrefWidth(32);
            lifeForce.add(healthBar);
            Position random = randomPosition();
            listOfBees.add(new Honeybee(random, healthBar));
        }
        int hornets = r.nextInt(2) + 4;
        for (int i = 0; i < hornets; i++) {
            ProgressBar healthBar = new ProgressBar();

            healthBar.setMinHeight(4);
            healthBar.setPrefHeight(4);
            healthBar.setMaxHeight(4);
            healthBar.setPrefWidth(32);
            lifeForce.add(healthBar);
            Position random = randomPosition();
            listOfBees.add(new Hornet(random, healthBar));
        }
        int sunflowers = r.nextInt(7) + 1;
        for (int i = 0; i < sunflowers; i++) {
            listOfFlowers.add(new Sunflower(randomPosition()));
        }
        int blackroses = r.nextInt(3) + 1;
        for (int i = 0; i < blackroses; i++) {
            listOfFlowers.add(new BlackRose(randomPosition()));
        }

        for (Bee b: listOfBees) {
            theGarden.getChildren().add(b.getBeeBox());
            double x = r.nextDouble() * theGarden.getMaxWidth();
            double y = r.nextDouble() * theGarden.getHeight();
            b.setUp(x, y);
        }

        for (Flower f: listOfFlowers) {
            theGarden.getChildren().add(f.getFlowerBox());
        }
    }

    private Position randomPosition() {
        return new Position((r.nextDouble() * theGarden.getMaxWidth() ), (r.nextDouble() * theGarden.getHeight()));
    }

}
