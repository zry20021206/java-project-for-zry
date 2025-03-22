package javaLeetcode;
import java.util.ArrayList;
import java.util.Arrays;
public class exercise2 {
    public static void main(String[] args) {
        int array[][] = {{1,2},{3,4}};
        int limits[] = {1,2};
        int k = 2;
        System.out.println(arraymax(k,array,limits));
    }
    public static long arraymax(int k, int array[][],int limits[]) {
    
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            Arrays.sort(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            int limit = Math.min(limits[i], array[i].length);
            for (int j = array[i].length - limit; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        long sum = 0;
        int array1[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array1[i] = list.get(i);
        }
        Arrays.sort(array1);
        for (int i = array1.length - k; i < array1.length; i++) {
            sum = sum + array1[i];
        }
        return sum;
    }
}
