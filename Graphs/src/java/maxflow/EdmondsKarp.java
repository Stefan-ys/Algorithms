package maxflow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class EdmondsKarp {
    private static int[][] graph;
    private static int[] parents;

    public static int findMaxFlow(int[][] targetGraph) {
        graph = targetGraph;
        parents = new int[graph.length];
        int maxFlow = 0;

        while (bfs()) {
            int node = graph.length - 1;
            int flow = Integer.MAX_VALUE;
            while (node != 0) {
                flow = Math.min(flow, graph[parents[node]][node]);
                node = parents[node];
            }
            maxFlow += flow;

            node = graph.length - 1;

            while (node != 0) {
                graph[parents[node]][node] -= flow;
                graph[node][parents[node]] += flow;
                node = parents[node];
            }
        }
        return maxFlow;
    }

    private static boolean bfs() {
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(parents, -1);

        deque.offer(0);
        visited[0] = true;

        while (!deque.isEmpty()) {
            int node = deque.poll();
            for (int child = 0; child < graph.length; child++) {
                if (graph[node][child] > 0 && !visited[child]) {
                    visited[child] = true;
                    parents[child] = node;
                    deque.offer(child);
                }
            }
        }
        return visited[visited.length - 1];
    }
}
