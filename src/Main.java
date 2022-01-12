
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
This simply loads the fxml of the garden.
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
