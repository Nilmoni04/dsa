class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long[] diff = new long[n+1];
        for(int[] b : boosts) {
            int l=b[0];
            int r=b[1];
            int v=b[2];
            diff[l] += v;
            diff[r+1] -= v;
        }
        long[] bonus = new long[n];
        long curr = 0;
        for(int i=0; i<n; i++) {
            curr += diff[i];
            bonus[i] = curr;
        }
        long need=0;
        for(int i=n-1; i>=0; i--) {
            long minReq = Math.max(0, monsters[i]-bonus[i]);
            if(need > 0) {
                minReq = Math.max(minReq, monsters[i]+need);
            }
            need = minReq;
        }
        return need;
    }
}