

    
# Merge Sorted Array

    
## Initial Setup
    
<div class="step">
        
We have two sorted arrays **nums1** and **nums2**. The goal is to merge these into a sorted array inside **nums1**.
        
<div class="array">
            <div class="element">1</div>
            <div class="element">2</div>
            <div class="element">3</div>
            <div class="element">0</div>
            <div class="element">0</div>
            <div class="element">0</div>
        </div>
        
And the array **nums2**:
        
<div class="array highlight-nums2">
            <div class="element">2</div>
            <div class="element">5</div>
            <div class="element">6</div>
        </div>
    </div>

    
## Your Approach (Sorting After Merge)
    
<div class="step">
        
**Step 1:** Insert elements from **nums2** into the end of **nums1**.
        
<div class="array">
            <div class="element">1</div>
            <div class="element">2</div>
            <div class="element">3</div>
            <div class="element highlight">2</div>
            <div class="element highlight">5</div>
            <div class="element highlight">6</div>
        </div>
    </div>

    <div class="step">
        **Step 2:** Sort the array.
        <div class="array">
            <div class="element highlight">1</div>
            <div class="element highlight">2</div>
            <div class="element highlight">2</div>
            <div class="element">3</div>
            <div class="element">5</div>
            <div class="element">6</div>
        </div>
    </div>

    
## Efficient Approach (Two-pointer Technique)
    
<div class="step">
        
**Step 1:** Initialize pointers **i**, **j**, and **k**.
        
<div class="array">
            <div class="element">1</div>
            <div class="element">2</div>
            <div class="element">3</div>
            <div class="element">0</div>
            <div class="element">0</div>
            <div class="element">0</div>
        </div>
        
Array **nums2** remains unchanged:
        
<div class="array highlight-nums2">
            <div class="element">2</div>
            <div class="element">5</div>
            <div class="element">6</div>
        </div>
    </div>

    <div class="step">
        **Step 2:** Start merging from the end, compare **nums1[i]** and **nums2[j]**. Place the larger value in **nums1[k]**.
        <div class="array">
            <div class="element">1</div>
            <div class="element">2</div>
            <div class="element">3</div>
            <div class="element">0</div>
            <div class="element">0</div>
            <div class="element highlight">6</div>
        </div>
        Pointers move accordingly.
    </div>

    <div class="step">
        **Step 3:** Continue merging. **nums1[k]** gets **5** next.
        <div class="array">
            <div class="element">1</div>
            <div class="element">2</div>
            <div class="element">3</div>
            <div class="element">0</div>
            <div class="element highlight">5</div>
            <div class="element">6</div>
        </div>
    </div>

    <div class="step">
        **Step 4:** Continue until all elements are merged.
        <div class="array">
            <div class="element">1</div>
            <div class="element highlight">2</div>
            <div class="element highlight">2</div>
            <div class="element">3</div>
            <div class="element">5</div>
            <div class="element">6</div>
        </div>
    </div>

    
## Comparison of Approaches:
    
<div class="step" style="background-color: rgb(255, 230, 230);">
        
**Your Approach:** 
        
            
- Time Complexity: O((m + n)^2) due to sorting after merging.
            
- Involves sorting the combined array after copying elements, which can be inefficient for large arrays.
        
        
    </div>
    
<div class="step" style="background-color: rgb(230, 255, 230);">
        
**Efficient Approach (Two-pointer technique):** 
        
            
- Time Complexity: O(m + n) since it merges the arrays in-place in a single pass.
            
- Does not require sorting after merging, which makes it much faster for larger arrays.
        
        
    </div>

    
## Code Comparison:
    
### Your Approach (Sorting after merging):
    
`
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = m; i &lt; m + n; i++) {
                nums1[i] = nums2[i - m];
            }
            for (int i = 0; i &lt; m + n; i++) {
                for (int j = i + 1; j &lt; m + n; j++) {
                    if (nums1[i] &gt; nums1[j]) {
                        int temp = nums1[i];
                        nums1[i] = nums1[j];
                        nums1[j] = temp;
                    }
                }
            }
        }
    }
    `

    
### Efficient Approach (Two-pointer technique):
    
`
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int k = m + n - 1;
            while (i &gt;= 0 &amp;&amp; j &gt;= 0) {
                if (nums1[i] &gt; nums2[j]) {
                    nums1[k--] = nums1[i--];
                } else {
                    nums1[k--] = nums2[j--];
                }
            }
            while (j &gt;= 0) {
                nums1[k--] = nums2[j--];
            }
        }
    }
    `



