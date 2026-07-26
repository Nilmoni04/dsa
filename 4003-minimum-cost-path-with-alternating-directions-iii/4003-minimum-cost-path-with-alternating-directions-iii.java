import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long minCost(int m, int n, int[][] penalty) {
        long max = Long.MAX_VALUE;
        long dp[][][] = new long[m][n][2];
        for(var x : dp){
            for(var y : x){
                Arrays.fill(y, max);
            }
        }

        var que = new PriorityQueue<Node>((a,b) -> Long.compare(a.cost, b.cost));

        dp[0][0][1] = 1l;
        que.offer(new Node(0, 0, 1, 1l));

        int dr[] = new int[]{0, 1, 0, -1};
        int dc[] = new int[]{1, 0, -1, 0};

        while(!que.isEmpty()){
            var next = que.poll();
            var i = next.i;
            var j = next.j;
            var parity = next.parity;
            var cost = next.cost;

            if(cost > dp[i][j][parity])
                continue;

            if(i == m - 1 && j == n - 1){
                return cost;
            }

            long wait = cost + penalty[i][j];

            var nparity = (parity + 1) % 2;

            if(wait < dp[i][j][nparity]){
                dp[i][j][nparity] = wait;
                que.offer(new Node(i, j, nparity, wait));
            }

            for(int d = 0; d < 4; d++){
                int ni = i + dr[d];
                int nj = j + dc[d];
                if(ni >= 0 && ni < m && nj >= 0 && nj < n){
                    boolean flag = (parity == 1) ? (d == 0 || d == 1) : (d == 2 || d == 3);
                    long ncost = 1l * (ni + 1) * (nj + 1) + (flag ? 0 : penalty[i][j]);

                    ncost += cost;
                    if(ncost < dp[ni][nj][nparity]){
                        dp[ni][nj][nparity] = ncost;
                        que.offer(new Node(ni, nj, nparity, ncost));
                    }
                }
            }
        }

        return -1;
    }

    class Node{
        int i;
        int j;
        int parity;
        long cost;

        public Node(int i, int j, int parity, long cost){
            this.i = i;
            this.j = j;
            this.parity = parity;
            this.cost = cost;
        }
    }
}