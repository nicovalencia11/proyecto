import java.util.*;

public class TopologicalSort {
    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // Inicializar el grado de entrada (inDegree) para cada nodo
        for (int node : graph.keySet()) {
            inDegree.put(node, 0);
        }

        // Calcular el grado de entrada para cada nodo
        for (List<Integer> neighbors : graph.values()) {
            for (int neighbor : neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // Inicializar la cola con los nodos de grado de entrada cero
        for (int node : graph.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.add(node);
            }
        }

        // Procesar nodos en orden topológico
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Collections.singletonList(4));
        graph.put(3, Collections.singletonList(4));
        graph.put(4, Collections.emptyList());

        List<Integer> result = topologicalSort(graph);
        System.out.println("Orden topológico: " + result);
    }
}