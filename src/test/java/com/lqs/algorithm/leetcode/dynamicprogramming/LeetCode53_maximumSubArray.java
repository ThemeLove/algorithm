package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * LeetCode 53 最大子数组和
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode53_maximumSubArray {

    @Test
    public void solution() {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        int[] nums = {5,4,-1,7,8}; // 23

        int ans = maxSubArray(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums ==  null) return 0;
        if (nums.length == 1) return nums[0];

        // dp[i]表示以nums[i]为结尾的最大子数组的和
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] < 0) { // dp[i-1] < 0 的话 + nums[i] 对 nums[i] 的和有消弱作用，应该丢弃，直接取nums[i]
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        ArrayUtil.printArr(dp);
        return max;
    }

    @Test
    public void solution2() {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // 6
        int[] nums = {5,4,-1,7,8}; // 23

        int ans = maxSubArray2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 最长子数组和
     * 暴力解法：2层循环
     * 外层枚举子数组起点位置，内存枚举子数组结束位置
     *
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];

        int maxSum = 0;
        for (int i = 0; i < nums.length; i ++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}