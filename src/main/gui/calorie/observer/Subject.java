package gui.calorie.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<CalorieObserver> observers = new ArrayList<>();

    public void addObserver(CalorieObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Object p, Object c, Object f) {
        for (CalorieObserver o : observers) {
            o.update(p, c, f);
        }
    }
}
