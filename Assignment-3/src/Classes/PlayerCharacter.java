package Classes;

public abstract class PlayerCharacter extends Character {
    private Weapon weapon;

    // Constructor that sets player stats and weapon
    public PlayerCharacter(String name, int baseAttack, int defense, int agility, int hitPoints, Weapon weapon) {
        super(name, baseAttack, defense, agility, hitPoints);
        this.weapon = weapon;
    }

    // === Getters & Setters ===

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Abstract method for subclasses to return their class description
    public abstract String getCharacterInformString();
}
