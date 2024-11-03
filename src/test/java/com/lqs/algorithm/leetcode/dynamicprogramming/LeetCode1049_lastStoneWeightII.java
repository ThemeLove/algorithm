package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 1049 最后一块石头的重量II
 * create by lqs
 * date:2024-10-30
 */
public class LeetCode1049_lastStoneWeightII {

    @Test
    public void solution() {
        int[] nums = {2, 7, 4, 1, 8, 1};
        int ans = lastStoneWeightII(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法：一维解法
     * 就是尽量把石头拆分成尽量相等的2部分，然后相撞，剩余的才最小.
     * 把所有石头总和/2,比如为target,然后转换为01背包问题，求dp[target]的最大值，然后根据最大值计算出剩余
     * @param nums
     * @return
     */
    public int lastStoneWeightII(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int sum = 0;
        for(int num: nums) {
            sum+=num;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        // init, 可以省略
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = target; j >=nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }

}