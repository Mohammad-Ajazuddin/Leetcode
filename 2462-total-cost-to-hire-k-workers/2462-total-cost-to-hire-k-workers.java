// class Solution {
//     public long totalCost(int[] costs, int k, int candidates) {
//         List<Integer> Costs = new ArrayList<>();
//         int n = costs.length;
//         long ans = 0L;
//         if(k==n)
//         {
//             for(int i=0;i<n;i++)
//             {
//                 ans+=costs[i];
//             }
//             return ans;
//         }
        
//         for(int i=0;i<n;i++){
//             Costs.add(costs[i]);
//         }
        
//         return solve(Costs,k,candidates,ans,1);//round 1
//     }
        
//     long solve(List<Integer> Costs,int k,int candidates,long ans,int round)
//     {
//         if(round == k+1) //As kth round yet to complete
//         {
//             return ans;
//         }
            
//         int size = Costs.size();
//         if(size>=(2*candidates))
//         {
//             long min1=Long.MAX_VALUE,min2 = Long.MAX_VALUE;
//             int index1 = 0,index2 = 0;
//             for(int i=0,j=size-1;i<candidates;i++,j--)
//             {
//                 if(Costs.get(i)<min1)
//                 {
//                     min1 = Costs.get(i);
//                     index1 = i;
//                 }
//                 if(Costs.get(j)<min2)
//                 {
//                     min2 = Costs.get(j);
//                     index2 = j;
//                 }
//             }
//             if(min1<min2)
//             {
//                 Costs.remove(index1);
//                 size = Costs.size();
//                 ans += min1;
//             }
//             else if(min1>min2)
//             {
//                 Costs.remove(index2);
//                 size = Costs.size();
//                 ans += min2;
//             }
//             else // Both mins equal
//             {
//                 Costs.remove(index1);
//                 size = Costs.size();
//                 ans += min1;
//             }
//         }
//         else
//         {
//             long min=Long.MAX_VALUE;
//             int index = 0;
//             for(int i=0;i<size;i++)
//             {
//                 if(Costs.get(i)<min)
//                 {
//                     min = Costs.get(i);
//                     index = i;
//                 }
//             }
//             ans += min;
//             Costs.remove(index);
//             size = Costs.size();
//         }
            
//         ans = solve(Costs,k,candidates,ans,round+1);
//         return ans;
//     }   
// } // GOT TLE 132/160 Testcases passed.


//Using priority Queue --- max priority (min number at root)

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> left = new PriorityQueue<>(); //As I need to select
        PriorityQueue<Integer> right = new PriorityQueue<>();//candidates from first or last
        int i = 0;                        //left maintains starting candidates
        int j = costs.length-1;
        long result = 0L;
        int rounds = 0;
        
        while(rounds<k)
        {
            while(left.size()<candidates && i<=j)
            {
                left.add(costs[i]);
                i++;
            }
            while(right.size()<candidates && j>=i)
            {
                right.add(costs[j]);
                j--;
            }

            // Root has the min value
            int leftValue = !left.isEmpty()?left.peek():Integer.MAX_VALUE; // if Pq is not empty, then it should have a min value
                                                                              //else return some max value which will be comp. with right                              
            int rightValue = !right.isEmpty()?right.peek():Integer.MAX_VALUE; 
        
            if(leftValue<=rightValue)
            {                       // we need to take min value
                result+=leftValue;  // And if both min ele are equal from left and right,
                left.remove();      //we should take less index element. so obviously left values have less index. Then remove that element
            }
            
            else{
                result+=rightValue;
                right.remove();
            }
        
            rounds++; // round completes. so next round
        }
        
        return result;
    }
}