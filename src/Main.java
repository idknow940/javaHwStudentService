import model.Student;
import service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Student s1 = new Student();
        s1.setFullName("Vazgen Gevorgyan");
        s1.setGender('M');
        s1.setYear(2000);
        s1.setMark(97.6);
        s1.setPhd(true);

        Student s2 = new Student();
        s2.setFullName("Laura Amiryan");
        s2.setGender('F');
        s2.setYear(2001);
        s2.setMark(78.4);
        s2.setPhd(false);

        Student s3 = new Student();
        s3.setFullName("Xachik Kirakosyan");
        s3.setGender('M');
        s3.setYear(1989);
        s3.setMark(94.9);
        s3.setPhd(false);

        Student[] students = {s1, s2, s3};
        studentService.sortByAge(students, true);

        System.out.println(
                "Oldest "
                        + studentService.oldestStudent(students)[0].info());
        System.out.println(
                "Youngest "
                        + studentService.youngestStudent(students)[0].info());
        System.out.println(students[0].info());
        studentService.printStudents(students);
    }
}
