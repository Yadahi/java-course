
public class Circle {
    private double radius;
    private String colour;

    //■In the Circle class, add a default constructor (no params) that will always create a green circle with a radius of 2.
    public Circle() {
        this.radius = 2.0;
        this.colour = "green";
    }

    //■Add a second overloaded constructor, which allows external classes to control the size of any new circle object.
    public Circle(double radius) {
        this.radius = radius;
        this.colour = "green";
    }

    //■Add a third constructor, which allows the creation of circles of any size or color on object creation.
    public Circle(double radius, String colour) {
        this.radius = radius;
        this.colour = colour;
    }

    //■Add getter methods for the two properties (this makes them read-only from outside)
    public double getRadius() {
        return this.radius;
    }

    public String getColour() {
        return this.colour;
    }

    //■Add a getArea method to calculate and return the total area of a circle object. Math.PI may be useful here…
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    //■Add a toString() method that will return a description of a circle object, something like “Radius = 2, Colour = Blue”
    public String toString() {
        return "Radius = " + this.radius + ", Colour = " + this.colour;
    }
}
