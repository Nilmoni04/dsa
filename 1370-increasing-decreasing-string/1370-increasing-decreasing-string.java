class Solution {
    public String sortString(String s) {
        StringBuilder result = new StringBuilder();
        int[] freqArray = new int[26];
        for(char ch : s.toCharArray()) 
            freqArray[ch - 'a']++;

        while(result.length() < s.length()) {
            for(int index = 0; index < 26; index++) {
                if(freqArray[index] > 0) {
                    result.append((char) (index + 'a'));
                    freqArray[index] -= 1;
                }
            }

            for(int index = 25; index >= 0; index--) {
                if(freqArray[index] > 0) {
                    result.append((char) (index + 'a'));
                    freqArray[index] -= 1;
                }
            }
        }

        return result.toString();
    }
}