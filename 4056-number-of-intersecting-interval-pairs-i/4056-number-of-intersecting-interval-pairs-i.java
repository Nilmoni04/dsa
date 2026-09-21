class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int pairs = 0;
        for(int[] interval : intervals) {
            int st = interval[0];
            int end = interval[1];

            while(!minHeap.isEmpty() && minHeap.peek() < st) {
                minHeap.poll();
            }
            pairs += minHeap.size();
            minHeap.offer(end);
        }
        return pairs;
    }
}