class Solution {
    public void dfs(int[][] isConnected, int i,int[] visited, int n)
    {
        if(visited[i]==1)
        {
            return;
        }
        visited[i]=1;
        for(int j=0;j<n;j++)
        {
            if(isConnected[i][j]==1)
                dfs(isConnected,j,visited,n);
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int size=isConnected.length;
        int[] visited=new int[size];
        int result=0;
        for(int i=0;i<size;i++)
        {
            if(visited[i]==0)
            {
                result++;
                dfs(isConnected,i,visited,size);
            }
        }
        return result;
    }
}