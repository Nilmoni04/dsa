import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[256];
        Map<String, Long> patternCost = new HashMap<>();
    }

    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        if (source.length() != target.length()) {
            return -1;
        }
        
        TrieNode root = new TrieNode();
        for (int i = 0; i < rules.size(); i++) {
            String pattern = rules.get(i).get(0);
            String repl = rules.get(i).get(1);
            int cost = costs[i];

            int starCount = 0;
            for (int j = 0; j < pattern.length(); j++) {
                if (pattern.charAt(j) == '*') {
                    starCount++;
                }
            }
            long totalCost = (long) cost + starCount;
            
            TrieNode curr = root;
            for (int j = 0; j < repl.length(); j++) {
                char c = repl.charAt(j);
                if (curr.children[c] == null) {
                    curr.children[c] = new TrieNode();
                }
                curr = curr.children[c];
            }
            curr.patternCost.put(pattern, Math.min(curr.patternCost.getOrDefault(pattern, Long.MAX_VALUE), totalCost));
        }
        
        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (source.charAt(i) == target.charAt(i) && dp[i + 1] != Long.MAX_VALUE) {
                dp[i] = dp[i + 1];
            }
            
            TrieNode curr = root;
            for (int j = i; j < n; j++) {
                char c = target.charAt(j);
                curr = curr.children[c];
                if (curr == null) {
                    break;
                }
                
                int L = j - i + 1;
                if (dp[i + L] != Long.MAX_VALUE && !curr.patternCost.isEmpty()) {
                    for (Map.Entry<String, Long> entry : curr.patternCost.entrySet()) {
                        String pattern = entry.getKey();
                        long cost = entry.getValue();
                        boolean match = true;

                        for (int k = 0; k < L; k++) {
                            char p = pattern.charAt(k);
                            if (p != '*' && p != source.charAt(i + k)) {
                                match = false;
                                break;
                            }
                        }
                        
                        if (match) {
                            dp[i] = Math.min(dp[i], dp[i + L] + cost);
                        }
                    }
                }
            }
        }
        
        return dp[0] == Long.MAX_VALUE ? -1 : (int) dp[0];
    }
}