package _011;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] citations1 = {3, 0, 6, 1, 5};
        System.out.println("Test Case 1 - Expected Output: 3");
        System.out.println("Output: " + solution.hIndex(citations1));
        System.out.println();

        // Test Case 2
        int[] citations2 = {1, 3, 1};
        System.out.println("Test Case 2 - Expected Output: 1");
        System.out.println("Output: " + solution.hIndex(citations2));
        System.out.println();

        // Test Case 3 - All zero citations
        int[] citations3 = {0, 0, 0, 0};
        System.out.println("Test Case 3 - Expected Output: 0");
        System.out.println("Output: " + solution.hIndex(citations3));
        System.out.println();

        // Test Case 4 - All high citations
        int[] citations4 = {10, 8, 5, 4, 3};
        System.out.println("Test Case 4 - Expected Output: 4");
        System.out.println("Output: " + solution.hIndex(citations4));
        System.out.println();

        // Test Case 5 - Mixed citations
        int[] citations5 = {25, 8, 5, 3, 3};
        System.out.println("Test Case 5 - Expected Output: 3");
        System.out.println("Output: " + solution.hIndex(citations5));
    }
}

class Solution {
    public int hIndex(int[] citations) {
        // Step 1: Sort the citations array in ascending order
        Arrays.sort(citations);
        int n = citations.length;

        // Step 2: Traverse through the sorted array
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }

        return 0;
    }
}
