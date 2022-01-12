/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Garden - Extended
 * Author:     Terry McGlaston
 * Date:       1/5/2022
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class starts the application, loading the garden and all of its bees.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("garden_simulator.fxml"));
        primaryStage.setTitle("Garden simulator 2022");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }
}
