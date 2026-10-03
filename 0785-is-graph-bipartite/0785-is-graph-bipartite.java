class Solution {
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;

        int[] col = new int[V];
        Arrays.fill(col, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (col[i] != -1) {
                continue;
            }

            q.add(i);
            col[i] = 0;

            while (!q.isEmpty()) {

                int curr = q.remove();

                for (int x : graph[curr]) {

                    if (col[x] == -1) {
                        col[x] = 1 - col[curr];
                        q.add(x);
                    }
                    else if (col[x] == col[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}