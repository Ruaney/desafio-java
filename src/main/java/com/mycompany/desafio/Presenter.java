package com.mycompany.desafio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.BiConsumer;

public class Presenter<T> {

    private Model<T> model;
    private View<T> view;
    private DataBinding<T> dataBinder;
    private Config config;

    public Presenter(Model<T> model, View<T> view, DataBinding<T> dataBinder) {
        this.model = model;
        this.view = view;
        this.dataBinder = dataBinder;
        attachListeners();

    }

     private void attachListeners() {
         view.addPropertyChangeListener("textField", (property, value) -> {
            if (view.getSelectedBindingType() == BindingType.OP2_ONE_WAY_VIEW_TO_MODEL ||
                view.getSelectedBindingType() == BindingType.OP3_TWO_WAY) {
                model.setData(value);
            }
        });

        model.addObserver((property, value) -> {
            if (property.equals("data") &&
                (view.getSelectedBindingType() == BindingType.OP1_ONE_WAY_MODEL_TO_VIEW ||
                 view.getSelectedBindingType() == BindingType.OP3_TWO_WAY)) {
                view.setProperty("textField", value);
            }
        });

        view.addPropertyChangeListener("applyBinding", (property, value) -> {
            if (value instanceof BindingType) {
                dataBinder.applyBinding((BindingType) value);
            }
        });
    }

    public void applyBinding(BindingType bindingType) {
        dataBinder.applyBinding(bindingType);
    }
}
