void main() {
    Food[] picnicBasket = new Food[3];

    Scanner sc = new Scanner(System.in);
    String foodName, foodType;

    System.out.println("Filling the picnic basket:");
    System.out.println("=".repeat(50));

    for (int i = 0; i < picnicBasket.length; i++) {
        System.out.println(String.format("Food item #%d", i + 1));
        System.out.println("Enter the food name:");
        foodName = sc.nextLine();
        System.out.println("Enter the food type (fruit/dairy/meat):");
        foodType = sc.nextLine();
        picnicBasket[i] = new Food(foodName, foodType);
    }

    for (int i = 0; i < picnicBasket.length; i++) {
        Food item = picnicBasket[i];
        String type = item.getType();

        if (type == null) {
            System.out.println("Invalid food type provided.");
        } else if (type.equals("fruit")) {
            System.out.println(item.eatIt());
        } else if (type.equals("dairy")) {
            System.out.println(item.eatIt());
        } else if (type.equals("meat")) {
            System.out.println(item.denyIt());
        } else {
            System.out.println(item.denyIt());
        }
    }
}

// Food #1 apple fruit -> eat it
// Food #2 cheese dairy -> eat it
// Food #3 broccoli vegetable -> don't eat it