class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length;
        int count=0;
        for(int i=1;i<size-1;i++)
        {
            if(nums[i]!=nums[0] && nums[i]!=nums[size-1])
            {
                count++;
            }
        }
        return count;
    }
}