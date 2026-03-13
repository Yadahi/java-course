package Classes;

public class Circle extends Shape {
    private double radius;

    public Circle(String shapeName, String color, double radius) {
        super(shapeName, color);
        this.radius = radius;
    }

    public boolean isLargeCircle() {
        return radius > 10;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return String.format("I'm %s circle named %s. My radius is %.2f. My area is: %f", super.getColor(), super.getShapeName(), radius, getArea());
    }
}
