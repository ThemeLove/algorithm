package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * LeetCode 674 最长连续递增序列
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode674_longestContinuesIncreasingSubSequence {

    @Test
    public void solution() {
//        int[] nums = {1,3,5,4,7}; // 3
        int[] nums = {1,3,5,7}; // 4
//        int[] nums = {2, 2, 2, 2}; // 1
        int ans = findLengthOfLCIS(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 暴力枚举法
     * 2层for循环，外层枚举子序列起始位置index, 内存从index+1 开始遍历并判断大小，如果小于则跳出当前层
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        // init 最小长度为1
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <= nums[j-1]) {
                    len = j-i;
                    break;
                }
                len = j-i+1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    @Test
    public void solution2() {
        int[] nums = {1,3,5,4,7}; // 3
//        int[] nums = {1,3,5,7}; // 4
//        int[] nums = {2, 2, 2, 2}; // 1
        int ans = findLengthOfLCIS2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int findLengthOfLCIS2(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;

        // dp[i] 表示以nums[i] 为结尾的连续递增子序列长度
        int[] dp = new int[nums.length];

        // init, 最少长度为1
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    @Test
    public void solution3() {
        int[] nums = {1,3,5,4,7}; // 3
//        int[] nums = {1,3,5,7}; // 4
//        int[] nums = {2, 2, 2, 2}; // 1
        int ans = findLengthOfLCIS3(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 滚动数组优化
     * @param nums
     * @return
     */
    public int findLengthOfLCIS3(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;

        // init, 最少长度为1
        int maxLen = 1;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            int q = 1;
            if (nums[i] > nums[i-1]) {
                 q = p + 1;
            }
            p = q;
            maxLen = Math.max(maxLen, q);
        }
        return maxLen;
    }



}