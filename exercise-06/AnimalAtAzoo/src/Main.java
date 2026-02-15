//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    /*
        Step 7: In Main() class, create three Animal objects,
        setting their properties via the constructors.
     */
    Animal myDog = new Animal();
    Animal wildCat = new Animal("Cat", 150, "Savannah", true);
    Animal myCow = new Animal("Cow", 1200, "Farm", false);

    /*
    Step 8: Add the three Animals to the Zoo (object array).
     */
    Animal[] zoo = new Animal[3];
    zoo[0] = myDog;
    zoo[1] = wildCat;
    zoo[2] = myCow;

    ArrayList<Animal> zooList = new ArrayList<>();
    zooList.add(myDog);
    zooList.add(wildCat);
    zooList.add(myCow);

    /*
    ■ Step 9: Let’s interact with our objects, to test their
    functionality. Create a loop to take each Animal out of
    the Zoo and call it’s methods
     */
    System.out.println("Using the array of object ... zoo ...");
    for (int i = 0; i < zoo.length; i++) {
        System.out.println("Animal " + (i + 1) + ":");
        System.out.println(zoo[i].feedAnimal());
        System.out.println(zoo[i].makeSound());
        System.out.println(zoo[i].toString());
    }

    System.out.println("=".repeat(50));
    System.out.println("Using the ArrayList of object ... zooList ...");
    for (Animal animal : zooList) {
        System.out.println("Animal " + animal.getSpecies() + ":");
        System.out.println(animal.feedAnimal());
        System.out.println(animal.makeSound());
        System.out.println(animal.toString());
    }
}
