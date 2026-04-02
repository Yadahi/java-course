package classes;

import javax.swing.*;

public class Lion extends Animal {
    private int tailLength;

    public Lion(String species, int weight, String habitat, boolean isEndangered, int tailLength) {
        super(species, weight, habitat, isEndangered);
        this.tailLength = tailLength;
        setAnimalImage(new ImageIcon(this.getClass().getResource("/images/lion.jpg")));
    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        String state = "not an Endangered species";
        if (this.isEndangered()) {
            state = "an Endangered species";
        }

        return String.format("I am a %dlb %s that lives in the %s. I am %s. My tail length is %d cm", this.getWeight(), this.getSpecies(), this.getHabitat(), state, tailLength);
    }
}
