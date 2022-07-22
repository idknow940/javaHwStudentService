package service;

import model.Student;

import java.util.Scanner;

public class StudentService {
    Scanner scanner;
    Student[] students;

    public StudentService() {
        this.scanner = new Scanner(System.in);
        this.students = null;
    }

    public StudentService(Student[] students) {
        this.scanner = new Scanner(System.in);
        this.students = students;
    }

    public void menu() {
        boolean active = true;
        System.out.println("\u2980 STUDENT CREATION MENU \u2980");

        while (active) {
            System.out.println("0. create students");
            System.out.println("1. add students");
            System.out.println("2. remove student");
            System.out.println("3. print students");
            System.out.println("4. sort students by age");
            System.out.println("5. oldest students");
            System.out.println("6. youngest students");
            System.out.println("7. PHD students");
            System.out.println("8. male students");
            System.out.println("9. female students");
            System.out.println("10. youngest female students");
            System.out.println("11. youngest male students");
            System.out.println("12. oldest female students");
            System.out.println("13. oldest male students");
            System.out.println("99. exit");
            System.out.print(">> ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    if (students == null) {
                        create();
                    } else {
                        System.out.print("Student array already created, want to create one again?: [y/n]");
                        choice = scanner.nextLine().charAt(0);
                        if (choice == 'y' || choice == 'Y') {
                            create();
                        }
                    }
                    break;

                case 1:
                    if (students != null) {
                        add();
                    }
                    break;

                case 2:
                    if (students != null) {
                        System.out.print("Enter the id of the student [must be a number]: ");
                        delete(scanner.nextInt());
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    if (students != null) {
                        for (Student student : students) {
                            if (student != null)
                                System.out.println(student.info());
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.print("Ascending order? [y/n]: ");
                    char inp = scanner.nextLine().charAt(0);
                    boolean asc = inp == 'y' || inp == 'Y';
                    sortByAge(students, asc);
                    break;

                case 5:
                    System.out.println("Oldest " + oldestStudents(students)[0].info());
                    break;

                case 6:
                    System.out.println("Youngest " + youngestStudents(students)[0].info());
                    break;

                case 7:
                    System.out.println("PHD students: ");
                    printStudents(phdStudents(students));
                    break;

                case 8:
                    System.out.println("Male students: ");
                    printStudents(femaleStudents(students));
                    break;

                case 9:
                    System.out.println("Female students: ");
                    printStudents(maleStudents(students));
                    break;

                case 10:
                    System.out.println("Youngest Females: ");
                    printYoungestFemales(students);
                    break;

                case 11:
                    System.out.println("Youngest Males: ");
                    printYoungestMales(students);
                    break;

                case 12:
                    System.out.println("Oldest Females: ");
                    printOldestFemales(students);
                    break;

                case 13:
                    System.out.println("Oldest Males: ");
                    printOldestMales(students);
                    break;

                case 99:
                    active = false;

                default:
                    break;
            }
        }
    }

    public void create() {
        System.out.print("How many students will you enter [must be a number]: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine();

        students = new Student[studentCount];

        for (int i = 0; i < studentCount; i++) {
            Student student = new Student();
            student.setId(i);
            // setting full name
            System.out.print("Full name: ");
            student.setFullName(scanner.nextLine());

            // setting year
            System.out.print("Birth year [must be a number]: ");
            student.setYear(scanner.nextInt());
            scanner.nextLine();

            // setting gender
            System.out.print("Gender [m/f]: ");
            student.setGender(scanner.nextLine().charAt(0));

            // setting phd
            System.out.print("Is PHD [y/n]: ");
            char phd = scanner.nextLine().charAt(0);
            student.setPhd(phd == 'y' || phd == 'Y');

            // setting mark
            System.out.print("Mark [must be a number]: ");
            student.setMark(scanner.nextDouble());
            scanner.nextLine();

            students[i] = student;

            System.out.println();
        }
    }

    public void add() {
        if (students != null) {
            System.out.print("How many students will you enter [must be a number]: ");
            int studentCount = scanner.nextInt();
            scanner.nextLine();
            int oldStudentsLen = students.length;
            Student[] oldStudents = students;
            students = new Student[oldStudentsLen + studentCount];
            for (int i = 0; i < students.length; i++) {
                if (i >= oldStudentsLen) {
                    Student student = new Student();

                    student.setId(i);

                    // setting full name
                    System.out.print("Full name: ");
                    student.setFullName(scanner.nextLine());

                    // setting year
                    System.out.print("Birth year [must be a number]: ");
                    student.setYear(scanner.nextInt());
                    scanner.nextLine();

                    // setting gender
                    System.out.print("Gender [m/f]: ");
                    student.setGender(scanner.nextLine().charAt(0));

                    // setting phd
                    System.out.print("Is PHD [y/n]: ");
                    char phd = scanner.nextLine().charAt(0);
                    student.setPhd(phd == 'y' || phd == 'Y');

                    // setting mark
                    System.out.print("Mark [must be a number]: ");
                    student.setMark(scanner.nextDouble());
                    scanner.nextLine();

                    students[i] = student;

                    System.out.println();
                } else {
                    students[i] = oldStudents[i];
                }
            }
        }
    }

    public void delete(int id) {
        if (students != null) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] != null && (students[i].getId() == id)) {
                    students[i] = null;
                }
            }
        }
    }

    public Student[] getStudents() {
        return students;
    }

    public Student[] oldestStudents(Student[] arr) {
        Student[] oldestArr = null;
        if (arr != null) {
            Student oldest = arr[0];
            int oldestCount = 0;
            for (Student i : arr) {
                if (i.getYear() <= oldest.getYear()) {
                    oldest = i;
                    oldestCount++;
                }
            }
            if (oldestCount != 0) {
                oldestArr = new Student[oldestCount];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i].getYear() == oldest.getYear()) {
                        oldestArr[j] = arr[i];
                        j++;
                    }
                }
            }
        }
        return oldestArr;
    }

    public Student[] youngestStudents(Student[] arr) {
        Student[] youngestArr = null;
        if (arr != null) {
            Student youngest = arr[0];
            int youngestCount = 0;
            for (Student i : arr) {
                if (i.getYear() >= youngest.getYear()) {
                    youngest = i;
                    youngestCount++;
                }
            }
            if (youngestCount != 0) {
                youngestArr = new Student[youngestCount];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i].getYear() == youngest.getYear()) {
                        youngestArr[j] = arr[i];
                        j++;
                    }
                }
            }
        }
        return youngestArr;
    }

    public Student[] femaleStudents(Student[] arr) {
        Student[] females = null;
        if (arr != null) {
            int count = 0;
            for (Student student : arr) {
                if (student != null && (student.getGender() == 'F' || student.getGender() == 'f')) {
                    count++;
                }
            }
            if (count != 0) {
                females = new Student[count];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i] != null && (arr[i].getGender() == 'F' || arr[i].getGender() == 'f')) {
                        females[j] = arr[i];
                        j++;
                    }
                }
            }
        }
        return females;
    }

    public Student[] maleStudents(Student[] arr) {
        Student[] males = null;
        if (arr != null) {
            int count = 0;
            for (Student student : arr) {
                if (student != null && (student.getGender() == 'M' || student.getGender() == 'm')) {
                    count++;
                }
            }
            if (count != 0) {
                males = new Student[count];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i] != null && (arr[i].getGender() == 'M' || arr[i].getGender() == 'm')) {
                        males[j] = arr[i];
                        j++;
                    }
                }
            }
        }
        return males;
    }

    public Student[] phdStudents(Student[] arr) {
        int count = 0;
        Student[] students = null;
        if (arr != null) {
            for (Student student : arr) {
                if (student != null && (student.isPhd())) {
                    count++;
                }
            }
            if (count != 0) {
                students = new Student[count];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i] != null && (arr[i].isPhd())) {
                        students[j] = arr[i];
                        j++;
                    }
                }
            }
        }
        return students;
    }

    public void printYoungestFemales(Student[] arr) {
        Student[] females = femaleStudents(arr);
        Student[] youngestF = youngestStudents(females);
        if (females != null) {
            for (Student f : youngestF) {
                if (f != null && (f.getGender() == 'f' || f.getGender() == 'F'))
                    System.out.println(f.info());
            }
        }
    }

    public void printOldestFemales(Student[] arr) {
        Student[] females = femaleStudents(arr);
        Student[] oldestF = oldestStudents(females);
        if (females != null) {
            for (Student f : oldestF) {
                if (f != null && (f.getGender() == 'f' || f.getGender() == 'F'))
                    System.out.println(f.info());
            }
        }
    }

    public void printYoungestMales(Student[] arr) {
        Student[] youngestM = youngestStudents(arr);
        Student[] males = maleStudents(youngestM);
        if (males != null) {
            for (Student m : males) {
                if (m != null && (m.getGender() == 'm' || m.getGender() == 'M'))
                    System.out.println(m.info());
            }
        }
    }

    public void printOldestMales(Student[] arr) {
        Student[] males = maleStudents(arr);
        Student[] oldestM = oldestStudents(males);
        if (males != null) {
            for (Student m : oldestM) {
                if (m != null && (m.getGender() == 'm' || m.getGender() == 'M'))
                    System.out.println(m.info());
            }
        }
    }

    public void printPhdFemales(Student[] arr) {
        Student[] phdF = phdStudents(arr);
        Student[] females = femaleStudents(phdF);
        if (females != null) {
            for (Student f : females) {
                if (f != null && (f.getGender() == 'f' || f.getGender() == 'F'))
                    System.out.println(f.info());
            }
        }
    }

    public void printPhdMales(Student[] arr) {
        Student[] phdM = phdStudents(arr);
        Student[] males = maleStudents(phdM);
        if (males != null) {
            for (Student m : males) {
                if (m != null && (m.getGender() == 'm' || m.getGender() == 'M'))
                    System.out.println(m.info());
            }
        }
    }

    public Student[] separateByMarks(double mark, boolean above, Student[] arr) {
        Student[] a = null;
        int studentCount = 0;
        if (arr != null) {
            if (above) {
                for (Student s : arr) {
                    if (s != null && (s.getMark() >= mark)) {
                        studentCount++;
                    }
                }
                if (studentCount > 0) {
                    a = new Student[studentCount];
                    for (int i = 0, j = 0; i < arr.length; i++) {
                        if (arr[i] != null && (arr[i].getMark() >= mark)) {
                            a[j] = arr[i];
                            j++;
                        }
                    }
                }
            } else {
                for (Student s : arr) {
                    if (s != null && (s.getMark() <= mark)) {
                        studentCount++;
                    }
                }
                if (studentCount > 0) {
                    a = new Student[studentCount];
                    for (int i = 0, j = 0; i < arr.length; i++) {
                        if (arr[i] != null && (arr[i].getMark() <= mark)) {
                            j++;
                            a[j] = arr[i];
                        }
                    }
                }
            }
        }
        return a;
    }

    public void sortByAge(Student[] arr, boolean ascending) {
        if (arr != null) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (ascending) {
                        if (arr[j] != null && arr[i] != null && (arr[j].getYear() < arr[j + 1].getYear())) {
                            Student temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    } else {
                        if (arr[j] != null && arr[i] != null && (arr[j].getYear() > arr[j + 1].getYear())) {
                            Student temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    }
                }
            }
        }
    }

    public void printStudents(Student[] arr) {
        if (arr != null) {
            for (Student i : arr) {
                if (i != null)
                    System.out.println(i.info());
            }
        }
    }
}
