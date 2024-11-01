package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;

/**
 * LeetCode 494 目标和
 * create by lqs
 * date:2024-10-30
 */
public class LeetCode494_targetSum {

    @Test
    public void solution() {
//        int[] nums = {1, 1, 1, 1, 1};
//        int target = 3;
        int[] nums = {1, 0};
        int target = 1;

        int ans = findTargetSumWays(nums, target);
        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯解法
     * 思路
     * 1.先计算所有元素和（totalSum） 和 目标和(target) 比较大小，
     *   a.target > totalSum, 无解
     *   b.target = totalSum, 只有1种全是正数组合
     *   c.target < totalSum, 则解可以转变成在元素中寻找元素组合的目标和等于totalSum- target的组合数，然后把这些组合都标记为负数即可.
     *   题解就是找元素和等于totalSum-target的组合数
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null) return 0;
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if (target > totalSum) return 0;
        if (target == totalSum) return 1;
        int targetSum = (totalSum + target) / 2;

        Arrays.sort(nums);
        backTracking(nums, targetSum, 0);
        return ans;
    }

    int ans = 0;
    public void backTracking(int[] nums, int targetSum, int startIndex) {
        // exit condition
        if (targetSum == 0) {
            ans++;
        }
        // loop
        for (int i = startIndex; i < nums.length; i++) {
            backTracking(nums, targetSum - nums[i], i+1);
        }
    }
}