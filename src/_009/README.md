# Best Time to Buy and Sell Stock II - Solution Explanation

## Question

**Problem:**  
You are given an integer array `prices` where `prices[i]` is the price of a given stock on the `i-th` day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it and then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

### Example 1:
**Input:**  
`prices = [7, 1, 5, 3, 6, 4]`

**Output:**  
`7`

**Explanation:**
- Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = `5 - 1 = 4`.
- Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = `6 - 3 = 3`.
- Total profit is `4 + 3 = 7`.

### Example 2:
**Input:**  
`prices = [1, 2, 3, 4, 5]`

**Output:**  
`4`

**Explanation:**
- Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = `5 - 1 = 4`.

### Example 3:
**Input:**  
`prices = [7, 6, 4, 3, 1]`

**Output:**  
`0`

**Explanation:**  
There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

---

## Algorithm Used: Greedy Approach

### How the Algorithm Works:
The goal is to find all the "uphill" opportunities in the stock price array. Every time the price on day `i` is higher than on day `i-1`, we add the difference to the profit. This is because we can buy on day `i-1` and sell on day `i` to make a profit.

1. Iterate over the array starting from day 1.
2. Whenever `prices[i] > prices[i-1]`, we calculate the profit as `prices[i] - prices[i-1]` and add it to the total profit.
3. Continue this process until the end of the array.
4. Return the accumulated profit.

---

## Step-by-Step Explanation with Visualization

Let’s take the example `prices = [7, 1, 5, 3, 6, 4]`.

### Initial Array:

| Day      | 1  | 2  | 3  | 4  | 5  | 6  |
|----------|----|----|----|----|----|----|
| Prices   | 7  | 1  | 5  | 3  | 6  | 4  |

---

### Step 1: Calculate Profit
1. On Day 2 (price = 1), buy.
2. On Day 3 (price = 5), sell.  
   Profit: `5 - 1 = 4`.

| Day      | 1  | 2  | 3  | 4  | 5  | 6  |
|----------|----|----|----|----|----|----|
| Prices   | 7  | 1  | 5  | 3  | 6  | 4  |
| Action   |    | B  | S  |    |    |    |

Total profit: 4

---

### Step 2: Continue Calculating Profit
1. On Day 4 (price = 3), buy.
2. On Day 5 (price = 6), sell.  
   Profit: `6 - 3 = 3`.

| Day      | 1  | 2  | 3  | 4  | 5  | 6  |
|----------|----|----|----|----|----|----|
| Prices   | 7  | 1  | 5  | 3  | 6  | 4  |
| Action   |    | B  | S  | B  | S  |    |

Total profit: `4 + 3 = 7`

---

### Final Result:
The maximum profit is **7**.

---

## Time and Space Complexity

- **Time Complexity:** `O(n)`, where `n` is the length of the prices array. We iterate through the array once.
- **Space Complexity:** `O(1)`, since we only use a few variables to store the profit.

---

## Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
