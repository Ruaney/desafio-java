/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ruaney
 */
public class DataBinding<T> {
  private Map<String, Binding<?>> bindings = new HashMap<>();

    public <T> void bindOneWay(Model<T> model, String modelProperty, View<T> view, String viewProperty) {
        Binding<T> binding = new Binding<>(model, modelProperty, view, viewProperty, false);
        bindings.put(modelProperty + "->" + viewProperty, binding);
        model.addObserver(binding);
    }

    public <T> void bindTwoWay(Model<T> model, String modelProperty, View<T> view, String viewProperty) {
        Binding<T> binding = new Binding<>(model, modelProperty, view, viewProperty, true);
        bindings.put(modelProperty + "<->" + viewProperty, binding);
        model.addObserver(binding);
        view.addObserver(binding);
    }

    private class Binding<T> implements Observer<T> {
        private Model<T> model;
        private String modelProperty;
        private View<T> view;
        private String viewProperty;
        private boolean twoWay;

        public Binding(Model<T> model, String modelProperty, View<T> view, String viewProperty, boolean twoWay) {
            this.model = model;
            this.modelProperty = modelProperty;
            this.view = view;
            this.viewProperty = viewProperty;
            this.twoWay = twoWay;
        }

        @Override
        public void update(String propertyName, T newValue) {
            if (propertyName.equals(modelProperty)) {
                view.update(viewProperty, newValue);
            } else if (twoWay && propertyName.equals(viewProperty)) {
                model.update(modelProperty, newValue);
            }
        }
    }
}
