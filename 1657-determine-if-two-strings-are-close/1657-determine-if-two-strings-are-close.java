class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
        {
            return false;
        }
        //to store count of chars in word1 and word2
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        
        for(int i=0;i<word1.length();i++)
        {
            freq1[word1.charAt(i)-'a']++;
            //ascii value of a = 97
            //0-25 indices. So if char a, then a-a = 0
        }
        
        for(int i=0;i<word2.length();i++)
        {
            freq2[word2.charAt(i)-'a']++;
        }
        
        
        // Now say abb, baa
        //       1a 2bs 1b 2as a,b must be in w2
        //here we check all distinct chars of w1 must present in w2
        //so we can rearrange
        //if not , not close words so return false
        for(int i=0;i<26;i++)
        {
            if((freq1[i]>0 && freq2[i]==0) ||(freq1[i]==0 && freq2[i]>0))
                return false;
        }
        
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        //here sorting bcz
        // bba, baa => 2bs,1a , 1b, 2as
        //after sorting 1,2 1,2
        //so op2 can be done
        //1a can be replaced with b and bs with a, then op1 so words become alike.
        //so now we check after sorting frequencies should be equal, then only equal frequency words can be replaced. else false
        
        for(int i=0;i<26;i++)
        {
            if(freq1[i]!=freq2[i])
                return false;
        }
        return true;
    }
}