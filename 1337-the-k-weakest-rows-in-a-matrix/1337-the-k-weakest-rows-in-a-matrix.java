class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[k];
        Map<Integer,Integer> rowSoldiers = new HashMap<>(m);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                //soldiers
                if(mat[i][j]==1)
                {
                    if(rowSoldiers.containsKey(i))
                    {
                        rowSoldiers.put(i,rowSoldiers.get(i)+1);
                    }
                    else{
                        rowSoldiers.put(i,1);
                    }
                }
                else if(j==0)
                {
                    rowSoldiers.put(i,0);
                    break;
                }
            }
        }
        
        for(int i=0;i<k;i++)
        {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int j=0;j<m;j++)
            {
                if(min>rowSoldiers.get(j)){
                    index = j;
                    min = rowSoldiers.get(j);
                }
            }
            rowSoldiers.put(index,Integer.MAX_VALUE);
            result[i] = index;
        }
        return result;
    }
}