class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String s = "123456789";
        String l = String.valueOf(low);
        String h = String.valueOf(high);
        for(int len = l.length(); len<= h.length(); len++) {
            for(int st=0; st<= 9-len; st++) {
                int num = Integer.parseInt(s.substring(st, st+len));
                if(num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}