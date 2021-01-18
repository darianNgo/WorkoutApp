package gui.calorie;
// Reference: docs.oracle.com

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class CalorieCounterGUI extends Action { // implements PropertyChangeListener
    private JPanel panel;
    private JFormattedTextField proteinInput;
    private double protein;
    private double carbs;
    private double fats;
    private List<Observer> observers = new ArrayList<>();

    private JLabel proteinLabel;
    private JLabel carbsLabel;
    private JLabel fatsLabel;
    private JLabel caloriesLabel;
    private JLabel inGrams;

    private static String gramsString = "(In Grams)";
    private static String proteinString = "Protein: ";
    private static String carbsString = "Carbs: ";
    private static String fatsString = "Fats: ";
    private static String caloriesString = "Total Caloric Intake: ";

    private JFormattedTextField proteinField;
    private JFormattedTextField carbsField;
    private JFormattedTextField fatsField;
    private JButton generate;

    private NumberFormat proteinFormat;
    private NumberFormat carbsFormat;
    private NumberFormat fatsFormat;
    private JPanel buttonPanel;

    private CalorieOutput output = new CalorieOutput();

    JFrame frame = new JFrame();


    public CalorieCounterGUI() {
        addObserver(output);
        panel = new JPanel(new BorderLayout());
        setUpFormats();
        frame.setLocationRelativeTo(null);
        makeLabels();

        proteinField = formTextField(proteinFormat, protein);
        carbsField = formTextField(carbsFormat, carbs);
        fatsField = formTextField(fatsFormat, fats);

        setLabels();

        JPanel labelPanel = makePanel();

        JPanel textField = makeTextFieldPanel();

        JPanel buttonPanel = makeButton();

        panelSetUp(labelPanel, textField, buttonPanel);
        frame.setVisible(true);
        frame.pack();
    }

    public void panelSetUp(JPanel labelPanel, JPanel textField, JPanel buttonPanel) {
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.add(labelPanel, BorderLayout.CENTER);
        panel.add(textField, BorderLayout.LINE_END);
        panel.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
        panel.setAlignmentX(frame.CENTER_ALIGNMENT);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
    }

    public JPanel makeButton() {
        generate = new JButton("Generate");
        generate.addActionListener(this);
        buttonPanel = new JPanel(new GridLayout(0, 1));
        buttonPanel.add(generate);
        return buttonPanel;
    }

    public JPanel makeTextFieldPanel() {
        JPanel textField = new JPanel(new GridLayout(0, 1));
        textField.add(proteinField);
        textField.add(carbsField);
        textField.add(fatsField);
        return textField;
    }

    public JPanel makePanel() {
        JPanel labelPanel = new JPanel(new GridLayout(0, 1));
        labelPanel.add(proteinLabel);
        labelPanel.add(carbsLabel);
        labelPanel.add(fatsLabel);
        return labelPanel;
    }

    public void setLabels() {
        proteinLabel.setLabelFor(proteinField);
        carbsLabel.setLabelFor(carbsField);
        fatsLabel.setLabelFor(fatsField);
    }

    public void makeLabels() {
        proteinLabel = new JLabel(proteinString);
        carbsLabel = new JLabel(carbsString);
        fatsLabel = new JLabel(fatsString);
    }

    public JFormattedTextField formTextField(NumberFormat format, double grams) {
        JFormattedTextField field = new JFormattedTextField(format);
        field.setValue(grams);
        field.setColumns(10);
        return field;
    }


    public static void main(String[] args) {
        new CalorieCounterGUI();
    }


    private void setUpFormats() {
        proteinFormat = NumberFormat.getNumberInstance();

        carbsFormat = NumberFormat.getNumberInstance();

        fatsFormat = NumberFormat.getNumberInstance();

//        caloriesFormat = NumberFormat.getNumberInstance();
    }


    public double generateCaloricIntakeFromGrams(double protein, double carbs, double fats) {
        return ((protein * 4) + (carbs * 4) + (fats * 9));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Generate")) {
            protein = Double.parseDouble(proteinField.getText());
            carbs = Double.parseDouble(carbsField.getText());
            fats = Double.parseDouble(fatsField.getText());
            notifyObservers(protein, carbs, fats);
            frame.dispose();
        }
    }
}
