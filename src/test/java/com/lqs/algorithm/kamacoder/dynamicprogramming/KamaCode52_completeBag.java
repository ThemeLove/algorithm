package com.lqs.algorithm.kamacoder.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * KamaCode 52 纯完全背包
 * https://kamacoder.com/problempage.php?pid=1052
 * create by lqs
 * date:2024-11-03
 */
public class KamaCode52_completeBag {

    @Test
    public void solution() {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagSize = 4;

        int ans = completeBag(weights, values, bagSize);
        System.out.println("ans -> " + ans);
    }

    /**
     * 完全背包 动态规划 二维数组解法
     * @param weights
     * @param values
     * @param bagSize
     * @return
     */
    public int completeBag(int[] weights, int[] values, int bagSize) {
        // dp 数组的定义: dp[i][j] 表示从下标为[0-i]的物品里任意取,同一物品可重复，放进容量为j的背包，价值总和最大是多少
        int[][] dp = new int[weights.length][bagSize+1];

        // init
        for (int j = weights[0]; j <= bagSize; j++) {
            dp[0][j] = dp[0][j-weights[0]] + values[0];
        }

        /*
        详细版：先遍历物品，再遍历背包
        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= bagSize ; j++) {
                if (weights[i] > j) { // 放不下
                    dp[i][j] = dp[i-1][j];
                } else { // 放的下
                    // 不放
                    int notPut = dp[i-1][j];
                    // 放
                    int put = dp[i][j-weights[i]] + values[i];
                    dp[i][j] = Math.max(notPut, put);
                }
            }
        }*/

        // 简化版本
        for (int i = 1; i < weights.length; i++) { // 先遍历物品
            for (int j = weights[i]; j <= bagSize; j++) { // 再遍历背包
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weights[i]] + values[i]);
            }
        }
        return dp[weights.length-1][bagSize];
    }

    @Test
    public void solution2() {
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagSize = 4;

        int ans = completeBag2(weights, values, bagSize);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划 一维数组解法
     * @param weights
     * @param values
     * @param bagSize
     * @return
     */
    public int completeBag2(int[] weights, int[] values, int bagSize) {
        // dp 数组的定义: dp[j] 表示从所有物品里任意取,同一物品可重复，放进容量为j的背包，价值总和最大是多少
        int[] dp = new int[bagSize + 1];

        // init 第一行
        /*for (int j = weights[0]; j <= bagSize; j++) {
            dp[j] = dp[j-weights[0]] + values[0];
        }

        for (int i = 1; i < weights.length ; i++) {
            for (int j = weights[i]; j <= bagSize ; j++) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
        }*/

        // 简化版， 先遍历物品再遍历背包
        for (int i = 0; i < weights.length ; i++) {
            for (int j = weights[i]; j <= bagSize ; j++) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
            ArrayUtil.printArr(dp);
        }

        /*
        简化版，先遍历背包再遍历物品
        for(int j = 0; j <= bagSize; j++) {
            for (int i = 0; i < weights.length && j >= weights[i]; i++) {
                dp[j] = Math.max(dp[j], dp[j-weights[i]] + values[i]);
            }
            ArrayUtil.printArr(dp);
        }*/
        return dp[bagSize];
    }

}