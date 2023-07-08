class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long minSum = 0,maxSum = 0;
        int[] candidates = new int[n-1];
        
        for(int i=0;i<n-1;i++)
        {
            candidates[i] = (weights[i] + weights[i+1]);
        }
        Arrays.sort(candidates);
        for(int i=0;i<k-1;i++)
        {
            minSum += candidates[i];
            maxSum += candidates[n-2-i];
        }
        return maxSum - minSum;
    }
}