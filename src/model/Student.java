package model;

public class Student {
    private String fullName;
    private int year;
    private char gender;
    private boolean isPhd;
    private double mark;

    public String info() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", year=" + year +
                ", gender='" + gender + '\'' +
                ", isPhd=" + (isPhd ? "Yes" : "No") +
                ", mark=" + mark +
                '}';
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
        this.gender = gender;
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
