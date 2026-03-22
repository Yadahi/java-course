package Classes;

import javax.swing.*;

public class Hammer extends Weapon {

    // Constructor that sets hammer stats and image
    public Hammer(int attack, int weight) {
        super(attack,weight);
        setWeaponPic(new ImageIcon(this.getClass().getResource("/Images/hammer.png")));
    }

    // Return weapon type name
    public String getWeaponType() {
        return "Hammer";
    }

    @Override
    public String getWeaponInformString() {
        return getWeaponDescription();
    }

    // Return weapon description for the character creation screen
    public static String getWeaponDescription() {
        return "The hammer is a weapon with powerful attack power. " +
                "A single attack can create a high hit point. " +
                "However, it is a heavy weapon and has a slow attack speed. ";
    }
}
