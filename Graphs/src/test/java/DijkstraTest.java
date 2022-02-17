import junit.framework.TestCase;
import org.junit.Test;
import shortestpath.Dijkstra;

import java.util.List;

public class DijkstraTest extends TestCase {
    private static final int[][] GRAPH = {
            {0, 0, 5, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {5, 0, 0, 3, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 2},
            {0, 0, 0, 0, 2, 0}
    };

    @Test
    public void testDijkstraAlgorithm() {
        List<Integer> result = Dijkstra.dijkstraAlgorithm(GRAPH, 0, GRAPH.length - 1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}