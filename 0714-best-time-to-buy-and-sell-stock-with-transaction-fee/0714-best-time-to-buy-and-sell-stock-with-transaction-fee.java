// class Solution {
//     public int maxProfit(int[] prices, int fee) {
//         int n = prices.length;
//         boolean buy=true;
//         int index=0;
//         return profit(prices,index,buy,n,fee);
//     }
//     public int profit(int[] prices,int index,boolean buy,int n,int fee)
//     {
//         if(index == n)
//         {
//             return 0;
//         }
//         int profit = 0;
//         //Buy Case --- while buying 2 scenarios -- you can buy 1st day or not buy first day
//         if(buy)
//             profit = Math.max(-prices[index] + profit(prices,index+1,false,n,fee), 0 + profit(prices,index+1,true,n,fee));
//         //not buy --- say today price is too high so you want to buy next day.
//         else
//             //sell case -- same you may sell today or may not
//             //bought and sold here so 1 txn fee      sold. So next you can buy. Hence buy = true
//             profit = Math.max(prices[index] - fee + profit(prices,index+1,true,n,fee), 0 + profit(prices,index+1,false,n,fee));
//         //you didnt sell. so no chance to buy hence false
        
//         return profit;
//     }
// }  TLE as recursion 2^n time complexity.

//Using DP 
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int buy=1;
        int index=0;
        int[][] dp = new int[n][2]; // 2 bcz buy = true/false let 1/0;
        for(int i=0;i<n;i++)
        {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return profit(prices,index,buy,n,fee,dp);
    }
    public int profit(int[] prices,int index,int buy,int n,int fee, int[][] dp)
    {
        if(index == n)
        {
            return 0;
        }
        if(dp[index][buy]!=-1)
        {
            return dp[index][buy];
        }
        int profit = 0;
        //Buy Case --- while buying 2 scenarios -- you can buy 1st day or not buy first day
        if(buy==1)
            profit = Math.max(-prices[index] + profit(prices,index+1,0,n,fee,dp), 0 + profit(prices,index+1,1,n,fee,dp));
        //not buy --- say today price is too high so you want to buy next day.
        else
            //sell case -- same you may sell today or may not
            //bought and sold here so 1 txn fee      sold. So next you can buy. Hence buy = true
            profit = Math.max(prices[index] - fee + profit(prices,index+1,1,n,fee,dp), 0 + profit(prices,index+1,0,n,fee,dp));
        //you didnt sell. so no chance to buy hence false
        
        return dp[index][buy] = profit;
    }
}         