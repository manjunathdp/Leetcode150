# Remove Element - Solution Explanation

## Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place. The order of the elements may be changed. Return the number of elements in `nums` which are not equal to `val`.

After removing the occurrences of `val`, the first `k` elements of `nums` should contain the elements that are not equal to `val`, while the remaining elements of `nums` do not matter.

### Example:

**Input:**  
`nums = [0,1,2,2,3,0,4,2]`, `val = 2`

**Output:**  
`k = 5`, `nums = [0,1,4,0,3,_,_,_]`

**Explanation:**  
Your function should return `k = 5`, and the first 5 elements of `nums` will be `[0, 1, 4, 0, 3]`. The remaining elements (underscores) do not matter.

---

## Step-by-Step Explanation with Visualization

We will iterate over the array, and whenever we encounter an element that is not equal to `val`, we move it to the front of the array. We maintain a pointer `p` to track the position of the last valid element.

Let's break down the steps using the example `nums = [0,1,2,2,3,0,4,2]` and `val = 2`:

### Initial State:

`nums = [0, 1, 2, 2, 3, 0, 4, 2]`  
`p = 0`

### Iteration Steps:

1. **Iteration 1:**  
   `nums[0] = 0` (not equal to `val`).  
   Move `nums[0]` to `nums[p]` and increment `p`.  
   Result: `nums = [0, 1, 2, 2, 3, 0, 4, 2]`, `p = 1`

2. **Iteration 2:**  
   `nums[1] = 1` (not equal to `val`).  
   Move `nums[1]` to `nums[p]` and increment `p`.  
   Result: `nums = [0, 1, 2, 2, 3, 0, 4, 2]`, `p = 2`

3. **Iteration 3:**  
   `nums[2] = 2` (equal to `val`).  
   Do nothing.

4. **Iteration 4:**  
   `nums[3] = 2` (equal to `val`).  
   Do nothing.

5. **Iteration 5:**  
   `nums[4] = 3` (not equal to `val`).  
   Move `nums[4]` to `nums[p]` and increment `p`.  
   Result: `nums = [0, 1, 3, 2, 3, 0, 4, 2]`, `p = 3`

6. **Iteration 6:**  
   `nums[5] = 0` (not equal to `val`).  
   Move `nums[5]` to `nums[p]` and increment `p`.  
   Result: `nums = [0, 1, 3, 0, 3, 0, 4, 2]`, `p = 4`

7. **Iteration 7:**  
   `nums[6] = 4` (not equal to `val`).  
   Move `nums[6]` to `nums[p]` and increment `p`.  
   Result: `nums = [0, 1, 3, 0, 4, 0, 4, 2]`, `p = 5`

### Final Result:

The first 5 elements in the array are `[0, 1, 3, 0, 4]`, and `p = 5`. Return `p` as the count of elements that are not equal to `val`.

---

## Time and Space Complexity

- **Time Complexity:** O(n), where `n` is the length of the array. We only iterate through the array once.
- **Space Complexity:** O(1), since we do not use any extra space that grows with the input size.

---

## Conclusion

This solution efficiently removes the specified value from the array while maintaining low time and space complexity. The function returns the count of valid elements, and the remaining elements in the array do not matter.

---

## Java Code

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }
        return p;
    }
}
