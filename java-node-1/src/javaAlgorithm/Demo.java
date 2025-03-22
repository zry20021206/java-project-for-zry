package javaAlgorithm;
public class Demo {
    public static void main(String[] args) {
        System.out.println(multiply(5));
    }
    public static int multiply(int num) {
        if (num == 1) {
            return 1;
        }
        return num * multiply(num - 1);
    }
}
