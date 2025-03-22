package javaLeetcode;
import java.util.Arrays;
public class exercise4 {
    public int largestInteger(int[] nums, int k) {
        int sum = nums.length - k + 1;
        int array1[] = new int[51];
        int array[][] = new int[sum][k];
        if (nums.length == k) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        else {
            for (int i = 0; i < sum; i++) {
            for (int j = 0; j < k; j++) {
                array[i][j] = nums[i + j];
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array1[array[i][j]]++;
            }
        }
        int max = -1;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 1 && i > max) {
                max = i;
            }
        }
        return max;
        }        
    }
}
