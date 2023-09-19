// class Solution {
//     public int findDuplicate(int[] nums) {
//         Map<Integer,Integer> count = new HashMap<>();
//         int n = nums.length;
//         for(int i=0;i<n;i++)
//         {
//             if(count.containsKey(nums[i])){
//                 return nums[i];
//             }
//             else
//             {
//                 count.put(nums[i],1);
//             }
//         }
//         return -1;
//     }
// }

class Solution {
    public int findDuplicate(int[] nums) {
        // 1,3,4,2,2
        Arrays.sort(nums);
        //1,2,2,3,4 now compare adj ele. if equal return
        int n = nums.length;
        for(int i = 0;i<n-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                return nums[i];
            }
        }
        return -1;
    }
}