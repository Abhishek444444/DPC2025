class SolutionXOR {
    public int missingNumber(int[] arr) {
        int n = arr.length + 1; // one number missing
        int xorAll = 0, xorArr = 0;

        // XOR all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        // XOR all elements in arr
        for (int num : arr) {
            xorArr ^= num;
        }

        // Missing number
        return xorAll ^ xorArr;
    }

    public static void main(String[] args) {
        SolutionXOR sol = new SolutionXOR();

        int[] arr1 = {1, 2, 4, 5};
        System.out.println("Missing number: " + sol.missingNumber(arr1)); 

        int[] arr2 = {2, 3, 4, 5};
        System.out.println("Missing number: " + sol.missingNumber(arr2)); 

        int[] arr3 = {1, 2, 3, 4};
        System.out.println("Missing number: " + sol.missingNumber(arr3)); 

        int[] arr4 = {1};
        System.out.println("Missing number: " + sol.missingNumber(arr4)); 
    }
}
