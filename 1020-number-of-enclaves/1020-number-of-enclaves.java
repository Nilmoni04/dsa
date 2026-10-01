class Pair {
    int first, second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int n=grid.length, m=grid[0].length;
        int[][] vis = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 || j==0 || i==n-1 || j==m-1) {
                    if(grid[i][j] == 1 && vis[i][j] == 0) {
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for(int[] dir : directions) {
                int nrow = row+dir[0];
                int ncol = col+dir[1];
                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}