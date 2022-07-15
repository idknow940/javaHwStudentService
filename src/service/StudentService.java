package service;

import model.Student;

public class StudentService {
    public Student[] oldestStudent(Student[] arr) {
        Student oldest = arr[0];
        int oldestCount = 0;
        for (Student i : arr) {
            if (i.getYear() <= oldest.getYear()) {
                oldest = i;
                oldestCount++;
            }
        }
        Student[] oldestArr = null;
        if (oldestCount != 0) {
            oldestArr = new Student[oldestCount];
            oldestArr[0] = oldest;
            for (int i = 1, j = 0; i < arr.length; i++) {
                if (arr[i].getYear() == oldest.getYear()) {
                    j++;
                    oldestArr[j] = arr[i];
                }
            }
        }
        return oldestArr;
    }

    public Student[] youngestStudent(Student[] arr) {
        Student youngest = arr[0];
        int youngestCount = 0;
        for (Student i : arr) {
            if (i.getYear() >= youngest.getYear()) {
                youngest = i;
                youngestCount++;
            }
        }
        Student[] youngestArr = null;
        if (youngestCount != 0) {
            youngestArr = new Student[youngestCount];
            youngestArr[0] = youngest;
            for (int i = 1, j = 0; i < arr.length; i++) {
                if (arr[i].getYear() == youngest.getYear()) {
                    j++;
                    youngestArr[j] = arr[i];
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
        for (Student student : arr) {
            if (student != null && (student.isPhd())) {
                count++;
            }
        }
        Student[] students = null;
        if (count != 0) {
            students = new Student[count];
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (arr[i] != null && (arr[i].isPhd())) {
                    students[j] = arr[i];
                    j++;
                }
            }
        }
        return students;
    }

    public void printYoungestFemales(Student[] arr) {
        Student[] youngestF = youngestStudent(arr);
        Student[] females = femaleStudents(youngestF);
        if (females != null) {
            for (Student f : youngestF) {
                if (f != null && (f.getGender() == 'f' || f.getGender() == 'F'))
                    System.out.println(f.info());
            }
        }
    }

    public void printOldestFemales(Student[] arr) {
        Student[] oldestF = youngestStudent(arr);
        Student[] females = femaleStudents(oldestF);
        if (females != null) {
            for (Student f : oldestF) {
                if (f != null && (f.getGender() == 'f' || f.getGender() == 'F'))
                    System.out.println(f.info());
            }
        }
    }

    public void printYoungestMales(Student[] arr) {
        Student[] youngestM = youngestStudent(arr);
        Student[] males = maleStudents(youngestM);
        if (males != null) {
            for (Student m : males) {
                if (m != null && (m.getGender() == 'm' || m.getGender() == 'M'))
                    System.out.println(m.info());
            }
        }
    }

    public void printOldestMales(Student[] arr) {
        Student[] oldestM = youngestStudent(arr);
        Student[] males = maleStudents(oldestM);
        if (males != null) {
            for (Student m : males) {
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
            for (Student m : phdM) {
                if (m != null && (m.getGender() == 'm' || m.getGender() == 'M'))
                    System.out.println(m.info());
            }
        }
    }

    public Student[] seperateByMarks(double mark, boolean above, Student[] arr) {
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
                        if (arr[j] != null && arr[i] != null && (arr[j].getYear() > arr[j + 1].getYear())) {
                            Student temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                        }
                    } else {
                        if (arr[j] != null && arr[i] != null && (arr[j].getYear() < arr[j + 1].getYear())) {
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
