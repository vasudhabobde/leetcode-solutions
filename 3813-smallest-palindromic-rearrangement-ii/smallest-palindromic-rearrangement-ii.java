class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int halfLen = s.length() / 2;

        // Check if at least k permutations are possible
        long total = countPermutations(freq, halfLen, k);

        if (total < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                // Need at least 2 copies to put this character
                // on both sides of the palindrome
                if (freq[ch] < 2) {
                    continue;
                }

                // Choose this character
                freq[ch] -= 2;

                long ways = countPermutations(
                    freq,
                    halfLen - pos - 1,
                    k
                );

                if (ways >= k) {
                    // This character belongs here
                    left.append((char) ('a' + ch));
                    break;
                } else {
                    // Skip all permutations starting with this character
                    k -= ways;

                    // Restore frequency
                    freq[ch] += 2;
                }
            }
        }

        // Find middle character if length is odd
        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                middle = String.valueOf((char) ('a' + i));
                break;
            }
        }

        // Right half is reverse of left
        String right = new StringBuilder(left)
                            .reverse()
                            .toString();

        return left.toString() + middle + right;
    }


    private long countPermutations(
        int[] freq,
        int length,
        int limit
    ) {
        long result = 1;
        int total = 0;

        for (int i = 0; i < 26; i++) {

            int count = freq[i] / 2;

            if (count == 0) {
                continue;
            }

            // Calculate:
            // (total + count)! / (total! * count!)
            for (int j = 1; j <= count; j++) {

                result = result * (total + j) / j;

                // We only care whether result >= k
                if (result >= limit) {
                    return limit;
                }
            }

            total += count;
        }

        return result;
    }
}