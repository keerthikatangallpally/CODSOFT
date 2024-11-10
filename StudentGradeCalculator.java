import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSubjects;

        System.out.println("Welcome to the Student Grade Calculator!");
        
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }
    
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 75) {
            grade = 'B';
        } else if (averagePercentage >= 50) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("\n^_^ Results^_^");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        System.out.println("\nThank you for using the Student Grade Calculator!");
        scanner.close();
    }
}