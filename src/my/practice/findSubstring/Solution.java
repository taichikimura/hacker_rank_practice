package my.practice.findSubstring;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


class Result {

    /*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String findSubstring(String s, int k) {

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        String subStr = s.substring(0, k);
        int vowelCount = getVowelCount(set, subStr.toCharArray());
        char first = subStr.charAt(0);
        int max = vowelCount;
        String ans = "Not found!";
        if (vowelCount > 0) {
            ans = subStr;
        }

        for (int i = 1; i <= s.length() - k; i++) {
            subStr = s.substring(i, k + i);
            char last = subStr.charAt(subStr.length() - 1);
            if (set.contains(last) && !set.contains(first)) {
                vowelCount++;
            } else if (!set.contains(last) && set.contains(first)) {
                vowelCount--;
            }
            first = subStr.charAt(0);
//          System.out.println(subStr + " " + vowelCount);
            if (vowelCount > max) {
                max = vowelCount;
                ans = subStr;
            }
        }
//      System.out.println(ans);
        return ans;
    }

    static int getVowelCount(Set<Character> set, char[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                count++;
            }
        }
        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.findSubstring(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
