package gui;

import classes.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements AnimalSelectionHandler {
    // Declare panels
    private ChoosePanel choosePanel;
    private DisplayPanel displayPanel;

    public MainFrame() {
        // Close the application when the user clicks the X button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the window position and size
        setBounds(100, 100, 800, 800);
        // Set the title
        setTitle("ABC Zoo App");
        // Stack panels and switch between them
        setLayout(new CardLayout());

        // Create the two screen panels and add them to the frame
        // I provide the MainFrame to ChoosePanel as argument. MainFrame implements AnimalSelectionHandler and in the constructor of ChoosePanel
        // I typed the parameter as AnimalSelectionHandler, therefore the object can call only methods defined in the interface
        choosePanel = new ChoosePanel(this);
        displayPanel = new DisplayPanel();

        // Add panels to frame
        add(choosePanel);
        add(displayPanel);


        // When the back button is clicked, reset both panels and return to the choose screen
        JButton resetBtn = displayPanel.getBackBtn();
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset and show the choose panel
                choosePanel.resetFields();
                choosePanel.setVisible(true);
                // Reset and hide display panel
                displayPanel.resetFields();
                displayPanel.setVisible(false);
            }
        });
    }

    // Switch to the display panel when an animal is selected
    @Override
    public void onAnimalSelected(Animal animal) {
        displayPanel.displayAnimal(animal);
        choosePanel.setVisible(false);
        displayPanel.setVisible(true);
    }
}
