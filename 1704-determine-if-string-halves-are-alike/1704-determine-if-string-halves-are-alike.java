// class Solution {
//     public boolean halvesAreAlike(String s) {
//         int n = s.length();
//         int avowels = 0;
//         int bvowels = 0;
//         for(int i=0;i<n;i++)
//         {
//             if(i<(n/2))
//             {
//                 if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U')
//                     avowels++;
//             }
//             else
//             {
//         if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U')
//                     bvowels++;
//                 }
//             }
//         }
        
//     }
// }

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> st = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int vowelsCount = 0;
        int n = s.length();
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            char charA = s.charAt(i);
            char charB = s.charAt(mid + i);
            if (st.contains(charA)) {
                vowelsCount++;
            }
            if (st.contains(charB)) {
                vowelsCount--;
            }
        }
        return vowelsCount == 0;
    }
}
