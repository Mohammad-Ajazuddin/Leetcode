//Ladder approach
//can be used in case "The first integer of each row is greater than the last integer of the previous row." is not given
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int rows = matrix.length;
//         int cols = matrix[0].length;
        
//         int i = 0; //first row
//         int j = cols - 1; // last col
//         //initially pointing at first row last col
//         while(i<rows && j>=0)
//         {
//             if(target == matrix[i][j])
//             {
//                 return true;
//             }
//             else if(target < matrix[i][j])
//             {
//                 j--; // 1 3 5 7 . last ind val 7 if target<7 it will be left to it col--
//             }
//             else
//             {       // 1  3  5  7
//                 i++;//10 11 16 20  target>7 will be in bottom. row ++
//             }
//         }
//         return false;
//     }
// }//0ms 41mb

//using binary search
//The first integer of each row is greater than the last integer of the previous row. so if we think to arrange all in 1d arr. all will be sorted
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = (rows*cols)-1;
        //not creating any temp 1d arr
        //   0  1  2  3
        //0  1  3  5  7
        //1 10 11 12 13
        //  0 1 2 3  4  5  6  7
        //  1 3 5 7 10 11 12 13
        //say 11 at ind 5 here but in 2d its at 1,1
        //row = a[mid/cols] col = a[mid%cols]
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(target == matrix[mid/cols][mid%cols])
            {
                return true;
            }
            else if(target < matrix[mid/cols][mid%cols])
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return false;
    }
}//0ms