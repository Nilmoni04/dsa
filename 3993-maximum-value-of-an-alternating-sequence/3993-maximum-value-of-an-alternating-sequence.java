class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n == 1) {
            return s;
        }
        long p = n/2;
        return (long) s+p*m-p+1;
    }
}