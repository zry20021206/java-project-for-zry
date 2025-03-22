package javaPuzzle;

import java.util.Random;

public class CodeUtil {
    public static String getCode() {
        String string = change(randomString());
        return string;
    }
   public static String randomString() {
        char array[] = new char[52];
        for (int i = 0; i < array.length; i++) {
            if (i <= 25) {
                array[i] = (char)(97 + i); 
            }
            else {
                array[i] = (char)(65 + i - 26);
            }      
        }
        Random rm = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(array[rm.nextInt(52)]);
        }
        char num = (char)('0' + rm.nextInt(10));
        sb.append(num);
        String string = sb.toString();
        return string;
    }
    public static String change(String string) {
        Random rm = new Random();
        char array[] = new char[string.length()];
        for (int j = 0; j < string.length(); j++) {
            array[j] = string.charAt(j);
        }
        for (int k = 0; k < string.length(); k++) {
            int i = rm.nextInt(string.length() - 1);
            char c = array[k];
            array[k] = array[i];
            array[i] = c;
        }
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < string.length(); n++) {
            sb.append(array[n]);
        }
        String string1 = sb.toString();
        return string1;
    }
}
