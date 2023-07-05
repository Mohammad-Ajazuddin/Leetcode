class Solution {
    public int longestSubarray(int[] nums) {
        int head=0,tail=0,ans=0,count=0;
        for(head=0;head<nums.length;head++)
        {
            if(nums[head]==0)
            {
                count++;//1 zero occurred
            }
            while(count>1)//maintaining sliding window with atmost 1 zero
            {
                if(nums[tail]==0)
                {
                    count--;
                }
                tail++;
            }
            ans = Math.max(ans,(head-tail));
        }
        return ans;
    }
}