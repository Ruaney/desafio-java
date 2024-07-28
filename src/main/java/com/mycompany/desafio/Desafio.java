/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.desafio;

/**
 *
 * @author ruaney
 */
public class Desafio {

    public static void main(String[] args) {
        // Criar instâncias das classes
        Model<String> model = new Model<>();
        View<String> view = new View<>();
        DataBinding binding = new DataBinding();
        DataBinding dataBinder = new DataBinding();
        Presenter presenter = new Presenter(model, view, dataBinder);
        
        // Atualizar o modelo e ver a atualização na view
        model.setData("Novo valor no modelo");
        System.out.println("View após atualização do modelo: " + view.getProperty("textField"));

        // Atualizar a view e ver a atualização no modelo
        view.setProperty("textField", "Novo valor na view");
        System.out.println("Modelo após atualização da view: " + model.getData());
  
   
    }
}
