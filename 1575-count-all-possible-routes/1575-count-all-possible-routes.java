class Solution {
    int mod = 1000000007;

    public int func(int[] locations, int start, int finish, int fuel, int[][] dp) {
        if (fuel < 0)
            return 0;
        if (dp[start][fuel] != -1)
            return dp[start][fuel];
        int ans = 0;
        if (start == finish)
            ans++;
        for (int i = 0; i < locations.length; i++) {
            if (i == start || Math.abs(locations[i] - locations[start]) > fuel)
                continue;
            ans += func(locations, i, finish, fuel - Math.abs(locations[i] - locations[start]), dp) % mod;
            ans %= mod;
        }
        dp[start][fuel] = ans % mod;
        return dp[start][fuel];
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int sz = locations.length;
        int[][] dp = new int[sz][fuel + 1];
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j <= fuel; j++) {
                dp[i][j] = -1;
            }
        }
        return func(locations, start, finish, fuel, dp);
    }
}
