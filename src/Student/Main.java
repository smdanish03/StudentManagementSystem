package Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StudentService service = new StudentService();

        while(true){
            System.out.println("\n1.Add 2.Show 3.Delete 4.Search 5.Update 6.Sort by Marks 7.Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // clear buffer

            switch(choice) {
                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = input.nextInt();

                    service.addStudent(new Student(id, name, marks));
                }
                case 2 -> service.showStudent();
                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = input.nextInt();
                    service.deleteStudent(id);
                }
                case 4 -> {
                    System.out.print("Enter ID to search: ");
                    int id = input.nextInt();
                    service.searchStudent(id);
                }
                case 5 -> {
                    System.out.print("Enter ID to update: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter new Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter new Marks: ");
                    int marks = input.nextInt();

                    service.updateStudent(id, name, marks);
                }
                case 6 -> service.sortByMarks(); // Sort + show topper
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}