package my.practice.substrCount;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count = 0;
        for (int i = 0; i < n; i++) {
            Character ch = null;
            int diffCount = 0;
            for (int j = i + 1; j <= n; j++) {
                String subStr = s.substring(i, j);
                if (ch == null) {
                    ch = subStr.charAt(0);
                }
                boolean isSpecial = isSpecialString(subStr);
                if (isSpecial) {
                    count++;
                }
                char lastChar = subStr.charAt(subStr.length() - 1);
                if (lastChar != ch) {
                    diffCount++;
                    if (diffCount > 2) {
                        break;
                    }
                }
            }
        }
        return count;
    }

    static boolean isSpecialString(String s) {

        int len = s.length();
        int halfLen = len / 2;
        String first = s.substring(0, halfLen);
        if (!allSameChar(first)) {
            return false;
        }
        int halfStartPos = halfLen;
        if (len % 2 == 1) {
            halfStartPos += 1;
        }
        String second = s.substring(halfStartPos, len);
        if (!first.equals(second)) {
            return false;
        }
        return true;
    }

    static boolean allSameChar(String s) {
        if (s.length() == 1) return true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
