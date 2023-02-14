import javafx.css.Style;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class MyChart {

    Pane pane = new Pane();

    public MyChart(double[] x, double[] y) {
        ArrayList<Double> x1 = DoubleStream.of(x).boxed().collect(
                Collectors.toCollection(new Supplier<ArrayList<Double>>() {
                    public ArrayList<Double> get() {
                        return (new ArrayList<Double>());
                    }
                }));
        ArrayList<Double> y1 = DoubleStream.of(y).boxed().collect(
                Collectors.toCollection(new Supplier<ArrayList<Double>>() {
                    public ArrayList<Double> get() {
                        return (new ArrayList<Double>());
                    }
                }));
        ArrayList<Double> x2 = new ArrayList<>();
        ArrayList<Double> y2 = new ArrayList<>();
        if (x1.size()>10000){
            for(int i=0;i<(int)(x1.size()/10);i++){
                double abs = 0;
                for(int j=0;j<10;j++){
                    abs += x1.get(i+j);
                }
                x2.add(abs/10);
                y2.add(y1.get(i+4));
            }
        } else {x2=x1;y2=y1;}



        XYChart.Series series = new XYChart.Series();
        for (int i = 0; i < x2.size(); i++) {
            series.getData().add(new XYChart.Data(x2.get(i), y2.get(i)));
        }

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Temps(s)");
        LineChart<Number, Number> graph = new LineChart<>(xAxis, yAxis);
        graph.getData().add(series);
        graph.setPrefWidth(1500);
        graph.setCreateSymbols(false);
        pane.getChildren().add(graph);
    }

    public Pane getPane() {
        return pane;
    }


}
