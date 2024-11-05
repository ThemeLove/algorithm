package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 组合总和IV
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode377_combinationSumIV {

    @Test
    public void solution() {
        int[] nums = {1, 2, 3};
        int ans = combinationSum4(nums, 4); // 7
        System.out.println("ans -> " + ans);
    }

    /**
     * 完全背包，求排列数
     * 一维数组解法，要先遍历背包再遍历物品
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        // dp 数组的定义, 从nums任选，可重复，正好组成target的排列数
        int[] dp = new int[target+1];
        dp[0] = 1;
        // 求排列数一定要先遍历背包，再遍历物品
        for (int j = 0; j <= target ; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}