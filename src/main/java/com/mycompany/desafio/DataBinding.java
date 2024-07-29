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

    public void bindModelToView(String modelProperty, String viewProperty) {
        model.addObserver((prop, value) -> {
            if (prop.equals(modelProperty)) {
                if (viewProperty.equals("textField")) {
                    view.setTextFieldText((String) value);
                }
            }
        });
    }

    public void bindViewToModel(String viewProperty, String modelProperty) {
        view.addPropertyChangeListener(viewProperty, (prop, value) -> {
            if (prop.equals(viewProperty)) {
                model.setData(value);
            }
        });
    }

    public void applyBinding(BindingType bindingType) {
        switch (bindingType) {
//            case OP1_ONE_WAY_MODEL_TO_VIEW:
//                bindModelToView("data", "textField");
//                break;
//            case OP2_ONE_WAY_VIEW_TO_MODEL:
//                bindViewToModel("textField", "data");
//                break;
            case OP3_TWO_WAY:
                bindModelToView("data", "textField");
                bindViewToModel("textField", "data");
                break;
        }
    }
}
