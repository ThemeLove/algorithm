package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * LeetCode213 打家劫舍II
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode213_houseRobberII {

    @Test
    public void solution() {
        int[] nums = {1, 2, 3, 1};
        int ans = rob(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * 由于有首尾相连的限制，偷了第一间，就不能偷最后一间；偷了最后一间就不能偷第一间
     * 所以最大值应该在这2个区间里取最大值
     * 偷第一间：0 ~ nums.length - 2
     * 偷最后一间：1 ~ nums.length - 1
     *
     * 问题就转化为打家劫舍198一样的问题，对2个区间求解，取最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int ret = rob(nums, 0, nums.length - 2);
        int ret2 = rob(nums, 1, nums.length - 1);
        return Math.max(ret, ret2);
    }

    public int rob(int[] nums, int start, int end) {
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            dp[i - start] = Math.max(dp[i - start -1], dp[i- start - 2] + nums[i]);
        }
        ArrayUtil.printArr(dp);
        return dp[end - start];
    }

    /**
     * 滚动数组优化
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public int rob2(int[] nums, int start, int end) {
        int p = nums[start];
        int q = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = Math.max(q, p + nums[i]);
            p = q;
            q = temp;
        }
        return q;
    }

}