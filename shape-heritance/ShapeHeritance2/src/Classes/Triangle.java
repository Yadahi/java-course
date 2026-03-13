package Classes;

public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(String shapeName, String color, int base, int height) {
        super(shapeName, color);
        this.base = base;
        this.height = height;
    }

    public boolean isEquilateral() {
        return base == height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }

    public String toString() {
        return String.format("I'm %s triangle named %s. My base is %d and my height is %d. My area is: %.1f", super.getColor(), super.getShapeName(), base, height, getArea());
    }
}
