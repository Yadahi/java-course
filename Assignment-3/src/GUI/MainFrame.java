package GUI;

import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame {
    // Player character created from user selection
    private PlayerCharacter player;
    // Monster object randomly generated
    private Monster monster;
    private Random random = new Random();
    // Array of monster names
    private String[] monsterNames = {"Goblin", "Wraith", "Ogre", "Basilisk", "Harpy"};

    public MainFrame() {
        // Closes the application when the user clicks the X button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the windows position and size
        setBounds(100, 100, 800, 800);
        // Set the title
        setTitle("DND Game");
        // Stack panels and switch between them
        setLayout(new CardLayout());

        // Create the three screen panels and add them to the frame
        IntroPanel introPanel = new IntroPanel();
        ChoosePanel choosePanel = new ChoosePanel();
        DisplayPanel displayPanel = new DisplayPanel();

        add(introPanel);
        add(choosePanel);
        add(displayPanel);

        // Get intro panel button and add listener to switch from intro to choose panel
        JButton displayBtn = introPanel.getDisplayBtn();
        displayBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introPanel.setVisible(false);
                choosePanel.setVisible(true);
            }
        });

        // Get choose panel button and add listener to switch from choose to display panel
        JButton startBattleBtn = choosePanel.getStartBattleBtn();
        startBattleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validate that all fields are filled before proceeding, otherwise show an alert
                if (!choosePanel.isFormComplete()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields before starting battle.");
                    return;
                }

                // Get player name, stats, weapon stats, and selected types from the choose panel
                String playerName = choosePanel.getPlayerName();
                int[] playerStats = choosePanel.getCharacterStats();
                int[] weaponStats = choosePanel.getWeaponStats();
                String characterType = choosePanel.getSelectedCharacterType();
                String weaponType = choosePanel.getSelectedWeapon();

                // Create the weapon
                Weapon weapon;
                if (weaponType.equals("Sword")) weapon = new Sword(weaponStats[0], weaponStats[1]);
                else if (weaponType.equals("Hammer")) weapon = new Hammer(weaponStats[0], weaponStats[1]);
                else weapon = new Dagger(weaponStats[0], weaponStats[1]);

                // Create the character
                if (characterType.equals("Warrior"))
                    player = new Warrior(playerName, playerStats[0], playerStats[1], playerStats[2], playerStats[3], weapon);
                else if (characterType.equals("Wizard"))
                    player = new Wizard(playerName, playerStats[0], playerStats[1], playerStats[2], playerStats[3], weapon);
                else
                    player = new Cleric(playerName, playerStats[0], playerStats[1], playerStats[2], playerStats[3], weapon);

                // Generate random stats and name for the monster, then create the monster object
                int monsterAttack = generateRandomStat();
                int monsterDefense = generateRandomStat();
                int monsterAgility = generateRandomStat();
                int monsterPoints = generateRandomStat();

                // Get random monster name
                String monsterName = generateRandomMonsterName();
                // Create the monster
                monster = new Monster(monsterName, monsterAttack, monsterDefense, monsterAgility, monsterPoints);

                // Send player and monster data to the display panel
                displayPanel.displayBattle(player, monster);
                choosePanel.setVisible(false);
                // Reset choose panel fields
                choosePanel.resetFields();
                displayPanel.setVisible(true);
            }
        });

        // Get reset button and add listener to return to the choose panel
        JButton resetBtn = displayPanel.getResetBtn();
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear player and monster objects
                player = null;
                monster = null;
                // Switch back to the choose panel
                choosePanel.setVisible(true);
                displayPanel.setVisible(false);
            }
        });
    }

    // Generate a random number between 1 and 100 for monster stats
    private int generateRandomStat() {
        return random.nextInt(100) + 1;
    }

    // Pick a random name from the monster names array
    private String generateRandomMonsterName() {
        int nameIndex = random.nextInt(monsterNames.length);
        return monsterNames[nameIndex];
    }
}
