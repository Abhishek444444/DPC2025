import java.util.*;

class Solution {
    // Function to count substrings with exactly K distinct characters
    public int countExactlyKDistinct(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }

    // Helper: Count substrings with at most K distinct characters
    private int countAtMostK(String s, int k) {
        int n = s.length();
        int left = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // Shrink window if more than k distinct chars
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }
                left++;
            }

            // Add substrings ending at 'right'
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countExactlyKDistinct("pqpqs", 2));  // 7
        System.out.println(sol.countExactlyKDistinct("aabacbebebe", 3)); // 10
        System.out.println(sol.countExactlyKDistinct("a", 1)); // 1
        System.out.println(sol.countExactlyKDistinct("abc", 3)); // 1
        System.out.println(sol.countExactlyKDistinct("abc", 2)); // 2
    }
}
