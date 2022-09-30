package sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import sorting.Pair;

public class Graph<T> {
    private Set<Pair<T>> edges;
    private Set<T> vertices;

    public Graph() {
        this.edges = new HashSet<>();
        this.vertices = new HashSet<>();
    }

    public void addEdge(T fromEdge, T toEdge) {
        this.edges.add(new Pair(fromEdge, toEdge));
    }

    public void addVertex(T toAdd) {
        this.vertices.add(toAdd);
    }

    public List<T> getVertices() {
        return this.vertices.stream().collect(Collectors.toList());
    }

    public List<T> getAdjacentVertices(T vertex) {
        Set<Pair<T>> edgesFromVertex = this.edges.stream()
                .filter(v -> v.getFirst().equals(vertex))
                .collect(Collectors.toSet());

        return edgesFromVertex.stream()
                .map(e -> e.getSecond())
                .collect(Collectors.toList());
    }
}