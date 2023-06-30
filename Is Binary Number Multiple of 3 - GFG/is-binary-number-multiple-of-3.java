//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine().trim());
            while(t-->0)
                {
                    String s = in.readLine().trim();
                    Solution ob = new Solution();
                    out.println(ob.isDivisible(s));
                }
                out.close();
        }
}    
// } Driver Code Ends


//User function Template for Java

// class Solution {
//     int isDivisible(String s) {
//         // code here
//         int sum=0;
//         int size = s.length();
//         for(int i=size-1;i>=0;i--)
//         {
//             int digit = Character.getNumericValue(s.charAt(i));
//             sum += digit * (int) Math.pow(2, size - 1 - i);
//         }
//         if(sum%3==0)
//         {
//             return 1;
//         }
//         else{
//             return 0;
//         }
//     }
// } only 15 Testcases passed. Need to figure out the reason

class Solution {
    int isDivisible(String s) {
        int evenSum = 0;
        int oddSum = 0;
        int size = s.length();
        
        for (int i = size - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i));
            
            if (i % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }
        
        int difference = Math.abs(evenSum - oddSum);
        if (difference % 3 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

