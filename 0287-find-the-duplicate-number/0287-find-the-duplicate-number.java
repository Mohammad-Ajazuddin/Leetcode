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
// } here extra space is used. 60.9 mb 20 ms

// class Solution {
//     public int findDuplicate(int[] nums) {
//         // 1,3,4,2,2
//         Arrays.sort(nums);
//         //1,2,2,3,4 now compare adj ele. if equal return
//         int n = nums.length;
//         for(int i = 0;i<n-1;i++)
//         {
//             if(nums[i]==nums[i+1])
//             {
//                 return nums[i];
//             }
//         }
//         return -1;
//     }
// } //but here array is modified. It is mentioned in question not to modify.   56mb 35ms

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int n = nums.length;
//         for(int i=0;i<n-1;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 if(nums[i] == nums[j])
//                 {
//                     return nums[i];
//                 } 
//             }
//         }
//         return -1;
//     }
// } TLE :)!!

//Floyds cycle detection tortaoise and hare algo
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // Phase 1: Find the intersection point of the two runners.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find the entrance to the cycle.
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}


