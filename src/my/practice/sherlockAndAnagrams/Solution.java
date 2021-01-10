package my.practice.sherlockAndAnagrams;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        Map<String, Integer> subStrMap = buildSubStrMap(s);
        int ans = getNumberOfPairs(subStrMap);
        return ans;
    }

    static int getNumberOfPairs(Map<String, Integer> map) {
        int count = 0;
        for (Integer value : map.values()) {
            count += getNumberOfPairs(value);
        }
        return count;
    }

    static int getNumberOfPairs(int count) {
        if (count == 1) return 0;
        int ans = 0;
        for (int i = count - 1; i >= 1; i--) {
            ans += i;
        }
        return ans;
    }

    static Map<String, Integer> buildSubStrMap(String s) {
        int length = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int subStrLen = i + 1;
            for (int j = 0; j < length; j++) {
                String subStr = s.substring(j, j + subStrLen);
                int count = 1;
                subStr = getSortedStr(subStr);
                if (map.containsKey(subStr)) {
                    count = map.get(subStr) + 1;
                }
                map.put(subStr, count);
                if (j + subStrLen == length) break;
            }
        }
        return map;
    }

    static String getSortedStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

