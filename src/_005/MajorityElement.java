package _005;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int candidate = 0;
        int points = 0;

        for(int i = 0; i < nums.length; i++) {
            if(points == 0) {
                candidate = nums[i];
            }
            if(candidate == nums[i]) {
                points++;
            } else {
                points--;
            }
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
