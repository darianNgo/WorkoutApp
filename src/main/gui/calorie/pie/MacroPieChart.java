package gui.calorie.pie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import javax.swing.*;
import java.awt.*;

//https://stackoverflow.com/questions/46887682/making-a-piechart-visible-in-jpanel

public class MacroPieChart extends JPanel {
    private double proteinInCalories;
    private double carbsInCalories;
    private double fatsInCalories;
    private double total;
    private final ObservableList<PieChart.Data> details =   FXCollections.observableArrayList();
    private static PieChart pieChart;

    public MacroPieChart(double protein, double carbs, double fats) {
        this.proteinInCalories = protein * 4;
        this.carbsInCalories = carbs * 4;
        this.fatsInCalories = fats * 9;
        this.total = proteinInCalories + carbsInCalories + fatsInCalories;
        setLayout(new GridLayout(2,3,10,10));


        JFXPanel dataPanel = new JFXPanel();
//        ScrollPane sp = new ScrollPane();

        details.addAll(new PieChart.Data("Protein: " + proteinInCalories, proteinInCalories),
                new PieChart.Data("Carbohydrates: " + carbsInCalories, carbsInCalories),
                new PieChart.Data("Fats: " + fatsInCalories, fatsInCalories));

        pieChart = new PieChart();
        pieChart.setData(details);
        pieChart.setTitle("Total Calories: " + total);
        pieChart.setLegendSide(Side.BOTTOM);
        pieChart.setLabelsVisible(true);
        Scene scene = new Scene(pieChart, 700, 700);
        dataPanel.setScene(scene);
        add(dataPanel);
        setPreferredSize(new Dimension(1000, 1000));

//        for (PieChart.Data data : details) {
//            if (data.getName().equals("Protein: " + proteinInCalories)) {
//                data.getNode().setStyle();
//            }
//        }

    }

}
