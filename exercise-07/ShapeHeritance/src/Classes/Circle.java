package Classes;

public class Circle extends Shape {
    private double radius;

    public Circle(String color, int numOfSides, double radius) {
        super(color, numOfSides);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "Circle[color=" + getColor() + ", numOfSides=" + getNumOfSides() + ", radius=" + radius + "]";
    }
}
