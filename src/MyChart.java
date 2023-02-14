import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
public class MyChart {

    Pane pane =new Pane();

    public MyChart(double[] x, double[] y) {
        ArrayList<Double> x1 = DoubleStream.of( x ).boxed().collect(
                Collectors.toCollection(new Supplier<ArrayList<Double>>() {
                    public ArrayList<Double> get() {
                        return( new ArrayList<Double>() );
                    }
                } ) );
        ArrayList<Double> y1 = DoubleStream.of( y ).boxed().collect(
                Collectors.toCollection( new Supplier<ArrayList<Double>>() {
                    public ArrayList<Double> get() {
                        return( new ArrayList<Double>() );
                    }
                } ) );
        XYChart.Series series = new XYChart.Series();
        for (int i=0; i<x1.size(); i++){
            series.getData().add(new XYChart.Data(x1.get(i), y1.get(i)));
            }

            NumberAxis xAxis = new NumberAxis();
            NumberAxis yAxis = new NumberAxis();
            xAxis.setLabel("Temps(s)");
            LineChart<Number,Number> graph = new LineChart<>(xAxis, yAxis);
            graph.getData().add(series);
            pane.getChildren().add(graph);
    }

    public Pane getPane() {
        return pane;
    }


}
