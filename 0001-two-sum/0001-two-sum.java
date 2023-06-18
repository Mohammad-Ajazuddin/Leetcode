class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ind[]=new int[2];
        int size=nums.length;
        for(int i=0;i<size-1;i++)
        {
            for(int j=i+1;j<size;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    ind[0]=i;
                    ind[1]=j;
                }
            }
        }
        return ind;        
    }
}