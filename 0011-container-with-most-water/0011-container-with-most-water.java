class Solution {
    public int maxArea(int[] height) {
       int n = height.length;
       int maxWater = 0;
       int left = 0, right = n - 1; // Initialize two pointers


       // Continue until pointers meet
       while (left < right) {
           int width = right - left; // Width between lines
           int minHeight = Math.min(height[left], height[right]); // Height is min of two lines
           maxWater = Math.max(maxWater, width * minHeight); // Update max area


           // Move the pointer pointing to the smaller height
           if (height[left] < height[right])
               left++;
           else
               right--;
       }


       return maxWater;
    }
}