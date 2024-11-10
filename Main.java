import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        students.add(new Student(name, rollNumber, grade));
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter Roll Number of student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void searchStudent() {
        System.out.print("Enter Roll Number of student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student Found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void updateStudent() {
        System.out.print("Enter Roll Number of student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.print("Enter new Grade: ");
                String newGrade = scanner.nextLine();
                student.setGrade(newGrade);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void menu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    updateStudent();
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.menu();
    }
}
