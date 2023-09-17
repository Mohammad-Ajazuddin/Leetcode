class Solution {
    public static List<Integer> generateRow(int rowNum)
    {
        int result = 1;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<rowNum;i++)
        {
            if(i==0)
            {
                temp.add(1);
            }
            else
            {
                result = result * (rowNum-i);
                result = result/i;
                temp.add(result);
            }
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            result.add(generateRow(i));
        }
        return result;
    }
}