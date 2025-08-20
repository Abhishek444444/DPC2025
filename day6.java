import java.util.*;

public class day6 {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        int n = arr.length;
        int prefixSum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // Case 1: subarray from 0 to i
            if (prefixSum == 0) {
                result.add(new int[]{0, i});
            }

            // Case 2: prefixSum seen before
            if (map.containsKey(prefixSum)) {
                for (int start : map.get(prefixSum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            // Store index of prefixSum
            map.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    // Helper to pretty-print
    private static String format(List<int[]> res) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] pair : res) {
            sb.append("(").append(pair[0]).append(", ").append(pair[1]).append("), ");
        }
        if (!res.isEmpty()) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(format(findZeroSumSubarrays(new int[]{1, 2, -3, 3, -1, 2})));
        System.out.println(format(findZeroSumSubarrays(new int[]{4, -1, -3, 1, 2, -1})));
        System.out.println(format(findZeroSumSubarrays(new int[]{1, 2, 3, 4})));
        System.out.println(format(findZeroSumSubarrays(new int[]{0, 0, 0})));
        System.out.println(format(findZeroSumSubarrays(new int[]{-3, 1, 2, -3, 4, 0})));
    }
}
