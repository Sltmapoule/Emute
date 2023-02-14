import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

enum FilterType{PasseBas,PasseHaut,PasseBande,CoupeBande};

public class Filter {
    Pane pane =new Pane();
    Button newFilter = new Button("Add Filter");
    Button okButton = new Button("Ok");
    Stage temp = new Stage();
    GridPane filterPane = new GridPane();
    Label label1 = new Label("Type :");
    TextField filterType = new TextField ();
    Label label2 = new Label("Fréquence basse :");
    TextField filterLF = new TextField ();

    int lowFreq;
    int highFreq;

    public Filter() {
        Scene tempScene = new Scene(filterPane,300,200,true);
        temp.setTitle("Ajoute un nouveau filtre");


        filterPane.setPadding(new Insets(30, 30, 50, 40));
        filterPane.setVgap(10);
        filterPane.setHgap(10);
        filterPane.add(label1,0,0);
        filterPane.add(filterType,1,0);
        filterPane.add(label2,0,1);
        filterPane.add(filterLF,1,1);
        filterPane.add(okButton,0,2);

        temp.setScene(tempScene);


        pane.getChildren().add(newFilter);
        newFilter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                temp.show();
            }
        });
        okButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println(filterType.getText());
                temp.hide();
            }
        });
    }

    public Pane getPane() {
        return pane;
    }
}
