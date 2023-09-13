//My code
// class Solution {
//     public int lengthOfLastWord(String s) {
//         String trimmed = s.trim();
//         int totalLength = trimmed.length();
//         int length = 0;
//         for(int i=(totalLength-1);(i>=0 && trimmed.charAt(i)!=' ');i-- )
//         {
//             length++;
//         }
//         return length;
//     }
// }

class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int ans = 0;

        while(i>=0) {
            if(s.charAt(i)!=' ') {
                ans++;
            }
            else {
                if(ans>0) {
                    return ans;
                }
            }
            i--;
        }

        return ans;
    }
}