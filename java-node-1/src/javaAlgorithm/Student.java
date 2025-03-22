package javaAlgorithm;

public class Student {
    private String name;
    private int age;
    private int height;
    public Student(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public void setheight(int height) {
        this.height = height;
    }
    public int getheight() {
        return height;
    }
    public void setage(int age) {
        this.age = age;
    }
    public int getage() {
        return age;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }

}
