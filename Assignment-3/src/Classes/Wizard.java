package Classes;

import javax.swing.*;

public class Wizard extends PlayerCharacter {

    // Constructor that sets wizard stats, weapon, and image
    public Wizard(String name, int baseAttack, int defense, int agility, int hitPoints, Weapon weapon) {
        super(name, baseAttack, defense, agility, hitPoints, weapon);
        setCharacterPic(new ImageIcon(this.getClass().getResource("/Images/wizard.png")));
    }

    // Return formatted string of wizard stats for the battle screen
    @Override
    public String toString() {
        return String.format("Player: %-10s\n---------------------" +
                        "\nClass: %-10s" +
                        "\nHP: %-3d\tDefense: %-3d\tAgility: %-3d\tBase Attack: %-3d" +
                        "\nWeapon: %-13s\tWeight: %-3d\tAttack Mod: %-3d" +
                        "\n\n",
                getName(),
                "Wizard",
                getHitPoints(),
                getDefense(),
                getAgility(),
                getBaseAttack(),
                getWeapon().getWeaponType(),
                getWeapon().getWeight(),
                getWeapon().getAttack());
    }

    @Override
    public String getCharacterInformString() {
        return getClassDescription();
    }

    // Return class description for the character creation screen
    public static String getClassDescription() {
        return "Wizards are usually elf. Have higher hit points but low defense ";
    }
}
