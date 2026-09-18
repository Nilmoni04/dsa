class Solution {
    public int maximumUnits(int[][] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr,(a, b) -> b[1] - a[1]);
        int i=0,ans=0;
        while(k>0&&i<n){
            int t = Math.min(arr[i][0],k);
            k-=t;
            ans+=t*arr[i][1];
            i++;
        }
        return ans;
    }
}