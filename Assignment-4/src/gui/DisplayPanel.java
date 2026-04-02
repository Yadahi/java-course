package gui;

import classes.Animal;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {
    // Set font object
    private static final Font MY_FONT = new Font("Courier", Font.BOLD, 20);
    private JButton backBtn;
    private JLabel animalNameLabel;
    private JLabel animalFoodLabel;
    private JLabel animalImageLabel;
    private JTextArea animalDescriptionInput;
    private JTextField animalNameInput;
    private JTextField animalFoodInput;

    public DisplayPanel() {
        //Set panel layout, visibility, and background color
        setLayout(null);
        setVisible(false);
        setBackground(new Color(131, 151, 215));

        // Button to reset and return to character creation
        backBtn = new JButton("Go Back");
        backBtn.setFont(MY_FONT);
        backBtn.setBounds(300, 680, 200, 40);

        // Animal name label
        animalNameLabel = new JLabel("Species");
        animalNameLabel.setFont(MY_FONT);
        animalNameLabel.setBounds(50, 50, 200, 30);

        // Animal name input field
        animalNameInput = new JTextField();
        animalNameInput.setFont(MY_FONT);
        animalNameInput.setBounds(260, 50, 200, 30);
        animalNameInput.setEditable(false);

        // Animal food label
        animalFoodLabel = new JLabel("Amount Of Food");
        animalFoodLabel.setFont(MY_FONT);
        animalFoodLabel.setBounds(50, 100, 200, 30);

        // Animal food input field
        animalFoodInput = new JTextField();
        animalFoodInput.setFont(MY_FONT);
        animalFoodInput.setBounds(260, 100, 200, 30);
        animalFoodInput.setEditable(false);

        // Animal image label
        animalImageLabel = new JLabel();
        animalImageLabel.setFont(MY_FONT);
        animalImageLabel.setBounds(50, 160, 200, 200);

        // Animal description input field
        animalDescriptionInput = new JTextArea();
        animalDescriptionInput.setFont(MY_FONT);
        animalDescriptionInput.setBounds(50, 400, 400, 120);
        // Text automatically wraps to the next line
        animalDescriptionInput.setLineWrap(true);
        // When wrapping occurs it breaks at word boundaries
        animalDescriptionInput.setWrapStyleWord(true);
        // User can't type into or modify the text in the text area
        animalDescriptionInput.setEditable(false);

        // Adding fields to panel
        add(animalNameLabel);
        add(animalNameInput);
        add(animalFoodLabel);
        add(animalFoodInput);
        add(animalImageLabel);
        add(animalDescriptionInput);
        add(backBtn);
    }

    // Set animal data to fields
    public void displayAnimal(Animal animal) {
        animalNameInput.setText(animal.getSpecies());
        animalFoodInput.setText(String.format("%.2flb", animal.calculateFood()));
        animalImageLabel.setIcon(animal.getAnimalImage());
        animalDescriptionInput.setText(animal.toString());
    }

    // Reset form
    public void resetFields() {
        animalNameInput.setText("");
        animalFoodInput.setText("");
        animalImageLabel.setText(null);
        animalDescriptionInput.setText("");
    }

    // Getter to expose the reset button
    public JButton getBackBtn() {
        return backBtn;
    }
}
