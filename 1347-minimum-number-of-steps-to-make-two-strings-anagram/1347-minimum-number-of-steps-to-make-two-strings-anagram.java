// class Solution {
//     public int minSteps(String s, String t) {
//         char[] sstr = s.toCharArray();
//         char[] tstr = t.toCharArray();
//         int count = s.length();
//         for(int i=0;i<s.length();i++)
//         {
//             for(int j=0;j<t.length();j++)
//             {
//                 if(sstr[i]==tstr[j])
//                 {
//                     tstr[j] = '*';
//                     count--;
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// } O(N^2)

class Solution {
    public int minSteps(String s, String t) {
        Map<Character,Integer> mp = new HashMap<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(mp.containsKey(c))
            {
                mp.put(c,mp.get(c)+1);
            }
            else
            {
                mp.put(c,1);
            }
        }
        
        for(int i=0;i<t.length();i++)
        {
            char c = t.charAt(i);
            if(mp.containsKey(c) && mp.get(c)!=0)
            {
                mp.put(c,mp.get(c)-1);
            }
            else
            {
                count++;
            }
        }
        return count;
    }
}