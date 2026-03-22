package Classes;

import javax.swing.*;

public class Cleric extends PlayerCharacter {

    // Constructor that sets cleric stats, weapon, and image
    public Cleric(String name, int baseAttack, int defense, int agility, int hitPoints, Weapon weapon) {
        super(name, baseAttack, defense, agility, hitPoints, weapon);
        setCharacterPic(new ImageIcon(this.getClass().getResource("/Images/dwarf.png")));
    }

    // Return formatted string of cleric stats for the battle screen
    @Override
    public String toString() {
        return String.format("Player: %-10s\n---------------------" +
                        "\nClass: %-10s" +
                        "\nHP: %-3d\tDefense: %-3d\tAgility: %-3d\tBase Attack: %-3d" +
                        "\nWeapon: %-13s\tWeight: %-3d\tAttack Mod: %-3d" +
                        "\n\n",
                getName(),
                "Cleric",
                getHitPoints(),
                getDefense(),
                getAgility(),
                getBaseAttack(),
                getWeapon().getWeaponType(),
                getWeapon().getWeight(),
                getWeapon().getAttack()
        );
    }

    @Override
    public String getCharacterInformString() {
        return getClassDescription();
    }

    // Return class description for the character creation screen
    public static String getClassDescription() {
        return "Clerics are usually dwarf. Have higher defense but low agility ";
    }
}
