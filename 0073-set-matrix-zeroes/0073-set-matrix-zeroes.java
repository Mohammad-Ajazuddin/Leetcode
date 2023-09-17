// //bruteforce
// class Solution {
//     void markRow(int r,int cols,int[][] matrix)
//     {
//         for(int i=0;i<cols;i++)
//         {
//             if(matrix[r][i]!=0)
//             {
//                 matrix[r][i] = -1;
//             }
//         }
//     }
    
//     void markCol(int c,int rows,int[][] matrix)
//     {
//         for(int i=0;i<rows;i++)
//         {
//             if(matrix[i][c]!=0)
//             {
//                 matrix[i][c] = -1;
//             }
//         }
//     }
    
    // public void setZeroes(int[][] matrix) {
    //     int rows = matrix.length;
    //     int cols = matrix[0].length;
//         for(int i=0;i<rows;i++)
//         {
//             for(int j=0;j<cols;j++)
//             {
//                 if(matrix[i][j]==0)
//                 {
//                     markRow(i,cols,matrix);
//                     markCol(j,rows,matrix);
//                 }
//             }
//         }
        
//         for(int i=0;i<rows;i++)
//         {
//             for(int j=0;j<cols;j++)
//             {
//                 if(matrix[i][j]==-1)
//                 {
//                     matrix[i][j]=0;
//                 }
//             }
//         }
//     }
// }
//another approach

class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length; 
        int col0 = 1;
        //mat[0][...] => cols
        //1st row in mat wil be tracking zeros of cols
        //as mat[0][0] overlap we are using 1st row from 2nd col to keep track of 0's columns col0 var for first col
        //mat[...][0] => rows
        //1st col keeps track of 0's rows
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {

                if(matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    if(j!=0)
                    {
                        matrix[0][j] = 0;
                    }
                    else
                    {
                        col0 = 0;
                    }
                }
            }
        }
    
        for(int i=1;i<rows;i++)
        {
            for(int j=1;j<cols;j++)
            {
                //if not 0 there might be conversion
                if(matrix[i][j]!=0)
                {
                  //check for rows & cols(which marked for tracking) which is 0
                   if(matrix[i][0] == 0 || matrix[0][j] == 0)
                   {
                       matrix[i][j] = 0; // marking/changing of smaller matrix done
                   }
                }
            }
        }
        
        if(matrix[0][0]==0)
        {
            for(int j=0;j<cols;j++)
            {
                matrix[0][j] = 0;
            }
        }
        
        if(col0 == 0)
        {
            for(int i=0;i<rows;i++)
            {
                matrix[i][0] = 0;
            }
        }
    }
}