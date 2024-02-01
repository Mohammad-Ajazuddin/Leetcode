class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int ans[][]=new int[nums.length/3][];
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=3)
        {
            if(nums[i+2]-nums[i]<=k)
            {
                ans[count]=new int[]{nums[i],nums[i+1],nums[i+2]};
                count++;
            }
            else
            {
                return new int[0][0];
            }
        }
        return ans;
    }
}