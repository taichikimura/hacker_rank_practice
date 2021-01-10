package my.practice.minimumBribes;

import java.util.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        Set<Integer> set = new HashSet<>();
        int expected = 1;
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            int actual = q[i];
            set.add(actual);
            if (expected == actual) {
                expected = getNextExpected(set, expected);
                continue;
            }
            int orgPos = actual - 1;
            int diff = orgPos - i;
            if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }
            bribes += 1;
            if (diff == 2) {
                bribes += 1;
            }
        }
        System.out.println(bribes);
    }

    static int getNextExpected(Set<Integer> set, int currentExpected) {
        int nextExpected = currentExpected + 1;
        while (true) {
            if (!set.contains(nextExpected)) {
                break;
            }
            nextExpected += 1;
        }
        return nextExpected;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
