class Solution {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder x = new StringBuilder();
            for (int i = 0; i < s.length(); i += k) {
                int y = 0;
                for (int j = i; j < Math.min(s.length(), i + k); j++) y += s.charAt(j) - '0';
                x.append(y);
            }
            s = x.toString();
        }
        return s;
    }
}