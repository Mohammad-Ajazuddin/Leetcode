class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low=1;         //for binary search
        int high=maxSum;   //to choose the max num at index
        int leftblocks=index; //left of our4 index
        int rightblocks=(n-1)-index; //right of our index
        int ans=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            long leftSum=0,rightSum=0,ele=mid-1; //here max at index Im assuming mid. so ele right & left to it will be mid-1
            if(rightblocks<=ele)
            {
                rightSum=(ele*(ele+1))/2 - ((ele-rightblocks)*(ele-rightblocks+1))/2;// 5 4 3 (n*(n+1))/2 gives sum of 1-5
                                                                        //but here 3-5. 1-5 sum - 1-2
            }
            else
            {
                rightSum=(ele*(ele+1))/2 + (rightblocks - ele);// This is case of say 4 3 2 1 1 1 1. till 3,2,1 n=3 (n*(n+1))/2 is sum
                                                               // And remaining blocks each represent 1. No of boxes = No of 1's
            }
            
             if(leftblocks<=ele)
            {
                leftSum=(ele*(ele+1))/2 - ((ele-leftblocks)*(ele-leftblocks+1))/2;
            }
            else
            {
                leftSum=(ele*(ele+1))/2 + (leftblocks - ele);
            }
            long totalSum=leftSum+mid+rightSum;
            
            if(totalSum<=maxSum) // Binary search
            {
                low=mid+1; //changing my low to mid+1 as i got the sum less tha maxSum
                ans=mid;
            }
            else
            {
                high=mid-1;//if totalSum > maxSum so that mid value is not possoble. so look for next smaller value
            }
        }
        return ans;
    }
}