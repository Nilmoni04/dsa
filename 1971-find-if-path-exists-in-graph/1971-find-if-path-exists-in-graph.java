class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Build the graph as adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // Since it's an undirected graph
        }

        // Step 2: Use DFS to check if destination is reachable
        boolean[] visited = new boolean[n];
        return dfs(graph, visited, source, destination);
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int current, int destination) {
        if (current == destination) return true;
        visited[current] = true;

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, destination))
                    return true;
            }
        }

        return false;
    }
}
