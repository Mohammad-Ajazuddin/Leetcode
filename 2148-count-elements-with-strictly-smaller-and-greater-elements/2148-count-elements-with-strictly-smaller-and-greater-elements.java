class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int size=nums.length;
        int count=0;
        boolean leftok,rightok;
        for(int i=1;i<size-1;i++)
        {
            leftok=false;
            rightok=false;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                {
                    leftok=true;
                    break;
                }
            }
            for(int j=i+1;j<size;j++)
            {
                if(nums[i]<nums[j])
                {
                    rightok=true;
                    break;
                }
            }
            if(leftok && rightok)
            {
                count++;
            }
        }
        return count;
    }
}