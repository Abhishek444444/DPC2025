import java.util.*;

class Solution {
    public List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];

        // Convert string to char array and sort (to handle duplicates easily)
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        backtrack(chars, new StringBuilder(), used, result);
        return result;
    }

    private void backtrack(char[] chars, StringBuilder path, boolean[] used, List<String> result) {
        // Base case: if path length == chars length, add permutation
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }

        // Try each character
        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (used[i]) continue;

            // Skip duplicates: only allow first unused duplicate
            if (i > 0 && chars[i] == chars[i-1] && !used[i-1]) continue;

            // Choose
            used[i] = true;
            path.append(chars[i]);

            // Explore
            backtrack(chars, path, used, result);

            // Undo choice (backtrack)
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }

    // Driver main
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.permuteUnique("abc")); 
        System.out.println(sol.permuteUnique("aab"));  
        System.out.println(sol.permuteUnique("aaa"));  
        System.out.println(sol.permuteUnique("a"));    
        System.out.println(sol.permuteUnique("abcd")); 
    }
}
