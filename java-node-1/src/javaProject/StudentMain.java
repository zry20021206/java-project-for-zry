package javaProject;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentMain {
     public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();  
        while (true) {
            System.out.println("------------欢迎来到讯飞学生管理系统------------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查询学生");
            System.out.println("5.退出系统");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入你要添加的学生id：");
                    int id = scanner.nextInt();
                    System.out.println("请输入你要添加的学生姓名：");
                    String name = scanner.next();
                    System.out.println("请输入你要添加的学生年龄：");
                    int age = scanner.nextInt();
                    System.out.println("请输入你要添加的学生性别：");
                    String sex = scanner.next();
                    Student student = new Student(id,name,age,sex);
                    boolean exists = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getid() == id) {
                            exists = true;
                            System.out.println("添加失败，id重复");
                            break;
                        }
                    }
                    if (!exists) {
                        list.add(student);
                        System.out.println("添加成功");
                    }           
                    break;//break只是跳出switch
                case 2:
                    if (list.size() == 0) {
                        System.out.println("学生列表为空");
                        break;
                    }
                    System.out.println("请输入你要删除学生的id：");
                    int delid = scanner.nextInt();
                    boolean del = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getid() == delid) {
                            System.out.println("删除学生的姓名是：" + list.get(i).getname());
                            list.remove(i);
                            System.out.println("删除成功");
                            del = true;
                            break;
                        }
                    }
                    if (!del) {
                        System.out.println("删除失败，id不存在");
                    }
                    break;
                case 3:
                    System.out.println("请输入你要修改学生的id：");
                    int modifyid = scanner.nextInt();
                    boolean modify = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getid() == modifyid) {
                            System.out.println("请输入你要修改学生的姓名：");
                            String newname = scanner.next();
                            list.get(i).setname(newname);
                            System.out.println("请输入你要修改学生的年龄：");
                            int newage = scanner.nextInt();
                            list.get(i).setage(newage);
                            System.out.println("请输入你要修改学生的性别：");
                            String newsx = scanner.next();
                            list.get(i).setsex(newsx);
                            System.out.println("修改成功");
                            modify = true;
                        }
                    }
                    if (!modify) {
                        System.out.println("修改失败，id不存在");
                    }
                    break;
                case 4:
                    System.out.println("------------欢迎来到讯飞学生管理系统------------");
                    if (list.size() == 0) {
                        System.out.println("学生列表为空");
                        break;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print("学生的id是：" + list.get(i).getid() + ";");
                        System.out.print("学生的姓名是：" + list.get(i).getname() + ";");
                        System.out.print("学生的年龄是：" + list.get(i).getage() + ";");
                        System.out.println("学生的性别是：" + list.get(i).getsex());
                    }
                    break;
                case 5:
                    System.out.println("退出系统");
                    System.exit(0);//直接退出程序
                default:
                    System.out.println("输入有误，请重新输入：");
            }  
        }
    }      
}
