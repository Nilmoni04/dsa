class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long count1 = 0, count2=0, swaps=0;
        long MOD = 1000000007;

        for(int num : nums) {
            if(num < a) {
                swaps = (swaps+count1+count2)%MOD;
            }
            else if(num <= b) {
                swaps = (swaps+count2)%MOD;
                count1++;
            } else {
                count2++;
            }
        }
        return (int) swaps;
    }
}