import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;

        do {
            System.out.println("\n=== Enterprise Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Roll Number: ");
                    String roll = scanner.nextLine();
                    System.out.print("Course: ");
                    String course = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    dao.addStudent(new Student(name, roll, course, age));
                }
                case 2 -> {
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\n--- Student List ---");
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId() + ", Name: " + s.getName() +
                                           ", Roll: " + s.getRollNumber() + ", Course: " + s.getCourse() +
                                           ", Age: " + s.getAge());
                    }
                }
                case 3 -> {
                    System.out.print("Enter Student ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("New Name: ");
                    String name = scanner.nextLine();
                    System.out.print("New Roll Number: ");
                    String roll = scanner.nextLine();
                    System.out.print("New Course: ");
                    String course = scanner.nextLine();
                    System.out.print("New Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    dao.updateStudent(id, new Student(name, roll, course, age));
                }
                case 4 -> {
                    System.out.print("Enter Student ID to delete: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    dao.deleteStudent(id);
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        scanner.close();
    }
}
