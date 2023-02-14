import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;
import java.util.Arrays;


public class Main extends Application {

    MyAudio audio = new MyAudio();
    double[] truc = {1,2,3};
    MyChart chart = new MyChart(truc,truc);
    Filter test = new Filter();


    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("EMute Project");
        primaryStage.getIcons().add(new Image("file:img/logo.png"));
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color : #000000;");
        Scene scene = new Scene(pane,800, 600, true);

        primaryStage.setScene(scene);
        primaryStage.show();

        pane.getChildren().add(audio.getPane());
        pane.getChildren().add(chart.getPane());
        pane.getChildren().add(test.getPane());
        chart.getPane().setTranslateY(50);
        test.getPane().setTranslateX(200);


    }

    public static void main(String[] args){
        launch(args);

    }

}
