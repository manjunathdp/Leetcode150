# Jumping Game - Solution Explanation

## Question

**Problem:**  
You are given an integer array `nums`. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

### Example 1:
**Input:**  
`nums = [2, 3, 1, 1, 4]`

**Output:**  
`true`

**Explanation:**  
Jump 1 step from index 0 to 1, then 3 steps to the last index.

---

### Example 2:
**Input:**  
`nums = [3, 2, 1, 0, 4]`

**Output:**  
`false`

**Explanation:**  
You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

---

## Algorithm Used: Greedy Approach

### How the Algorithm Works:
We work backwards from the last index of the array.
1. Initialize `goal` as the last index of the array.
2. For each index `i`, check if you can reach or exceed the current `goal` by jumping from `i` using the maximum jumps allowed (`i + nums[i]`).
3. If possible, update `goal` to be `i`.
4. Finally, if the `goal` becomes `0`, return `true` because it means you can jump from the first index to the last. Otherwise, return `false`.

---

## Step-by-Step Explanation with Visualization

Let’s take the example `nums = [2, 3, 1, 1, 4]`.

We initialize `goal = 4` (last index). We will iterate through the array from right to left.

---

### Step 1: Initial Array

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |Goal |

We start with the goal at index 4, which is the last index.

---

### Step 2: Check from Index 4
At index 4, the value is 4. Since this is our goal, we can stay here.  
Goal remains at index 4.

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |     |**Goal**|

---

### Step 3: Check from Index 3
At index 3, the value is 1. We can jump from index 3 to index 4, which is the goal.  
Update goal to index 3.

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |     |**Goal**|     |

---

### Step 4: Check from Index 2
At index 2, the value is 1. We can jump from index 2 to index 3, which is the goal.  
Update goal to index 2.

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |     |**Goal**|     |     |

---

### Step 5: Check from Index 1
At index 1, the value is 3. We can jump from index 1 to index 4 (or beyond).  
Update goal to index 1.

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |     |**Goal**|     |     |     |

---

### Step 6: Check from Index 0
At index 0, the value is 2. We can jump from index 0 to index 2 (goal).  
Update goal to index 0.

| Index |  0  |  1  |  2  |  3  |  4  |
|-------|-----|-----|-----|-----|-----|
| nums  |  2  |  3  |  1  |  1  |  4  |
|       |**Goal**|     |     |     |     |

---

### Final Result:
Since the `goal` is now 0, we can reach the last index from the first, so the result is `true`.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the array. We traverse the array once from right to left.
- **Space Complexity:** `O(1)`, as we only use a few extra variables (`goal`).

---

## Java Code

```java
class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        return goal == 0;
    }
}
