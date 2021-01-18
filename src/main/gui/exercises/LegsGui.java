package gui.exercises;
// ALL IMAGES FROM: https://workoutlabs.com/

import javax.swing.*;

public class LegsGui extends WorkoutsGui {
    private ImageIcon squat;
    private ImageIcon pistol;
    private ImageIcon jump;
    private ImageIcon dead;

    // EFFECTS: calls super, making th panel, and sets the title to the workout type
    public LegsGui() {
        super();
        setTitle("Legs");
        this.maxClicks = 3;
    }

    @Override
    public void loadImages() {
        squat = new ImageIcon("./data/squat.png");
        pistol = new ImageIcon("./data/pistol.png");
        jump = new ImageIcon("./data/jump.png");
        dead = new ImageIcon("./data/dead.png");
    }

    // REQUIRES: for "NEXT" or "BACK" to be clicked
    // EFFECTS: depending on the integer click, changes the label and icon associated to the int
    @Override
    public void click() {
        switch (clicks) {
            case 0:
                changeLabelAndIcon("SQUATS: 3 x 10", squat);
                break;
            case 1:
                changeLabelAndIcon("SINGLE LEG PISTOL SQUATS: 2 x 5 EACH SIDE", pistol);
                break;
            case 2:
                changeLabelAndIcon("JUMP SQUATS: 2 x 10", jump);
                break;
            case 3:
                changeLabelAndIcon("DEADLIFTS: 5 x 8", dead);
                checkMaxClick();
                break;
        }
    }


    public static void main(String[] args) {
        new LegsGui();
    }

}
