
public class Main {
    public static void main(String[] args) {
        //■Create a Main class, that will be used to instantiate and interact with your Circle class.
        //■In the Main class’ PSVM method, write a program to create at least three circle objects (testing each constructor)
        // and interact with the other class methods.
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(3.5, "red");

        // Circle 1
        System.out.println("Circle 1:");
        System.out.println("Area: " + circle1.getArea());
        System.out.println("Colour: " + circle1.getColour());
        System.out.println("Radius: " + circle1.getRadius());
        System.out.println("Description of a circle: " + circle1.toString());

        // Circle 2
        System.out.println("Circle 2:");
        System.out.println("Area: " + circle2.getArea());
        System.out.println("Colour: " + circle2.getColour());
        System.out.println("Radius: " + circle2.getRadius());
        System.out.println("Description of a circle: : " + circle2.toString());

        // Circle 3
        System.out.println("Circle 3:");
        System.out.println("Area: " + circle3.getArea());
        System.out.println("Colour: " + circle3.getColour());
        System.out.println("Radius: " + circle3.getRadius());
        System.out.println("Description of a circle: " + circle3.toString());
    }
}

