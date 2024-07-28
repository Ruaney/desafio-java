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
import javax.swing.JButton;
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

    public View() {

        frame = new JFrame("Exemplo de Data Binding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);

        label = new JLabel("Nome do usuário:");
        textField = new JTextField(20);
        outputField = new JTextField(20);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(new JLabel("Valor atualizado: "));
        panel.add(outputField);

        frame.add(panel);
        frame.setVisible(true);
        // Atualizar a saída (outputLabel) sempre que o texto for alterado no textField
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newValue = textField.getText();
                setProperty("textField", (T) newValue);
                setProperty("outputLabel", (T) newValue);  // Atualiza o outputLabel
            }
        });
          outputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newValue = outputField.getText();
                setProperty("textField", (T) newValue);
                setProperty("outputLabel", (T) newValue);  // Atualiza o outputLabel
            }
        });
      
    }

    public void update(Object data) {
        textField.setText((String) data);
    }

    public T getProperty(String propertyName) {
        return properties.get(propertyName);
    }

    public void setProperty(String propertyName, T value) {
        properties.put(propertyName, value);
        if (propertyName.equals("textField")) {
            textField.setText((String) value);
        } else if (propertyName.equals("outputLabel")) {
            outputField.setText((String) value);
        }
        notifyObservers(propertyName, value);
    }

    public void render() {
        frame.setVisible(true);
    }

    public void update(String propertyName, T newValue) {
        setProperty(propertyName, newValue);
    }

}
