import java.util.*;

 class PrimeFactorization {

    // Function to return prime factors of a number
    public static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();

        // Step 1: Factor out 2 (even prime)
        while (n % 2 == 0) {
            factors.add(2L);
            n /= 2;
        }

        // Step 2: Factor out odd numbers up to sqrt(n)
        for (long i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Step 3: If n > 1, then it's a prime factor
        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    // Main function to test
    public static void main(String[] args) {
        System.out.println("Factors of 18: " + primeFactors(18));         // [2, 3, 3]
        System.out.println("Factors of 30: " + primeFactors(30));         // [2, 3, 5]
        System.out.println("Factors of 49: " + primeFactors(49));         // [7, 7]
        System.out.println("Factors of 19: " + primeFactors(19));         // [19]
        System.out.println("Factors of 64: " + primeFactors(64));         // [2, 2, 2, 2, 2, 2]
        System.out.println("Factors of 123456: " + primeFactors(123456)); // [2, 2, 2, 2, 2, 3, 643]
    }
}
