package javaStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class Demo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张三，24", "李四，25", "王五，26");
        List<Student> liststudent = list.stream().map(Student :: new).collect(Collectors.toList());
        for (Student student : liststudent) {
            System.out.println(student.getname() + " " + student.getage());
        }
    }
}

class Student {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student(String str) {
        this.name = str.split("，")[0];
        this.age = Integer.parseInt(str.split("，")[1]);
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


