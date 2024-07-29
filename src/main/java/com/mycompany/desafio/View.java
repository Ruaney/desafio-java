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
    private Map<String, T> properties = new HashMap<>();
    private JTextField outputField;
    private JLabel inputLabel;
    private JComboBox<BindingType> bindingTypeComboBox;
    private JButton applyButton;
    private T propertyValue;

    public View() {
        frame = new JFrame("Exemplo de Data Binding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        inputLabel = new JLabel("modelo");
        textField = new JTextField(20);
        outputField = new JTextField(20);
        bindingTypeComboBox = new JComboBox<>(BindingType.values());
        applyButton = new JButton("Aplicar Binding");
        JPanel panel = new JPanel();
        panel.add(inputLabel);
        panel.add(textField);
        panel.add(new JLabel("atualizar modelo (só sera atualizado se a config for OP2 ou OP3)"));
        panel.add(outputField);
        panel.add(new JLabel("Tipo de Binding: "));
        panel.add(bindingTypeComboBox);
        panel.add(applyButton);

        frame.add(panel);
        frame.setVisible(true);
     
    }

    public void setProperty(String propertyName, T value) {
        properties.put(propertyName, value);
        if (propertyName.equals("textField")) {
            textField.setText((String) value);
        }
        if (propertyName.equals("label")) {
            label.setText((String) value);
        }
    }

    public T getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public void addPropertyChangeListener(String propertyName, Observer<T> observer) {
        addObserver(observer);
    }

    public BindingType getSelectedBindingType() {
        // Mock implementation for demonstration purposes
        return (BindingType) bindingTypeComboBox.getSelectedItem();
    }

}
