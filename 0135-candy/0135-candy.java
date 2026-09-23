class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int sum=1, i=1;

        while(i<n) {
            if(ratings[i] == ratings[i-1]) {
                i++;
                sum += 1;
                continue;
            }
            int peek = 1;
            while(i<n && ratings[i] > ratings[i-1]) {
                peek++;
                sum+=peek;
                i++;
            }
            if(i == n) {
                return sum;
            }
            int down = 1;
            while(i<n && ratings[i] < ratings[i-1]) {
                i++;
                sum+=down;
                down++;
            }
            if(down > peek) {
                sum += down-peek;
            }
        }
        return sum;
    }
}