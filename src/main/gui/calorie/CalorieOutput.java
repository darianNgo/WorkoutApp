package gui.calorie;

import gui.calorie.observer.CalorieObserver;
import gui.calorie.pie.MacroPieChart;

import javax.swing.*;

public class CalorieOutput extends JComponent implements CalorieObserver {
    protected double protein;
    protected double carbs;
    protected double fats;
    protected double calories;
    protected MacroPieChart pie;

    public CalorieOutput() {
    }


    @Override
    public void update(Object p, Object c, Object f) {
        this.protein = (double) p;
        this.carbs = (double) c;
        this.fats = (double) f;
        this.calories = ((protein * 4) + (carbs * 4) + (fats * 9));
        pie = new MacroPieChart(protein, carbs, fats);
        new CalorieOutputGui(pie);
    }
}
