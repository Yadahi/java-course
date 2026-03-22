package GUI;

import Classes.Monster;
import Classes.PlayerCharacter;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {
    private JLabel playerNameLabel;
    private JLabel playerImageLabel;
    private JLabel monsterNameLabel;
    private JLabel monsterImageLabel;
    private JTextArea stats;
    private JButton resetBtn;

    public DisplayPanel() {
        //Set font object
        Font myFont = new Font("Calibri", Font.BOLD, 22);

        //Set panel layout, visibility and background color
        setLayout(null);
        setVisible(false);
        setBackground(new Color(131, 151, 215));

        // Battle title label
        JLabel titleLabel = new JLabel("Battle to the Death!");
        titleLabel.setFont(myFont);
        titleLabel.setBounds(50, 10, 350, 30);

        // Player name label displayed above player image
        playerNameLabel = new JLabel();
        playerNameLabel.setFont(myFont);
        playerNameLabel.setBounds(100, 80, 300, 30);

        // Player character image
        playerImageLabel = new JLabel();
        playerImageLabel.setBounds(130, 120, 180, 180);

        // Monster name label displayed above monster image
        monsterNameLabel = new JLabel();
        monsterNameLabel.setFont(myFont);
        monsterNameLabel.setBounds(500, 80, 300, 30);

        // Monster character image
        monsterImageLabel = new JLabel();
        monsterImageLabel.setBounds(530, 120, 180, 180);

        // Text area to display both player and monster stats
        stats = new JTextArea();
        stats.setFont(myFont);
        stats.setBounds(50, 320, 700, 350);
        stats.setEditable(false);

        // Button to reset and return to character creation
        resetBtn = new JButton("Play Again");
        resetBtn.setFont(myFont);
        resetBtn.setBounds(300, 680, 200, 40);

        // Add all components to the panel
        add(titleLabel);
        add(playerNameLabel);
        add(playerImageLabel);
        add(monsterNameLabel);
        add(monsterImageLabel);
        add(stats);
        add(resetBtn);
    }

    // Set player and monster names, images, and stats on the display screen
    public void displayBattle(PlayerCharacter player, Monster monster) {
        playerNameLabel.setText("Player: " + player.getName());
        playerImageLabel.setIcon(player.getCharacterPic());
        monsterNameLabel.setText("Monster: " + monster.getName());
        monsterImageLabel.setIcon(monster.getCharacterPic());
        stats.setText(String.format("%s\n%s", player.toString(), monster.toString()));
    }

    // Getter for reset button so MainFrame can add an action listener
    public JButton getResetBtn() {
        return resetBtn;
    }
}
