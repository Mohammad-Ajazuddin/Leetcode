class Solution {
    public static int rev(int num)
    {
        int ans = 0;
        while(num>0)
        {
            int lastdigit = num%10;
            ans = ans * 10 + lastdigit;
            num = num/10;
        }
        return ans;
    }
    public int countNicePairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        int mod = (int)(1e9+7);
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            int rev = rev(num);
            int diff = num - rev;
            if(map.containsKey(diff))
            {
                count = (count + map.get(diff)) % mod;
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        return count;
    }
}