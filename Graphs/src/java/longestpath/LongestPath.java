package longestpath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

public class LongestPath {

    public static Integer longestPath(int[][] graph, int sourceNode, int destinationNode) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MIN_VALUE);
        distance[sourceNode] = 0;
        boolean[] visited = new boolean[graph.length];

        ArrayDeque<Integer> sorted = new ArrayDeque<>();

        for (int i = 1; i < graph.length; i++) {
            topologicalSort(i, sorted, visited, graph);
        }
        while (!sorted.isEmpty()) {
            int node = sorted.pop();
            for (int i = 1; i < graph.length; i++) {
                int weight = graph[node][i];
                if (weight != 0) {
                    if (distance[node] + weight > distance[i]) {
                        distance[i] = distance[node] + weight;
                    }
                }
            }
        }
        return distance[destinationNode];
    }

    private static void topologicalSort(int node, ArrayDeque<Integer> sorted, boolean[] visited, int[][] graph) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (int i = 1; i < graph[node].length; i++) {
            if (graph[node][i] != 0) {
                topologicalSort(i, sorted, visited, graph);
            }
        }
        sorted.push(node);
    }
}
