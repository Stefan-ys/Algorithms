package shortestpath;

import java.util.*;

public class Dijkstra {

    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {
        int[] distance = new int[graph.length];
        int[] prev = new int[graph.length];

        boolean[] visited = new boolean[graph.length];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        distance[sourceNode] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Comparator.comparing(node -> distance[node])
        );
        queue.offer(sourceNode);

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            visited[parent] = true;
            int[] children = graph[parent];

            for (int i = 0; i < children.length; i++) {
                if (children[i] != 0 && !visited[i]) {
                    queue.offer(i);

                    int newDistance = distance[parent] + graph[parent][i];

                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        prev[i] = parent;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        path.add(destinationNode);
        int n = prev[destinationNode];

        while (n != -1) {
            path.add(n);
            n = prev[n];
        }
        Collections.reverse(path);

        return path.size() == 1 ? null : path;

    }
}
