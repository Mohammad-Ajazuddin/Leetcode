import java.util.*;
// class Solution {
//     public static int getNum(String s,int i)
//     {
//         int n=0;
//         if(s.charAt(i)=='I')
//         {
//             n=1;
//         }
//         else if(s.charAt(i)=='V')
//         {
//             n=5;
//         }
//         else if(s.charAt(i)=='X')
//         {
//             n=10;
//         }
//         else if(s.charAt(i)=='L')
//         {
//             n=50;
//         }
//         else if(s.charAt(i)=='C')
//         {
//             n=100;
//         }
//         else if(s.charAt(i)=='D')
//         {
//             n=500;
//         }
//         else if(s.charAt(i)=='M')
//         {
//             n=1000;
//         }
//         return n;
//     }
//     public static int romanToInt(String s) {
//         int sum=0;
//         for(int i=s.length()-1;i>=0;i--)
//         {
//             int n1=getNum(s,i);
//             int n2=0;
//             if(i!=0)
//                 n2=getNum(s,i-1);
//             if(n1>n2)
//             {
//                 sum+=(n1-n2);
//                 i--;
//             }
//             else
//             {
//                 sum+=n1;
//             }
//         }
//         return sum;
//     }
// }
class Solution{
    public int romanToInt(String s) {
    
        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }
}
