package my.practice.longestSubarray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'longestSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestSubarray(List<Integer> arr) {
        int ans = 1;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            int len = 1;
            int start = arr.get(i);
            Integer target = null;
            for (int j = i + 1; j < size; j++) {
                int next = arr.get(j);
                if (Math.abs(start - next) > 1) break;
                if (start == next) {
                    len++;
                    continue;
                }
                if (target == null) {
                    target = next;
                    len++;
                    continue;
                }
                if (next != target) break;
                len++;
            }
            if (len > ans) {
                ans = len;
            }
        }
        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.longestSubarray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
