package com.lqs.algorithm.kamacoder.dynamicprogramming;

import org.junit.Test;

/**
 * KamaCoder 46题： 纯01背包问题
 * https://kamacoder.com/problempage.php?pid=1046
 * create by lqs
 * date:2024-11-03
 */
public class KamaCode46_01Bag {

    @Test
    public void solution() {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagSize = 4;
        int ans = maxValue(weights, values, bagSize);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划 二维数组解法
     * @param weights
     * @param values
     * @param bagSize
     * @return
     */
    public int maxValue(int[] weights, int[] values, int bagSize) {
        // dp数组的定义：dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[weights.length][bagSize+1];
        // init 初始化 dp[0][j]行，只有物品0的重量<=背包重量的时候，才可以放入背包
        for(int j = weights[0]; j < bagSize; j++) {
            dp[0][j] = values[0];
        }
        // traversal 详细版
        /*for (int i = 1; i < weights.length; i++) { // 遍历物品
            for (int j = 0; j <= bagSize; j++) { // 遍历背包
                if (weights[i] > j) {// 放不下
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }*/

        // 精简版
        for (int i = 1; i < weights.length; i++) { // 遍历物品
            for (int j = weights[i]; j <= bagSize; j++) { // 遍历背包
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
            }
        }
        return dp[weights.length-1][bagSize];
    }

    @Test
    public void solution2() {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagSize = 4;
        int ans = maxValue2(weights, values, bagSize);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划 一维数组写法
     * @param weights
     * @param values
     * @param bagSize
     * @return
     */
    public int maxValue2(int[] weights, int[] values, int bagSize) {
        // dp数组的定义：dp[j]为 容量为j的背包所背的最大价值
        int[] dp = new int[bagSize+1];
        // init
        dp[0] = 0;

        // 详细版
        /*for (int i = 0; i < weights.length; i++) {
            for (int j = bagSize; j >= 0 ; j--) {
                if (weights[i] > j) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
                }
            }
        }*/

        // 精简版
        for (int i = 0; i < weights.length; i++) { // 遍历物品
            for (int j = bagSize; j >= weights[i]; j--) { // 遍历背包
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }
        return dp[bagSize];
    }

}