class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;

        int[][] ans = new int[n][m];
        for(int i=0; i<n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] front = q.remove();
                int x = front[0];
                int y = front[1];

                for(int[] dir : directions) {
                    int nx = x+dir[0];
                    int ny = y+dir[1];

                    if(nx>=0 && ny>=0 && nx<n && ny<m && ans[nx][ny] == Integer.MAX_VALUE) {
                        ans[nx][ny] = ans[x][y]+1;
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return ans;
    }
}