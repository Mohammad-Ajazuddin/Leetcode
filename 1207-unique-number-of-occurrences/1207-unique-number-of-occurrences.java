class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        
        for(int ele:arr)
        {
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i]!=arr[j] && freq.get(arr[i])==freq.get(arr[j]))
                {
                    return false;
                }
            }
        }
        return true;
    }
}