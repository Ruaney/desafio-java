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
        view.addPropertyChangeListener("modelEditField", (property, value) -> {
            if (view.getSelectedBindingType() == BindingType.OP3_TWO_WAY) {
                model.setData(value);
            }
        });

        // Atualiza a view quando o modelo é alterado
        model.addObserver((property, value) -> {
            if (property.equals("data")) {
                if (view.getSelectedBindingType() == BindingType.OP3_TWO_WAY) {
                    view.setModelEditFieldText((String) value);
                    view.setModelValueLabel((String) value);
                }
            }
        });

        // Aplica o tipo de binding selecionado
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
