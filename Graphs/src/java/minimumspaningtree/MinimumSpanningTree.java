package minimumspaningtree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumSpanningTree {

    public List<Edge> kruskalAlgorithm(int numberOfVertices, List<Edge> edges) {
        Collections.sort(edges);

        List<Edge> forest = new ArrayList<>();

        int[] parents = new int[numberOfVertices];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        while (!edges.isEmpty()) {
            Edge edge = edges.remove(0);

            int source = edge.getStartNode();
            int destination = edge.getEndNode();

            int firstRoot = findRoot(source, parents);
            int secondRoot = findRoot(destination, parents);

            if (firstRoot != secondRoot) {
                forest.add(edge);
                parents[firstRoot] = secondRoot;
            }
        }
        return forest;
    }

    private int findRoot(int node, int[] parents) {

        while (parents[node] != node) {
            node = parents[node];
        }
        return node;
    }


}
