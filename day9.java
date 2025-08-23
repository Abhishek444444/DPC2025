class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Take the first string as the prefix candidate
        String prefix = strs[0];

        // Compare prefix with every other string
        for (int i = 1; i < strs.length; i++) {
            // Shrink prefix until it matches the beginning of strs[i]
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // Driver main
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] input1 = {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix(input1)); // fl

        String[] input2 = {"dog", "racecar", "car"};
        System.out.println(sol.longestCommonPrefix(input2)); // ""

        String[] input3 = {"apple", "ape", "april"};
        System.out.println(sol.longestCommonPrefix(input3)); // ap

        String[] input4 = {""};
        System.out.println(sol.longestCommonPrefix(input4)); // ""

        String[] input5 = {"alone"};
        System.out.println(sol.longestCommonPrefix(input5)); // alone
    }
}
