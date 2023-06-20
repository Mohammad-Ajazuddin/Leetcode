class Solution {
    public int[] getAverages(int[] nums, int k) {
   //      int size = nums.length;
   //      int[] ans = new int[size];
   //      int div = (2*k)+1;
   //      if(size<div)
   //      {
   //          int i=0;
   //          while(i<size)
   //          {
   //              ans[i]=-1;
   //              i++;
   //          }
   //          return ans;
   //      }
   //      for(int i=0;i<size;i++)
   //      {
   //          if(i<=k)
   //          {
   //              if((i-k)<0)
   //              {
   //                  ans[i]=-1;
   //              }
   //              else{
   //                  int count = k;
   //                  long sum = 0L;
   //                  int m=i-1;
   //                  int n=i+1;
   //                  while(count!=0 )
   //                  {
   //                      sum+=nums[m]+nums[n];
   //                      m--;
   //                      n++;
   //                      count--;
   //                  }
   //                  sum+=nums[i];
   //                  ans[i]=(int) (sum/div);
   //              }
   //          }
   //          if(i>k)
   //          {
   //              if((i+k)>size-1)
   //              {
   //                  ans[i]=-1;
   //              }
   //              else{
   //                  int count = k;
   //                  long sum = 0L;
   //                  int m=i-1;
   //                  int n=i+1;
   //                  while(count!=0)
   //                  {
   //                      sum+=nums[m]+nums[n];
   //                      m--;
   //                      n++;
   //                      count--;
   //                  }
   //                  sum+=nums[i];
   //                  ans[i]=(int) (sum/div);
   //              }
   //          }
   //      }
   //      return ans;
   // }//one test case failed. 
    //This is also correct if ans[i]= (int) (sum/div) instead of (int)sum/div
    //parenthesis. But it took 1945 ms 59.9 MB
    
    //Optimal solution 12ms 60.9 MB
        int size = nums.length;
        int krange = (2*k) + 1;
        int[] ans = new int[size];
        for(int i=0;i<size;i++)
        {
            ans[i]=-1;
        }
        if(size<krange)
        {
            return ans;
        }
        long[] prefixSum = new long[size+1];
        prefixSum[0] = 0;
        for(int i=1;i<=size;i++)
        {
            prefixSum[i]=prefixSum[i-1] + nums[i-1];
        }
        for(int i=k;(i+k)<size;i++)
        {
            ans[i] = (int)((prefixSum[i+1+k] - prefixSum[i-k])/krange);
        }
        return ans;
    }
}