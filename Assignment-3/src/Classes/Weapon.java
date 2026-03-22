package Classes;

import javax.swing.*;

public abstract class Weapon {
    private int attack;
    private int weight;
    private ImageIcon weaponPic;

    // Constructor to initialize weapon attack and weight
    public Weapon(int attack, int weight) {
        this.attack = attack;
        this.weight = weight;
    }

    // === Getters & Setters ===

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ImageIcon getWeaponPic() {
        return weaponPic;
    }

    public void setWeaponPic(ImageIcon weaponPic) {
        this.weaponPic = weaponPic;
    }

    // Abstract method for subclasses to return weapon type name
    public abstract String getWeaponType();

    // Abstract method for subclasses to return weapon description
    public abstract String getWeaponInformString();
}
