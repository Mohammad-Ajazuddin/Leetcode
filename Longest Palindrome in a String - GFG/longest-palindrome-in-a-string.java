//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
        // code here
        int size = S.length();
        int max_len = 1;
        int start = 0, end = 0;
        //odd length
        for(int i=0;i<size-1;i++)
        {
            int l = i, r = i;
            while(l>=0 && r<size)
            {
                if(S.charAt(l) == S.charAt(r))
                {
                    l--;
                    r++;
                }
                else{
                    break;
                }
            }
            int len = r - l - 1;
            if(len>max_len)
            {
                max_len = len;
                start = l + 1;
                end = r - 1;
            }
        }
        //even length
        for(int i=0;i<size-1;i++)
        {
            int l = i, r = i + 1;
            while(l>=0 && r<size)
            {
                if(S.charAt(l) == S.charAt(r))
                {
                    l--;
                    r++;
                }
                else{
                    break;
                }
            }
            int len = r - l - 1;
            if(len>max_len)
            {
                max_len = len;
                start = l + 1;
                end = r - 1;
            }
        }
        
        return S.substring(start,end+1);
    }
}