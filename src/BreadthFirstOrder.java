import java.util.*;

public class BreadthFirstOrder {
    private Set<Integer> visited;
    private Queue<Integer> queue;

    public BreadthFirstOrder(Map<Integer, List<Integer>> graph) {
        visited = new HashSet<>();
        queue = new LinkedList<>();

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                bfs(graph, node);
            }
        }
    }

    private void bfs(Map<Integer, List<Integer>> graph, int node) {
        visited.add(node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Collections.singletonList(4));
        graph.put(3, Collections.singletonList(4));
        graph.put(4, Collections.emptyList());

        BreadthFirstOrder bfsOrder = new BreadthFirstOrder(graph);
        System.out.println("BFS Order:");
    }
}