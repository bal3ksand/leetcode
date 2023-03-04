/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ */

class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;
        int maxProfit = 0;
        while (r < prices.length) {
            if (prices[r] < prices[l])
                l = r;
            else if (prices[r] > prices[l])
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            r += 1;
        }
        return maxProfit;
    }
}