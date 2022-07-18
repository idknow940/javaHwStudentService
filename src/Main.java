import model.Student;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student[] students = studentService.interact();
        studentService.sortByAge(students, true);
        System.out.println("Oldest " + studentService.oldestStudent(students)[0].info());
        System.out.println("Youngest " + studentService.youngestStudent(students)[0].info());
        System.out.print("Youngest Females: ");
        studentService.printYoungestFemales(students);
        System.out.println();
        System.out.print("Oldest Females: ");
        studentService.printOldestFemales(students);
        System.out.println();
        System.out.print("Youngest Males: ");
        studentService.printYoungestMales(students);
        System.out.println();
        System.out.print("Oldest Males: ");
        studentService.printOldestMales(students);
        System.out.println();
        System.out.print("PHD Females: ");
        studentService.printPhdFemales(students);
        System.out.println();
        System.out.print("PHD Males: ");
        studentService.printPhdMales(students);
        System.out.println();
        System.out.print("PHD Students: ");
        studentService.phdStudents(students);
        System.out.println();
        System.out.print("Students: ");
        studentService.printStudents(students);
    }
}
