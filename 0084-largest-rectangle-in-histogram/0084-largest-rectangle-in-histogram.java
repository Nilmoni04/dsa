class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int[] leftsmaller=new int[heights.length];
        int[] rightsmaller=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                leftsmaller[i]=-1;
            }
            else{
                leftsmaller[i]=s.peek();
            }
            s.push(i);
        }
        s.clear();
        for(int i=heights.length-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                rightsmaller[i]=heights.length;
            }
            else{
              rightsmaller[i]=s.peek();
            }
            s.push(i);
        }
        int maxArea=0;
        int currArea=0;
        for(int i=0;i<heights.length;i++){
            currArea=(heights[i])*(rightsmaller[i]-leftsmaller[i]-1);
            maxArea=Math.max(maxArea,currArea);
        }
        return maxArea;
    }
}