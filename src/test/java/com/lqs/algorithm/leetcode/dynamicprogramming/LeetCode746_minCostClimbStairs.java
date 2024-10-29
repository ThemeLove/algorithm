package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 746 使用最小花费爬楼梯
 * create by lqs
 * date:2024-10-28
 */
public class LeetCode746_minCostClimbStairs {

    @Test
    public void solution() {
//        int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int ans = minCostClimbingStairs(cost);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        // dp 数组的含义: dp[i] 表示爬到第i阶的最小花费, 数组长度为cost.length + 1, 因为数组下标是从0 开始的
        int[] dps = new int[cost.length + 1];
        // init
        dps[0] = 0;
        // dps[1] 注意，题目中说可以从index 0 或 1 开始爬， 如果从index = 0开始爬，则dps[1] = cost[0], 如果从index = 1 开始爬（直接站在第一阶上）则消耗是0
        // 所以dps[1]有2个取值dps[1] = 0 或dps[1] = cost[0], 所以最小花费是0
        dps[1] = 0;
        // 遍历顺序从小->大
        for(int i = 2; i < dps.length; i++) {
            // 递推公式
            dps[i] = Math.min(dps[i-1] + cost[i-1], dps[i-2]+cost[i-2]);
        }
        return dps[cost.length];
    }

    @Test
    public void solution2() {
        // int[] cost = {10,15,20};
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        int ans = minCostClimbingStairs2(cost);
        System.out.println("ans -> " + ans);
    }

    /**
     * 滚动数组
     * 同样可以用滚动数组优化动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length <= 1) return 0;
        int p = 0;
        int q = 0;
        int ans = 0;
        for(int i = 2; i <= cost.length; i++) {
            ans = Math.min(p + cost[i-2], q + cost[i -1]);
            p = q;
            q = ans;
        }
        return ans;
    }

}