package javaProject;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
    static ArrayList<User> users = new ArrayList<>();
    static {
        users.add(new User("admin", "admin", "123456789012345678", "12345678901"));
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------欢迎来到讯飞学生管理系统------------");
            System.out.println("请选择操作：");
            System.out.println("1.登录");
            System.out.println("2.注册");
            System.out.println("3.忘记密码");
            System.out.println("4.退出");
            System.out.println("请输入你的选择：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    login(users);
                    break;
                case 2:
                    rejest(users);
                    break;
                case 3:
                    forgetpassword(users);
                    break;
                case 4:
                    System.exit(0);
                default :
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }      
    }
    public static void rejest(ArrayList<User> users) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名：");
        String username = scanner.next();
        String regex = "^[a-zA-Z0-9]{3,15}$";
        boolean exists = false;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getusername().equals(username)) {
                System.out.println("用户名已存在");
                exists = true;
                return;//终止方法调用并且回到调用方法的位置
            }
        }
        if (username.matches(regex) && !exists) {
            System.out.println("用户名符合要求！");
            System.out.println("请输入你的密码：");
            String password = scanner.next();
            System.out.println("请确认你的密码：");
            String finalpassword = scanner.next();
            if (password.equals(finalpassword) && finalpassword.matches(regex)) {
                System.out.println("密码符合要求");
                System.out.println("请输入你的身份证号：");
                String ID = scanner.next();
                String regexID = "^[0-9]{17}[0-9X]$";
                if (ID.matches(regexID)) {
                    System.out.println("身份证号符合要求");
                    System.out.println("请输入你的手机号：");
                    String phonenumber = scanner.next();
                    String regexphone = "^1[3-9][0-9]{9}$";
                    if (phonenumber.matches(regexphone)) {
                        System.out.println("手机号符合要求");
                        System.out.println("注册成功");
                        User user = new User(username, password, ID, phonenumber);
                        users.add(user);
                    }
                    else {
                        System.out.println("手机号不符合要求");
                        return;
                    }
                }
                else {
                    System.out.println("身份证号不符合要求");
                    return;
                }
            }
            else {
                System.out.println("密码不符合要求");
                return;
            }
        }
        else {
            System.out.println("用户名不符合要求");
            return;
        }
    } 
    public static void login(ArrayList<User> users) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名：");
        String username = scanner.next();
        boolean exists = false;
        
        // 遍历用户列表检查用户名是否存在
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getusername().equals(username)) {
                exists = true;
                System.out.println("请输入你的密码：");
                int attempts = 0; // 密码输入尝试次数
                while (attempts < 3) {  // 最大允许3次尝试
                    String password = scanner.next();
                    if (users.get(i).getpassword().equals(password)) {
                        // 密码验证通过
                        String regexverificationcode = Verify.main();
                        System.out.println("验证码为：" + regexverificationcode);
                        int verificationAttempts = 0; // 验证码输入尝试次数
                        while (verificationAttempts < 3) {  // 最大允许3次验证码尝试
                            System.out.println("请输入验证码：");
                            String verificationcode = scanner.next();
                            if (verificationcode.equals(regexverificationcode)) {
                                System.out.println("登录成功");
                                System.out.println("欢迎回来，" + username);
                                StudentMain.main(null); // 进入学生主界面
                                return;
                            } else {
                                verificationAttempts++;  // 错误验证码，增加尝试次数
                                if (verificationAttempts < 3) {
                                    System.out.println("验证码错误，请重新输入（剩余 " + (3 - verificationAttempts) + " 次机会）：");
                                } else {
                                    System.out.println("验证码输入错误超过次数，登录失败");
                                    return;
                                }
                            }
                        }
                    } else {
                        attempts++;  // 错误密码，增加尝试次数
                        if (attempts < 3) {
                            System.out.println("密码错误，请重新输入（剩余 " + (3 - attempts) + " 次机会）：");
                        } else {
                            System.out.println("密码输入错误超过次数，登录失败");
                            return;
                        }
                    }
                }
            }
        }
        if (!exists) {
            System.out.println("用户名不存在");
            return;
        }
    }
    public static void forgetpassword(ArrayList<User> users) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的用户名：");
        String username = scanner.next();   
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getusername().equals(username)) {
                System.out.println("请输入你的身份证号：");
                String ID = scanner.next();
                if (users.get(i).getID().equals(ID)) {
                    System.out.println("请输入你的手机号：");
                    String phonenumber = scanner.next();
                    if (users.get(i).getphonenumber().equals(phonenumber)) {
                        System.out.println("请输入你的新密码：");
                        String newpassword = scanner.next();
                        users.get(i).setpassword(newpassword);
                        System.out.println("修改成功");
                        return;
                    }
                    else {
                        System.out.println("手机号错误");
                        return;
                    }
                }
                else {
                    System.out.println("身份证号错误");
                    return;
                }             
            }    
        }
        System.out.println("用户名错误");
    } 
}
