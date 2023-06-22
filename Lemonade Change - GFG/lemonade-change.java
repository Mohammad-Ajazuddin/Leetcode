//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// class Solution {
//     static boolean lemonadeChange(int N, int bills[]) {
        // code here
    //     int fives=0,tens=0,twenties=0;
    // for(int i=0;i<N;i++){
    //     if(bills[0]==10 || bills[0]==20)
    //     {
    //         return false;
    //     }
    //     else if(bills[i]==5){
    //         fives++;
    //     }
    //     else if(bills[i]==10)
    //     {
    //         tens++;
    //     }
    //     else
    //     {
    //         twenties++;
    //     }
    // }
    // int flag = 0;
    // for(int i=0;i<N;i++)
    // {
    //     if(bills[i] == 10)
    //     {
    //         if(fives>=1 && fives!=0)
    //         {
    //             fives--;
    //         }
    //         else{
    //             flag = 1;
    //             break;
    //         }
    //     }
    //     else if(bills[i] == 20)
    //     {
    //         if(fives>=1 && tens>=1 && fives!=0 && tens!=0 )
    //         {
    //             fives--;
    //             tens--;
    //         }
    //         else if(fives>=3 && fives!=0)
    //         {
    //             fives-=3;
    //         }
    //         else{
    //             flag = 1;
    //             break;
    //         }
    //     }
    // }
    // if(flag==1)
    // {
    //     return false;
    // }
    // else{
    //     return true;
    // }This is wrong here actually Im collecting all the money first and later returning the change
    //  But it is not the problem stmt.
class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        int fiveCount = 0;
        int tenCount = 0;

        for (int i = 0; i < N; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else { // bills[i] == 20
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
