//Ladder approach
//can be used in case "The first integer of each row is greater than the last integer of the previous row." is not given
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int i = 0; //first row
        int j = cols - 1; // last col
        //initially pointing at first row last col
        while(i<rows && j>=0)
        {
            if(target == matrix[i][j])
            {
                return true;
            }
            else if(target < matrix[i][j])
            {
                j--; // 1 3 5 7 . last ind val 7 if target<7 it will be left to it col--
            }
            else
            {       // 1  3  5  7
                i++;//10 11 16 20  target>7 will be in bottom. row ++
            }
        }
        return false;
    }
}