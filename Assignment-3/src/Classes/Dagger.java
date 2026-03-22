package Classes;

import javax.swing.*;

public class Dagger extends Weapon {

    // Constructor that sets dagger stats and image
    public Dagger(int attack, int weight) {
        super(attack,weight);
        setWeaponPic(new ImageIcon(this.getClass().getResource("/Images/dagger.png")));
    }

    // Return weapon type name
    public String getWeaponType() {
        return "Dagger";
    }

    @Override
    public String getWeaponInformString() {
        return getWeaponDescription();
    }

    // Return weapon description for the character creation screen
    public static String getWeaponDescription() {
        return "A dagger is a light and fast weapon. " +
                "Classes with high agility are very effective when using this weapon. " +
                "It can maintain fast attack speed, but the increase in additional attack power is not high..";
    }
}
