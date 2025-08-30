public class LCMCalculator {

    // Function to calculate GCD using Euclidean Algorithm
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using relation with GCD
    public static long lcm(long n, long m) {
        return (n / gcd(n, m)) * m;  // divide first to avoid overflow
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("LCM of 4 and 6 = " + lcm(4, 6));          // Expected 12
        System.out.println("LCM of 5 and 10 = " + lcm(5, 10));        // Expected 10
        System.out.println("LCM of 7 and 3 = " + lcm(7, 3));          // Expected 21
        System.out.println("LCM of 1 and 987654321 = " + lcm(1, 987654321)); // Expected 987654321
        System.out.println("LCM of 123456 and 789012 = " + lcm(123456, 789012)); // Expected 8117355456
    }
}
