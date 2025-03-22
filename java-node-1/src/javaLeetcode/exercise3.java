package javaLeetcode;

public class exercise3 {
    static int count = 0; // 记录合法方案数

    public static int countPossibleArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int[] diff = new int[n];

        for (int i = 1; i < n; i++) {
            diff[i] = original[i] - original[i - 1];
        }

        for (int first = bounds[0][0]; first <= bounds[0][1]; first++) {
            dfs(1, first, original, bounds, diff);
        }
        System.out.println(count);
        return count;
    }


    private static void dfs(int index, int first, int[] original, int[][] bounds, int[] diff) {
        if (index == original.length) {
            count++;
            return;
        }

        int currentValue = first + diff[index];

        if (currentValue >= bounds[index][0] && currentValue <= bounds[index][1]) {
            dfs(index + 1, currentValue, original, bounds, diff);
        }
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int[][] bounds = {{1, 10}, {2, 9}, {3, 8}, {4, 7}};
        System.out.println(countPossibleArrays(original, bounds));
    }
}

