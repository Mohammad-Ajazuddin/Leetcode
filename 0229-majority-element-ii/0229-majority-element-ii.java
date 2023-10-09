//bruteforce
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int  n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int count = 0;
            if(ans.size() == 0 || ans.get(0) != nums[i])
            {
                for(int j=0;j<n;j++)
                {
                    if(nums[i]==nums[j])
                    {
                        count++;
                    }
                } 
                if(count>(n/3))
                {
                    ans.add(nums[i]);
                }
            }
            if(ans.size()==2)
            {
                break; // as at max 2 majority ele
            }
        }
        return ans;
    }
}