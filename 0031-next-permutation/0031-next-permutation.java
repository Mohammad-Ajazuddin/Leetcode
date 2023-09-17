class Solution {
    public void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums,int start,int end)
    {
        int i = start,j = end;
        while(i<j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int dip_index = -1;
        //2 1 5 4 3 0 0
        // here ele 1, ind 1 is dip, as remaining to the right are all > to it
        int n = nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                dip_index = i;
                break;
            }
        }
        
        if(dip_index==-1)
        {
            reverse(nums,0,n-1);
        }
        
        else
        {
            //finding just > to dip ele
            for(int i=n-1;i>dip_index;i--)
            {
                if(nums[i]>nums[dip_index])
                {
                    swap(nums,i,dip_index);
                    break;
                }
            }
            
            reverse(nums,dip_index+1,n-1);
        }
    }
}