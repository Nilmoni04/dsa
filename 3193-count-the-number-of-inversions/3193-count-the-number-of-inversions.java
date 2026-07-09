class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int[][] dp = new int[n + 1][401];
        int[] req = new int[n + 1];
        Arrays.fill(req, -1);

        for (int[] requirement : requirements) {
            int a = requirement[0];
            int b = requirement[1];
            req[a + 1] = b;
        }

        if (req[1] <= 0) {
            dp[1][0] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int c = 0; c < i; c++) {
                for (int j = 0; j + c <= 400; j++) {
                    if (req[i] != -1 && j + c != req[i]) continue;
                    dp[i][j + c] += dp[i - 1][j];
                    dp[i][j + c] %= 1000000007;
                }
            }
        }

        return dp[n][req[n]];
    }
}