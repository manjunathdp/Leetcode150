# Jump Game II - Solution Explanation

## Question

**Problem:**  
You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`, and each element `nums[i]` represents the maximum length of a forward jump from index `i`.

Return the **minimum number of jumps** to reach `nums[n-1]`. The test cases are generated such that you can always reach the last index.

---

### Example 1:
**Input:**  
`nums = [2, 3, 1, 1, 4]`

**Output:**  
`2`

**Explanation:**  
Jump 1 step from index `0` to index `1`, then 3 steps to the last index.

---

### Example 2:
**Input:**  
`nums = [2, 3, 0, 1, 4]`

**Output:**  
`2`

**Explanation:**  
Jump 1 step from index `0` to index `1`, then 3 steps to the last index.

---

## Algorithm Used: Greedy Approach

### How the Algorithm Works:
1. We use two variables, `current` and `farthest`, to keep track of the maximum index we can reach after each jump.
2. `current` keeps track of how far we can go with the current number of jumps, while `farthest` keeps track of the farthest index we can jump from all visited indices.
3. Iterate through the array. Every time we reach the current farthest possible index, we make a jump and update the `current` to the farthest index.

---

## Step-by-Step Explanation with Visualization

Let’s take the example `nums = [2, 3, 1, 1, 4]`.

We start with `jumps = 0`, `current = 0`, and `farthest = 0`.

---

### Step 1: Initial Array

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |     |
| Farthest | 2 |     |     |     |     |

At index `0`, we can jump up to index `2` (`farthest = 2`).  
Since we have reached `current` (index `0`), we make a jump and update `current` to `farthest` (`current = 2`).  
`Jumps = 1`

---

### Step 2: Check from Index 1

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |     |
| Farthest | 2 | 4 |     |     |     |

At index `1`, the value is `3`. We can jump up to index `4` (`farthest = 4`).  
Since we haven’t yet reached `current` (index `2`), we continue.

---

### Step 3: Check from Index 2

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |     |
| Farthest | 2 | 4 | 4 |     |     |

At index `2`, the value is `1`. We can jump up to index `3` (`farthest = 4`).  
Since we have reached `current` (index `2`), we make a jump and update `current` to `farthest` (`current = 4`).  
`Jumps = 2`

---

### Step 4: Check from Index 3

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |     |
| Farthest | 2 | 4 | 4 | 4 |     |

At index `3`, the value is `1`. We can jump up to index `4`.  
Since we haven’t yet reached `current` (index `4`), we continue.

---

### Step 5: Reached the Last Index

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |     |
| Farthest | 2 | 4 | 4 | 4 |     |

We have reached index `4`, which is the last index, with a total of `2` jumps.

---

### Final Result:
We reach the last index in `2` jumps.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the array. We traverse the array once.
- **Space Complexity:** `O(1)`, as we use a few extra variables.

---

## Java Code

```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1;
        int jumps = 0;
        int current = 0;
        int farthest = 0;
        
        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            
            if (i == current) {
                current = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
