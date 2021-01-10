package my.practice.hourglassSum;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                int count = hourglassSum(row, col, arr);
                max = Math.max(max, count);
            }
        }
        return max;
    }

    static int hourglassSum(int row, int col, int[][] arr) {
        int sum = 0;
        sum += arr[row][col];
        sum += arr[row][col+1];
        sum += arr[row][col+2];
        sum += arr[row + 1][col+1];
        sum += arr[row + 2][col];
        sum += arr[row + 2][col+1];
        sum += arr[row + 2][col+2];
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
