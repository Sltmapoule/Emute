import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Filter {
    String[] FilterType = {"PasseBas", "PasseHaut", "PasseBande", "CoupeBande"};
    Button okButton = new Button("Ok");
    Button newFilter = new Button("Add Filter");
    Button removeButton = new Button("Remove");
    Stage temp = new Stage();
    GridPane filterPane = new GridPane();
    Pane pane = new Pane();
    ArrayList<FilterValues> filters = new ArrayList<>();
    ArrayList<CheckBox> checks = new ArrayList<>();
    ArrayList<Label> idFilter = new ArrayList<>();
    Pane global = new Pane();
    VBox existingFilters = new VBox();




    ObservableList<String> types = FXCollections.observableArrayList(
            "Passe Bas", "Passe Haut", "Passe Bande", "Coupe Bande");
    ListView<String> listTypes = new ListView<>(types);

    Label label1 = new Label("Type :");
    Label label2 = new Label("Fréquence basse :");
    TextField filterLF = new TextField();
    Label label3 = new Label("Fréquence haute :");
    TextField filterHF = new TextField();
    Label nouveauFiltre = new Label("Nouveau filtre :");
    Label ancienFiltre = new Label( "Filtres existants :");
    TextField removeTxt = new TextField();

    String type;
    int lowFreq;
    int highFreq;
    int i = 1;

    public Filter() {
        Scene tempScene = new Scene(global, 700, 300, true);
        temp.setTitle("Ajoute un nouveau filtre");

        filterPane.setPadding(new Insets(0, 0, 0, 5));
        filterPane.setVgap(10);
        filterPane.setHgap(10);
        filterPane.add(label1, 0, 0);
        filterPane.add(listTypes, 1, 0);
        listTypes.setPrefHeight(95);
        listTypes.setPrefWidth(175);
        filterPane.add(label2, 0, 1);
        filterPane.add(filterLF, 1, 1);
        filterPane.add(label3, 0, 2);
        filterPane.add(filterHF, 1, 2);
        filterPane.setPrefWidth(350);
        filterPane.getChildren().add(okButton);
        okButton.setTranslateX(120);
        okButton.setTranslateY(150);
        filterPane.getChildren().add(removeTxt);
        filterPane.getChildren().add(removeButton);
        removeButton.setTranslateX(450);
        removeButton.setTranslateY(150);
        removeTxt.setTranslateX(350);
        removeTxt.setTranslateY(150);
        removeTxt.setPromptText("n°");
        removeTxt.setPrefSize(20,30);
        existingFilters.setSpacing(10);


        pane.getChildren().add(newFilter);
        temp.setScene(tempScene);

        existingFilters.setPadding(new Insets(0, 0, 0, 5));
        existingFilters.setLayoutX(5);
        global.getChildren().add(nouveauFiltre);
        global.getChildren().add(ancienFiltre);
        ancienFiltre.setTranslateX(350);
        global.getChildren().add(filterPane);
        filterPane.setTranslateY(50);
        global.getChildren().add(existingFilters);
        existingFilters.setTranslateY(50);
        existingFilters.setTranslateX(200+(350-filterPane.getWidth())/2);



        newFilter.setOnMouseClicked(mouseEvent -> temp.show());
        okButton.setOnMouseClicked(mouseEvent -> {
            type = FilterType[listTypes.getSelectionModel().getSelectedIndex()];
            try {
                lowFreq = Integer.parseInt(filterLF.getText());
            } catch (NumberFormatException e) {
                lowFreq = 0;
            }
            try {
                highFreq = Integer.parseInt(filterHF.getText());
            } catch (NumberFormatException e) {
                highFreq = 0;
            }
            temp.hide();
            filterLF.setText("");
            filterHF.setText("");
            System.out.println(type);
            System.out.println(lowFreq);
            System.out.println(highFreq);
            filters.add(new FilterValues(type,lowFreq,highFreq));
            checks.add(new CheckBox());
            checks.get(i-1).setSelected(true);
            checks.get(i-1).setAllowIndeterminate(false);
            idFilter.add(new Label(String.valueOf(i)));

            HBox lastFilter = new HBox(5);
            lastFilter.setSpacing(10);
            lastFilter.getChildren().addAll(
                    //idFilter.get(i-1) ,
                    checks.get(i-1),
                    new Label(filters.get(i-1).getType()),
                    new Label(String.valueOf(filters.get(i-1).getLowFreq())),
                    new Label(String.valueOf(filters.get(i-1).getHighFreq())));
            existingFilters.getChildren().add(lastFilter);
            i+=1;
        });

        removeButton.setOnMouseClicked(mouseEvent -> {
            int k = Integer.parseInt(removeTxt.getText());
            removeTxt.clear();
            existingFilters.getChildren().remove(k - 1);
            checks.remove(k-1);
            idFilter.remove(k-1);
            filters.remove(k-1);
            idFilter.clear();
            for(int j=0;j<filters.size();j++){
                idFilter.add(new Label(String.valueOf(j)));
            }
            i-=1;
        });
    }
    public void update(){
        if (listTypes.getSelectionModel().getSelectedIndex()!=-1){
            filterHF.setDisable(listTypes.getSelectionModel().getSelectedIndex() == 0);
            filterLF.setDisable(listTypes.getSelectionModel().getSelectedIndex() == 1);
        }
    }

    public Pane getPane() {
        return pane;
    }

    public String getType() {
        return type;
    }

    public int getLowFreq() {
        return lowFreq;
    }

    public int getHighFreq() {
        return highFreq;
    }

    public Stage getTemp() {
        return temp;
    }

    public Pane getGlobal() {
        return global;
    }
}

