# Best Time to Buy and Sell Stock  - Java Solution

## Question

**Problem:**  
You are given an array `prices` where `prices[i]` is the price of a stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If no profit is possible, return `0`.

### Example 1:
**Input:**  
`prices = [7, 1, 5, 3, 6, 4]`

**Output:**  
`5`

**Explanation:**  
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6 - 1 = 5.

### Example 2:
**Input:**  
`prices = [7, 6, 4, 3, 1]`

**Output:**  
`0`

**Explanation:**  
No profit is possible as prices keep decreasing.

---

## Algorithm Used: Two-Pointer Technique

The solution uses a **two-pointer technique** to traverse the array once.

- The **buy** pointer is initialized to track the day with the lowest stock price.
- The **sell** pointer is initialized to track the day for selling the stock.
- If the price on the current sell day is lower than the buy day, the buy day is updated.
- Otherwise, the profit between the sell and buy day is calculated, and if it's greater than the current `maxProfit`, it is updated.

This ensures that the array is traversed in a single pass with **O(1)** extra space.

---

## Step-by-Step Explanation with Visualization

Let’s take the example `prices = [7, 1, 5, 3, 6, 4]`.

### Initial Array:

| 7 | 1 | 5 | 3 | 6 | 4 |
|---|---|---|---|---|---|

### Step 1:
Initialize `buy = 0`, `sell = 1`, and `maxProfit = 0`.

---

### Iteration 1:
- Compare prices[0] (7) and prices[1] (1).  
  Since 1 < 7, update `buy = 1`.

| 7 | **1** | 5 | 3 | 6 | 4 |
|---|---|---|---|---|---|
| ↑ | ↓ |   |   |   |   |

---

### Iteration 2:
- Compare prices[1] (1) and prices[2] (5).  
  Profit = 5 - 1 = 4. Update `maxProfit = 4`.

| 7 | **1** | **5** | 3 | 6 | 4 |
|---|---|---|---|---|---|
| ↑ | ↓ | ↑ |   |   |   |

---

### Iteration 3:
- Compare prices[1] (1) and prices[3] (3).  
  Profit = 3 - 1 = 2. `maxProfit` remains 4.

| 7 | **1** | 5 | **3** | 6 | 4 |
|---|---|---|---|---|---|
| ↑ | ↓ |   | ↑ |   |   |

---

### Iteration 4:
- Compare prices[1] (1) and prices[4] (6).  
  Profit = 6 - 1 = 5. Update `maxProfit = 5`.

| 7 | **1** | 5 | 3 | **6** | 4 |
|---|---|---|---|---|---|
| ↑ | ↓ |   |   | ↑ |   |

---

### Iteration 5:
- Compare prices[1] (1) and prices[5] (4).  
  Profit = 4 - 1 = 3. `maxProfit` remains 5.

| 7 | **1** | 5 | 3 | 6 | **4** |
|---|---|---|---|---|---|
| ↑ | ↓ |   |   |   | ↑ |

---

### Final Result:
The maximum profit is **5**.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the array. The array is traversed in a single pass.
- **Space Complexity:** `O(1)`, as the array is modified in place using only a few extra variables (`buy`, `sell`, `maxProfit`).

---

## Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;
        int currentProfit = 0;
        
        while (sell < prices.length) {
            if (prices[buy] > prices[sell]) {
                buy = sell;
            } else {
                currentProfit = prices[sell] - prices[buy];
                if (maxProfit < currentProfit) {
                    maxProfit = currentProfit;
                }
            }
            sell++;
        }
        return maxProfit;
    }
}
