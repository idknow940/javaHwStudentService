package model;

public class Student {
    private int id;
    private String fullName = "John Doe";
    private int year = 2000;
    private char gender = 'm';
    private boolean isPhd = false;
    private double mark;

    public Student() {

    }

    public Student(int id, String fullName, int year, char gender, boolean isPhd, double mark) {
        this.id = id;
        if (!fullName.isEmpty()) {
            this.fullName = fullName;
        }
        if (year != 0) {
            this.year = year;
        }
        this.gender = gender;
        this.isPhd = isPhd;
        this.mark = mark;
    }

    public String info() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", year=" + year +
                ", gender='" + gender + '\'' +
                ", isPhd=" + (isPhd ? "Yes" : "No") +
                ", mark=" + mark +
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
