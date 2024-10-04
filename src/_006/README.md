# Rotate Array - Solution Explanation

## Question

**Problem:**  
Given an integer array `nums`, rotate the array to the right by `k` steps, where `k` is non-negative.

### Example 1:
**Input:**  
`nums = [1,2,3,4,5,6,7]`, `k = 3`

**Output:**  
`[5,6,7,1,2,3,4]`

### Example 2:
**Input:**  
`nums = [-1,-100,3,99]`, `k = 2`

**Output:**  
`[3,99,-1,-100]`

---

## Algorithm Used: Array Reversal

This algorithm solves the problem using three reversals:

1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n - k` elements.

This method ensures the array is rotated in place with **O(1)** extra space.

---

## Step-by-Step Explanation with Visualization

Let’s take the example `nums = [1,2,3,4,5,6,7]`, `k = 3`.

### Initial Array:

| 1 | 2 | 3 | 4 | 5 | 6 | 7 |
|---|---|---|---|---|---|---|

### Step 1:
Reverse the entire array.

| 7 | 6 | 5 | 4 | 3 | 2 | 1 |
|---|---|---|---|---|---|---|
| ↑ |   |   |   |   |   |   |

---

### Step 2:
Reverse the first `k = 3` elements.

| 5 | 6 | 7 | 4 | 3 | 2 | 1 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ |   |   |   |   |

---

### Step 3:
Reverse the remaining `n - k = 4` elements.

| 5 | 6 | 7 | 1 | 2 | 3 | 4 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ | ↑ | ↑ | ↑ | ↑ |

---

### Final Result:
The rotated array is **[5, 6, 7, 1, 2, 3, 4]**.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the array.
- **Space Complexity:** `O(1)`, since the array is modified in place.

---

## Java Code

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
