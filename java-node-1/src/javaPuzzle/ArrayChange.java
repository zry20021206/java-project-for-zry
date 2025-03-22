package javaPuzzle;
import java.util.Random;
public class ArrayChange {
    public static int[] change(int array[]) {
        Random rm = new Random();
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = rm.nextInt(array.length);
            array[i] = array[j];
            array[j] = temp;
        }
        return array;   
    }
}
