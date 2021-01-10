package my.practice.isValid;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 1;
            if (map.containsKey(c)) {
                count = map.get(c) + 1;
            }
            map.put(c, count);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        boolean isValid = isValid(1, min, max, map);
        if (isValid) return "YES";

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                map.remove(entry.getKey());
                break;
            }
        }

        isValid = isValid(0, min, max, map);
        if (isValid) return "YES";
        return "NO";
    }

    static boolean isValid(int tolerance, int min, int max, Map<Character, Integer> map ) {
        int diffToMax = 0;
        int diffToMin = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            diffToMax += max - value;
            diffToMin += value - min;
        }
        if (diffToMax <= tolerance || diffToMin <= tolerance) {
            return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
