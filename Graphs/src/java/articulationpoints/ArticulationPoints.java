package articulationpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoints {

    private static List<Integer>[] graph;
    private static List<Integer> points;
    private static boolean[] visited;
    private static int[] parents;
    private static int[] depths;
    private static int[] lowPoints;

    public static List<Integer> findArticulationPoints(List<Integer>[] targetGraph) {
        graph = targetGraph;
        points = new ArrayList<>();
        visited = new boolean[graph.length];
        parents = new int[graph.length];
        depths = new int[graph.length];
        lowPoints = new int[graph.length];

        Arrays.fill(parents, -1);

        articulationPoints(0, 1);

        return points;
    }

    private static void articulationPoints(int node, int depth) {
        visited[node] = true;
        depths[node] = depth;
        lowPoints[node] = depth;

        int children = 0;

        boolean isArticulationPoint = false;

        for (int child : graph[node]) {
            if (!visited[child]) {
                parents[child] = node;
                children++;
                articulationPoints(child, depth + 1);

                if (lowPoints[child] >= depth) {
                    isArticulationPoint = true;
                }
                lowPoints[node] = Math.min(lowPoints[node], lowPoints[child]);
            } else if (parents[node] != child) {
                lowPoints[node] = Math.min(lowPoints[node], depths[child]);
            }
        }
        if ((parents[node] == -1 && children > 1) || (parents[node] != -1 && isArticulationPoint)) {
            points.add(node);
        }
    }
}
