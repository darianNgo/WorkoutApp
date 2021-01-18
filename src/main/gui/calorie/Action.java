package gui.calorie;

import gui.calorie.observer.Subject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Action extends Subject implements ActionListener {
    @Override
    public abstract void actionPerformed(ActionEvent e);
}
