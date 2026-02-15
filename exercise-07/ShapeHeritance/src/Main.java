import Classes.Circle;
import Classes.Rectangle;
import Classes.Shape;
import Classes.Triangle;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("Red", 0, 5.0);
        Shape rectangle = new Rectangle("Blue", 4, 10, 5);
        Shape triangle = new Triangle("Green", 3, 8, 6);

        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Rectangle area: " + rectangle.getArea());
        System.out.println("Triangle area: " + triangle.getArea());
    }
}
