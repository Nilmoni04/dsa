class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int[] nextGreater = new int[nums.length];
        int n = nums.length;

        for(int i=2*n-1; i>=0; i--) {
            int idx = i%n;
            while(!s.isEmpty() && nums[s.peek()] <= nums[idx]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGreater[idx] = -1;
            } else {
                nextGreater[idx] = nums[s.peek()];
            }
            s.push(idx);
        }
        return nextGreater;
    }
}