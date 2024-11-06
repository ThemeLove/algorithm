package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * LeetCode 300 最长递增子序列
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode300_longestIncreasingSubsequence {

    @Test
    public void solution() {
        int[] nums = {10,9,2,5,3,7,101,18}; // 4
        int ans = lengthOfLIS(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * 注意子序列和子数组不同，子序列可以不连续，子数组必须连续
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return 1;
        // dp[i] 表示以nums[i]结尾的最长递增子序列长度

        int[] dp = new int[nums.length];

        // init, 以每个元素为结尾的子序列长度最少为1，即元素本身
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

}