package javaProject;

public class Student {
    private int id;
    private String name;
    private int age;
    private String sex;
    public Student(){}
    public Student(int id, String name, int age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public int getid() {
        return id;
    }
    public String getname() {
        return name;
    }
    
    public int getage() {
        return age;
    }
    public String getsex() {
        return sex;
    }
    public void setid(int id) {
        this.id = id;
    }
    public void setname(String name) {
        this.name = name;
    }
    public void setsex(String sex) {
        this.sex = sex;
    }
    public void setage(int age) {
        this.age = age;
    }
    
}
