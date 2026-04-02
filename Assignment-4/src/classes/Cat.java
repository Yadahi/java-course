package classes;

import javax.swing.*;

public class Cat extends Animal {
    private int whiskerLength;

    public Cat(String species, int weight, String habitat, boolean isEndangered, int whiskerLength) {
        super(species, weight, habitat, isEndangered);
        this.whiskerLength = whiskerLength;
        setAnimalImage(new ImageIcon(this.getClass().getResource("/images/cat.jpg")));
    }

    public int getWhiskerLength() {
        return whiskerLength;
    }

    public void setWhiskerLength(int whiskerLength) {
        this.whiskerLength = whiskerLength;
    }

    @Override
    public String toString() {
        String state = "not an endangered species";
        if (this.isEndangered()) {
            state = "an endangered species";
        }

        return String.format("I am a %dlb %s that lives in the %s. I am %s. My whisker length is %d cm ", this.getWeight(), this.getSpecies(), this.getHabitat(), state, whiskerLength);
    }
}
