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
// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         int n = nums.length;
//         // least occurrence of the majority element:
//         int minAppearance = (n/3) + 1;
//         List<Integer> result = new ArrayList<>();
//         HashMap<Integer,Integer> mpp = new HashMap<>();
//         for(int i=0;i<n;i++)
//         {
//             int value = mpp.getOrDefault(nums[i],0);
//             mpp.put(nums[i],value+1);
            
//             //checking if nums[i] is
//             // the majority element:
//             if(mpp.get(nums[i])==minAppearance)
//             {
//                 result.add(nums[i]);
//             }
            
//             if(result.size()==2)
//             {
//                 break;
//             }
//         }
//         return result;
//     }
// }

//Optimal Moores Voting Algo
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(count1==0 && nums[i]!=ele2)
            {
                ele1 = nums[i];
                count1++;
            }
            else if(count2==0 && nums[i]!=ele1)
            {
                ele2 = nums[i];
                count2++;
            }
            else if(ele1==nums[i])
            {
                count1++;
            }
            else if(ele2==nums[i])
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==ele1)
            {
                count1++;
            }
            else if(nums[i]==ele2)
            {
                count2++;
            }
        }
        if(count1>(n/3))
        {
            result.add(ele1);
        }
        if(count2>(n/3))
        {
            result.add(ele2);
        }
        return result;
    }
}
