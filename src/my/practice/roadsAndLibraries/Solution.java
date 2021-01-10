package my.practice.roadsAndLibraries;

import java.io.*;
import java.util.*;

public class Solution {

    static class Vertex {
        int id;
        int color = -1;
        List<Integer> vertices = new ArrayList<>();
        public Vertex(int id) {
            this.id = id;
        }
    }

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        Vertex[] vertices = buildVertices(n, cities);
        long minCost = 0;
        List<Integer> noOfVertices = getNoOfVertices(vertices);
        for (Integer vertexCount : noOfVertices) {
            long cost1 = c_road * (vertexCount - 1) + c_lib;
            long cost2 = c_lib * vertexCount;
            minCost += Math.min(cost1, cost2);
        }
        return minCost;
    }

    static Vertex[] buildVertices(int n, int[][] cities) {
        Vertex[] vertices = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < cities.length; i++) {
            int id1 = cities[i][0] - 1;
            int id2 = cities[i][1] - 1;
            vertices[id1].vertices.add(id2);
            vertices[id2].vertices.add(id1);
        }
        return vertices;
    }

    static List<Integer> getNoOfVertices(Vertex[] vertices) {
        List<Integer> noOfVertices = new ArrayList<>();
        int color = 0;
        for (Vertex vertex : vertices) {
            if (vertex.color == -1) {
                int count = getNoOfVertices(vertex, vertices, color);
                noOfVertices.add(count);
                color++;
            }
        }
        return noOfVertices;
    }

    static int getNoOfVertices(Vertex vertex, Vertex[] vertices, int color) {
        List<Integer> ids = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex.id);
        while (!stack.empty()) {
            int id = stack.pop();
            if (vertices[id].color != -1) {
                continue;
            }
            vertices[id].color = color;
            ids.add(id);
            for (int nId : vertices[id].vertices) {
                if (vertices[nId].color == -1) {
                    stack.push(nId);
                }
            }
        }
        return ids.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
