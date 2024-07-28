/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio;

import java.io.IOException;

/**
 *
 * @author ruaney
 */
public class Presenter {

    private Model<String> model;
    private View<String> view;
    private DataBinding dataBinder;

    public Presenter(Model<String> model, View<String> view, DataBinding dataBinder) {
        this.model = model;
        this.view = view;
        this.dataBinder = dataBinder;

        bind();
    }

    private void bind() {
        dataBinder.bindTwoWay(model, "data", view, "textField");
        dataBinder.bindOneWay(model, "data", view, "outputLabel");
    }

    public void updateModel(String newData) throws IOException {
        model.setData(newData);
    }

    public void updateView(String newData) {
        view.setProperty("textField", newData);
    }
}
