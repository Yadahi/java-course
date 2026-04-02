package classes;

import javax.swing.*;

public class Dog extends Animal {
    private String breed;

    public Dog(String species, int weight, String habitat, boolean isEndangered, String breed) {
        super(species, weight, habitat, isEndangered);
        this.breed = breed;
        setAnimalImage(new ImageIcon(this.getClass().getResource("/images/dog.jpg")));

    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        String state = "not an Endangered species";
        if (this.isEndangered()) {
            state = "an Endangered species";
        }

        return String.format("I am a %dlb %s that lives in the %s. I am %s. My breed is %s", this.getWeight(), this.getSpecies(), this.getHabitat(), state, breed);
    }
}
