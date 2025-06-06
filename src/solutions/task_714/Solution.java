package solutions.task_714;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee
 * representing a transaction fee.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.
 * Note:
 * You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
    //  public int maxProfit(int[] prices, int fee) {
    //      int[] ints = new int[prices.length];
    //      for (int i = 0; i < prices.length - 1; i++) {
    //          for (int j = i + 1; j < prices.length; j++) {
    //              ints[j] = Math.max(Math.max(ints[i] + prices[j] - prices[i] - fee, ints[j]), ints[j - 1]);
    //          }
    //      }
    //      return ints[prices.length - 1];
    //  }
}