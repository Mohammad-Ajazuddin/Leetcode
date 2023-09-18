class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE,sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            sum += nums[i];
            if(sum>result)
            {
                result = sum;
            }
            
            if(sum<0)
            {
                //not carrying forward -ve values
                //as we need max sum, -ve nums reduce sum
                sum = 0;
            }
        }
        return result;
    }
}