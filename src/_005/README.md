# Finding the Majority Element - Solution Explanation

## Question

**Problem:**  
Given an integer array `nums` of size `n`, return the majority element. The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

### Example 1:
**Input:**  
`nums = [3, 2, 3]`

**Output:**  
`3`

### Example 2:
**Input:**  
`nums = [2, 2, 1, 1, 1, 2, 2]`

**Output:**  
`2`

---

## Algorithm Used: Boyer-Moore Voting Algorithm

This algorithm helps find the majority element in **O(n)** time and **O(1)** space. It keeps track of a **candidate** and a **counter** (`points`). When the counter is zero, the candidate is replaced. If the candidate matches the current element, the counter increases; otherwise, it decreases.

---

## Step-by-Step Explanation with Visualization

Let’s take the example `nums = [2, 2, 1, 1, 1, 2, 2]`.

We initialize `candidate = 0` and `points = 0`. We will iterate through the array and update the `candidate` and `points` as per the Boyer-Moore algorithm rules.

### Initial Array:

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|

### Iteration 1:
- **Element:** 2  
  Since `points == 0`, **candidate** becomes 2 and `points` increases to 1.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ |   |   |   |   |   |   |
|---|---|---|---|---|---|---| 

**Candidate:** 2, **Points:** 1

---

### Iteration 2:
- **Element:** 2  
  Since `candidate == nums[i]`, `points` increases to 2.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ | ↑ |   |   |   |   |   |  
**Candidate:** 2, **Points:** 2

---

### Iteration 3:
- **Element:** 1  
  Since `candidate != nums[i]`, `points` decreases to 1.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ |   |   |   |   |  
**Candidate:** 2, **Points:** 1

---

### Iteration 4:
- **Element:** 1  
  Since `candidate != nums[i]`, `points` decreases to 0.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ | ↑ |   |   |   |  
**Candidate:** 2, **Points:** 0

---

### Iteration 5:
- **Element:** 1  
  Since `points == 0`, **candidate** becomes 1 and `points` increases to 1.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ | ↑ | ↑ |   |   |  
**Candidate:** 1, **Points:** 1

---

### Iteration 6:
- **Element:** 2  
  Since `candidate != nums[i]`, `points` decreases to 0.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ | ↑ | ↑ | ↑ |   |  
**Candidate:** 1, **Points:** 0

---

### Iteration 7:
- **Element:** 2  
  Since `points == 0`, **candidate** becomes 2 and `points` increases to 1.

| 2 | 2 | 1 | 1 | 1 | 2 | 2 |
|---|---|---|---|---|---|---|
| ↑ | ↑ | ↑ | ↑ | ↑ | ↑ | ↑ |  
**Candidate:** 2, **Points:** 1

---

### Final Result:
The majority element is **2**.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the array.
- **Space Complexity:** `O(1)`, as we only use a few variables for computation.

---

## Java Code

```java
class Solution {
    public int majorityElement(int[] nums) {
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
}
