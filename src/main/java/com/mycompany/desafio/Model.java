/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio;


/**
 *
 * @author ruaney
 * @param <T>
 */
public class Model<T> extends Observable<T> {
   private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        notifyObservers("data", data);
    }

    public void update(String propertyName, T newValue) {
        if (propertyName.equals("data")) {
            setData(newValue);
        }
    }

}
