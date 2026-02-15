package Classes;

public class Rectangle extends Shape{
    private int length;
    private int width;

    public Rectangle(String color, int numOfSides, int length, int width) {
        super(color, numOfSides);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}
