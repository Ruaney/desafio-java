package com.mycompany.desafio;
import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String propertyName, T newValue) {
        for (Observer<T> observer : observers) {
            observer.update(propertyName, newValue);
        }
    }
}
