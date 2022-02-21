package minimumspaningtree;

public class Edge<E> implements Comparable<Edge> {
    private E value;
    private int startNode;
    private int endNode;
    private int weight;

    public Edge(E value, int startNode, int endNode, int weight) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.weight = weight;
    }

    public E getValue() {
        return value;
    }

    public Edge<E> setValue(E value) {
        this.value = value;
        return this;
    }

    public int getStartNode() {
        return startNode;
    }

    public Edge<E> setStartNode(int startNode) {
        this.startNode = startNode;
        return this;
    }

    public int getEndNode() {
        return endNode;
    }

    public Edge<E> setEndNode(int endNode) {
        this.endNode = endNode;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Edge<E> setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.getWeight());
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startNode=" + startNode +
                ", endNode=" + endNode +
                ", weight=" + weight +
                '}';
    }
}
