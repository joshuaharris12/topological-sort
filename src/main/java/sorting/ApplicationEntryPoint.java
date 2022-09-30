package sorting;

import java.util.List;

public class ApplicationEntryPoint {

    public static void main(String[] args) {
        TopologicalSort<String> topologicalSort = new TopologicalSort<>();
        Graph graph = new Graph();

        graph.addVertex("underwear");
        graph.addVertex("trousers");
        graph.addVertex("belt");
        graph.addVertex("shoes");
        graph.addVertex("shirt");
        graph.addVertex("jacket");
        graph.addVertex("socks");
        graph.addVertex("watch");
        graph.addVertex("tie");

        graph.addEdge("underwear", "trousers");
        graph.addEdge("underwear", "shoes");
        graph.addEdge("trousers", "shoes");
        graph.addEdge("trousers", "belt");
        graph.addEdge("belt", "jacket");
        graph.addEdge("tie", "jacket");
        graph.addEdge("shirt", "belt");
        graph.addEdge("shirt", "tie");
        graph.addEdge("socks", "shoes");

        List<String> sortedVertices = topologicalSort.sort(graph);
        sortedVertices.stream().forEach(System.out::println);
    }
}
