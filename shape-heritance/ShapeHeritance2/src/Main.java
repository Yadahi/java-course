import Classes.Circle;
import Classes.Rectangle;
import Classes.Shape;
import Classes.Triangle;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    // initialize Random instance
    private static Random rand = new Random();
    // create an array of color names
    private static String[] colorNames = {"red", "blue", "green", "yellow", "pink"};

    public static void main(String[] args) {
        // create ArrayLists for each shape subtype
        ArrayList<Circle> circles = new ArrayList<>();
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        ArrayList<Triangle> triangles = new ArrayList<>();
        // list that holds all shapes (combined from the specific lists)
        ArrayList<Shape> allShapes = new ArrayList<>();

        // get user's input
        int inputNumber = getValidatedNumber("How many of each shape type should be generated");

        // circle — create circle instances and add them to the circles list
        for (int i = 0; i < inputNumber; i++) {
            // get the shape's name
            String shapeName = getValidatedString(String.format("%d) Enter circle shape's name", i + 1));
            // get the radius
            int radius = getValidatedNumber(String.format("%d) Enter circle radius", i + 1));
            // get a random color
            String color = getRandomColor();
            // create a Circle instance
            Circle circle = new Circle(shapeName, color, radius);
            // add to the circles list
            circles.add(circle);
        }
        // append all circles to the allShapes list
        allShapes.addAll(circles);

        // rectangle — create rectangle instances and add them to the rectangles list
        for (int i = 0; i < inputNumber; i++) {
            // get the shape's name
            String shapeName = getValidatedString(String.format("%d) Enter rectangle shape's name", i + 1));
            // get the length
            int length = getValidatedNumber(String.format("%d) Enter rectangle length", i + 1));
            // get the width
            int width = getValidatedNumber(String.format("%d) Enter rectangle width", i + 1));
            // get a random color
            String color = getRandomColor();
            // create a Rectangle instance
            Rectangle rectangle = new Rectangle(shapeName, color, length, width);
            // add to the rectangles list
            rectangles.add(rectangle);
        }
        allShapes.addAll(rectangles);

        // triangle — create triangle instances and add them to the triangles list
        for (int i = 0; i < inputNumber; i++) {
            // get the shape's name
            String shapeName = getValidatedString(String.format("%d) Enter triangle shape's name", i + 1));
            // get the base
            int base = getValidatedNumber(String.format("%d) Enter triangle base", i + 1));
            // get the height
            int height = getValidatedNumber(String.format("%d) Enter triangle height", i + 1));
            // get a random color
            String color = getRandomColor();
            // create a Triangle instance
            Triangle triangle = new Triangle(shapeName, color, base, height);
            // add to the triangles list
            triangles.add(triangle);
        }
        allShapes.addAll(triangles);

        int totalShapes = allShapes.size();

        // report — assemble a report of the created shapes and show it to the user
        // initialize report header
        String report = "Shares in Memory\n\n";
        report += "Circle:\n";
        // append formatted circle details
        report += printShapeReport(circles);
        report += "Rectangles:\n";
        // append formatted rectangle details
        report += printShapeReport(rectangles);
        report += "Triangles:\n";
        // append formatted triangle details
        report += printShapeReport(triangles);
        // append total number of shapes
        report += String.format("Total Shapes: %d", totalShapes);
        // display the assembled report in a dialog
        JOptionPane.showMessageDialog(null, report);
    }

    private static String getRandomColor() {
        // get a random index between 0 and the length of colorNames
        int randomNum = rand.nextInt(colorNames.length);
        // return the color at that random index
        return colorNames[randomNum];
    }

    private static String printShapeReport(ArrayList<? extends Shape> shapes) {
        // create a string to hold the report
        String report = "";
        // for each shape in the list
        for (Shape shape : shapes) {
            // add the shape's text and a newline
            report += String.format("%s\n", shape.toString());
        }
        // add a blank line after the list
        report += "\n";
        // return the built report
        return report;
    }

    // helper method to validate number input
    private static int getValidatedNumber(String title) {
        while (true) {
            // asks the input
            String input = JOptionPane.showInputDialog(null, title, "Input", JOptionPane.QUESTION_MESSAGE);
            // when cancel was selected return -1
            if (input == null) {
                return -1;
            }

            try {
                // parse string
                int stringInput = Integer.parseInt(input);
                return stringInput;
            } catch (Exception e) {
                // throw new RuntimeException(e);
                // not a valid integer
            }
            // show validation message
            JOptionPane.showMessageDialog(null, "Please enter a number");
        }
    }

    // helper method to validate string input
    private static String getValidatedString(String title) {
        while (true) {
            // asks the input
            String input = JOptionPane.showInputDialog(null, title, "Input", JOptionPane.QUESTION_MESSAGE);
            // when cancel was selected return null
            if (input == null) {
                return null;
            }
            // return input when it is not empty
            if (!input.trim().isEmpty()) {
                return input.trim();
            }
            // show validation message
            JOptionPane.showMessageDialog(null, "Please enter valid information");
        }
    }
}