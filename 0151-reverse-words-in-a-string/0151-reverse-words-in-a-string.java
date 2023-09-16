class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim(); //heading trailing spaces removed
        String[] words = s1.split("\\s+");// splits if one or more spaces like "a good    example"
        int words_count = words.length;
        StringBuilder result = new StringBuilder();
        for(int i=words_count - 1;i>=0;i--)
        {
            result.append(words[i]);   
            if(i!=0)
            {
                result.append(" ");
            }
        }
        return result.toString();
    }
}