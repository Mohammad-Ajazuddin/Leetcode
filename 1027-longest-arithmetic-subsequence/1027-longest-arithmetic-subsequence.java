class Solution {
    public int longestArithSeqLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer>[] dp = new HashMap[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();

            for (int j = 0; j < i; j++) {
                int difference = nums[i] - nums[j];
                int length = dp[j].getOrDefault(difference, 1) + 1;

                dp[i].put(difference, length);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;        
    }
}