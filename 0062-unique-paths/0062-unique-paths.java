//bruteforce -- recursion -- exponential complexity
//will give TLE
// class Solution {
//     public static int countPaths(int i, int j, int m, int n)
//     {
//         //reached last cell. So one path found
//         if(i==(m-1) && j==(n-1))
//         {
//             return 1;
//         }
//         //exceeds down/right path. From that position cant go anywhere
//         //so 0
//         if(i>=m || j>=n)
//         {
//             return 0;
//         }
        
//         else
//         {
//                         //right                 down
//             return countPaths(i,j+1,m,n) + countPaths(i+1,j,m,n);
//         }
//     }
//     public int uniquePaths(int m, int n) {
//         return countPaths(0,0,m,n);
//     }
// }

//DP to avoid computing of overlapping sub problems
class Solution {
    public static int countPaths(int i, int j, int[][] dp, int m, int n)
    {
        if(i==(m-1) && j==(n-1))
        {
            return 1;
        }
        if(i>=m || j>=n)
        {
            return 0;
        }
        //check if a sub problem already computed. if so directly return it.
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        else
        {
            return dp[i][j] = countPaths(i,j+1,dp,m,n) + countPaths(i+1,j,dp,m,n);
        }
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
        {
            Arrays.fill(dp[i],-1);    
        }
        return countPaths(0,0,dp,m,n);
    }
}
