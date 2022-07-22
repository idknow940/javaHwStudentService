package model;

public class Student {
    private int id;
    private String fullName;
    private int year;
    private char gender;
    private boolean isPhd;
    private double mark;

    public Student() {
        this.fullName = "John Doe";
        this.year = 2000;
        this.gender = 'm';
        this.isPhd = false;
    }

    public Student(int id, String fullName, int year, char gender, boolean isPhd, double mark) {
        this.id = id;
        if (!fullName.isEmpty()) {
            this.fullName = fullName;
        } else {
            this.fullName = "John Doe";
        }
        if (year != 0) {
            this.year = year;
        } else {
            this.year = 2000;
        }
        this.gender = gender;
        this.isPhd = isPhd;
        this.mark = mark;
    }

    public String info() {
        return "Student{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", year=" + getYear() +
                ", gender='" + getGender() + '\'' +
                ", isPhd=" + (isPhd() ? "Yes" : "No") +
                ", mark=" + getMark() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender == 'M' || gender == 'm' ? 'm' : 'f';
    }

    public boolean isPhd() {
        return isPhd;
    }

    public void setPhd(boolean phd) {
        isPhd = phd;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
