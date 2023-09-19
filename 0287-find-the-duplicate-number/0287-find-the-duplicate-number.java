class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(count.containsKey(nums[i])){
                return nums[i];
            }
            else
            {
                count.put(nums[i],1);
            }
        }
        return -1;
    }
}