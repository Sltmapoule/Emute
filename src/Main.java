import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

    MyAudio audio = new MyAudio();
    double[] abs = new double[200000];
    double[] ord = new double[200000];
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

        for(int i=0;i<200000;i++){
            abs[i]=i;
            ord[i]=2*Math.cos(i);
        }
        MyChart chart = new MyChart(abs,ord);


        pane.getChildren().add(audio.getPane());
        pane.getChildren().add(test.getPane());
        pane.getChildren().add(chart.getPane());
        chart.getPane().setTranslateY(50);
        test.getPane().setTranslateX(200);


    }

    public static void main(String[] args){
        launch(args);

    }

}
