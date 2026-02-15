import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Programming IT Courses");
        System.out.println("COURSE ENTRY");
        System.out.println("=".repeat(20));

        // Creating an array of 2 course objects
        Course[] courses = new Course[2];
        // Iterate over the courses array and add course name to each course object
        for (int i = 0; i < 2; i++) {
            // Input validation for course name, it should not be empty
            String courseName;
            do {
                // Check if the course name is not empty
                System.out.print("Enter name for course #" + (i + 1) + ": ");
                courseName = sc.nextLine().trim();
                if (courseName.isEmpty()) {
                    System.out.println("Course name cannot be empty. Please enter a valid course name.");
                }
            } while (
                    courseName.isEmpty()
            );

            // Create a new course object
            Course course = new Course(courseName);
            // Add course to the courses array
            courses[i] = course;
        }

        System.out.println("Student Entry");
        System.out.println("=".repeat(20));

        // Iterate over courses array and add 6 students to each course, for each student add 2 assignment scores
        for (Course course : courses) {
            System.out.println("Enter students for " + course.courseName + ":");
            for (int i = 0; i < 6; i++) {
                String studentName;
                // Input validation
                // Check if the student name is not empty
                do {
                    System.out.println("Enter name for student # " + (i + 1) + ": ");
                    studentName = sc.nextLine().trim();
                    if (studentName.isEmpty()) {
                        System.out.println("Student name cannot be empty. Please enter a valid student name.");
                    }
                } while (
                        studentName.isEmpty()
                );

                // Create a new student object
                Student student = new Student(studentName);

                // Assign marks for 2 assignments
                for (int j = 0; j < 2; j++) {
                    int score = -1;
                    boolean validInput = false;

                    // Input validation for assignment scores
                    while (!validInput) {
                        System.out.println(String.format("Enter Assignment%d mark for %s: ", j + 1, studentName));

                        // Check if the input is an integer
                        // It is not ideal because it introduces a glitch where if the user hit enter
                        // several times and then enter a string the while loop will run several times
                        // I would write it in different way, but I didn't want to write something we haven't covered yet
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a whole number.");
                            sc.nextLine(); // clear the bad input
                            continue; // skip to the next iteration
                        }

                        // This line run only when the input is an integer
                        score = sc.nextInt();
                        sc.nextLine();

                        // Validate the score range
                        if (score < 0 || score > 100) {
                            System.out.println("Invalid score. Please enter a score between 0 and 100.");
                        } else {
                            validInput = true;
                        }
                    }
                    // Only add number if score is valid integer between 0 and 100
                    student.addScore(j, score);
                }
                // Add students to the course
                course.addStudent(i, student);
            }
        }

        // Report stats per course
        System.out.println("REPORT: Stats per Course");
        System.out.println("=".repeat(30));
        // Iterate over courses array and print course report
        for (Course course : courses) {
            System.out.println(course.toString());
            System.out.println(); // add one blank line
        }
        System.out.println(); // add one blank line

        // Report stats per student
        System.out.println("REPORT: Stats per student");
        System.out.println("=".repeat(30));
        // Iterate over courses array and print student report for each course
        for (Course course : courses) {
            System.out.println(course.courseName);
            // Iterate over enrolled students and print student report
            for (Student student : course.enrolledStudents) {
                // Check if student is not null
                if (student != null) {
                    System.out.println(student.toString());
                }
            }
            System.out.println(); // add one blank line
        }
    }
}