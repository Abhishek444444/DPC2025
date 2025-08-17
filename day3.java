
    class Solution {
    public int findDuplicate(int[] nums) {
        // Step 1: Detect cycle (Floyd’s Tortoise & Hare)
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];        // move 1 step
            fast = nums[nums[fast]]; // move 2 steps
        } while (slow != fast);

        // Step 2: Find entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // duplicate number
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findDuplicate(new int[]{1,3,4,2,2})); // 2
        System.out.println(sol.findDuplicate(new int[]{3,1,3,4,2})); // 3
        System.out.println(sol.findDuplicate(new int[]{1,1}));       // 1
        System.out.println(sol.findDuplicate(new int[]{1,4,4,2,3})); // 4

    }
}


