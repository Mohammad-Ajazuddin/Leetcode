class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int i = 0, j = n, k =0;
        while(k<2*n - 1)
        {
            ans[k] = nums[i];
            ans[k+1] = nums[j];
            i++;
            j++;
            k+=2;
        }
        return ans;
    }
}