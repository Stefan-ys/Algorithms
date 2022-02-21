package graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrix<E> {
    int[][] adjMatrix;
    Map<String, Integer> nodeTable = new HashMap<>();


    public int[][] AdjacencyMatrix(List<String> input, int nodes) {
        //INPUT FORM ->   (E node) <-> (E node) - (int weight)
        adjMatrix = new int[nodes][nodes];
        int nodeIndex = 0;
        nodeTable = new HashMap<>();
        for (String s : input) {
            String[] inputArr = s.split("\\s+");
            String from = inputArr[0];
            String to = inputArr[2];
            int weight = Integer.parseInt(inputArr[4]);

            if (!nodeTable.containsKey(from)) {
                nodeTable.put(from, nodeIndex++);
            }
            if (!nodeTable.containsKey(to)) {
                nodeTable.put(to, nodeIndex++);
            }
            adjMatrix[nodeTable.get(from)][nodeTable.get(to)] = weight;
            adjMatrix[nodeTable.get(to)][nodeTable.get(from)] = weight;
        }

        return adjMatrix;
    }

}
