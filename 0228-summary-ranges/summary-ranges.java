class Solution {
    public List<String> summaryRanges(int[] nums) {
        int start=0;
        int current=0;
        int size=nums.length;
        List<String> result = new ArrayList<>();
        if(size==0)
            return result;
        while (current < size) {
             if (current != size - 1 && nums[current] + 1 == nums[current + 1]) {
                 current++;
             } 
             else {
                 StringBuilder range = new StringBuilder();
                 range.append(nums[start]);
                 if (start != current) {
                     range.append("->").append(nums[current]);
                 }
                 result.add(range.toString());
                 current++;
                 start = current;
             }
         }
         return result; 
    }
}// Runtime 0 ms. Memory 41 MB.
