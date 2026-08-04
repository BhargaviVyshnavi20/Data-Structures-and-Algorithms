// Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*
Problem:
You are given an array prices where prices[i] is the price
of a given stock on the ith day.

You want to maximize your profit by choosing a single day
to buy one stock and choosing a different future day to sell
that stock.

Return the maximum profit you can achieve from this transaction.

If you cannot achieve any profit, return 0.

------------------------------------------------------------

Example 1:
Input:
prices = [7,1,5,3,6,4]

Output:
5

Explanation:
Buy on day 2 (price = 1)
Sell on day 5 (price = 6)

Profit = 6 - 1 = 5

------------------------------------------------------------

Example 2:
Input:
prices = [7,6,4,3,1]

Output:
0

Explanation:
Prices keep decreasing, so no profit can be made.

------------------------------------------------------------

Example 3:
Input:
prices = [2,4,1]

Output:
2

Explanation:
Buy on day 1 (price = 2)
Sell on day 2 (price = 4)

Profit = 4 - 2 = 2
*/

public class Best_Time_To_Buy_And_Sell_Stock {

    // ==========================================================
    // Approach: Track Minimum Price
    // ==========================================================
    // Time Complexity : O(N)
    // Space Complexity: O(1)
    //
    // Observation:
    // Traverse the array while maintaining the minimum stock
    // price seen so far.
    //
    // For every day:
    //
    // profit = currentPrice - minimumPrice
    //
    // Update the maximum profit whenever a larger profit is found.
    //
    // Also update the minimum price if a smaller price appears.
    // ==========================================================

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            if (price < minPrice) {
                minPrice = price;
            }

            int profit = price - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    // Driver Code
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximum Profit = " + maxProfit(prices));
    }
}