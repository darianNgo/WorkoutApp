package gui.exercises;
// ALL IMAGES FROM: https://workoutlabs.com/

import javax.swing.*;

public class AbsGui extends WorkoutsGui {
    private ImageIcon sit;
    private ImageIcon raise;
    private ImageIcon twist;
    private ImageIcon climber;
    private ImageIcon dog;

    // EFFECTS: calls super, making th panel, and sets the title to the workout type
    public AbsGui() {
        super();
        setTitle("Abdominal");
        maxClicks = 4;
    }

    // EFFECTS: loads the images for this workout
    @Override
    public void loadImages() {
        sit = new ImageIcon("./data/sit.png");
        raise = new ImageIcon("./data/hanging.png");
        twist = new ImageIcon("./data/twist.png");
        climber = new ImageIcon("./data/climber.png");
        dog = new ImageIcon("./data/dog.png");
    }

    // REQUIRES: for "NEXT" or "BACK" to be clicked
    // EFFECTS: depending on the integer click, changes the label and icon associated to the int
    @Override
    public void click() {
        switch (clicks) {
            case 0:
                changeLabelAndIcon("SIT-UPS: 3 X 15", sit);
                break;
            case 1:
                changeLabelAndIcon("HANGING LEG-RAISE: 3 x 10", raise);
                break;
            case 2:
                changeLabelAndIcon("WEIGHTED TWISTS: 3 x 20", twist);
                break;
            case 3:
                changeLabelAndIcon("MOUNTAIN CLIMBERS: 2 x 50", climber);
                break;
            case 4:
                changeLabelAndIcon("STRETCH: 2 x 30 SECOND HOLD", dog);
                checkMaxClick();
                break;
        }

    }


    public static void main(String[] args) {
        new AbsGui();
    }

}
