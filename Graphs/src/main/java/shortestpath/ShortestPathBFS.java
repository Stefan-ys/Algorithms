package shortestpath;

import java.util.*;

public class ShortestPathBFS<E> {
    private List<E> path;


    public List<E> shortestPathBfs(Map<E, List<E>> graph, E startNode, E endNode) {
        path = new ArrayList<>();
        List<E> tmp = new ArrayList<>();


        shortestPathSearchDFS(startNode, endNode, graph, tmp);

        return path;
    }

    private void shortestPathSearchDFS(E currentNode, E endNode, Map<E, List<E>> graph, List<E> tmp) {
        tmp.add(currentNode);
        if (currentNode.equals(endNode)) {
            if (tmp.size() < path.size() || path.size() == 0) {
                path = List.copyOf(tmp);
            }
            return;
        }
        for (E child : graph.get(currentNode)) {
            shortestPathSearchDFS(child, endNode, graph, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
