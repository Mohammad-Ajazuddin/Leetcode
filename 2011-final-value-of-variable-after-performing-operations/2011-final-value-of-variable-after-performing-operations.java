class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;
        for(String s : operations)
        {
            if(s.contains("++"))
            {
                value++;
            }
            else
            {
               value--; 
            }
        }
        return value;
    }
}