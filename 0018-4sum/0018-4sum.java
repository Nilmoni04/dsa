class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);

        for(int i=0; i<n-3;i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            for(int j=i+1; j<n-2; j++) {
                if(j>i+1 && nums[j]==nums[j-1]) {
                    continue;
                }
                long remainingTarget = (long)target - nums[i] - nums[j];
                int left=j+1, right=n-1;

                while(left<right) {
                    int sum=nums[left]+nums[right];
                    if(sum < remainingTarget) {
                        left++;
                    } else if(sum>remainingTarget) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        int prevLeft = nums[left], prevRight = nums[right];
                    while (left < right && nums[left] == prevLeft) left++;
                    while (left < right && nums[right] == prevRight) right--;
                    }
                }
            }
        }
        return result;
    }
}