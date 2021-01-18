package gui.calorie.pie;

import javax.swing.*;
import java.awt.*;

// reference: http://www.java2s.com/Code/Java/2D-Graphics-GUI/DrawingaPieChart.htm

public class CaloriePieChart extends JComponent {
    private Slice proteinSlice;
    private Slice carbsSlice;
    private Slice fatsSlice;
    private Slice[] slices;


    public CaloriePieChart(double protein, double carbs, double fats) {
        proteinSlice = new Slice(protein, Color.RED);
        carbsSlice = new Slice(carbs, Color.BLUE);
        fatsSlice = new Slice(fats, Color.GREEN);
        slices = new Slice[]{proteinSlice, carbsSlice, fatsSlice};
    }

    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), slices);
    }

    public void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;
        for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
        }

        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slices[i].value * 360 / total);

            g.setColor(slices[i].color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slices[i].value;
        }

    }

}