//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            
            String S1[] = read.readLine().split(" ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxDiamonds(A,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long maxDiamonds(int[] A, int N, int K) {
        // code here
    //     long sum=0;
    //     for(int i=0;i<K;i++){
    //         // int maxInd=currentLarge(A,N);
    //         // sum+=A[maxInd];
    //         // A[maxInd]=A[maxInd]/2;
    //     }
    //     return sum;
    // }
    // static int currentLarge(int [] A,int N){
    //     int max=A[0],index=0;
    //     for(int i=0;i<N;i++)
    //     {
    //         if(A[i]>max)
    //         {
    //             max=A[i];
    //             index=i;
    //         }
    //     }
    //     return index;
    // } // TLE
        PriorityQueue<Integer> pq = new PriorityQueue<>(N,Comparator.reverseOrder());

        for(int i:A)
        {
            pq.add(i);
        }
        long sum=0;
        for(int i=0;i<K;i++)
        {
            sum+=pq.peek();// Add the largest element to the sum
            int val=pq.peek();
            pq.poll();
            pq.add(val/2);
        }   
        return sum;
    }
}    