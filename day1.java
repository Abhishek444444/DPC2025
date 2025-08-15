public class day1{

public void arr_Sort(int[] nums) {

        int n = nums.length;
        if(n==0 || n==1){
            System.out.println("Array is Empty or have only 1 element");
            return;
        }
        int a = 0, b = 0, c = n - 1;

        while (b <= c) {
            if (nums[b] == 0) {
                swap(nums, a, b);
                a++;
                b++;
            } else if (nums[b] == 1) {
                b++;
            } else {
                swap(nums, b, c);
                c--;
            }
        }

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {

        System.out.print("[");

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");

    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 1, 0, 2, 1, 0 };
        day1 a = new day1();
        a.arr_Sort(arr);
        a.printArray(arr);
    }
}