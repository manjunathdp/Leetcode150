package _002;

class RemoveElement {

    // Main method with example
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int k = removeElement(nums, val);

        System.out.println("k = " + k);  // Should output: k = 2
        System.out.print("Updated array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        // Should output: Updated array: 2 2
    }

    public static int removeElement(int[] nums, int val) {
        int p = 0;  // Pointer to track the position of non-val elements
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];  // Move the element to the 'p' position
                p++;  // Increment 'p' for the next non-val element
            }
        }
        return p;  // 'p' is the length of the array without the 'val' elements

    }


}
