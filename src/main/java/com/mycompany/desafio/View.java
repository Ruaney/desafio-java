/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desafio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ruaney
 * @param <T>
 */
public class View<T> extends Observable<T> {

    private JFrame frame;
    private JLabel label;
    private JTextField textField;
    private JTextField modelEditField; // Campo para editar o Model
    private Map<String, T> properties = new HashMap<>();
    private JLabel inputLabel;
    private JComboBox<BindingType> bindingTypeComboBox;
    private JButton applyBindingButton;
    private JLabel modelValueLabel;

    public View() {
        frame = new JFrame("Exemplo de Data Binding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);

        inputLabel = new JLabel("modelo");
        textField = new JTextField(20);
        modelEditField = new JTextField(20); // Campo para editar o Model
        modelValueLabel = new JLabel("Model Value: "); // Inicialização do JLabel

        bindingTypeComboBox = new JComboBox<>(BindingType.values());
        applyBindingButton = new JButton("Aplicar Binding");
        JPanel panel = new JPanel();
        panel.add(new JLabel("view:"));
        panel.add(textField);
        panel.add(new JLabel("Editar Modelo:")); // Label para o novo campo
        panel.add(modelEditField); // Adiciona o campo de edição do Model
        panel.add(modelValueLabel);
        panel.add(new JLabel("Select Binding Type:"));
        panel.add(bindingTypeComboBox);
        panel.add(applyBindingButton);

        frame.add(panel);
        frame.setVisible(true);
        // Listener para notificar mudanças em textField e outputField
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                notifyObservers("textField", (T) textField.getText());
            }
        });
        modelEditField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                notifyObservers("modelEditField", (T) modelEditField.getText());
            }
        });
    }

    public T getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public void addPropertyChangeListener(String propertyName, Observer<T> observer) {
        addObserver(observer);
    }

    public void setTextFieldText(String text) {
        textField.setText(text);
    }

    public void setModelValueLabel(String text) {
        modelValueLabel.setText("Model Value: " + text);
    }

    public String getTextFieldText() {
        return textField.getText();
    }

    public void setModelEditFieldText(String text) {
        modelEditField.setText(text);
    }

    public String getModelEditFieldText() {
        return modelEditField.getText();
    }

    public BindingType getSelectedBindingType() {
        return (BindingType) bindingTypeComboBox.getSelectedItem();
    }

}
