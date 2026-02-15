public class Food {
    public String food;
    public String type;

    public Food(String food, String type) {
        this.food = food;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public String eatIt() {
        return String.format("You just ate the %s", this.food);
    }

    public String denyIt() {
        return String.format("Not eating that! I hate %s", this.type);
    }
}
