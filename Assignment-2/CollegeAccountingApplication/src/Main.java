import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] options = {"Student", "Staff", "Finish"};
        ArrayList<Staff> staffList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();

        // dialog that asks the user to enter Student, Staff or Finish.
        boolean continueEntering = true;
        while (continueEntering) {
            int choice = JOptionPane.showOptionDialog(null, "Select Student or Staff", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            // if Finish or close button selected terminate loop
            if (choice == -1 || choice == 2) {
                continueEntering = false;
            } else if (choice == 0) {
                // get student year
                // there is a contradiction in the requirements because it says "Also validate that the student year is between 1 and 5.
                // Inform the user with a dialog if it is outside this range."
                // but it is also stated that "Year (1,2,3,4)" and the screenshots show "Enter student year (1–4)"
                // I followed the direct requirement sentence
                int year = getValidatedNumber("Enter student year (1-5)", 1, 5);
                // if cancel selected go back to main option dialog
                if (year == -1) continue;

                // get student name
                String name = getValidatedString("Enter Student Name");
                // if cancel selected go back to main option dialog
                if (name == null) continue;

                // get student name
                String address = getValidatedString("Enter Student Address");
                // if cancel selected go back to main option dialog
                if (address == null) continue;

                // adds Student to studentList
                Student student = new Student(name, address, year);
                studentList.add(student);
            } else {
                // get student name
                String name = getValidatedString("Enter Staff Name");
                // if cancel selected go back to main option dialog
                if (name == null) continue;
                // get student name
                String address = getValidatedString("Enter Staff Address");
                // if cancel selected go back to main option dialog
                if (address == null) continue;
                // get staff year
                int year = getValidatedNumber("Enter staff years of service", 1, 24);
                // if cancel selected go back to main option dialog
                if (year == -1) continue;

                // adds Staff to staffList
                Staff staff = new Staff(name, address, year);
                staffList.add(staff);
            }
        }
        // total number of students
        int studentTotal = studentList.size();
        // total number of staff
        int staffTotal = staffList.size();

        // creates string with list of students and details
        String studentReportString = "";
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            studentReportString += String.format("%d. %s\n", i+1, student.toString());
        }

        // creates string with list of staff and details
        String staffReportString = "";
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            staffReportString += String.format("%d. %s\n", i+1, staff.toString());
        }

        // create full student report
        String studentReport = String.format("Students [Total: %s]\n%s", studentTotal, studentReportString);
        // create full staff report
        String staffReport = String.format("Staff [Total: %s]\n%s", staffTotal, staffReportString);

        // calculates total students fee
        // first part of the report
        double studentFees = 0;
        for (Student student : studentList) {
            studentFees += student.calculateInstallmentFee();
        }

        // calculates total staff pay
        // second part of the report
        double staffPay = 0;
        for (Staff staff : staffList) {
            staffPay += staff.calculateBiWeeklyPay();
        }

        // concatenate outgoing, incoming and total
        // final part of the report
        String results = String.format("Results:\nOutgoing: $%.2f\nIncoming: $%.2f\nTotal: $%.2f", staffPay, studentFees, (studentFees - staffPay));

        // full report
        String report = String.format("%s\n%s\n%s", studentReport, staffReport, results);
        JOptionPane.showMessageDialog(null, report);

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

    // helper method to validate number input
    private static int getValidatedNumber(String title, int min, int max) {
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
                // check the range
                if (stringInput >= min && stringInput <= max) {
                    return stringInput;
                } else {
                    // show validation message with range
                    JOptionPane.showMessageDialog(null, String.format("Please enter a number in range (%d - %d)", min, max));
                    continue;
                }
            } catch (Exception e) {
                // throw new RuntimeException(e);
                // not a valid integer
            }
            // show validation message
            JOptionPane.showMessageDialog(null, "Please enter a number");

        }
    }
}
