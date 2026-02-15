package Classes;

public abstract class Shape {
    private String color;
    private int numOfSides;

    public Shape(String color, int numOfSides) {
        this.color = color;
        this.numOfSides = numOfSides;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public void setNumOfSides(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public abstract double getArea();

    public String toString() {
        return "Shape[color=" + color + ", numOfSides=" + numOfSides + "]";
    }
}
