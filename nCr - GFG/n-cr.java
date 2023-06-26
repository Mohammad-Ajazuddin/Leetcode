//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int nCr(int n, int r) {
        int mod = 1000000007;

        // Create a 2D array to store the values of nCr
        int[][] dp = new int[n + 1][r + 1];

        // Fill the base cases
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // Calculate the values of nCr using Pascal's Triangle
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i && j<=r; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        // Return the result
        return dp[n][r];
    }
}
