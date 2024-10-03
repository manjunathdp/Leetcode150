package _004;

import java.util.Arrays;

public class RemoveDuplicates2 {

    public static int removeDuplicates(int[] nums) {
        int count = 0;
        // Traverse through the array
        for (int n : nums) {
            // Place the element if we haven't already placed it twice
            if (count < 2 || n != nums[count - 2]) {
                nums[count] = n;
                count++;
            }
        }
        return count; // Return the new length (k)
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(nums));

        int k = removeDuplicates(nums); // Call the function

        System.out.println("Modified Array: " + Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
        System.out.println("k = " + k); // Print the value of k
    }

}
