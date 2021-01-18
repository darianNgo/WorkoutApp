package gui.exercises;
// ALL IMAGES FROM: https://workoutlabs.com/

import javax.swing.*;

public class ChestGui extends WorkoutsGui {
    private ImageIcon skipRopeImage;
    private ImageIcon pushUpImage;
    private ImageIcon inclinePushUpImage;
    private ImageIcon widePushUpImage;
    private ImageIcon trianglePushUpImage;
    private ImageIcon spiderPushUpImage;

    // EFFECTS: calls super, making th panel, and sets the title to the workout type
    public ChestGui() {
        super();
        setTitle("Chest");
        this.maxClicks = 5;
    }

    // EFFECTS: loads the images for this workout
    @Override
    public void loadImages() {
        skipRopeImage = new ImageIcon("./data/skipRopeImage.png");
        pushUpImage = new ImageIcon("./data/pushUpImage.png");
        inclinePushUpImage = new ImageIcon("./data/InclinePushUpImage.png");
        widePushUpImage = new ImageIcon("./data/widePushUpImage.png");
        trianglePushUpImage = new ImageIcon("./data/trianglePushUpImage.png");
        spiderPushUpImage = new ImageIcon("./data/spiderManPushUpImage.png");

    }

    // REQUIRES: for "NEXT" or "BACK" to be clicked
    // EFFECTS: depending on the integer click, changes the label and icon associated to the int
    @Override
    public void click() {
        switch (clicks) {
            case 0:
                changeLabelAndIcon("SKIP ROPE", skipRopeImage);
                break;
            case 1:
                changeLabelAndIcon("PUSH-UPS: 2 x 10", pushUpImage);
                break;
            case 2:
                changeLabelAndIcon("INCLINE PUSH-UPS: 2 x 10", inclinePushUpImage);
                break;
            case 3:
                changeLabelAndIcon("WIDE PUSH-UPS: 2 x 10", widePushUpImage);
                break;
            case 4:
                changeLabelAndIcon("TRIANGLE PUSH-UPS: 2 x 10", trianglePushUpImage);
                break;
            case 5:
                changeLabelAndIcon("SPIDER-MAN PUSH-UPS: 2 x 10", spiderPushUpImage);
                checkMaxClick();
                break;
        }

    }


    public static void main(String[] args) {
        new ChestGui();
    }

}
