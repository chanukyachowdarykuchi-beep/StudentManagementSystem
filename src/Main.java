//import java.sql.Connection;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
import java.util.List;
import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            StudentDAO dao = new StudentDAO();
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add student");
                System.out.println("2. View all students");
                System.out.println("3. Update marks");
                System.out.println("4. Delete student");
                System.out.println("5. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();

                if (choice == 1) {
                    sc.nextLine();
                    System.out.print("Name: ");   String name   = sc.nextLine();
                    System.out.print("Email: ");  String email  = sc.nextLine();
                    System.out.print("Course: "); String course = sc.nextLine();
                    System.out.print("Marks: ");  int marks     = sc.nextInt();
                    dao.addStudent(new Student(0, name, email, course, marks));

                } else if (choice == 2) {
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\nID | Name | Email | Course | Marks");
                    System.out.println("------------------------------------");
                    for (Student s : students) System.out.println(s);

                } else if (choice == 3) {
                    System.out.print("Student ID: "); int id = sc.nextInt();
                    System.out.print("New marks: ");  int marks = sc.nextInt();
                    dao.updateMarks(id, marks);

                } else if (choice == 4) {
                    System.out.print("Student ID to delete: ");
                    dao.deleteStudent(sc.nextInt());

                } else if (choice == 5) {
                    System.out.println("Goodbye!");
                    break;
                }
            }
            sc.close();
        }
    }