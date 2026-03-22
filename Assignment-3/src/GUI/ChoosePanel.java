package GUI;

import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ChoosePanel extends JPanel {
    // Character type radio buttons
    private JRadioButton rdoWarrior;
    private JRadioButton rdoWizard;
    private JRadioButton rdoCleric;

    // Weapon type radio buttons
    private JRadioButton rdoDagger;
    private JRadioButton rdoSword;
    private JRadioButton rdoHammer;

    // Name input field
    private JTextField nameText;

    // Description areas for character type and weapon
    private JTextArea typeDescription;
    private JTextArea weaponDescription;

    // Character stat fields
    private JTextField hpText;
    private JTextField defText;
    private JTextField agiText;
    private JTextField atkText;

    // Weapon stat fields
    private JTextField atkModText;
    private JTextField weightText;

    // Buttons
    private JButton startBattleBtn;
    private JButton rerollBtn;

    // Random number generator for rerolling stats
    private Random random = new Random();

    // Button groups for radio button selections
    private ButtonGroup typeRadios;
    private ButtonGroup weaponRadios;

    public ChoosePanel() {
        //Set font object
        Font myFont = new Font("Calibri", Font.BOLD, 22);

        //Set panel layout, visibility and background color
        setLayout(null);
        setVisible(false);
        setBackground(new Color(131, 151, 215));

        // Title label
        JLabel titleLabel = new JLabel("Character Generator");
        titleLabel.setFont(myFont);
        titleLabel.setBounds(50, 10, 350, 30);

        // Name label
        JLabel nameLabel = new JLabel("Enter Name");
        nameLabel.setFont(myFont);
        nameLabel.setBounds(50, 45, 180, 30);

        // Name input field
        nameText = new JTextField();
        nameText.setFont(myFont);
        nameText.setBounds(230, 45, 300, 30);

        // Set up character type radio buttons and listeners
        addTypeRadios(myFont);
        // Character type description area
        typeDescription = createDescriptionField(myFont, 230, 80);
        // Character stat labels and text fields
        addCharacterStats(myFont);

        // Set up weapon radio buttons and listeners
        addWeaponRadios(myFont);
        // Weapon description area
        weaponDescription = createDescriptionField(myFont, 520, 180);
        // Weapon stat labels and text fields
        addWeaponStats(myFont);

        // Button to proceed to battle screen
        startBattleBtn = new JButton("Start Battle");
        startBattleBtn.setFont(myFont);
        startBattleBtn.setBounds(550, 610, 200, 40);

        // Add components to the panel
        add(startBattleBtn);
        add(titleLabel);
        add(nameLabel);
        add(nameText);
        add(typeDescription);
        add(weaponDescription);
    }

    // === HELPER METHODS ===

    // Helper method that set values to character type statistic text fields
    private void setStats(String hp, String def, String agi, String atk) {
        hpText.setText(hp);
        defText.setText(def);
        agiText.setText(agi);
        atkText.setText(atk);
    }

    // Helper method that set values to weapon statistic text fields
    private void setWeaponStats(String atkMod, String weight) {
        atkModText.setText(atkMod);
        weightText.setText(weight);
    }

    // Helper method that creates radio button with common properties
    private JRadioButton createRadioButton(String text, Font font, int y) {
        JRadioButton rb = new JRadioButton(text);
        rb.setFont(font);
        rb.setBounds(50, y, 250, 30);
        return rb;
    }

    // Helper method that create a non-editable text field for displaying stats
    private JTextField createStatTextField(Font font, int x, int y) {
        JTextField tf = new JTextField();
        tf.setFont(font);
        tf.setBounds(x, y, 60, 30);
        tf.setEditable(false);
        return tf;
    }

    // Helper method that create stats label field
    private JLabel createStatLabelField(String text, Font font, int x, int y) {
        JLabel lf = new JLabel(text);
        lf.setFont(font);
        lf.setBounds(x, y, 180, 30);
        return lf;
    }

    // Helper method that create a non-editable text area for descriptions
    private JTextArea createDescriptionField(Font font, int y, int h) {
        JTextArea ta = new JTextArea();
        ta.setFont(font);
        ta.setBounds(50, y, 450, h);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.setEditable(false);
        return ta;
    }

    // Helper method that creates random number between 0 and 99 for stats
    private int generateRandomStat() {
        return random.nextInt(100);
    }

    // === PANEL SETUP METHODS ===

    // Create character type radio buttons with listeners that set description and default stats
    public void addTypeRadios(Font myFont) {
        // Character type section label
        JLabel typeLabel = new JLabel("Character Type");
        typeLabel.setFont(myFont);
        typeLabel.setBounds(50, 80, 250, 30);

        // Create radio button and set listener to update description and stats
        rdoWarrior = createRadioButton("Warrior", myFont, 115);
        rdoWarrior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeDescription.setText(Warrior.getClassDescription());
                setStats("100", "60", "40", "20");
            }
        });

        rdoWizard = createRadioButton("Wizard", myFont, 150);
        rdoWizard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeDescription.setText(Wizard.getClassDescription());
                setStats("80", "30", "70", "25");
            }
        });

        rdoCleric = createRadioButton("Cleric", myFont, 185);
        rdoCleric.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeDescription.setText(Cleric.getClassDescription());
                setStats("90", "70", "20", "15");
            }
        });

        // Group radio buttons so only one can be selected at a time
        typeRadios = new ButtonGroup();
        typeRadios.add(rdoWizard);
        typeRadios.add(rdoWarrior);
        typeRadios.add(rdoCleric);

        // Add components to the panel
        add(typeLabel);
        add(rdoWizard);
        add(rdoWarrior);
        add(rdoCleric);
    }

    // Create weapon radio buttons with listeners that set description and weapon stats
    private void addWeaponRadios(Font myFont) {
        // Weapon section label
        JLabel weaponLabel = new JLabel("Select Your Weapon");
        weaponLabel.setFont(myFont);
        weaponLabel.setBounds(50, 330, 300, 30);

        // Create radio button and set listener to update description and stats
        rdoDagger = createRadioButton("Dagger", myFont, 365);
        rdoDagger.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponDescription.setText(Dagger.getWeaponDescription());
                setWeaponStats("3", "5");
            }
        });

        rdoSword = createRadioButton("Sword", myFont, 400);
        rdoSword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponDescription.setText(Sword.getWeaponDescription());
                setWeaponStats("5", "10");
            }
        });

        rdoHammer = createRadioButton("Hammer", myFont, 435);
        rdoHammer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weaponDescription.setText(Hammer.getWeaponDescription());
                setWeaponStats("8", "15");
            }
        });

        // Group weapon radio buttons so only one can be selected at a time
        weaponRadios = new ButtonGroup();
        weaponRadios.add(rdoDagger);
        weaponRadios.add(rdoSword);
        weaponRadios.add(rdoHammer);

        // Add components to the panel
        add(weaponLabel);
        add(rdoDagger);
        add(rdoSword);
        add(rdoHammer);
    }

    // Create character stat labels, text fields, and reroll button
    private void addCharacterStats(Font myFont) {
        // Stats section label
        JLabel statsLabel = new JLabel("Character Stats");
        statsLabel.setFont(myFont);
        statsLabel.setBounds(600, 80, 250, 30);

        // Create stat labels and their corresponding text fields
        JLabel hpLabel = createStatLabelField("Hit Points", myFont, 550, 115);
        hpText = createStatTextField(myFont, 700, 115);

        JLabel defLabel = createStatLabelField("Defense", myFont, 550, 150);
        defText = createStatTextField(myFont, 700, 150);

        JLabel agiLabel = createStatLabelField("Agility", myFont, 550, 185);
        agiText = createStatTextField(myFont, 700, 185);

        JLabel atkLabel = createStatLabelField("Base Attack", myFont, 550, 220);
        atkText = createStatTextField(myFont, 700, 220);

        // Add stat components to the panel
        add(statsLabel);
        add(hpLabel);
        add(hpText);
        add(defLabel);
        add(defText);
        add(agiLabel);
        add(agiText);
        add(atkLabel);
        add(atkText);

        // Reroll button to randomize character stats
        rerollBtn = new JButton("Reroll");
        rerollBtn.setFont(myFont);
        rerollBtn.setBounds(550, 260, 140, 30);
        add(rerollBtn);

        // Add listener to generate random values for all stat fields
        rerollBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // generate random stats and set them in the text fields
                hpText.setText(String.valueOf(generateRandomStat()));
                defText.setText(String.valueOf(generateRandomStat()));
                agiText.setText(String.valueOf(generateRandomStat()));
                atkText.setText(String.valueOf(generateRandomStat()));
            }
        });
    }

    // Create weapon stat labels and text fields
    private void addWeaponStats(Font myFont) {
        // Weapon stats section label
        JLabel weaponStatsLabel = new JLabel("Weapon Stats");
        weaponStatsLabel.setFont(myFont);
        weaponStatsLabel.setBounds(600, 330, 250, 30);

        // Create weapon labels with their text fields
        JLabel atkModLabel = createStatLabelField("Attack Mod.", myFont, 550, 365);
        atkModText = createStatTextField(myFont, 700, 365);

        JLabel weightLabel = createStatLabelField("Weight", myFont, 550, 400);
        weightText = createStatTextField(myFont, 700, 400);

        // Add weapon stat components to the panel
        add(weaponStatsLabel);
        add(atkModLabel);
        add(atkModText);
        add(weightLabel);
        add(weightText);
    }

    // Reset all fields and selections to empty state for a new character creation
    public void resetFields() {
        // Clear name field
        nameText.setText("");

        // Clear character stat fields and description
        hpText.setText("");
        defText.setText("");
        agiText.setText("");
        atkText.setText("");
        typeDescription.setText("");

        // Clear weapon stat fields and description
        atkModText.setText("");
        weightText.setText("");
        weaponDescription.setText("");

        // Deselect all radio buttons
        typeRadios.clearSelection();
        weaponRadios.clearSelection();
    }

    // Check if all required fields are filled in before starting battle
    public boolean isFormComplete() {
        return !nameText.getText().isEmpty()
                && getSelectedCharacterType() != null
                && getSelectedWeapon() != null
                && !hpText.getText().isEmpty()
                && !defText.getText().isEmpty()
                && !agiText.getText().isEmpty()
                && !atkText.getText().isEmpty()
                && !atkModText.getText().isEmpty()
                && !weightText.getText().isEmpty();
    }

    // === GETTERS ===
    // Return the player name entered by the user
    public String getPlayerName() {
        return nameText.getText();
    }

    // Return the selected character type as a string, or null if none selected
    public String getSelectedCharacterType() {
        if (rdoWarrior.isSelected()) return "Warrior";
        if (rdoWizard.isSelected()) return "Wizard";
        if (rdoCleric.isSelected()) return "Cleric";
        return null;
    }

    // Return the selected weapon type as a string, or null if none selected
    public String getSelectedWeapon() {
        if (rdoDagger.isSelected()) return "Dagger";
        if (rdoSword.isSelected()) return "Sword";
        if (rdoHammer.isSelected()) return "Hammer";
        return null;
    }

    // Returns character stats as an array
    public int[] getCharacterStats() {
        return new int[]{
                Integer.parseInt(hpText.getText()),
                Integer.parseInt(defText.getText()),
                Integer.parseInt(agiText.getText()),
                Integer.parseInt(atkText.getText())
        };
    }

    // Returns weapon stats as an array
    public int[] getWeaponStats() {
        return new int[]{
                Integer.parseInt(atkModText.getText()),
                Integer.parseInt(weightText.getText())
        };
    }

    // Getter for start battle button so MainFrame can add an action listener
    public JButton getStartBattleBtn() {
        return startBattleBtn;
    }
}