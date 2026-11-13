class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] diffArray = new int[n];
        int totalDiffSum = 0;
        long numberOfOperations = -1;
        boolean allElementsEqual = true;
        for(int i=0; i<n; i++){
            if(nums1[i] != nums2[i]) allElementsEqual = false;
            if(k != 0){
                diffArray[i] = (nums1[i] - nums2[i]);
                if(diffArray[i] % k != 0) return numberOfOperations;
                totalDiffSum += diffArray[i];
            }
        }
        if((k == 0) && (allElementsEqual == true)) return numberOfOperations + 1;
        else if((totalDiffSum == 0) && (k != 0)){
            numberOfOperations += 1;
            for(int i: diffArray){
                if(i < 0){
                    numberOfOperations += Math.abs(i) / k;
                }
            }
        }
        return numberOfOperations;
    }
}