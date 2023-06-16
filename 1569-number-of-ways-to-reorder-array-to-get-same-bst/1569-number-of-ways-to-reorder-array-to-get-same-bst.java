class Solution {
    static int MOD = 1000000007;
    static int[][] pascalTriangle;
    
    public int numOfWays(int[] nums){
        //build only if haven't built
        if(pascalTriangle==null)
            buildPascalTriangle();
        List<Integer> arr = new ArrayList<>();
        for(int n:nums)
            arr.add(n);
        //get all combinations
        return (int)numOfWays(arr) - 1; //-1 coz 1 combination is already given
    }
    
    private long numOfWays(List<Integer> nums)
    {
        if(nums.size()<=2)
            return 1;
        
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int n:nums)
        {
            if(n<root)
            {
                left.add(n);
            }
            else if(n>root){
                right.add(n);
            }
        }
        return (pascalTriangle[left.size() + right.size()][left.size()] % MOD * numOfWays(left) % MOD * numOfWays(right) % MOD);
    }
    static void buildPascalTriangle(){
        int n=1000;
        pascalTriangle = new int[n][n];
        // Populate the triangle
       for (int i = 0; i < n; i++) {pascalTriangle[i][i] = 1;
                                    pascalTriangle[i][0] =1;}
       
       for(int i=2;i<n;i++){
            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = (pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j]) % MOD;
            }
        }
    }
}