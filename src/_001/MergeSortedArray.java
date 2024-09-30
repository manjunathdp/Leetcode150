package _001;
// Merge Sorted Array Approaches

public class MergeSortedArray {
    
    // Your Approach (Sorting after merging)
    public void mergeUsingSorting(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        for (int i = 0; i < m + n; i++) {
            for (int j = i + 1; j < m + n; j++) {
                if (nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }

    // Efficient Approach (Two-pointer technique)
    public void mergeUsingTwoPointers(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MergeSortedArray solution = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        // Test your approach
        System.out.println("Using Sorting Approach:");
        solution.mergeUsingSorting(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Reset nums1
        nums1 = new int[]{1, 2, 3, 0, 0, 0};

        // Test efficient approach
        System.out.println("Using Two-pointer Approach:");
        solution.mergeUsingTwoPointers(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
