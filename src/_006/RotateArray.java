package _006;

public class RotateArray  {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original Array:");
        printArray(nums);

        rotate(nums, k);

        System.out.println("Array after rotation by " + k + " steps:");
        printArray(nums);
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;  // To handle cases where k > nums.length
        reverse(nums, 0, nums.length - 1);  // Step 1: Reverse the entire array
        reverse(nums, 0, k - 1);  // Step 2: Reverse the first k elements
        reverse(nums, k, nums.length - 1);  // Step 3: Reverse the rest
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

