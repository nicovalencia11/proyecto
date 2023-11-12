import java.util.*;

public class LevelOrderSort {
    public static Map<Integer, Integer> levelOrderSort(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> inDegree = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> levels = new HashMap<>();
        int level = 0;

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
                levels.put(node, level);
            }
        }

        // Procesar nodos por niveles
        while (!queue.isEmpty()) {
            int node = queue.poll();
            level = levels.get(node) + 1;

            for (int neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);

                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                    levels.put(neighbor, level);
                }
            }
        }

        return levels;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Collections.singletonList(4));
        graph.put(3, Collections.singletonList(4));
        graph.put(4, Collections.emptyList());

        Map<Integer, Integer> result = levelOrderSort(graph);
        System.out.println("Niveles: " + result);
    }
}