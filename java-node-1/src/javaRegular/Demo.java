package javaRegular;
public class Demo {
    public static void main(String[] args) {
        String string = "abcdefg";
        String regex = ".*abc.*";
        String regex1 = "abc";
        String regex2 = "d";
        System.out.println(string.matches(regex));
        String string1 = string.replaceAll(regex1, "123");
        System.out.println(string1);
        String array[] = string.split(regex2);
        for (int n = 0; n < array.length; n++) {
            System.out.println(array[n]);
        }
    }
}

