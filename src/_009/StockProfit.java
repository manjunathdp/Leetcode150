package _009;

import java.util.Arrays;

public class StockProfit {

    public static void main(String[] args) {
        // Test Case 1: Expected profit = 7
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1 Profit: " + maxProfit(prices1));  // Output: 7

        // Test Case 2: Expected profit = 4
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2 Profit: " + maxProfit(prices2));  // Output: 4

        // Test Case 3: Expected profit = 0
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 3 Profit: " + maxProfit(prices3));  // Output: 0
    }

    // Method to calculate the maximum profit
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}