package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * 该题没有完全理解透，需要参考题解继续多思考!!!
 *
 * reflink:https://www.bilibili.com/video/BV1eK411o7QA?spm_id_from=333.788.videopod.sections&vd_source=b859174ae70e495ba11b3c433be2a7ee
 *
 * LeetCode 96 不同的二叉搜索树
 * create by lqs
 * date:2024-10-29
 */
public class LeetCode96_uniqueBSTS {

    @Test
    public void solution() {
        int ans = numTrees(3);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // 1, 2 ,3, 4, 5,......n
        // dp 数组的定义, dp[i]表示i个元素组成的不同二叉搜索树数
        int[] dp = new int[n+1];

        // init
        dp[0] = 1; // 空二叉树
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] += dp[j-1] * dp[i-j]; // dp[j-1]左子树种类树 * dp[i-j] 右子树种类树
            }
        }
        return dp[n];
    }
}