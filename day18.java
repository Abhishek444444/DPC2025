class Solution {
    public int countDivisors(int N) {
        int count = 0;

        // Iterate only up to sqrt(N)
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) { // i is a divisor
                if (i * i == N) {
                    // Perfect square divisor counted once
                    count += 1;
                } else {
                    // Count both i and N/i
                    count += 2;
                }
            }
        }

        return count;
    }

    // Main function to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countDivisors(12));   // Output: 6
        System.out.println(sol.countDivisors(18));   // Output: 6
        System.out.println(sol.countDivisors(29));   // Output: 2
        System.out.println(sol.countDivisors(100));  // Output: 9
        System.out.println(sol.countDivisors(1));    // Output: 1
        System.out.println(sol.countDivisors(997));  // Output: 2
    }
}
