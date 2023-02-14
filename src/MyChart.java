import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class MyChart {

    Pane pane =new Pane();

    public MyChart() {


        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Temps(s)");
        LineChart<Number,Number> graph = new LineChart<Number,Number>(xAxis,yAxis);
        XYChart.Series series = new XYChart.Series();
        series.setName("test");
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
        graph.getData().add(series);

        ArrayList x = new ArrayList(List.of(1,2,3,4,5,6,7,8,9));
        ArrayList y = new ArrayList(List.of(5,4,9,3,7,5,6,2,8));
        XYChart.Series series1 = GenerateSeries(x,y);
        graph.getData().add(series1);

        pane.getChildren().add(graph);
        graph.setTranslateY(50);
    }

    public XYChart.Series GenerateSeries(ArrayList<Number> x, ArrayList<Number> y){
        XYChart.Series series = new XYChart.Series();
        for (int i=0; i<x.size(); i++){
            series.getData().add(new XYChart.Data(x.get(i), y.get(i)));
        }
        return series;
    }

    public Pane getPane() {
        return pane;
    }
}
