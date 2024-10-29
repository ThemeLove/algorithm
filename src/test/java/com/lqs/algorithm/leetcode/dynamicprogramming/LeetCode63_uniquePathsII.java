package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 63 不同路径II
 * create by lqs
 * date:2024-10-28
 */
public class LeetCode63_uniquePathsII {

    @Test
    public void solution() {
//        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
//        int[][] obstacleGrid = {{0,1}, {0,0}};
        int[][] obstacleGrid = {{0,0}, {0,1}};

        int ans = uniquePathsWithObstacles(obstacleGrid); // 2
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法，在LeetCode 62的基础上 添加了障碍物，思路是障碍物的位置路径数目为0
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0].length == 0) return 0;
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        // dps 数组的定义，dps[i][j] (i <m, j<n) 表示移动到第i行第j列的不同路径数，
        // 状态转移dps[i][j] 可以由dps[i][j-1]向右移动一位 也可以由dps[i-1][j]向下移动一位得到，
        // 注意dps[i][j-1] 和 dps[i-1][j] 位置为障碍物时，其值应为0
        // 并且要判断dps[i][j]对应位置的obstacleGrid[i][j]是否==1，如果时，直接返回0
        // 所以dps[i][j] = dps[i][j-1] + dps[i-1][j]
        int[][] dps = new int[row][column];
        // init 初始化过程也要注意
        // 由于边界条件限制，第一行只能一直向右移动得到，第一列只能一直向下移动得到
        // init first row
        boolean hasRowObstacle = false;
        for(int i = 0; i < column; i++) {
            if (hasRowObstacle) {
                dps[0][i] = 0;
            } else if(obstacleGrid[0][i] == 0){
                dps[0][i] = 1;
            } else {
                dps[0][i] = 0;
                hasRowObstacle = true;
            }
        }
        // init first column
        boolean hasColumnObstacleGrid = false;
        for(int i = 0; i < row; i++) {
            if (hasColumnObstacleGrid) {
                dps[i][0] = 0;
            } else if(obstacleGrid[i][0] == 0) {
                dps[i][0] = 1;
            } else {
                dps[i][0] = 0;
                hasColumnObstacleGrid = true;
            }
        }
        // 从dps[1][1]开始遍历计算dps[i][j]
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                // 转移方程
                if (obstacleGrid[i][j] == 1) {
                    dps[i][j] = 0;
                } else {
                    dps[i][j] = (obstacleGrid[i][j-1] == 0 ? dps[i][j-1] : 0) + (obstacleGrid[i-1][j] == 0 ? dps[i-1][j] : 0);
                }
            }
        }
        return dps[row-1][column-1];
    }

}