class Solution {
    public int uniqueXorTriplets(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums) set.add(num);
        ArrayList<Integer> arr=new ArrayList<>(set);
        int maxXor=(int)Math.pow(2,11);
        boolean[][] dp=new boolean[4][maxXor];
        dp[0][0]=true;
        for(Integer it:arr) for(int i=3;i>0;i--) for(int j=0;j<maxXor;j++) if(dp[i-1][j]) dp[i][j^it]=true;
        for(int i=0;i<maxXor;i++) if(dp[3][i]) set.add(i);
        return set.size();
    }
}