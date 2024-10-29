package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 62 不同路径
 * create by lqs
 * date:2024-10-28
 */
public class LeetCode62_uniquePaths {

    @Test
    public void solution() {
        int ans = uniquePaths(3, 2); // 3
        System.out.println("ans -> " + ans);

        int ans2 = uniquePaths(3, 7); // 28
        System.out.println("ans2 -> " + ans2);
    }

    /**
     * 二维动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        // dps 数组的定义，dps[i][j] (i <m, j<n) 表示移动到第i行第j列的不同路径数，
        // 状态转移dps[i][j] 可以由dps[i][j-1]向右移动一位 也可以由dps[i-1][j]向下移动一位得到
        // 所以dps[i][j] = dps[i][j-1] + dps[i-1][j]
        int[][] dps = new int[m][n];
        // init 初始化过程也要注意
        // 由于边界条件限制，第一行只能一直向右移动得到，第一列只能一直向下移动得到
        // init first column
        for(int i = 0; i < m; i++) {
            dps[i][0] = 1;
        }
        // init first row
        for(int j = 0; j < n; j++) {
            dps[0][j] = 1;
        }

        // 从dps[1][1]开始遍历计算dps[i][j]
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dps[i][j] = dps[i][j-1] + dps[i-1][j];
            }
        }
        return dps[m-1][n-1];
    }

}