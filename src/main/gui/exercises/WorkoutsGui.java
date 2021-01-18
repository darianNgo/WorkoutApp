package gui.exercises;

import gui.MenuGui;
import model.Favourites;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class WorkoutsGui extends JFrame implements ActionListener {

    public static Favourites favourites = new Favourites("My Favourite Exercises");
    protected JLabel pictureAndLabel;
    protected int clicks;
    protected int maxClicks;
    protected int startClick = -1;
    protected JButton quitButton;
    protected JButton nextButton;
    protected JButton backButton;
    protected JButton favouritesButton;
    protected JPanel pictureAndTitlePanel;
    protected Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 20);
    protected Border lineBorder = BorderFactory.createLineBorder(Color.DARK_GRAY, 3);

    // EFFECTS: makes the general panel for the exercises, and sets up the main functions for this frame
    public WorkoutsGui() {
        setPreferredSize(new Dimension(1000, 500));
        clicks = 0;
        makeButtons();
        buttonsToActionListener();
        JPanel buttonPanel = buttonPanelSetup();
        add(buttonPanel, BorderLayout.CENTER);
        loadImages();
        mainPanelSetup();
        click();
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // EFFECTS: generates the main panel
    public void mainPanelSetup() {
        this.getContentPane().setLayout(new FlowLayout());
        JPanel pictureAndTitlePanel = makeNewExercisePanel();
        add(pictureAndTitlePanel, CENTER_ALIGNMENT);
    }

    // EFFECTS: generates the exercise shown panel
    public JPanel makeNewExercisePanel() {
        JPanel pictureAndTitlePanel = new JPanel();
        pictureAndLabel = new JLabel();
        pictureAndLabel.setFont(font);
        pictureAndLabel.setIconTextGap(3);
        pictureAndLabel.setVerticalTextPosition(SwingConstants.TOP);
        pictureAndLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        pictureAndTitlePanel.add(pictureAndLabel);
        pictureAndTitlePanel.setBorder(lineBorder);
        return pictureAndTitlePanel;
    }

    // EFFECTS: makes the buttons for the current frame
    public void makeButtons() {
        quitButton = new JButton("QUIT");
        nextButton = new JButton("NEXT");
        backButton = new JButton("BACK");
        favouritesButton = new JButton("ADD TO FAVOURITES");
    }

    // EFFECTS: loads the appropriate images for the workout
    public void loadImages() {
    }


    // EFFECTS: connects the buttons made with action listener
    public void buttonsToActionListener() {
        quitButton.addActionListener(this);
        nextButton.addActionListener(this);
        backButton.addActionListener(this);
        favouritesButton.addActionListener(this);
    }

    // EFFECTS: creates button panel and adds the buttons to the button panel
    public JPanel buttonPanelSetup() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.add(nextButton);
        buttonPanel.add(backButton);
        buttonPanel.add(quitButton);
        buttonPanel.add(favouritesButton);
        return buttonPanel;
    }

    public abstract void click();

    public void checkMaxClick() {
        if (clicks >= maxClicks) {
            clicks = startClick;
        }
    }

    // EFFECTS: changes the label and icon shown on main frame
    public void changeLabelAndIcon(String s, ImageIcon imageIcon) {
        pictureAndLabel.setText(s);
        pictureAndLabel.setIcon(imageIcon);
        pack();
    }


    // REQUIRES: button to be pressed
    // EFFECTS: "NEXT" changes the picture and label according to click by adding 1 to clicks and, "BACK" deducts
    // 1 from click and changes label and icon according to click, "ADD TO FAVOURITES" adds the exercise to favourites
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NEXT")) {
            clicks++;
            click();
        }
        if (e.getActionCommand().equals("BACK")) {
            clicks--;
            click();
        }
        if (e.getActionCommand().equals("QUIT")) {
            dispose();
            new MenuGui();
        }
        if (e.getActionCommand().equals("ADD TO FAVOURITES")) {
            SavedWorkoutsGui.favourites.addExercise(new ExerciseLabelAndImage(pictureAndLabel.getText(),
                    pictureAndLabel.getIcon().toString()));
        }
    }

}
