package gui.calorie;

import gui.MenuGui;
import gui.calorie.pie.MacroPieChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalorieOutputGui extends CalorieOutput implements ActionListener {
    private static MacroPieChart pie;
    private JFrame frame;


    public CalorieOutputGui(MacroPieChart pie) {
        frame = new JFrame();
        JPanel buttonPanel = new JPanel(new GridLayout(0, 1));
        JButton button = new JButton("Back");
        button.addActionListener(this);
        buttonPanel.add(button);
        frame.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        pie.setAlignmentX(CENTER_ALIGNMENT);
        pie.setAlignmentY(CENTER_ALIGNMENT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pie);

        frame.setLocationRelativeTo(null);
    }


    public static void main(String[] argv) {
        new CalorieOutputGui(pie);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            new MenuGui();
            frame.dispose();
        }
    }
}
