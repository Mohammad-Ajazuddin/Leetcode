class Solution {
    static void reverse(int[] row,int rows)
    {
        int start = 0, end = rows-1;
        while(start<end)
        {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //transpose
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //reverse each row of transposed matrix
        for(int i=0;i<n;i++)
        {
            reverse(matrix[i],n);
        }
    }
}