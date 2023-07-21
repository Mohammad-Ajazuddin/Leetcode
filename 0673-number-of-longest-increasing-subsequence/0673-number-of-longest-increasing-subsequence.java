class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n <= 1) return n;
        int[] lis = new int[n];
        int[] count = new int[n];
        for(int i = 0; i < n; ++i){
            lis[i] = 1;
            count[i] = 1;
        }
        
        for(int j = 1; j < n; ++j){
            for(int i = 0; i <j; ++i){
                if(nums[i] < nums[j]){
                    if(lis[i] >= lis[j]){
                        lis[j] = lis[i] + 1;
                        count[j] = count[i];
                    } else if(lis[j] == lis[i] + 1) 
                        count[j] += count[i];
                }
            }
        }
        
        int longest = 0;
        for(int i = 0; i < n; ++i)
            longest = Math.max(longest, lis[i]);
        
        int result = 0;
        for(int i = 0; i < n; ++i)
            if(lis[i] == longest) result += count[i];
        
        return result;
    }
}