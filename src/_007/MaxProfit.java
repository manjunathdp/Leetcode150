package _007;

public class MaxProfit {

    public static void main(String[] args) {
        // Example input
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Call the function and print the result
        int maxProfit = maxProfit(prices);
        System.out.println("The maximum profit is: " + maxProfit);
    }

    // Function to calculate maximum profit
    public static int maxProfit(int[] prices) {
        int buy = 0;        // Pointer for buying
        int sell = 1;       // Pointer for selling
        int maxProfit = 0;  // To store the maximum profit
        int currentProfit;  // To calculate the current profit

        // Iterate through the prices array
        while (sell < prices.length) {
            if (prices[buy] > prices[sell]) {
                // If the current selling price is less than buying price, update the buy pointer
                buy = sell;
            } else {
                // Otherwise, calculate the current profit
                currentProfit = prices[sell] - prices[buy];
                // Update maxProfit if currentProfit is greater
                if (maxProfit < currentProfit) {
                    maxProfit = currentProfit;
                }
            }
            // Move to the next selling day
            sell++;
        }
        return maxProfit;
    }
}

