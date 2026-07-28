import java.util.*;

class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        StringBuilder half = new StringBuilder();
        char mid = '\0';
        
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if (cnt[i] % 2 == 1) {
                mid = c;
            }
            int half_count = cnt[i] / 2;
            for (int j = 0; j < half_count; j++) {
                half.append(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append(half);
        if (mid != '\0') {
            result.append(mid);
        }
        result.append(half.reverse());
        
        return result.toString();
    }
}