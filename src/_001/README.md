
# Merge Sorted Array

You are given two integer arrays **nums1** and **nums2**, sorted in non-decreasing order, and two integers **m** and **n**, representing the number of elements in **nums1** and **nums2** respectively.

Merge **nums1** and **nums2** into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array **nums1**. To accommodate this, **nums1** has a length of **m + n**, where the first **m** elements denote the elements that should be merged, and the last **n** elements are set to 0 and should be ignored. **nums2** has a length of **n**.

## Initial Setup

We have two sorted arrays **nums1** and **nums2**. The goal is to merge these into a sorted array inside **nums1**.

**nums1**:

```
[1, 2, 3, 0, 0, 0]
```

**nums2**:

```
[2, 5, 6]
```

## Your Approach (Sorting After Merge)

**Step 1:** Insert elements from **nums2** into the end of **nums1**.

```
[1, 2, 3, 2, 5, 6]
```

**Step 2:** Sort the array.

```
[1, 2, 2, 3, 5, 6]
```

## Efficient Approach (Two-pointer Technique)

**Step 1:** Initialize pointers **i**, **j**, and **k**.

```
nums1: [1, 2, 3, 0, 0, 0]
nums2: [2, 5, 6]
```

**Step 2:** Start merging from the end, compare **nums1[i]** and **nums2[j]**. Place the larger value in **nums1[k]**.

```
[1, 2, 3, 0, 0, 6]
```

**Step 3:** Continue merging. **nums1[k]** gets **5** next.

```
[1, 2, 3, 0, 5, 6]
```

**Step 4:** Continue until all elements are merged.

```
[1, 2, 2, 3, 5, 6]
```

## Comparison of Approaches:

### Your Approach:

- Time Complexity: O((m + n)^2) due to sorting after merging.
- Involves sorting the combined array after copying elements, which can be inefficient for large arrays.

### Efficient Approach (Two-pointer technique):

- Time Complexity: O(m + n) since it merges the arrays in-place in a single pass.
- Does not require sorting after merging, which makes it much faster for larger arrays.

## Code Comparison:

### My Approach (Sorting after merging):

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        for (int i = 0; i < m + n; i++) {
            for (int j = i + 1; j < m + n; j++) {
                if (nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
    }
}
```

### Efficient Approach (Two-pointer technique):

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
```
