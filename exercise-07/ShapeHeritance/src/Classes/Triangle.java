package Classes;

public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle(String color, int numOfSides, int base, int height) {
        super(color, numOfSides);
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}
