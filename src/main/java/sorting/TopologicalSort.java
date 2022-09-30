package sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class TopologicalSort<T> {
    public List<T> sort(Graph<T> graph) {
        Stack<T> stack = new Stack<>();
        List<T> queue = new ArrayList<>();
        Set<T> visited = new HashSet<>();

        List<T> V = graph.getVertices();
        while(visited.size() != V.size()) {
            List<T> notVisited = getUnvisitedVertices(V, visited);
            if (!notVisited.isEmpty()) {
                stack.push(notVisited.get(0));
            }

            while (!stack.empty()) {
                T u = stack.peek();
                List<T> adjacent = graph.getAdjacentVertices(u);

                List<T> adjacentNotVisited = adjacent.stream().filter(v -> !visited.contains(v)).collect(Collectors.toList());
                if (adjacent.isEmpty() || adjacentNotVisited.isEmpty()) {
                    stack.pop();
                    queue.add(0, u);
                    visited.add(u);
                } else {
                    adjacentNotVisited.stream().forEach(stack::push);
                }
            }
        }

        return queue;
    }

    private List<T> getUnvisitedVertices(List<T> vertices, Set<T> visited) {
        return vertices.stream()
                .filter(v -> !visited.contains(v))
                .collect(Collectors.toList());
    }
}