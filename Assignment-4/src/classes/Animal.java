package classes;

import javax.swing.*;

public abstract class Animal {
    private String species;
    private int weight;
    private String habitat;
    private boolean isEndangered;
    private ImageIcon animalImage;

    public Animal(String species, int weight, String habitat, boolean isEndangered) {
        this.species = species;
        this.weight = weight;
        this.habitat = habitat;
        this.isEndangered = isEndangered;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public void setEndangered(boolean endangered) {
        isEndangered = endangered;
    }

    public void setAnimalImage(ImageIcon animalImage) {
        this.animalImage = animalImage;
    }

    public ImageIcon getAnimalImage() {
        return animalImage;
    }

    public double calculateFood() {
        return this.weight * 0.5;
    }

    @Override
    public abstract String toString();
}
