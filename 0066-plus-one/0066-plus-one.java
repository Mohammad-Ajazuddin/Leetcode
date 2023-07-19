// class Solution {
//     public int[] plusOne(int[] digits) {
//         int size = digits.length;
//         if(digits[size-1]==0)
//         {
//             digits[size-1] = 1;
//             return digits;
//         }
//         long number = 0L;
//         long place = 1L; // 1's 10's ...
//         for(int i=size-1;i>=0;i--)
//         {
//             number += digits[i] * place;
//             place *= 10;
//         }
//         number+=1;
//         long temp = number;
//         int length = String.valueOf(temp).length();
//         int[] result = new int[length];
//         for(int i=length-1;i>=0;i--)
//         {
//             result[i] = (int)(number%10L);
//             number/=10L;
//         }
//         return result;
//     }
// }// sily code ...79/111 cases passed

class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // If the entire array consists of nines, create a new array with size+1
        int[] result = new int[size + 1];
        result[0] = 1;
        return result;
    }
}
