public class Animal {
    /*
    Step 1: Define an Animal class with four properties:
        – Species – ex. Lion, cow or sloth
        – Max Weight – The maximum average weight of an
        adult of the species
        – Habitat – ex. Jungle, ocean or mountains
        – Is Endangered – Flag to indicate whether the
        animal species is endangered
     */
    private String species;
    private int maxWeight;
    private String habitat;
    private boolean isEndangered;

    /*
    Step 2: Add a default constructor, with any default
        values that you feel may be required
     */
    public Animal() {
        this.setSpecies("Dog");
        this.setMaxWeight(30);
        this.setHabitat("Home");
        this.setEndangered(false);

//        this.species = "Dog";
//        this.maxWeight = 30;
//        this.habitat = "Home";
//        this.isEndangered = false;
    }

    /*
    Step 3: Add a parameterized constructor, to
        allow setting of all properties on object
        creation.
     */

    public Animal(String species, int maxWeight, String habitat, boolean isEndangered) {
        this.setSpecies(species);
        this.setMaxWeight(maxWeight);
        this.setHabitat(habitat);
        this.setEndangered(isEndangered);
    }

        /*
    Step 4: Determine scope/access of properties
        – Are they completely internal to the class? // YES
        – Should an external class be permitted to read the property values? // YES, getter method
        – Should an external class be permitted to change the property values? // YES, setter method
    Step 5: Create appropriate getter/setter methods, as required
     */

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
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

    /*
    Step 6: Create three methods – ie. Actions that Animal instances can do, or that involve Animal objects

        – In our program, an animal can report its state. (toString())
        ■ Ex. “I am a 500lb tiger that lives in the jungle. I am an endangered species.”
        – Note: Let’s do all console printing in Main(), not Animal.
     */
    // – Animals can be fed – ex. Feed a tiger a steak.
    public String feedAnimal() {
        return String.format("The %s has been fed a steak.", this.species);
    }

    // – Animals can make a sound – ex. A cow can moo.
    public String makeSound() {
        String sound = "unknown sound";
        if (this.species.equals("Dog")) {
            sound = "bark";
        } else if (this.species.equals("Cat")) {
            sound = "meow";
        } else if (this.species.equals("Cow")) {
            sound = "moo";
        }

        return String.format("The %s goes '%s'.", this.species, sound);
    }

    public String toString() {
        String state = "not an Endangered species";
        if (this.isEndangered) {
            state = "an Endangered species";
        }
        String report = String.format("I am a %dlb %s that lives in the %s. I am %s.",
                this.maxWeight, this.species, this.habitat, state);

        return report;
    }


}
