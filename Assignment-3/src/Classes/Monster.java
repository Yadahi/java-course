package Classes;

import javax.swing.*;

public class Monster extends Character {

    // Constructor that sets monster stats and image
    public Monster(String name, int baseAttack, int defense, int agility, int hitPoints) {
        super(name, baseAttack, defense, agility, hitPoints);
        setCharacterPic(new ImageIcon(this.getClass().getResource("/Images/monster.jpg")));
    }

    // Return formatted string of monster stats for the battle screen
    @Override
    public String toString() {
        return String.format("Monster: %-10s\n---------------------" +
                        "\nHP: %-3d\tDefense: %-3d\tAgility: %-3d\tBase Attack: %-3d" +
                        "\n\n",
                getName(),
                getHitPoints(),
                getDefense(),
                getAgility(),
                getBaseAttack()
        );
    }
}