package gui.exercises;
// ALL IMAGES FROM: https://workoutlabs.com/

import javax.swing.*;

public class BackGui extends WorkoutsGui {
    private ImageIcon pullUp;
    private ImageIcon chin;
    private ImageIcon band;
    private ImageIcon rows;
    private ImageIcon roll;


    // EFFECTS: calls super, making th panel, and sets the title to the workout type
    public BackGui() {
        super();
        setTitle("Back");
        this.maxClicks = 4;
    }
    // EFFECTS: loads the images for this workout

    @Override
    public void loadImages() {
        pullUp = new ImageIcon("./data/pullUp.png");
        chin = new ImageIcon("./data/chin.png");
        band = new ImageIcon("./data/band.png");
        rows = new ImageIcon("./data/rows.png");
        roll = new ImageIcon("./data/roll.png");

    }

    // REQUIRES: for "NEXT" or "BACK" to be clicked
    // EFFECTS: depending on the integer click, changes the label and icon associated to the int
    @Override
    public void click() {
        switch (clicks) {
            case 0:
                changeLabelAndIcon("PULL-UPS: 3 x 10", pullUp);
                break;
            case 1:
                changeLabelAndIcon("CHIN-UPS: 2 x 10", chin);
                break;
            case 2:
                changeLabelAndIcon("BAND ROWS: 3 x 5", band);
                break;
            case 3:
                changeLabelAndIcon("DUMBBELL ROWS: 2 x 10", rows);
                break;
            case 4:
                changeLabelAndIcon("FOAM ROLL: 5 MINUTES", roll);
                checkMaxClick();
                break;
        }

    }


    public static void main(String[] args) {
        new BackGui();
    }

}
