class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, list, ans);
        return ans;
    }
    private void backtrack(String s, List<String> list, List<List<String>> ans) {
        if(s.length() == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<s.length(); i++) {
            String part = s.substring(0,i+1);
            if(isPallindrome(part)) {
                list.add(part);
                backtrack(s.substring(i+1), list, ans);
                list.remove(list.size()-1);
            }
        }
    }
    static boolean isPallindrome(String s) {
        int l=0, r=s.length()-1;
        while(l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}