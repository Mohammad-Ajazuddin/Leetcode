class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m-1;
        int right = 0;
        
        while(left>=0 && right<n)
        {
            if(nums1[left]>nums2[right])
            {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                right++;
                left--;
            }
            else
            {
                break;
            }
        }
        //Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index=0;
        for(int i=m;i<m+n;i++)
        {
            nums1[i] = nums2[index++];
        }
        Arrays.sort(nums1);
    }
}