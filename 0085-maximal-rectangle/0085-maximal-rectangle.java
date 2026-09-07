class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) {
          return 0;  
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j]=0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(heights));
        }
        return maxArea;
    }

    private int largestRectangle(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        
        for(int i=0; i<=heights.length; i++) {
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while(!s.isEmpty() && currHeight < heights[s.peek()]) {
                int height = heights[s.pop()];
                int right = i;
                int left = s.isEmpty() ? -1 : s.peek();
                int width = right - left - 1;
                maxArea = Math.max(maxArea, height*width);
            }
            s.push(i);
        }
        return maxArea;
    }
}