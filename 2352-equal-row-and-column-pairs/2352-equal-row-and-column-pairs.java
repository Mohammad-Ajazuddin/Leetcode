class Solution {
    public int equalPairs(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int count=0;
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        // if(rows==2)
        // {
        //     if((grid[0][0]==grid[0][1]) && grid[1][0]==grid[1][1])
        //     {
        //         return 4;
        //     }
        //     else if((grid[0][0]==grid[1][1])||(grid[0][1]==grid[1][0]))
        //     {
        //         return 2;
        //     }
        // }
        for(int i=0;i<rows;i++)
        {
            s1.setLength(0);
            for(int j=0;j<cols;j++)
            {
                s1.append(grid[i][j]);
            }
            for(int k=0;k<cols;k++)
            {
                s2.setLength(0);
                for(int l=0;l<rows;l++)
                {
                    s2.append(grid[l][k]);
                }
                if(s1.toString().equals(s2.toString()))
                {
                    int check=0;
                    int r=i,c=k;
                    for(int m=0;m<rows;m++)
                    {
                        if(grid[r][m]==grid[m][c])
                        {
                            check++;
                        }
                        else{
                            break;
                        }
                    }
                    if(check==rows)
                    {
                        count++;
                    }
                }
            }
            
        }
        return count;
    }
} //WRONG ANSWER
