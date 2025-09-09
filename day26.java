import java.util.*;

 class Solution {

    public boolean isCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                if (dfs(v, -1, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int current, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[current] = true;

        for (int neighbor : adj.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, current, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // Found a back edge indicating a cycle
                return true;
            }
        }
        return false;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int V1 = 5;
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 0}};
        System.out.println("Example 1: " + solution.runExample(V1, edges1)); // Output: true

        // Example 2
        int V2 = 3;
        int[][] edges2 = {{0, 1}, {1, 2}};
        System.out.println("Example 2: " + solution.runExample(V2, edges2)); // Output: false

        // Example 3
        int V3 = 4;
        int[][] edges3 = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Example 3: " + solution.runExample(V3, edges3)); // Output: true
    }

    // Helper function to build adjacency list and call isCycle
    public boolean runExample(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // because it's an undirected graph
        }
        return isCycle(V, adj);
    }
}
