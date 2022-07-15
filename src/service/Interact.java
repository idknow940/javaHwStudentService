package service;

import model.Student;

import java.util.Scanner;

public class Interact {
    Scanner s = new Scanner(System.in);

    public Student[] run() {
        System.out.println("enter the total number of students");
        int numOfStudents = s.nextInt();
        s.nextLine();
        Student[] students = new Student[numOfStudents];
        for (int i = 0; i < numOfStudents; i++) {
            Student st = new Student();
            System.out.print("FullName: ");
            st.setFullName(s.nextLine());
            System.out.print("Year Of Birth");
            st.setYear(s.nextInt());
            s.nextLine();
            System.out.print("Gender [m/f]");
            st.setGender(s.nextLine().charAt(0));
            System.out.print("PHD [y/n]");
            st.setPhd(s.nextLine().charAt(0) == 'y' || s.nextLine().charAt(0) == 'Y');
            System.out.print("Mark");
            st.setMark(s.nextDouble());
            s.nextLine();
            students[i] = st;
            System.out.println();
        }
        return students;
    }
}