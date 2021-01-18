package gui.exercises;

import javax.swing.*;

public class ArmsGui extends WorkoutsGui {
    private ImageIcon curls;
    private ImageIcon hammer;
    private ImageIcon kickback;
    private ImageIcon overhead;
    private ImageIcon trianglePushUpImage;

    // EFFECTS: calls super, making th panel, and sets the title to the workout type
    public ArmsGui() {
        super();
        setTitle("Arms");
        this.maxClicks = 4;
    }

    // EFFECTS: loads the images for this workout
    @Override
    public void loadImages() {
        curls = new ImageIcon("./data/curls.png");
        hammer = new ImageIcon("./data/hammer.png");
        kickback = new ImageIcon("./data/kickback.png");
        overhead = new ImageIcon("./data/overhead.png");
        trianglePushUpImage = new ImageIcon("./data/trianglePushUpImage.png");

    }

    // REQUIRES: for "NEXT" or "BACK" to be clicked
    // EFFECTS: depending on the integer click, changes the label and icon associated to the int
    @Override
    public void click() {
        switch (clicks) {
            case 0:
                changeLabelAndIcon("BICEP CURLS: 3 X 10", curls);
                break;
            case 1:
                changeLabelAndIcon("HAMMER CURLS: 3 x 10", hammer);
                break;
            case 2:
                changeLabelAndIcon("TRICEP KICK-BACKS: 2 x 10", kickback);
                break;
            case 3:
                changeLabelAndIcon("OVERHEAD PRESS: 5 x 5", overhead);
                break;
            case 4:
                changeLabelAndIcon("TRIANGLE PUSH-UPS: 3 x 10", trianglePushUpImage);
                checkMaxClick();
                break;
        }

    }


    public static void main(String[] args) {
        new ArmsGui();
    }

}
