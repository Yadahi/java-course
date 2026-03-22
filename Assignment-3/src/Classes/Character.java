package Classes;

import javax.swing.*;

public abstract class Character {

    // Character properties shared by all subclasses
    private String name;
    private int baseAttack;
    private int defense;
    private int agility;
    private int hitPoints;
    private ImageIcon characterPic;

    // Constructor to initialize character with name and stats
    public Character(String name, int baseAttack, int defense, int agility, int hitPoints) {
        this.name = name;
        this.agility = agility;
        this.baseAttack = baseAttack;
        this.defense = defense;
        this.hitPoints = hitPoints;
    }

    // === Getters & Setters ===

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public ImageIcon getCharacterPic() {
        return characterPic;
    }

    public void setCharacterPic(ImageIcon characterPic) {
        this.characterPic = characterPic;
    }
}