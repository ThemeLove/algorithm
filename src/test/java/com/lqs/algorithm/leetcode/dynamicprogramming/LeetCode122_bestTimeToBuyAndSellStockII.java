package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode122 买卖股票的最佳时机II
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode122_bestTimeToBuyAndSellStockII {

    @Test
    public void solution() {
        // 7,1,5,3,6,4
        int[] nums = {7,1,5,3,6,4}; // 7
        int ans = maxProfit(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 贪心解法
     * 把nums用折线图表示出来的话，最大利润即统计所有上升的线段（盈利的部分）
     * 用代码实现即只要后一个元素比前一个元素大，累计所有差值即为最大利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int maxProfit = 0;
        int prePrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prePrice) {
                maxProfit += prices[i] - prePrice;
            }
            prePrice = prices[i];
        }
        return maxProfit;
    }

    @Test
    public void solution2() {
        // 7,1,5,3,6,4
        int[] nums = {7,1,5,3,6,4}; // 7
        int ans = maxProfit2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int len = prices.length;
        // dp[i][0] 表示第i天持有股票所得最多现金 ，这里可能有同学疑惑，本题中只能买卖一次，持有股票之后哪还有现金呢？
        // 其实一开始现金是0，那么加入第i天买入股票现金就是 -prices[i]， 这是一个负数。
        // dp[i][1] 表示第i天不持有股票所得最多现金

        int[][] dp = new int[len][2];

        // init
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < len; i++) {
            // dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            // 特别注意，这里由于股票可以多次买卖，利润是可以累加的，所以买入时最大金额即为 dp[i-1][1] -prices[i],
            // 不能用- prices[i], 和LeetCode121 只能买卖一次的场景不同，也是唯一的不同
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        return dp[len-1][1];
    }

}