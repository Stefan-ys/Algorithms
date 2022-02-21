package shortestpath;

import java.util.*;

public class BellmanFord {

    public static List<Integer> bellmanFord(int[][] graph, int sourceNode, int destinationNode) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] prev = new int[graph.length];
        Arrays.fill(prev, -1);

        distance[sourceNode] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            for (int row = 1; row < graph.length; row++) {
                for (int col = 0; col < graph[row].length; col++) {
                    int weight = graph[row][col];
                    if (weight != 0) {
                        int source = row;
                        int destination = col;
                        if (distance[source] != Integer.MAX_VALUE) {
                            int newValue = distance[source] + weight;
                            if (newValue < distance[destination]) {
                                distance[destination] = newValue;
                                prev[destination] = source;
                            }
                        }
                    }
                }
            }
        }
        for (int row = 0; row < graph.length; row++) {
            for (int col = 1; col < graph[row].length; col++) {
                int weight = graph[row][col];
                if (weight != 0) {
                    int source = row;
                    int destination = col;
                    if (distance[source] != Integer.MAX_VALUE) {
                        int newValue = distance[source] + weight;
                        if (newValue < distance[destination]) {
                            throw new IllegalStateException("Negative Cycle");
                        }
                    }
                }
            }
        }
        List<Integer> path = new ArrayList<>();

        path.add(destinationNode);
        int node = prev[destinationNode];

        while (node != -1) {
            path.add(node);
            node = prev[node];
        }
        Collections.reverse(path);

        return path;

    }
}
