class Solution {
    public static void calculateCosttill(int[] costtill,int node,int[] manager,int[] informTime)
    {
        int leafnode=node,cost=0;
        while(manager[node]!=-1)
        {
            cost+=informTime[manager[node]];
            node=manager[node];
        }
        costtill[leafnode]=cost;
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int[] costtill=new int[n];
        for(int i=0;i<n;i++)
        {
            if(informTime[i]==0)
            {
                Solution.calculateCosttill(costtill,i,manager,informTime);
            }
        }
        int maxcost=costtill[0];
        //int maxnode=0;
        for(int i=0;i<n;i++){
            if(maxcost<costtill[i])
            {
                maxcost=costtill[i];
                //maxnode=i;
            }
        }
        return maxcost;
//         int ans=0;
//         while(manager[maxnode]!=-1)                    when executed with this commented section 
//         {                                              Runtime: 249 ms Memory Usage: 57.6 MB
//             ans+=informTime[manager[maxnode]];         Actually I calculated cost for each leaf node already
//             maxnode=manager[maxnode];                  Just I need Max cost. So this is not required
//         }                                              But after removing I got Runtime: 251 ms Memory Usage: 61.8 MB
//         return ans;
    }
}
