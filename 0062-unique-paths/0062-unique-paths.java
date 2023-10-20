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
// class Solution {
//     public static int countPaths(int i, int j, int[][] dp, int m, int n)
//     {
//         if(i==(m-1) && j==(n-1))
//         {
//             return 1;
//         }
//         if(i>=m || j>=n)
//         {
//             return 0;
//         }
//         //check if a sub problem already computed. if so directly return it.
//         if(dp[i][j]!=-1)
//         {
//             return dp[i][j];
//         }
//         else
//         {
//             return dp[i][j] = countPaths(i,j+1,dp,m,n) + countPaths(i+1,j,dp,m,n);
//         }
//     }
//     public int uniquePaths(int m, int n) {
//         int[][] dp = new int[m][n];
//         for(int i=0;i<m;i++)
//         {
//             Arrays.fill(dp[i],-1);    
//         }
//         return countPaths(0,0,dp,m,n);
//     }
// }

//optimal -- using combinatorics

class Solution{
    public int uniquePaths(int m,int n)
    {
        int N = m+n-2; // atmost right directions = n-1
                    //lly down m-1. total m-1+n-1 = m+n-2
        //total possible combinations
        // totalC(r or d)
        int r = m-1;
        long result = 1;
        //computing nCr
        //Ex 10C3, r=3, 3 places 10*9*8/3*2*1
        for(int i=1;i<=r;i++)
        {
            result = result * (N-r+i)/i;
        }
        return (int)result;
    }
}
