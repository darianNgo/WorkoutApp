package gui;

import gui.calorie.CalorieCounterGUI;
import gui.exercises.SavedWorkoutsGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Reference: https://www.youtube.com/watch?v=5o3fMLPY7qY&t=119s&ab_channel=AlexLee

public class MenuGui extends JFrame implements ActionListener {
    private JButton workoutButton;
    private JButton calorieCounterButton;
    private JButton favouritesButton;
    private JLabel label;

    // EFFECTS: makes the main menu and buttons
    public MenuGui() {
        workoutButton = new JButton("Workout");
        calorieCounterButton = new JButton("Calorie Counter");
        favouritesButton = new JButton("Favourites");
        label = new JLabel("Select The Following Options:");
        workoutButton.addActionListener(this);
        calorieCounterButton.addActionListener(this);
        favouritesButton.addActionListener(this);

        JPanel panel = panelSetup();

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    // EFFECTS: makes the panel for the buttons
    public JPanel panelSetup() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(workoutButton);
        panel.add(calorieCounterButton);
        panel.add(favouritesButton);
        return panel;
    }

    public static void main(String[] args) {
        new MenuGui();
    }

    // REQUIRES: for a button to be pressed
    // EFFECTS: directs user to appropriate frame
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Workout")) {
            dispose();
            new WorkoutMenuGui();
        }
        if (e.getActionCommand().equals("Favourites")) {
            dispose();
            new SavedWorkoutsGui();
        }
        if (e.getActionCommand().equals("Calorie Counter")) {
            dispose();
            new CalorieCounterGUI();
        }
    }
}
