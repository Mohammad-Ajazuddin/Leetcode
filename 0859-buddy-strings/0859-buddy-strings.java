class Solution {
    public boolean buddyStrings(String s, String goal) {
        int notmatch = 0;
        int size = s.length();
        int[] idx=new int[2];
        for(int i=0,j=0;i<size;i++)
        {
            if(s.charAt(i)!=goal.charAt(i))
            {
                notmatch++;
                if(notmatch>2)
                {
                    return false;
                }
                idx[j++]=i;
            }
        }
        boolean sameChars  = false;
        if(notmatch==0)
        {
            for(int i=0;i<size && sameChars==false;i++)
            {
                for(int j=0;j<size;j++)
                {
                    if(s.charAt(i)==s.charAt(j) && i!=j)
                    {
                        sameChars = true;
                        break;
                    }
                }
            }
            if(sameChars)
            {
                return true;
            }
            else{
                return false;
            }
        }
        char char1 = s.charAt(idx[0]);
        char char2 = s.charAt(idx[1]);
        String res="";
        for(int i=0;i<size;i++)
        {
            if(i==idx[0]||i==idx[1])
            {
                if(i==idx[0])
                {
                    res+=char2;
                }
                else{
                    res+=char1;
                }
            }
            else{
                res+=s.charAt(i);
            }
        }
        if(res.equals(goal))
        {
            return true;
        }
        else{
            return false;
        }
    }
}