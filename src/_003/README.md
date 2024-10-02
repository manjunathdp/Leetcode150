
# (#26) Remove Duplicates - Solution Explanation

## Question

**Problem:**  
Given a sorted integer array `nums`, remove duplicates in-place such that each unique element appears only once, and return the number of unique elements `k`.

Modify the array such that the first `k` elements contain the unique elements in their original order. The remaining elements don't matter.

**Example:**

- **Input:** `nums = [0,0,1,1,1,2,2,3,3,4]`
- **Output:** `5`, `nums = [0,1,2,3,4,_,_,_,_,_]`

---

## Step-by-Step Explanation

We use two pointers to remove duplicates efficiently. The first pointer `j` will track the position of unique elements, while the second pointer `i` iterates through the array.

Let's take the example `nums = [0,0,1,1,1,2,2,3,3,4]`:

```
Initial Array:
[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
```

### Step 1
Initialize `j = 0`. Start iterating from the second element (`i = 1`).

### Iteration 1
- `nums[1] == nums[0]`, so skip it.

### Iteration 2
- `nums[2] != nums[0]`. Increment `j` and move `nums[2]` to `nums[1]`.

```
[0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
```

### Iteration 3 & 4
- Both `nums[3] == nums[2]` and `nums[4] == nums[2]`, so skip them.

### Iteration 5
- `nums[5] != nums[2]`. Increment `j` and move `nums[5]` to `nums[2]`.

```
[0, 1, 2, 1, 1, 2, 2, 3, 3, 4]
```

### Iteration 6
- `nums[6] == nums[5]`, so skip it.

### Iteration 7
- `nums[7] != nums[5]`. Increment `j` and move `nums[7]` to `nums[3]`.

```
[0, 1, 2, 3, 1, 2, 2, 3, 3, 4]
```

### Iteration 8
- `nums[8] == nums[7]`, so skip it.

### Iteration 9
- `nums[9] != nums[7]`. Increment `j` and move `nums[9]` to `nums[4]`.

```
[0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
```

### Step 2
After all iterations, the first five elements of the array contain unique values: `[0, 1, 2, 3, 4]`.

The result is `k = 5`, as there are 5 unique elements.

---

## Time and Space Complexity

- **Time Complexity:** O(n) – We traverse the array once.
- **Space Complexity:** O(1) – We do not use any additional space except the two pointers.

---

## Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
```

---

## Conclusion

The approach uses a **two-pointer technique** to efficiently remove duplicates in O(n) time while maintaining O(1) space complexity, making it one of the best solutions to this problem.
