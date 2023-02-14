import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MyAudio {

    Pane pane =new Pane();
    FileChooser importFile = new FileChooser();
    Button openFile = new Button("Import a music");
    String urlFile = "";
    Button lecture = new Button("lecture");

    public MyAudio() {
        importFile.setTitle("Select a music");
        pane.getChildren().add(openFile);
        pane.getChildren().add(lecture);
        lecture.setTranslateX(100);



        openFile.setOnMouseClicked(mouseEvent -> {
            File newFile = importFile.showOpenDialog(new Stage());
            urlFile = newFile.toURI().toString();
            System.out.println(urlFile);


        });
        System.out.println(urlFile);

        lecture.setOnMouseClicked( mouseEvent -> {
            AudioClip truc = new AudioClip(urlFile);
            truc.play();
        });

    }

    public Pane getPane() {
        return pane;
    }
}
