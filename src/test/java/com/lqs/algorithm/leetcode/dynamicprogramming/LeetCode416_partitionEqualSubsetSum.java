package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 416 分割等和子集
 * create by lqs
 * date:2024-10-29
 */
public class LeetCode416_partitionEqualSubsetSum {

    @Test
    public void solution() {
        int[] nums = {1, 5, 11, 5}; // true {1, 5, 5} {11}
//        int[] nums = {1, 2, 3, 5}; // false
//        int[] nums = {1, 2, 5}; // false

        boolean ans = canPartition(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法：定义二维数组解法
     * 本体中nums[i]的值既是01背包问题中的重量，也是物品的价值，目标和可以看成是总价值。
     * 本体的退出条件是判单dp[i][targetSum] == targetSum, 如果等于说明背包正好填满了，满足条件
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if (totalSum % 2 == 1) return false; // 奇数不满足条件
        int targetSum = totalSum / 2;

        int[][] dp = new int[nums.length][targetSum + 1];
        // init
        for (int j = nums[0]; j <=targetSum ; j++) {
            dp[0][j] = nums[0];//元素的值既是重量又是价值
        }
        // 省略初始化的过程，因为默认为0，初始化也是要初始化为0
        for(int i = 1; i < nums.length; i++) {//遍历物品
            // 赋值下一层
            for(int j = nums[i]; j <= targetSum; j++) {//遍历背包
                // 状态转移方程
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - nums[i]] + nums[i]);
            }
            // 每一层结束都判断一下背包容量为target时，是否完全装满
            if (dp[i][targetSum] == targetSum) return true;
        }
        return false;
    }

    @Test
    public void solution2() {
        int[] nums = {1, 5, 11, 5}; // true {1, 5, 5} {11}
//        int[] nums = {1, 2, 3, 5}; // false
//        int[] nums = {1, 2, 5}; // false

        boolean ans = canPartition2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划01背包问题，一维数组解法
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if (totalSum % 2 == 1) return false; // 奇数不满足条件
        int targetSum = totalSum / 2;

        int[] dp = new int[targetSum + 1];
        // init 默认为0，初始化的值也为0
        dp[0] = 0;
        // 先遍历物品，再倒序遍历背包，顺序不可调整
        for (int i = 0; i < nums.length; i++) {// 遍历物品
            for(int j = targetSum; j >= nums[i]; j--) {// 遍历背包
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 每一层结束都判断一下背包容量为target时，是否完全装满
            if (dp[targetSum] == targetSum) return true;
        }
        return false;
    }

    @Test
    public void solution3() {
        int[] nums = {1, 5, 11, 5}; // true {1, 5, 5} {11}
//        int[] nums = {1, 2, 3, 5}; // false
//        int[] nums = {1, 2, 5}; // false

        boolean ans = canPartition3(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯算法解法（暴力法，超出时间限制）
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
        // 先计算总和
        int totalSum = 0;
        for (int i= 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        // 如果和是奇数，肯定不满足要求
        if (totalSum % 2 == 1) return false;
        return backtrack(nums, 0, totalSum/2);
    }

    public boolean backtrack(int[] nums, int startIndex, int target) {
        // exit condition
        if (target == 0) {
            return true;
        }
        // loop
        for (int i = startIndex; i < nums.length -1 ; i++) {
            boolean met = backtrack(nums, i+1, target - nums[i]);
            if (met) return true;
        }
        return false;
    }
}