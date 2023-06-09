class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int size=letters.length;
        for(int i=0;i<size;i++)
        {
            if(letters[i]>target)
            {
                return letters[i];
            }
            // else if(letters[i]==target && i<(size-1))
            // {
            //     return letters[i+1];
            // }
        }
        return letters[0];
    }
}