/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.desafio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ruaney
 */
public class Desafio {

    public static void main(String[] args) {
        // Criação do Modelo
        Model<String> model = new Model<>();

        // Criação da View
        View<String> view = new View<>();

        // Criação do DataBinder
        DataBinding<String> dataBinder = new DataBinding<>(model, view);

        // Criação do Presenter
        Presenter<String> presenter = new Presenter<>(model, view, dataBinder);

        // Configura o modelo e a visão inicial
        model.setData("Valor inicial no modelo");
        view.setTextFieldText(model.getData());
        view.setModelEditFieldText(model.getData());
    }

}
