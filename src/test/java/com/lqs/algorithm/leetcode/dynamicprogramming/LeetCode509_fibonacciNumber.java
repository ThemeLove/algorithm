package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 509 斐波那契数列
 * create by lqs
 * date:2024-10-28
 */
public class LeetCode509_fibonacciNumber {

    @Test
    public void solution() {
        int ans = fib(8);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public int fib(int n) {
        // 1.dp 数组的定义以及下标的含义
        // dp[i] 表示第i项的斐波那契数，i 从 0 到 n，所以数组长度为n+1
        int[] dps = new int[n+1];

        // 初始化
        dps[0] = 0;
        dps[1] = 1;
        // 遍历顺序从前往后
        for(int i = 2; i < dps.length; i++) {
            //递推公式
            dps[i] = dps[i-1] + dps[i-2];
        }
        return dps[n];
    }

    @Test
    public void solution2() {
        int ans = fib2(8);
        System.out.println("ans -> " + ans);
    }

    /**
     * 滚动数组解法
     * 也可以用几个变量简化动态规划解法，降低空间复杂度
     * @param n
     * @return
     */
    public int fib2(int n) {
        int ppre = 0;
        int pre = 1;
        int ans = pre + ppre;
        for (int i = 2; i <= n; i++) {
            ans = pre + ppre;
            ppre = pre;
            pre = ans;
        }
        return ans;
    }

    @Test
    public void solution3() {
        int ans = fib3(8);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法：即是暴力法，有很多重复计算，可以进一步用hash 进行记忆化递归优化
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib3(n-1) + fib3(n-2);
    }

    @Test
    public void solution4() {
        int ans = fib4(8);
        System.out.println("ans -> " + ans);
    }

    public int fib4(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        return recursion(n, cache);
    }

    public int recursion(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ans = recursion(n - 1,  cache) + recursion(n - 2, cache);
        cache.put(n, ans);
        return ans;
    }
}