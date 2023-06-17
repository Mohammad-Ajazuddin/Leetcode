
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;
        Arrays.sort(arr2);
        
        // Initialize the dynamic programming table
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        
        // Base case: when no elements are taken from arr2
        dp[0][0] = Integer.MIN_VALUE / 2;
        
        // Dynamic programming loop
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr1[i - 1] > dp[j][i - 1])
                    dp[j][i] = Math.min(dp[j][i], arr1[i - 1]);
                
                if (j > 0) {
                    int idx = Arrays.binarySearch(arr2, dp[j - 1][i - 1] + 1);
                    if (idx < 0) idx = -idx - 1;
                    if (idx < arr2.length)
                        dp[j][i] = Math.min(dp[j][i], arr2[idx]);
                }
                
                if (i == n && dp[j][i] != Integer.MAX_VALUE / 2)
                    return j;
            }
        }
        
        return -1; // No way to make arr1 strictly increasing
    }
}
