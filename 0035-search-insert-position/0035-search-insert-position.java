class Solution {
    public int searchInsert(int[] nums, int target) {
        int size=nums.length;
        int low=0;
        int high=size-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]<target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else if(nums[mid]==target)
            {
                return mid;
            }
        }
        return low;
    }
}