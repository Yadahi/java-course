public class Course {
    public String courseName;
    public Student[] enrolledStudents;

    // Constructor - only course name is required as students can be added later
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new Student[6];
    }

    // Add student to the course
    public void addStudent(int index, Student student) {
        enrolledStudents[index] = student;
    }

    // Calculate averages for assignment 1, assignment 2, and total average
    public int[] getAverages() {
        int studentCount = 0;
        int[] averages = new int[3]; // [assignment1Average, assignment2Average, totalAverage]

        int totalAssignment1 = 0;
        int totalAssignment2 = 0;

        // Iterate over enrolled students and calculate total scores for each assignment
        for (Student student : enrolledStudents) {
            if (student != null) {
                studentCount++;
                totalAssignment1 += student.scores[0];
                totalAssignment2 += student.scores[1];
            }
        }

        // check if there are no students enrolled
        // should not happen as there is input validation in main method
        if (studentCount == 0) {
            return averages; // return zeros if no students are enrolled
        }

        // Calculate averages
        int assignment1Average = totalAssignment1 / studentCount;
        int assignment2Average = totalAssignment2 / studentCount;
        int totalAverage = (assignment1Average + assignment2Average) / 2;

        averages[0] = assignment1Average;
        averages[1] = assignment2Average;
        averages[2] = totalAverage;
        // return an array of [assignment1Average, assignment2Average, totalAverage]
        return averages;
    }

    // Determine course grade based on total average
    public String getCourseGrade(int totalAverage) {
        if (totalAverage >= 90) {
            return "A";
        } else if (totalAverage >= 80) {
            return "B";
        } else if (totalAverage >= 70) {
            return "C";
        } else if (totalAverage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Method that returns a string representation of the course report
    public String toString() {
        // Handle case with no enrolled students
        // Assume that students are added in order and therefore if the
        // first student is null then there are no students enrolled in the course
        // Could be improved by using ArrayList.isEmpty() or by iterating over the array to check for null values
        if (enrolledStudents[0] == null) {
            return String.format("%s: No enrolled students.", courseName);
        }
        // Getting averages for assignments and total
        int[] averages = getAverages();
        int assignment1Average = averages[0];
        int assignment2Average = averages[1];
        int totalAverage = averages[2];

        // Getting course grade
        String courseGrade = getCourseGrade(totalAverage);
        // Return formatted string
        return String.format("%s:\t Assignment1 - %d\t Assignment2 - %d\t Average - %d\nCourse Rating: %s",
                courseName,
                assignment1Average,
                assignment2Average,
                totalAverage,
                courseGrade);
    }
}
