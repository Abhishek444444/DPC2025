import java.util.*;

public class MergeTwoSortedArrays {
    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                // Swap arr1[i] and arr2[j]
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;

                // Fix arr2[j] (since it might be out of order)
                int first = arr2[j];
                int k = j + 1;
                while (k < n && arr2[k] < first) {
                    arr2[k - 1] = arr2[k];
                    k++;
                }
                arr2[k - 1] = first;

                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
    }
}
