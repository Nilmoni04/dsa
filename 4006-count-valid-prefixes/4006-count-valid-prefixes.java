class Solution {
    public int countValidPrefixes(String s) {
        int c0 = 0, c1=0;
        int validCount = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                c0++;
            } else {
                c1++;
            }
            if(Math.abs(c0-c1) <= 1) {
                validCount++;
            }
        }
        return validCount;
    }
}