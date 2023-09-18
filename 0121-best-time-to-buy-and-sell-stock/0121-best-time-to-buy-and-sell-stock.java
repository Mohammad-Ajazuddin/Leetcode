class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int n= prices.length;
        for(int i=0;i<n;i++)
        {
            minBuyPrice = Math.min(minBuyPrice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minBuyPrice);
        }
        return maxProfit;
    }
}