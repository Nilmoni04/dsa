class Solution {
    private Map<Long, int[]> memo;
    public int minMaxWaitingTime(int[] demand, int[] fuel) {
        this.memo = new HashMap<>();

        int[] res = dfs(0, fuel[0], fuel[1], 0, 0, 0, demand);
        if(res[0] == 0) return -1;
        return res[1];
    }
    private int[] dfs(int i, int a, int b, int f0, int f1, int r, int[] demand) {
        if(i >= demand.length) {
            return new int[]{0,0};
        }
        long key = encode(i,a,b,f0,f1,r);
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        int need=demand[i];
        int bestCount = 0;
        int bestWait = 0;

        if(a>=need) {
            int S = Math.max(r,f0);
            int wait = S-r;
            int new_a = a-need;
            int new_f0 = S+need;
            int new_f1 = Math.max(f1,S);
            int[] sub = dfs(i+1, new_a, b, new_f0, new_f1, S, demand);
            int count = 1+sub[0];
            int maxWait = Math.max(wait, sub[1]);
            if(count > bestCount || (count == bestCount && maxWait < bestWait)) {
                bestCount = count;
                bestWait = maxWait;
            }
        }
        if(b >= need) {
            int S = Math.max(r,f1);
            int wait = S-r;
            int new_b = b-need;
            int new_f1 = S+need;
            int new_f0 = Math.max(f0,S);
            int[] sub = dfs(i+1, a, new_b, new_f0, new_f1, S, demand);
            int count = 1+sub[0];
            int maxWait = Math.max(wait, sub[1]);
            if(count > bestCount || (count == bestCount && maxWait < bestWait)) {
                bestCount = count;
                bestWait = maxWait;
            }
        }
        int[] res = new int[]{bestCount,bestWait};
        memo.put(key,res);
        return res;
    }
    private long encode(int i, int a, int b, int f0, int f1, int r) {
        long key=i;
        key=key*51+a;
        key=key*51+b;
        key=key*51+f0;
        key=key*51+f1;
        key=key*51+r;

        return key;
    }
}