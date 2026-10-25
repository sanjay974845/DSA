class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, 1);   // first row: one way to reach each cell

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];     // dp[j] (above) + dp[j-1] (left)
            }
        }
        return dp[n - 1];
    }
}

        
    
