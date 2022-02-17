import junit.framework.TestCase;
import org.junit.Assert;
import shortestpath.ShortestPathBFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPathBFSTest extends TestCase {
    private static ShortestPathBFS shortestPathBFS = new ShortestPathBFS();

    private Map<Character, List<Character>> createGraph() {
        Map<Character, List<Character>> graph = new HashMap<>();

        graph.put('A', List.of('B', 'C', 'D'));
        graph.put('B', List.of('C'));
        graph.put('C', List.of('E', 'G'));
        graph.put('D', List.of('J'));
        graph.put('E', List.of('F'));
        graph.put('F', List.of('H'));
        graph.put('G', List.of('I'));
        graph.put('H', List.of('K'));
        graph.put('I', List.of('K'));
        graph.put('J', List.of('K'));
        graph.put('K', List.of());

        return graph;
    }

    public void testShortestPathBfs() {
        Map<Character, List<Character>> graph = createGraph();
        List<Character> path = shortestPathBFS.shortestPathBfs(graph, 'A', 'K');
        char[] expectedResult = {'A', 'D', 'J', 'K'};
        Assert.assertEquals(expectedResult.length, path.size());
        for (int i = 0; i < expectedResult.length; i++) {
            char c = path.get(i);
            Assert.assertEquals(expectedResult[i], c);
        }

    }
}