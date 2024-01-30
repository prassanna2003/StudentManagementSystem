import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }
}

public class StudentManagementSystem {
    private static final int MAX_STUDENTS = 100;
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    displayStudents();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }

        System.out.println("Exiting Student Management System.");
        scanner.close();
    }

    private static void addStudent(Scanner scanner) {
        if (studentCount < MAX_STUDENTS) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            Student newStudent = new Student(name, age, id);
            students[studentCount] = newStudent;
            studentCount++;

            System.out.println("Student added successfully.");
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

    private static void removeStudent(Scanner scanner) {
        if (studentCount > 0) {
            System.out.print("Enter student ID to remove: ");
            String idToRemove = scanner.nextLine();

            boolean found = false;
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getId().equals(idToRemove)) {
                    found = true;
                    for (int j = i; j < studentCount - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    studentCount--;
                    System.out.println("Student removed successfully.");
                    break;
                }
            }

            if (!found) {
                System.out.println("Student with ID " + idToRemove + " not found.");
            }
        } else {
            System.out.println("No students to remove.");
        }
    }

    private static void displayStudents() {
        if (studentCount > 0) {
            System.out.println("List of Students:");
            for (int i = 0; i < studentCount; i++) {
                System.out.println("Name: " + students[i].getName() +
                                   ", Age: " + students[i].getAge() +
                                   ", ID: " + students[i].getId());
            }
        } else {
            System.out.println("No students to display.");
        }
    }
}
