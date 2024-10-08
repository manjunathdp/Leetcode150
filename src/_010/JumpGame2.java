package _010;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1;
        int jumps = 0;  // To count the number of jumps
        int current = 0; // Current farthest index that can be reached with the current number of jumps
        int farthest = 0; // Farthest index that can be reached

        for (int i = 0; i < n; i++) {
            // Update the farthest index we can reach
            farthest = Math.max(farthest, nums[i] + i);

            // If we reach the current limit, we need to make a jump
            if (i == current) {
                current = farthest; // Update the current limit to the farthest we can reach
                jumps++; // Increment the jump count
            }
        }

        return jumps;
    }

}

public class JumpGame2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for nums1: " + solution.jump(nums1)); // Output: 2

        // Example 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Minimum jumps for nums2: " + solution.jump(nums2)); // Output: 2
    }
}
