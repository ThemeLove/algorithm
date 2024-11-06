package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode121 买卖股票的最佳时机
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode121_bestTimeToBuyAndSellStock {

    @Test
    public void solution() {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit(prices);
        System.out.println("ans -> " + ans);
    }

    /**
     * 2层for循环暴力枚举法
     * 外层枚举买入股票的位置，内存枚举卖出股票的位置
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    @Test
    public void solution2() {
        int[] prices = {7,1,5,3,6,4};
        int ans = maxProfit2(prices);
        System.out.println("ans -> " + ans);
    }

    /**
     * 一次遍历
     * 遍历中维护当前i之前元素的最低价和最大利润
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    @Test
    public void solution3() {
        int[] prices = {7,1,5,3,6,4};//5
        int ans = maxProfit3(prices);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        // dp[i][0] 表示第i天持有股票所得最多现金 ，这里可能有同学疑惑，本题中只能买卖一次，持有股票之后哪还有现金呢？
        // 其实一开始现金是0，那么加入第i天买入股票现金就是 -prices[i]， 这是一个负数。
        // dp[i][1] 表示第i天不持有股票所得最多现金

        int[][] dp = new int[len][2];

        // init
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < len; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            // 特别注意，这里由于股票只能买卖一次，所以买入时最大金额即为 -prices[i], 不能用dp[i][1] - prices[i]
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }

        return dp[len-1][1];
    }


}