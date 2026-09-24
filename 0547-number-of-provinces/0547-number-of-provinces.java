class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(i, isConnected, vis);
                provinces++;
            }
        }
        return provinces;
    }
    public void dfs(int curr, int[][] isConnected, boolean[] vis) {
        vis[curr] = true;
        for(int i=0; i<isConnected.length; i++) {
            if(!vis[i] && isConnected[curr][i] == 1) {
                dfs(i, isConnected, vis);
            }
        }
    }
}