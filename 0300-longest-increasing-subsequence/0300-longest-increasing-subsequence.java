class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        int arr[] = new int[set.size()];
        int i=0;
        for(int n : set) {
            arr[i]=n;
            i++;
        }

        Arrays.sort(arr);
        return lcs(nums, arr);
    }
    public static int lcs(int nums[], int arr[]) {
        int n=nums.length;
        int m=arr.length;
        int dp[][] = new int[n+1][m+1];

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                if(nums[i-1] == arr[j-1]) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}