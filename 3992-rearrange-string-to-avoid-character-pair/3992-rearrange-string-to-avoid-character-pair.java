class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder ys = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder xs = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(c == y) {
                ys.append(c);
            } else if(c == x) {
                xs.append(c);
            } else {
                mid.append(c);
            }
        }
        return ys.append(mid).append(xs).toString();
    }
}