package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 416 割等和子集
 * create by lqs
 * date:2024-10-29
 */
public class LeetCode416_partitionEqualSubsetSum {

    @Test
    public void solution() {
//        int[] nums = {1, 5, 11, 5}; // true {1, 5, 5} {11}
//        int[] nums = {1, 2, 3, 5}; // false
        int[] nums = {1, 2, 5}; // false

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
        int[][] dp = new int[nums.length + 1][targetSum + 1];
        // 省略初始化的过程，因为默认为0，初始化也是要初始化为0
        for(int i = 1; i <= nums.length; i++) {
            // 赋值下一层
            for(int j = 1; j <= targetSum; j++) {
                // 状态转移方程
                if (nums[i-1] > j) { // 判单当前物品是否大于背包容量
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - nums[i-1]] + nums[i-1]);
                }
            }
            if (dp[i][targetSum] == targetSum) return true;
        }
        return false;
    }

    @Test
    public void solution2() {
//        int[] nums = {1, 5, 11, 5}; // true {1, 5, 5} {11}
//        int[] nums = {1, 2, 3, 5}; // false
        int[] nums = {1, 2, 5}; // false

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
        // 不同单独初始化dp数组，默认为0，初始化的值也为0
        // 倒序遍历
        for (int i = 0; i < nums.length; i++) {
            for(int j = targetSum; j >= 0; j--) {
                if (nums[i] <= j) { //只有放的下的时候才执行
                    dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                }
            }
            // 每一层赋值完，判断最后一个元素是否满足要求
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