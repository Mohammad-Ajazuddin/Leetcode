class Solution {
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        int totalLength = trimmed.length();
        int length = 0;
        for(int i=(totalLength-1);(i>=0 && trimmed.charAt(i)!=' ');i-- )
        {
            length++;
        }
        return length;
    }
}