// class Solution {
//     public double myPow(double x, int n) {
//         double result = 1;
//         int N = 0;
//         if(x == 1.0)
//         {
//             return x;
//         }
//         if(n < 0 && n!= Integer.MIN_VALUE)
//         {
//             N = -n;        
//         }
//         else
//         {
//             N = n;
//         }
//         if(N == Integer.MIN_VALUE)
//         {   
//             N = Integer.MAX_VALUE;
//             for(int i=0;i<N;i++)
//             {
//                 result *= x;
//             }
//             result *= x;
//             return 1/result;
//         }
        
//         else{
//             for(int i=0;i<N;i++)
//             {
//                 result *= x;
//             }
//         }
        
//         if(n < 0)
//         {
//             return 1/result;
//         }
//         else
//         {
//             return result;
//         }
//     }
// }

class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0) {
            return x;
        }
        
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return result;
    }
}
