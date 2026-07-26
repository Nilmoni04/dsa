class Solution {
    private static final int MOD = 1_000_000_007;

    public int countValidSequences(int n, int k) {
        if (n < k) {
            return 0;
        }
        long total = nCr(n - 1, k - 1);

        long oddProductSequences = 0;
        if ((n - k) % 2 == 0) {
            int m = (n + k) / 2 - 1;
            oddProductSequences = nCr(m, k - 1);
        }

        long ans = (total - oddProductSequences + MOD) % MOD;
        return (int) ans;
    }
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;

        if (r > n - r) {
            r = n - r;
        }

        long num = 1;
        long den = 1;

        for (int i = 1; i <= r; i++) {
            num = (num * (n - i + 1)) % MOD;
            den = (den * i) % MOD;
        }

        return (num * modInverse(den, MOD)) % MOD;
    }

    private long modInverse(long a, int m) {
        return power(a, m - 2, m);
    }

    private long power(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}