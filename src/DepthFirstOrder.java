import java.util.*;

public class DepthFirstOrder {
    private Set<Integer> visited;
    private Stack<Integer> stack;

    public DepthFirstOrder(Map<Integer, List<Integer>> graph) {
        visited = new HashSet<>();
        stack = new Stack<>();

        for (int node : graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(graph, node);
            }
        }
    }

    private void dfs(Map<Integer, List<Integer>> graph, int node) {
        visited.add(node);

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(graph, neighbor);
            }
        }

        stack.push(node);
    }

    public List<Integer> getOrder() {
        List<Integer> order = new ArrayList<>();
        while (!stack.isEmpty()) {
            order.add(stack.pop());
        }
        return order;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Collections.singletonList(4));
        graph.put(3, Collections.singletonList(4));
        graph.put(4, Collections.emptyList());

        DepthFirstOrder dfsOrder = new DepthFirstOrder(graph);
        List<Integer> order = dfsOrder.getOrder();
        System.out.println("DFS Order: " + order);
    }
}