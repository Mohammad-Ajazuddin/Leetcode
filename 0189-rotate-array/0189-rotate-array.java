// class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k%nums.length;
//         //1 2 3 4 shifting by 4 places will be same
//         //More than 4 say 6 => 4+2, with 4 shifting same ans, need to do 2 shifts on original
//         //6%4 = 2.
//         int[] temp = new int[k];
//         int n = nums.length;
        
//         for(int i=n-k;i<n;i++)
//         {
//             temp[i-(n-k)] = nums[i];
//         }
        
//         for(int i=n-1;i>=k;i--)
//         {
//             nums[i] = nums[i-k];
//         }
        
//         for(int i=0;i<k;i++)
//         {
//             nums[i] = temp[i];
//         }
//     }
// }


//without extra space

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int n = nums.length;
        reverse(nums,0,(n-k-1));
        reverse(nums,(n-k),n-1);
        reverse(nums,0,n-1);
    }
    
    public void reverse(int[] nums,int start,int end)
    {
        for(int i=start;i<=(start+end)/2;i++)
        {
            int temp = nums[i];
            nums[i] = nums[(start+end)-i];
            nums[(start+end)-i] = temp;
        }
    }
}