package stronglyconectedcomponents;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StronglyConnectedComponents {
    private static List<List<Integer>> stronglyConnectedComponents;
    private static Deque<Integer> stack = new ArrayDeque<>();
    private static List<Integer>[] reverseGraph;


    public static List<List<Integer>> findStronglyConnectedComponents(List<Integer>[] targetGraph) {

        boolean[] visited = new boolean[targetGraph.length];
        stronglyConnectedComponents = new ArrayList<>();

        for (int node = 0; node < targetGraph.length; node++) {
            dfs(node, targetGraph, visited);
        }
        setReversedGraph(targetGraph);

        visited = new boolean[targetGraph.length];

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited[node]) {
                stronglyConnectedComponents.add(new ArrayList<>());
                reverseDfs(node, visited);
            }
        }
        return stronglyConnectedComponents;
    }

    private static void reverseDfs(int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        stronglyConnectedComponents.get(stronglyConnectedComponents.size() - 1).add(node);

        for (int child : reverseGraph[node]) {
            reverseDfs(child, visited);
        }
    }

    @SuppressWarnings("unchecked")
    private static void setReversedGraph(List<Integer>[] graph) {
        reverseGraph = new ArrayList[graph.length];
        for (int i = 0; i < reverseGraph.length; i++) {
            reverseGraph[i] = new ArrayList<>();
        }
        for (int node = 0; node < graph.length; node++) {
            for (int child = 0; child < graph[node].size(); child++) {
                int parent = graph[node].get(child);
                reverseGraph[parent].add(node);
            }
        }
    }

    private static void dfs(int node, List<Integer>[] graph, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;

        for (int child : graph[node]) {
            dfs(child, graph, visited);
        }
        stack.push(node);
    }
}
