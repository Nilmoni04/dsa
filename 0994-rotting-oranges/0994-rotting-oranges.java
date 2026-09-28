class Solution {
    static boolean isSafe(int i, int j, int n, int m) {
        return (i>=0 && j>=0 && i<n && j<m);
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            boolean flag = false;
            for(int i=0; i<size; i++) {
                int[] cell = q.poll();
                int x=cell[0], y=cell[1];

                for(int[] dir : directions) {
                    int nx = x+dir[0];
                    int ny = y+dir[1];

                    if(isSafe(nx,ny,n,m) && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        q.add(new int[]{nx,ny});
                        flag = true;
                    }
                }
            }
            if(flag) time++;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return time;
    }
}