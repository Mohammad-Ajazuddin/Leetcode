class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<=2)
        {
            return false;
        }
        int i=0,j=1,k=2;
        for(;k<arr.length;i++,j++,k++)
        {
            if(arr[i]%2!=0 && arr[j]%2!=0 && arr[k]%2!=0)
            {
                return true;
            }
        }
        return false;
    }
}