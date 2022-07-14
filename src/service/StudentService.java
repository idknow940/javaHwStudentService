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
        int count = 0;
        for (Student student : arr) {
            if (student.getGender() == 'F' || student.getGender() == 'f') {
                count++;
            }
        }
        Student[] females = null;
        if (count != 0) {
            females = new Student[count];
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (arr[i].getGender() == 'F' || arr[i].getGender() == 'f') {
                    j++;
                    females[j] = arr[i];
                }
            }
        }
        return females;
    }

    public Student[] maleStudents(Student[] arr) {
        int count = 0;
        for (Student student : arr) {
            if (student.getGender() == 'M' || student.getGender() == 'm') {
                count++;
            }
        }
        Student[] males = null;
        if (count != 0) {
            males = new Student[count];
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (arr[i].getGender() == 'M' || arr[i].getGender() == 'm') {
                    j++;
                    males[j] = arr[i];
                }
            }
        }
        return males;
    }

    public Student[] phdStudents(Student[] arr) {
        int count = 0;
        for (Student student : arr) {
            if (student.isPhd()) {
                count++;
            }
        }
        Student[] males = null;
        if (count != 0) {
            males = new Student[count];
            for (int i = 0, j = 0; i < arr.length; i++) {
                if (arr[i].isPhd()) {
                    j++;
                    males[j] = arr[i];
                }
            }
        }
        return males;
    }

    public void printYoungestFemales(Student[] arr) {
        Student[] females = femaleStudents(arr);
        Student[] youngestF = youngestStudent(females);
        for (Student f :
                youngestF) {
            System.out.println(f);
        }
    }

    public void printOldestFemales(Student[] arr) {
        Student[] females = femaleStudents(arr);
        Student[] youngestF = youngestStudent(females);
        for (Student f :
                youngestF) {
            System.out.println(f);
        }
    }

    public void printYoungestMales(Student[] arr) {
        Student[] females = femaleStudents(arr);
        Student[] youngestF = youngestStudent(females);
        for (Student f :
                youngestF) {
            System.out.println(f);
        }
    }

    public void printOldestMales(Student[] arr) {
        Student[] males = maleStudents(arr);
        Student[] youngestM = youngestStudent(males);
        for (Student m :
                youngestM) {
            System.out.println(m);
        }
    }

    public void printPhdFemales(Student[] arr) {
        Student[] females = femaleStudents(arr);
        Student[] phdF = phdStudents(females);
        for (Student f :
                phdF) {
            System.out.println(f);
        }
    }

    public void printPhdMales(Student[] arr) {
        Student[] males = maleStudents(arr);
        Student[] phdM = phdStudents(males);
        for (Student m :
                phdM) {
            System.out.println(m);
        }
    }

    public Student[] seperateByMarks(double mark, boolean above, Student[] arr) {
        Student[] a = null;
        int studentCount = 0;
        if (above) {
            for (Student s :
                    arr) {
                if (s.getMark() >= mark) {
                    studentCount++;
                }
            }
            if (studentCount > 0) {
                a = new Student[studentCount];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i].getMark() >= mark) {
                        j++;
                        a[j] = arr[i];
                    }
                }
            }
        } else {
            for (Student s :
                    arr) {
                if (s.getMark() <= mark) {
                    studentCount++;
                }
            }
            if (studentCount > 0) {
                a = new Student[studentCount];
                for (int i = 0, j = 0; i < arr.length; i++) {
                    if (arr[i].getMark() <= mark) {
                        j++;
                        a[j] = arr[i];
                    }
                }
            }
        }
        return a;
    }

    public void sortByAge(Student[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (ascending){
                    if (arr[j].getYear() < arr[j + 1].getYear()) {
                        Student temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j].getYear() > arr[j + 1].getYear()) {
                        Student temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
    public void printStudents(Student[] arr){
        for (Student i:
                arr) {
            System.out.println(i.info());
        }
    }
}
