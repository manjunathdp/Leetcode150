package _003;

import java.util.Arrays;


public class RemoveDuplicates {
    public static void main(String[] args) {


        // Example 2: Testing nums = [0,0,1,1,1,2,2,3,3,4]
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = removeDuplicates(nums);

        // Output results
        System.out.println("k = " + k); // Expected output: k = 5
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOfRange(nums, 0, k))); // Expected output: [0, 1, 2, 3, 4]
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}

