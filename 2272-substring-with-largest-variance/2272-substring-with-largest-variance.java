class Solution {
    public int largestVariance(String s) {
        int ans = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                if (ch1 == ch2 || freq.getOrDefault(ch1, 0) == 0 || freq.getOrDefault(ch2, 0) == 0) {
                    continue;
                }
                
                for (int rev = 1; rev <= 2; rev++) {
                    int cnt1 = 0, cnt2 = 0;
                    
                    for (char c : s.toCharArray()) {
                        cnt1 += c == ch1 ? 1 : 0;
                        cnt2 += c == ch2 ? 1 : 0;
                        
                        if (cnt1 < cnt2) {
                            cnt1 = cnt2 = 0;
                        }
                        
                        if (cnt1 > 0 && cnt2 > 0) {
                            ans = Math.max(ans, cnt1 - cnt2);
                        }
                    }
                    
                    s = new StringBuilder(s).reverse().toString();
                }
            }
        }
        
        return ans;
    }
}
