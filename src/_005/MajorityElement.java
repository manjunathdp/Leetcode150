package _005;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int points = 0;

        for (int num : nums) {
            if (points == 0) {
                candidate = num;
            }
            points += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {

        // Example 2
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);

        System.out.println("The majority element is: " + result); // Output: 2
    }
}
