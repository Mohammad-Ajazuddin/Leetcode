class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start=0;
        int current=0;
        int size=nums.length;
        List<String> result = new ArrayList<>();
        if(size==0)
            return result;
        // while(current<size)
        // {
        //     if(current!=size-1)//not last index.
        //     {
        //         if(nums[current]+1==nums[current+1])
        //         {
        //             current++;
        //         }
        //         else if(nums[start]!=nums[current]) //[0,2,3,4,6,8,9]  o/p ["0","2->4","6","8->9"]
        //         {                            // to avoid 0->0
        //             result.add(nums[start] + "->" + nums[current]);
        //             current++;
        //             start=current;
        //         }
        //         else
        //         {
        //             result.add(nums[start] + "");
        //             current++;
        //             start=current;
        //         }
        //     }
        //     else
        //     {
        //         result.add(nums[current] + "");
        //     }
        // }
        // return result;   MEMORY LIMIT EXCEEDING
        //There were redundancies previously
        while(current<size)
        {
            if(current!=size-1 && (nums[current]+1==nums[current+1]))
            {
                current++;
            }
            else{
                if(nums[start]!=nums[current])
                {
                    result.add(nums[start] + "->" + nums[current]);
                    current++;
                    start=current;
                }
                else{
                    result.add(nums[start] + "");
                    current++;
                    start=current;
                }
            }
        }
        // while (current < size) {
        //     if (current != size - 1 && nums[current] + 1 == nums[current + 1]) {
        //         current++;
        //     } 
        //     else {
        //         StringBuilder range = new StringBuilder();
        //         range.append(nums[start]);
        //         if (start != current) {
        //             range.append("->").append(nums[current]);
        //         }
        //         result.add(range.toString());
        //         current++;
        //         start = current;
        //     }
        // }
        return result;
    }
}