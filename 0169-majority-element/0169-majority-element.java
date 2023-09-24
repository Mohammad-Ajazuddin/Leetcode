//better approach   TC 0(NlogN) + O(N) SC = 0(N) if unique
// class Solution {
//     public int majorityElement(int[] nums) {
//         int n = nums.length;
//         HashMap<Integer,Integer> ele_count = new HashMap<>();
//         //store in map
//         for(int i=0;i<n;i++)
//         {
//             int value = ele_count.getOrDefault(nums[i],0);
//             ele_count.put(nums[i],value+1);
//         }
//         //search in map
//            //Interface  key-val pair       iterable (all k-v pairs)
//         for(Map.Entry<Integer,Integer> it : ele_count.entrySet())
//         {
//             if(it.getValue()>(n/2))
//                 return it.getKey();
//         }
//         return -1;
//     }
// } 10ms 46.3MB


//Moores voting algo.
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ele = 0;
        int n = nums.length;
        //moores voting algo
        for(int i =0;i<n;i++)
        {
            if(count == 0)
            {
                ele = nums[i];
                count = 1;
            }
            else if(nums[i] == ele)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return ele;
        //verify the ele as majority or not 
        //This part is actually not necessary as it is mentioned in q majority ele always exists
        // count = 0;
        // for(int i=0;i<n;i++)
        // {
        //     if(ele==nums[i])
        //     {
        //         count++;
        //     }
        // }
        // if(count>(n/2))
        // {
        //     return ele;
        // }
        // return -1;
    }
}