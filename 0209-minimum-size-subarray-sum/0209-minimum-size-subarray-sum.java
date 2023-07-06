class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length,window=0,right=0,left=0,result=Integer.MAX_VALUE;
        for(;right<n;right++)
        {
            window += nums[right];
            
            while(window>=target)
            {                            //length of subarray
                result = Math.min(result,right-left+1);
                window-=nums[left];
                left++;
            }
        }
        if(result==Integer.MAX_VALUE)// unchanged. Did not find sum >= target
        {
            return 0;
        }
        else
        {
            return result;
        }
    }
}