
void main() {
    String[] letterGrades = {"A", "B", "C", "D", "F"};
    int[] gradePoints = {4, 3, 2, 1, 0};

    System.out.println("Enter a letter grade (A, B, C, D, F): ");
    Scanner sc = new Scanner(System.in);
    String inputGrade = sc.nextLine().toUpperCase();
    System.out.println(inputGrade);

    for (int i = 0; i < letterGrades.length; i++) {
        if (letterGrades[i].equals(inputGrade)) {
            System.out.println("The grade point for " + inputGrade + " is: " + gradePoints[i]);
            return;
        }
    }
}
