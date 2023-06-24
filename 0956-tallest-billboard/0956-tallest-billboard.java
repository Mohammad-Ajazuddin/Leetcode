class Solution {
    public int offset = 5000;// as diff s1-s2 can be negative
    public int tallestBillboard(int[] rods) {
        //dp[index][s1][s2] is not feasable 20*5000*5000 complexity
        //s1,s2 reduced to diff.
        int[][] dp =new int[21][2*offset+1]; //-5000<=diff<=5000
        int result = 0;                     //As when s1=0, s2=5000 diff = -5000
        int n = rods.length;            //to repst -values we can -5000+5000(offset) = 0 index
        for(int i=0;i<dp.length;i++)   //hence we are taking extra space 10000
        {
            Arrays.fill(dp[i],-1);
        }
        result = solve(0,0,rods,dp,n);// index 0, diff 0.
        
        if(result<0)
        {
            return 0;
        }
        else
        {
            return result;
        }
    }
    
    public int solve(int index,int diff,int[] rods,int[][] dp,int n){
        if(index==n)
        {
            if(diff==0)
            {
                return 0;
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
            
        if(dp[index][offset+diff]!=-1)
        {
            return dp[index][offset+diff];
        }
            
        int skip = solve(index+1,diff,rods,dp,n);
        int set1 = rods[index] + solve(index+1,diff+rods[index],rods,dp,n);//diff = s1-s2 adding to support1 set s1-s2 + rods[i] =>diff+rods[i]
        int set2 = solve(index+1,diff-rods[index],rods,dp,n);
            //adding rod to support2 2nd set, s1-(s2+rods[i]) => diff-rods[i]
        return dp[index][offset+diff] = Math.max(Math.max(skip,set1),set2);
    }
}