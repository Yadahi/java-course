public class Student {
    public String studentName;
    public int[] scores;

    // Constructor - only student name is required as the scores can be added later
    public Student(String studentName) {
        this.studentName = studentName;
        this.scores = new int[2];
    }

    // Method to add score
    public void addScore(int index, int score) {
        if (index >= 0 && index < scores.length) {
            this.scores[index] = score;
        }
    }

    // Method to calculate total score
    public int getTotalScore() {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    // Method to represent student details as a string
    public String toString() {
        return String.format("%s:\t Assignment1 - %d\t Assignment2 - %d\t Total - %d",
                studentName,
                scores[0],
                scores[1],
                getTotalScore());
    }
}
