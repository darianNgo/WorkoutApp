package gui.exercises;
// ALL IMAGES FROM: https://workoutlabs.com/

import javax.swing.*;

public class ShouldersGui extends WorkoutsGui {
    private ImageIcon fly;
    private ImageIcon press;
    private ImageIcon reverse;
    private ImageIcon military;

    // EFFECTS: calls super, making th panel, and sets the title to the workout type
    public ShouldersGui() {
        super();
        setTitle("Shoulders");
        this.maxClicks = 3;
    }

    // EFFECTS: loads the images for this workout
    @Override
    public void loadImages() {
        press = new ImageIcon("./data/shoulderPress.png");
        fly = new ImageIcon("./data/fly.png");
        reverse = new ImageIcon("./data/reverseFly.png");
        military = new ImageIcon("./data/military.png");
    }

    // REQUIRES: for "NEXT" or "BACK" to be clicked
    // EFFECTS: depending on the integer click, changes the label and icon associated to the int
    @Override
    public void click() {
        switch (clicks) {
            case 0:
                changeLabelAndIcon("SHOULDER-PRESS: 3 X 6", press);
                break;
            case 1:
                changeLabelAndIcon("LATERAL RAISES: 3 X 12", fly);
                break;
            case 2:
                changeLabelAndIcon("BENT-OVER LATERAL RAISES: 2 X 12", reverse);
            case 3:
                changeLabelAndIcon("MILITARY PRESS: 3 X 6", military);
                checkMaxClick();
                break;

        }

    }


    public static void main(String[] args) {
        new ShouldersGui();
    }

}

