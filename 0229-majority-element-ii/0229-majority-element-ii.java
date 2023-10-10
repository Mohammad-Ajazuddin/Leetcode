//bruteforce
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         int  n = nums.length;
//         List<Integer> ans = new ArrayList<>();
//         for(int i=0;i<n;i++)
//         {
//             int count = 0;       //skip checking if already its maj ele
//             if(ans.size() == 0 || ans.get(0) != nums[i])
//             {
//                 for(int j=0;j<n;j++)
//                 {
//                     if(nums[i]==nums[j])
//                     {
//                         count++;
//                     }
//                 } 
//                 if(count>(n/3))
//                 {
//                     ans.add(nums[i]);
//                 }
//             }
//             if(ans.size()==2)
//             {
//                 break; // as at max 2 majority ele
//             }
//         }
//         return ans;
//     }
// }

//Better Approach -- using Hashing O(N*logN)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int minAppearance = (n/3) + 1;
        List<Integer> result = new ArrayList<>();
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int value = mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i],value+1);
            
            if(mpp.get(nums[i])==minAppearance)
            {
                result.add(nums[i]);
            }
            
            if(result.size()==2)
            {
                break;
            }
        }
        return result;
    }
}