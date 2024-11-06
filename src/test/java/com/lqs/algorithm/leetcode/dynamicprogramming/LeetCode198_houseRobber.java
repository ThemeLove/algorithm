package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode198 打家劫舍
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode198_houseRobber {

    @Test
    public void solution() {
        int[] nums = {1, 2, 3, 1}; // 4
        int ans = rob(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法：
     * 对于第i间房子有不偷或偷2种方案
     * 不偷：则和偷前i-1间房子的最大价值相等，即dp[i] = dp[i-1]
     * 偷：则第i-1就不能偷，最大值则为dp[i] = dp[i-2] + nums[i]
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        // dp[i] 数组的定义：考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
        int[] dp = new int[nums.length];

        // init
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }

    @Test
    public void solution2(){
        int[] nums = {1, 2, 3, 1}; // 4
        int ans = rob2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 滚动数组解法
     * 从solution一种可以看出，dp[i] 只和 dp[i-1] 和 dp[i-2]有关，我们求的是最大值，所以可以在loop中优化
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        // dp[i] 数组的定义：以nums[i]
        int[] dp = new int[nums.length];

        // init
        int p = nums[0];
        int q = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(q, p + nums[i]);
            p = q;
            q = temp;
        }
        return q;
    }

}