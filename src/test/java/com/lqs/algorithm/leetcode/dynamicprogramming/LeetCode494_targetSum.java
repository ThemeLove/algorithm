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
//        int[] nums = {7,9,3,8,0,2,4,8,3,9}; // sort -> {0, 2, 3, 3, 4, 7, 8, 8, 9, 9}
//        int target = 0;
//        int[] nums = {1, 1, 1, 1, 1};
//        int[] nums = {1, 1, 1, 1, 1};
//        int target = 3;
//        int[] nums = {1, 0};
//        int target = 1;

          int[] nums = {1, 3, 5};
          int target = 4;

        int ans = findTargetSumWays(nums, target);
        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯解法
     * 思路
     * 1.先计算所有元素和（totalSum） 和 目标和(target) 比较大小，
     *   a.target > totalSum, 无解
     *   b.target = totalSum, 只有1种全是正数组合
     *   c.target < totalSum, 则解可以转变成在元素中寻找元素组合的目标和等于(totalSum+target)/2的组合数,
     *   如果（totalSum+target）% 2  == 1， 则无解，要先返回
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
        if((totalSum + target) % 2 == 1) return 0; // 这里一定要return，不然会得到错误答案，因为(totalSum + target)/2 如果不是整数会向下取整
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
        for (int i = startIndex; i < nums.length && nums[i] <= targetSum; i++) {
            backTracking(nums, targetSum - nums[i], i+1);
        }
    }

    @Test
    public void solution2() {
        int[] nums = {7,9,3,8,0,2,4,8,3,9}; // sort -> {0, 2, 3, 3, 4, 7, 8, 8, 9, 9}
        int target = 0;
        int ans = findTargetSumWays2(nums, target);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归算法（回溯）
     * 每个元素取整数或取负数，暴力枚举所有组合数，检查符合提议的组合数
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays2(int[] nums, int target) {
        backTracking2(nums, target, 0, 0);
        return ans;
    }

    public void backTracking2(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (target == sum) {
                ans++;
            }
        } else {
            // 对每个数分别加 正号 和 负号
            backTracking2(nums, target, sum + nums[index], index+1); // 正数
            backTracking2(nums, target, sum - nums[index], index+1); // 负数
        }
    }

    @Test
    public void solution3() {
//        int[] nums = {7,9,3,8,0,2,4,8,3,9}; // sort -> {0, 2, 3, 3, 4, 7, 8, 8, 9, 9}
//        int target = 0;

        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;

//        int[] nums = {100};
//        int target = -200;
//
//        int[] nums = {1, 1, 1, 1, 1}; //
//        int target = 3;

        int ans = findTargetSumWays3(nums, target);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法：一维解法
     * 思路：
     * 1.先计算数组的总和为sum, 把数组分为2部分，分别计算其总和，假设为left, right,则有以下关系
     * left + right = sum
     * left - right = target
     * left = (sum + target) / 2
     *
     * 2.则此时问题转变01背包问题，从nums中选取元素（价值和体积都为nums[i]），正好装满left(背包总体积)，有多少种装法
     * 3.初始化
     *   先用物品0 对dp数组进行初始化
     *   dp[0] 比较特殊，如果物品0 = 0， 有放或不放 2种方案； 物品0 ！= 0 ，只能不放，只有1种方案
     *   dp[1->left]只有物品0 == i时（正好装满），1种方案，别的情况都是要么装不下，要么装不满，0种方案
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays3(int[] nums, int target) {
        if (nums == null) return 0;
        int totalSum = 0;
        for(int num: nums) {
            totalSum += num;
        }
        if((totalSum + target) % 2 == 1) return 0;// 目标值为小数，则无解
        int targetSum = (totalSum + target)/2;
        if (targetSum < 0) return 0; // 如果target 是 负数， 返回0
        // dp 数组的定义为：从0->i的物品中任意选取，正好装满容量为j的背包的组合数
        int[] dp = new int[targetSum+1];
        // 如果物品0 == 0， 则初始化为2，如果不等于0，则初始化为1
        // 物品0 == 0时，有不放和放2种方案
        dp[0] = nums[0] == 0 ? 2 : 1;
        // init
        for (int j = 1; j <= targetSum; j++) {
            if (nums[0] == j){
                dp[j] = 1;
            }else {
                dp[j] = 0;
            }
        }
        // 动态规划
        /*for (int i = 1; i < nums.length; i++) {
            for (int j = targetSum; j >= 0; j--) {
                if (nums[i] > j) {// 当前物品装不下，正好装满容量为i的背包组合数为从0~i-1 物品中任选物品的组合数
                    dp[j] = dp[j]; // 即不覆盖当前值
                } else {//当前物品装的下的话，当前物品可选 可 不选 2种情况，dp[i] 为其总和
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }*/
        // 精简版 先遍历物品，再倒序遍历背包
        for (int i = 1; i < nums.length; i++) {
            for (int j = targetSum; j >= nums[i]; j--) {
                //当前物品装的下的话，当前物品可选 可 不选 2种情况，dp[i] 为其总和
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[targetSum];
    }
}