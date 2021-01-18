package gui.exercises;

import gui.MenuGui;
import persistence.JsonRead;
import persistence.JsonWrite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SavedWorkoutsGui extends WorkoutsGui {
    private JButton loadButton;
    private JButton backButton;
    private JButton saveButton;
    private static final String JSON_STORE = "./data/favouritesGui.json";
    private final JsonWrite jsonWriter;
    private final JsonRead jsonReader;
    protected JPanel favouriteExercisesPanel;
    protected JPanel scrollPanel;

    // EFFECTS: calls super, making the panel, and sets the title. makes new json write and read
    public SavedWorkoutsGui() {
        super();
        jsonWriter = new JsonWrite(JSON_STORE);
        jsonReader = new JsonRead(JSON_STORE);
        scrollPanel = new JPanel();
        mainPanelSetup();
        makeFavourites();
        JScrollPane pane = new JScrollPane(favouriteExercisesPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.add(pane, BorderLayout.CENTER);
        add(scrollPanel);
        setTitle("My Favourite Exercises");
    }

    // EFFECTS: makes panel and sets up the layout
    @Override
    public void mainPanelSetup() {
        this.getContentPane().setLayout(new FlowLayout());
        JPanel buttonPanel = buttonPanelSetup();
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
        add(buttonPanel);
        favouriteExercisesPanel = new JPanel();
        favouriteExercisesPanel.setLayout(new BoxLayout(favouriteExercisesPanel, BoxLayout.Y_AXIS));
    }

//    public JScrollPane makeScrollable(JPanel panel) {
//        scrollPane = new JScrollPane(panel);
//        scrollPane.setViewportView(panel);
//        return scrollPane;
//    }

    // EFFECTS: makes the buttons
    @Override
    public void makeButtons() {
        backButton = new JButton("Back");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
    }

    // EFFECTS: connects made buttons to action listener
    @Override
    public void buttonsToActionListener() {
        backButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
    }


    // EFFECTS: makes panel for buttons and adds them
    @Override
    public JPanel buttonPanelSetup() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 50));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(saveButton);
        panel.add(backButton);
        panel.add(loadButton);
        pack();
        return panel;
//        return makeFavourites(panel);
    }

    @Override
    public void click() {
        // void
    }

    // REQUIRES: a exercise needs to be added by selecting the add to favourites button on a workout frame
    // EFFECTS: takes the images and labels of the exercise in the favourites list and makes new panels
    public void makeFavourites() {
        for (ExerciseLabelAndImage e : favourites.getExercises()) {
            String name = e.getName();
            ImageIcon imageIcon = new ImageIcon(e.getImageIcon());
            JPanel panel = new JPanel();
            JLabel label = new JLabel();
            label.setText(name);
            label.setIcon(imageIcon);
            label.setFont(font);
            label.setIconTextGap(3);
            label.setVerticalTextPosition(SwingConstants.TOP);
            label.setHorizontalTextPosition(SwingConstants.CENTER);
            panel.add(label);
            panel.setBorder(lineBorder);
            favouriteExercisesPanel.add(panel);
            pack();
        }
    }


//    @Override
//    public JSONObject toFavExercise() {
//        JSONObject fav = new JSONObject();
//        for (ExerciseLabelAndImage e : WorkoutsGui.favourites.getExercises()) {
//            String name = e.getName();
//            ImageIcon imageIcon = new ImageIcon(e.getImageIcon());
//            fav.put("name", name);
//            fav.put("Icon", imageIcon);
//        }
//        return fav;
//    }

    // Effects: saves favourites to file
    private void saveFavourites() {
        try {
            jsonWriter.open();
            jsonWriter.writeExercise(favourites);
            jsonWriter.close();
            System.out.println("Saved " + getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads favourites from file
    private void loadFavourites() {
        try {
            favourites = jsonReader.readGui();
            System.out.println("Loaded " + getName() + " from " + JSON_STORE);
        } catch (IOException io) {
            System.out.println("Unable to get favourites from file: " + JSON_STORE);
        }
    }

    public static void main(String[] args) {
        new SavedWorkoutsGui();
    }

    // EFFECTS: save to store in json file, load ro load previously saved files, and back to go back to main menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            saveFavourites();
        }
        if (e.getActionCommand().equals("Back")) {
            dispose();
            new MenuGui();
        }
        if (e.getActionCommand().equals("Load")) {
            loadFavourites();
            dispose();
            new SavedWorkoutsGui();
        }
    }
}