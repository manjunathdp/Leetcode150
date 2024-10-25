# H-Index - Solution Explanation

## Question

**Problem:**  
Given an array `citations` where each element represents the number of citations for a research paper, return the researcher's h-index. The h-index is defined as the maximum value `h` such that the researcher has published at least `h` papers with `h` or more citations.

---

### Example 1:
**Input:**  
`citations = [3, 0, 6, 1, 5]`

**Output:**  
`3`

**Explanation:**  
The researcher has 3 papers with at least 3 citations each, and the remaining papers have no more than 3 citations.

---

### Example 2:
**Input:**  
`citations = [1, 3, 1]`

**Output:**  
`1`

**Explanation:**  
The researcher has 1 paper with at least 1 citation, and the remaining papers have no more than 1 citation.

---

## Algorithm Used: Sorting

### How the Algorithm Works:
1. **Sort the Array:** Sort the citations array in ascending order.
2. **Traverse the Sorted Array:** For each citation at index `i`, check if the citation count is at least `n - i` (where `n` is the total number of papers). This calculation represents the number of papers that have at least `citations[i]` citations.
3. **Return h-Index:** If `citations[i] >= n - i`, return `n - i` as the h-index.

---

## Step-by-Step Explanation with Visualization

Let’s go through the example `citations = [3, 0, 6, 1, 5]` step-by-step.

1. **Step 1: Sort the Array**

   Sorted citations: `[0, 1, 3, 5, 6]`

2. **Step 2: Traverse and Calculate H-Index**

   | Index | Citation Count | Papers with ≥ Citation Count | Condition Check | h-Index |
      |-------|----------------|------------------------------|-----------------|---------|
   | 0     | 0              | 5 (total papers - index)    | 0 < 5          | Continue|
   | 1     | 1              | 4                           | 1 < 4          | Continue|
   | 2     | 3              | 3                           | 3 ≥ 3          | h = 3   |
   | 3     | 5              | 2                           | 5 ≥ 2          | Continue|
   | 4     | 6              | 1                           | 6 ≥ 1          | Continue|

   The first time we meet the condition `citations[i] >= n - i` is at index 2, where `citations[2] = 3` and `n - 2 = 3`. Therefore, the h-index is `3`.

---

### Final Result:
The h-index is `3`.

---

## Time and Space Complexity

- **Time Complexity:** `O(n log n)` due to sorting.
- **Space Complexity:** `O(1)` since we sort in-place and use constant extra space.

---

## Java Code

```java
import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        // Step 1: Sort the citations array in ascending order
        Arrays.sort(citations);
        int n = citations.length;

        // Step 2: Traverse through the sorted array
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }

        return 0;
    }
}
