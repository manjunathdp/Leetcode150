# Remove Duplicates 2 - Solution Explanation

## Question

**Problem:**  
Given an integer array `nums` sorted in non-decreasing order, remove duplicates in-place such that each unique element appears at most twice. The relative order of elements should be maintained.

Modify the array in-place and return the number of elements in `nums` after duplicates have been removed.

**Example:**

**Input:**  
`nums = [1,1,1,2,2,3]`

**Output:**  
`5, nums = [1,1,2,2,3,_]`

**Explanation:**  
Your function should return `k = 5`, and the first 5 elements of `nums` should contain `1, 1, 2, 2, and 3`. The remaining elements (underscores) do not matter.

---

## Step-by-Step Explanation with Visualization

We will iterate through the array and allow each unique element to appear at most twice. We use a `count` pointer to track where we place the next valid element.

Let's take the example `nums = [1,1,1,2,2,3]`:

| 1 | 1 | 1 | 2 | 2 | 3 |
|---|---|---|---|---|---|

**Step 1:** Initialize `count = 0`. Iterate through the array:

- **Iteration 1:** `nums[0] = 1`.  
  It is the first occurrence, so we place it at `nums[count]` and increment `count`.

  | 1 | 1 | 1 | 2 | 2 | 3 |
    |---|---|---|---|---|---|

- **Iteration 2:** `nums[1] = 1`.  
  Since we haven't seen two occurrences of 1 yet, place it at `nums[count]` and increment `count`.

  | 1 | 1 | 1 | 2 | 2 | 3 |
    |---|---|---|---|---|---|

- **Iteration 3:** `nums[2] = 1`.  
  We've already placed two occurrences of 1, so skip this element.

- **Iteration 4:** `nums[3] = 2`.  
  It is the first occurrence of 2, so place it at `nums[count]` and increment `count`.

  | 1 | 1 | 2 | 2 | 2 | 3 |
    |---|---|---|---|---|---|

- **Iteration 5:** `nums[4] = 2`.  
  Since we haven't seen two occurrences of 2 yet, place it at `nums[count]` and increment `count`.

  | 1 | 1 | 2 | 2 | 3 | _ |
    |---|---|---|---|---|---|

- **Iteration 6:** `nums[5] = 3`.  
  It is the first occurrence of 3, so place it at `nums[count]` and increment `count`.

  | 1 | 1 | 2 | 2 | 3 | _ |
    |---|---|---|---|---|---|

**Step 2:** After iterating through the array, the first 5 elements are the valid elements. Return `k = 5`.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the array. We iterate through the array once.
- **Space Complexity:** `O(1)`, since we modify the array in-place without extra space.

---

## Conclusion

This solution efficiently removes duplicates, allowing each element to appear at most twice, while maintaining low time and space complexity. The final result contains the count of valid elements and modifies the array in-place.

---

## Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (count < 2 || n != nums[count-2]) {
                nums[count] = n;
                count++;
            }
        }
        return count;
    }
}
