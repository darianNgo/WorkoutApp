package gui;

import gui.exercises.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Reference: https://www.youtube.com/watch?v=5o3fMLPY7qY&t=119s&ab_channel=AlexLee

public class WorkoutMenuGui extends JFrame implements ActionListener {
    private JButton chestButton;
    private JButton shoulderButton;
    private JButton armButton;
    private JButton backButton;
    private JButton absButton;
    private JButton legsButton;
    //private JButton enduranceButton;
    private JLabel label;

    // makes the layout of the workout menu
    // EFFECTS: creates buttons and calls methods to make general layout of the workout menu
    public WorkoutMenuGui() {
        chestButton = new JButton("Chest");
        shoulderButton = new JButton("Shoulders");
        armButton = new JButton("Arms");
        backButton = new JButton("Back");
        absButton = new JButton("Abdominal");
        legsButton = new JButton("Legs");
        //enduranceButton = new JButton("Endurance");
        label = new JLabel("Select The Following Options:");
        chestButton.addActionListener(this);
        shoulderButton.addActionListener(this);
        armButton.addActionListener(this);
        backButton.addActionListener(this);
        absButton.addActionListener(this);
        legsButton.addActionListener(this);
        //enduranceButton.addActionListener(this);
        JPanel panel = panelSetup();

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    // EFFECTS: sets up the panel for the buttons
    public JPanel panelSetup() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(chestButton);
        panel.add(shoulderButton);
        panel.add(armButton);
        panel.add(absButton);
        panel.add(backButton);
        panel.add(legsButton);
        //panel.add(enduranceButton);
        return panel;
    }

    public static void main(String[] args) {
        new WorkoutMenuGui();
    }

    // REQUIRES: a button to be pressed
    // EFFECTS: generates the appropriate frame depending on user choice
    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkMuscleGroup(e, "Chest")) {
            new ChestGui();
        }
        if (checkMuscleGroup(e, "Shoulders")) {
            new ShouldersGui();
        }
        if (checkMuscleGroup(e, "Arms")) {
            new ArmsGui();
        }
        if (checkMuscleGroup(e, "Abdominal")) {
            new AbsGui();
        }
        if (checkMuscleGroup(e, "Back")) {
            new BackGui();
        }
        if (checkMuscleGroup(e, "Legs")) {
            new LegsGui();
        }
    }

    public boolean checkMuscleGroup(ActionEvent e, String muscleGroup) {
        if (e.getActionCommand().equals(muscleGroup)) {
            dispose();
            return true;
        } else {
            return false;
        }
    }
}
