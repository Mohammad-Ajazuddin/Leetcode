//better approach   TC 0(NlogN) + O(N)
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> ele_count = new HashMap<>();
        //store in map
        for(int i=0;i<n;i++)
        {
            int value = ele_count.getOrDefault(nums[i],0);
            ele_count.put(nums[i],value+1);
        }
        //search in map
           //Interface  key-val pair       iterable (all k-v pairs)
        for(Map.Entry<Integer,Integer> it : ele_count.entrySet())
        {
            if(it.getValue()>(n/2))
                return it.getKey();
        }
        return -1;
    }
}