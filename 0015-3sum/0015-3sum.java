class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
       int n = nums.length;
       Arrays.sort(nums); // Step 1: Sort the array
       for (int i = 0; i < n - 2; i++) {
           // Step 2: Skip duplicates for the first element
           if (i > 0 && nums[i] == nums[i - 1]) continue;
           int target = -nums[i];
           int left = i + 1, right = n - 1;
           // Step 3: Two-pointer approach
           while (left < right) {
               int sum = nums[left] + nums[right];


               if (sum == target) {
                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));


                   // Step 4: Skip duplicate values
                   while (left < right && nums[left] == nums[left + 1]) left++;
                   while (left < right && nums[right] == nums[right - 1]) right--;


                   left++;
                   right--;
               } else if (sum < target) {
                   left++;
               } else {
                   right--;
               }
           }
       }


       return result;
    }
}