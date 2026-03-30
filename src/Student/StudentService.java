package Student;

import java.util.ArrayList;

class StudentService {

    ArrayList<Student> list = new ArrayList<>();

    // Add Student
    void addStudent(Student s){
        for (Student st : list) {
            if (st.id == s.id) {
                System.out.println("ID already exists!");
                return;
            }
        }
        list.add(s);
        System.out.println("Student Added!");
    }

    // Show Students
    void showStudent(){
        if (list.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : list){
            System.out.println("ID: "+s.id + " | Name: "+s.name+" | Marks: "+s.marks);
        }
    }

    // Delete Student
    void deleteStudent(int id){
        boolean removed = list.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("Student Deleted!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Search Student
    void searchStudent(int id){
        for (Student s : list){
            if (s.id == id){
                System.out.println("Found → ID: "+s.id+" | Name: "+s.name+" | Marks: "+s.marks);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Update Student
    void updateStudent(int id, String name, int marks){
        for (Student s : list){
            if (s.id == id){
                s.name = name;
                s.marks = marks;
                System.out.println("Student Updated!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Sort by Marks & Show Topper
    void sortByMarks() {
        if (list.isEmpty()) {
            System.out.println("No students to sort!");
            return;
        }

        // Sort descending
        list.sort((s1, s2) -> s2.marks - s1.marks);

        System.out.println("\nStudents Sorted by Marks (Highest First):");
        showStudent();

        // Show Topper
        Student top = list.get(0);
        System.out.println("\nTopper: " + top.name + " (" + top.marks + ")");
    }
}