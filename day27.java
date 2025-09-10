import java.util.*;

 class Solution {

    public int shortestPath(int V, List<List<Integer>> adj, int start, int end) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[V];

        Arrays.fill(distance, -1); // Initialize distances as -1 (unreachable)

        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == end) {
                return distance[node]; // Found the destination
            }

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        return -1; // If end is not reachable
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int V1 = 5;
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}};
        System.out.println("Example 1: " + solution.runExample(V1, edges1, 0, 4)); // Output: 3

        // Example 2
        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}};
        System.out.println("Example 2: " + solution.runExample(V2, edges2, 0, 2)); // Output: 2

        // Example 3
        int V3 = 4;
        int[][] edges3 = {{0, 1}, {1, 2}};
        System.out.println("Example 3: " + solution.runExample(V3, edges3, 2, 3)); // Output: -1
    }

    // Helper function to build adjacency list and call shortestPath
    public int runExample(int V, int[][] edges, int start, int end) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // undirected graph
        }
        return shortestPath(V, adj, start, end);
    }
}
