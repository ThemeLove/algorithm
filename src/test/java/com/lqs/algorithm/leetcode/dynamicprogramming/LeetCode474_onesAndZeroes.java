package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 474  一和零
 * create by lqs
 * date:2024-11-01
 */
public class LeetCode474_onesAndZeroes {

    @Test
    public void solution() {
        String[] strs = {"10","0001","111001","1","0"};
        int ans = findMaxForm(strs, 5, 3);
        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯算法（每个元素选或不选）
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        backTracking(strs, new ArrayList<>(), m, n, 0);
        return maxLen;
    }

    int maxLen;
    public void backTracking(String[] strs, List<String> list, int m, int n, int index) {
        if (index < strs.length) {
            String str = strs[index];
            // 不take 该元素的情况
            backTracking(strs, list, m, n, index+1);//取
            // take 该元素的情况
            list.add(str);
            backTracking(strs, list, m, n, index+1);//不取
            // 这里要回溯掉
            list.removeLast();
        } else {
            // collect result condition
            if(check(list, m, n)) { // 满足条件的子集，更新其长度，取最大值
                System.out.println("list -> " +list);
                maxLen = Math.max(maxLen, list.size());
            }
        }
    }

    public boolean check(List<String> list, int m, int n) {
        int oneNum = 0;
        int zeroNum = 0;
        for (String str: list) {
            for (char ch: str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                    if (zeroNum > m) return false;
                }else {
                    oneNum++;
                    if (oneNum > n) return false;
                }
            }
        }
        return true;
    }

    @Test
    public void solution2() {
        String[] strs = {"10","0001","111001","1","0"};
        int ans = findMaxForm2(strs, 5, 3);
        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯方案2
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        backTracking2(strs, new ArrayList<>(), m, n, 0);
        return maxLen;
    }

    public void backTracking2(String[] strs, List<String> path, int m, int n, int index) {
        if (check(path, m, n)) {
            System.out.println("path -> " + path);
            maxLen = Math.max(maxLen, path.size());
        }
        // loop
        for (int i = index; i < strs.length; i++) {
            String str = strs[i];
            path.add(str);
            backTracking2(strs, path, m, n, i+1);
            path.removeLast();
        }
    }

    @Test
    public void solution3() {
        String[] strs = {"10","0001","111001","1","0"};
        int ans = findMaxForm3(strs, 5, 3);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * 二个维度的01背包问题
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm3(String[] strs, int m, int n) {
        // dp 数组的定义：从物品strs中任选物品，装满m个0，n个1的背包，最多选几个物品
        int[][] dp = new int[m+1][n+1];
        // init
        dp[0][0] = 0;

        // loop
        for (int i = 0; i < strs.length; i++) {
            int zeroNum = 0;
            int oneNum = 0;
            String str = strs[i];
            for(char ch: str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            // 2个维度倒序遍历
            for (int j = m; j>=zeroNum; j--) {
                for (int k = n; k>=oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeroNum][k-oneNum] + 1);
                    System.out.println("dp["+j+"]["+k+"]->" + dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }


    @Test
    public void solution4() {
        String[] strs = {"10","0001","111001","1","0"};
        int ans = findMaxForm4(strs, 5, 3);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划，详细版本
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm4(String[] strs, int m, int n) {
        // dp 数组的定义：从物品strs中任选物品，装满m个0，n个1的背包，最多选几个物品
        int[][] dp = new int[m+1][n+1];
        // init,dp[0][0]表示装满0个0，0个1的背包最多放几个物品为0
        dp[0][0] = 0;
        // 因为本题的解是求放物品个数的最大值，所以初始化一般初始化为0，正解的话会在给dp数组赋值的过程中覆盖初始值，一般是Math.max实现
        // 1->m个0，0个1 的初始化,初始化为0,因为二维数组元素值默认为0，无需额外操作
        // 0个0,1->n个1 的初始化，初始化为0,因为二维数组元素值默认为0，无需额外操作

        // loop
        for (int i = 0; i < strs.length; i++) {//遍历物品
            int zeroNum = 0;
            int oneNum = 0;
            String str = strs[i];
            for(char ch: str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            /*// 2个维度倒序遍历背包,要倒序遍历
            for(int j = m; j>=0; j--) {
                for (int k = n; k >=0; k--) {
                    if (j >= zeroNum && k >= oneNum) { // 背包容量放的下的时候才可以选择放或者不放
                        // 选择不放
                        int noPut = dp[j][k]; // 不覆盖原来的值，此时dp[j][k]的值是遍历上一个物品时(即i-1)赋的值
                        // 选择放，先把二个维度的背包减掉再加上放当前物品，数量+1
                        int put = dp[j - zeroNum][k - oneNum] + 1;
                        // 取最大值
                        dp[j][k] = Math.max(noPut, put);
                    } else{ // 背包容量放不下,自然不放当前物品，不覆盖原来的值，此时dp[j][k]的值是遍历上一个物品时(即i-1)赋的值
                        dp[j][k] = dp[j][k];
                    }
                }
            }*/

            // 精简版 2个维度倒序遍历背包
            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeroNum][k-oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}