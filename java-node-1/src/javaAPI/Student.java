package javaAPI;
public class Student implements Cloneable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setname(String name) {
        this.name = name;
    }
    public String getname() {
        return name;
    }
    public void setage(int age) {
        this.age = age;
    }
    public int getage() {
        return age;
    }
    @Override
    public String toString() {
        return "name:" + name + ",age:" + age;
    }
    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student s = (Student)super.clone();
        s.setname("小");
        s.setage(20);
        return s; 
    }
}
