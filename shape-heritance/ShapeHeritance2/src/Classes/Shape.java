package Classes;

public abstract class Shape {
    //This is the parent class:
    private String shapeName;
    private String color;

    //Constructor:
    public Shape(String shapeName, String color) {
        this.setShapeName(shapeName);
        this.color = color;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getColor() {
        return color;
    }

    public abstract String toString();

    public abstract double getArea();
}
