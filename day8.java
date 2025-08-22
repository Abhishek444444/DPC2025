import java.util.*;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        String[] words = s.split("\\s+");

        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "the sky is blue";
        System.out.println(sol.reverseWords(s1));

        String s2 = "  hello world  ";
        System.out.println(sol.reverseWords(s2));

        String s3 = "a good   example";
        System.out.println(sol.reverseWords(s3)); 

        String s4 = "    ";
        System.out.println("\"" + sol.reverseWords(s4) + "\"");

        String s5 = "word";
        System.out.println(sol.reverseWords(s5)); 
    }
}
