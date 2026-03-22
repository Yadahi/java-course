package Classes;

import javax.swing.*;

public class Sword extends Weapon {

    // Constructor that sets sword stats and image
    public Sword(int attack, int weight) {
        super(attack, weight);
        setWeaponPic(new ImageIcon(this.getClass().getResource("/Images/sword.png")));
    }

    // Return weapon type name
    public String getWeaponType() {
        return "Sword";
    }

    @Override
    public String getWeaponInformString() {
        return getWeaponDescription();
    }

    // Return weapon description for the character creation screen
    public static String getWeaponDescription() {
        return "A sword is a good all-round weapon. " +
                "It is not too heavy and inflicts a lot of damage.";
    }
}
