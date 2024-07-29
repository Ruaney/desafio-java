/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author ruaney
 */
public class DataBinding<T> {

    private Model<T> model;
    private View<T> view;

    public DataBinding(Model<T> model, View<T> view) {
        this.model = model;
        this.view = view;
    }

    public void bindModelToView(String propertyName) {
        model.addObserver((prop, value) -> {
            if (prop.equals("data")) {
                view.setProperty(propertyName, value);
            }
        });
    }

    public void bindViewToModel(String propertyName) {
        view.addPropertyChangeListener(propertyName, (prop, value) -> {
            if (prop.equals(propertyName)) {
                model.setData(value);
            }
        });
    }

    public void applyBinding(BindingType bindingType) {
        switch (bindingType) {
            case OP1_ONE_WAY_MODEL_TO_VIEW:
                bindModelToView("textField");
                break;
            case OP2_ONE_WAY_VIEW_TO_MODEL:
                bindViewToModel("textField");
                break;
            case OP3_TWO_WAY:
                bindModelToView("textField");
                bindViewToModel("textField");
                break;
        }
    }
}
