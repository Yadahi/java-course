package Classes;

public class Rectangle extends Shape {
    private int length;
    private int width;

    public Rectangle(String shapeName, String color, int length, int width) {
        super(shapeName, color);
        this.length = length;
        this.width = width;
    }

    public boolean isSquare() {
        return length == width;
    }

    public double getArea() {
        return length * width;
    }

    public String toString() {
        return String.format("I'm %s rectangle named %s. My length is %d and my width is %d. My area is: %.1f", super.getColor(), super.getShapeName(), length, width, getArea());
    }
}
