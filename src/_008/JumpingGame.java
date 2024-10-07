package _008;

class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}

public class JumpingGame {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Example 1: " + solution.canJump(nums1));  // Output: true

        // Example 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Example 2: " + solution.canJump(nums2));  // Output: false
    }
}