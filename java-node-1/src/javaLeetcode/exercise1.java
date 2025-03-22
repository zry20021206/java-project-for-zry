package javaLeetcode;

import java.util.Scanner;

public class exercise1 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String string = sc.next();
        int operation = string.length()-2;
        while(operation > 0) {
            string = change(string);
            operation--;
        }
        if (string.charAt(0) == string.charAt(1)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
    public static String change(String string) {
        int array[] = new int[string.length()];
        int array1[] = new int[string.length() - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            array[i] = (int)string.charAt(i) - '0';
        }
        for (int i = 0; i < string.length() - 1; i++) {
            array1[i] = (array[i] + array[i+1]) % 10;
        }
        for (int i = 0; i < string.length() - 1; i++) {
            sb.append(array1[i]);
        }
        String string1 = sb.toString();
        return string1;
    }
}
