package com.lqs.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法，解决组合问题
 * 循环里套递归
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode77_combinations {
    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> ans = combine(4, 2);

        System.out.println("ans -> " + ans);
    }

    public static List<List<Integer>> combine(int n, int k) {

        backTracking(n, k, 1);

        return ans;
    }

    public static void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path)); // 这里要新new 一个ArrayList, 不然每次加入的path是同一个对象，会影响之前加入的值
            return;
        }
//      for (int i = startIndex; i <= n; i++) {
        for (int i = startIndex; i <  n - (k - path.size()) + 1; i++) {// 剪枝的操作
            path.add(i);
            backTracking(n, k, i+1);
            path.removeLast();
        }
    }



}