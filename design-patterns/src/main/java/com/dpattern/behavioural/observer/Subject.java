package com.dpattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * class to attach observers and notify them in case there is a state change
 *
 * @author Srinath.Rayabarapu
 */
public class Subject {

    private int state;
    private List<Observer> observersList = new ArrayList<>();

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        System.out.println("State changed to " + state);
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        this.observersList.add(observer);
    }

    private void notifyAllObservers() {
        if(this.observersList.isEmpty()){
            System.out.println("No Observers to notify!");
        }
        for (Observer observer : this.observersList) {
            observer.update();
        }
    }
}