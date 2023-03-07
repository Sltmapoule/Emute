import com.github.psambit9791.jdsp.filter.Bessel;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;


public class Main extends Application {

    MyAudio audio = new MyAudio();
    Filter filter = new Filter();



    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("EMute Project");
        primaryStage.getIcons().add(new Image("file:img/logo.png"));
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color : #000000;");
        Scene scene = new Scene(pane,800, 600, true);
        pane.getChildren().add(filter.getPane());
        filter.getPane().setTranslateX(200);

        primaryStage.setScene(scene);
        primaryStage.show();

        pane.getChildren().add(audio.getPane());

        double sampleRate = 4096;
        double frequency = 400;
        double amplitude = 8;
        double seconds = 4;
        double twoPiF = 2*Math.PI*frequency;
        double [] buffer = new double[(int)(seconds*sampleRate)];
        double [] time = new double[(int)(seconds*sampleRate)];
        Complex[] bufferfft = new Complex[(int)(seconds*sampleRate)];
        for(int sample = 0; sample < buffer.length; sample++){
            time[sample] =sample/sampleRate;
            buffer[sample] = (float)(amplitude*(Math.sin(10*Math.PI*(time[sample]))+Math.sin(20*Math.PI*(time[sample]))+Math.sin(30*Math.PI*(time[sample]))));
            bufferfft[sample]= new Complex(buffer[sample],0 );
        }


        int Fs = 100; //Sampling Frequency in Hz
        int order = 4; //order of the filter
        int cutOff = 9; //Cut-off Frequency
        Bessel flt = new Bessel(Fs); //signal is of type double[]

        double[] result = flt.lowPassFilter(buffer, order, cutOff); //get the result after filtering

        MyChart chart = new MyChart(time,buffer);

        pane.getChildren().add(chart.getPane());
        chart.getPane().setTranslateY(50);
        at.start();
    }

    AnimationTimer at = new AnimationTimer() {
        @Override
        public void handle(long l) {
            filter.update();


        }
    };

    public static void main(String[] args){
        launch(args);


    }


}
