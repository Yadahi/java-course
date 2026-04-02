package gui;

import classes.Cat;
import classes.Dog;
import classes.Lion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoosePanel extends JPanel {
    // Set font object and made it final since the font never change and applied upper snake case convention
    private static final Font MY_FONT = new Font("Courier", Font.BOLD, 20);
    private AnimalSelectionHandler handler;
    private ButtonGroup typeRadios;

    public ChoosePanel(AnimalSelectionHandler handler) {
        // Handler restricts access to only methods defined in the interface
        this.handler = handler;

        //Set panel layout, visibility, and background color
        setLayout(null);
        setVisible(true);
        setBackground(new Color(131, 151, 215));

        // Title label
        JLabel titleLabel = new JLabel("Done by Viliam. W0520973");
        titleLabel.setFont(MY_FONT);
        titleLabel.setBounds(50, 250, 350, 30);
        add(titleLabel);

        // Animal type radio buttons
        addTypeRadios();
    }

    // Helper method that creates radio button with common properties
    private JRadioButton createRadioButton(String text, Font font, int y) {
        JRadioButton rb = new JRadioButton(text);
        rb.setFont(font);
        rb.setBounds(50, y, 250, 30);
        rb.setBackground(Color.WHITE);
        rb.setOpaque(true);
        return rb;
    }

    // Create radio buttons, group them, and register selection listeners
    private void addTypeRadios() {
        // Create radio button and add event listener
        JRadioButton dogBtn = createRadioButton("Dog", MY_FONT, 100);
        dogBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Each button creates its animal and notifies the handler
                Dog dog = new Dog("Dog", 200, "home", false, "Husky");
                handler.onAnimalSelected(dog);
            }
        });
        JRadioButton catBtn = createRadioButton("Cat", MY_FONT, 150);
        catBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cat cat = new Cat("Cat", 70, "home", false, 10);
                handler.onAnimalSelected(cat);
            }
        });
        JRadioButton lionBtn = createRadioButton("Lion", MY_FONT, 200);
        lionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Lion lion = new Lion("Lion", 800, "home", false, 100);
                handler.onAnimalSelected(lion);
            }
        });

        // Group radio buttons so only one can be selected at a time
        typeRadios = new ButtonGroup();
        typeRadios.add(dogBtn);
        typeRadios.add(catBtn);
        typeRadios.add(lionBtn);

        // Add buttons to panel
        add(dogBtn);
        add(catBtn);
        add(lionBtn);
    }

    // Clear radio buttons
    public void resetFields() {
        typeRadios.clearSelection();
    }
}
