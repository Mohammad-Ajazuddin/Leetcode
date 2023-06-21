// class Solution {
//     public long minCost(int[] nums, int[] cost) {
//         int n = nums.length;
//         long minCost=0L;
//         long prevCost = Long.MAX_VALUE;
//         int start = 0;
//         while(start!=n){
//             long value = nums[start];
//             for(int i=0;i<n;i++)
//             {
//                 if(nums[i]<value)
//                 {
//                     minCost += (cost[i]*(value-nums[i]));
//                 }
//                 else if(nums[i]>value)
//                 {
//                     minCost += (cost[i]*(nums[i]-value));
//                 }
//             }
//             minCost = Math.min(prevCost,minCost);
//             prevCost = minCost;
//             minCost = 0;
//             start++;
//         }
//         return prevCost;
//     }
// }   TLE 41/48 Testcases


class Solution {
    public long minCost(int[] nums, int[] cost) {
        // Create an array of indices to track the original positions
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Sort the indices array based on the values in nums array
        Arrays.sort(indices, Comparator.comparingInt(i -> nums[i]));
        Arrays.sort(nums);
        int[] rearrangedCost = new int[nums.length];
        long total = 0L; // 1 freq/cost =2 here we can think as 2 1's. so this total
                         //will be sum of costs. Total elements. we can find median and 
                         // equal the array elements with median

        for (int i = 0; i < nums.length; i++) {
            total += cost[i];
            rearrangedCost[i] = cost[indices[i]];
        }

        long total_by_two = (total+1) / 2;
        long median = 0L;
        long cumulativeCost = 0L;
        int index = 0;
        
        while (cumulativeCost < total_by_two) {
            cumulativeCost += rearrangedCost[index];
            median = nums[index];
            index++;
        }

        long minCost = 0L;
        for (int i = 0; i < nums.length; i++) {
            minCost += Math.abs(nums[i] - median) * rearrangedCost[i];
        }

        return minCost;
    }
}