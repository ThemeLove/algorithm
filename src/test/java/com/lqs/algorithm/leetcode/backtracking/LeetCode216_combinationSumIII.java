package com.lqs.algorithm.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode216_combinationSumIII {

    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();


    public static void main(String[] args) {

        List<List<Integer>> ans = combinationSum3(3, 9);

        System.out.println("ans -> " + ans);

    }

    public static List<List<Integer>> combinationSum3(int k, int target) {

        backTracking(k, target, 0, 1);

        return ans;

    }

    public static void backTracking(int k, int target, int sum, int startIndex) {
        // exit condition
        if (path.size() == k && sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // loop
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1 && sum < target; i++) {
            path.add(i);
            sum +=i;
            backTracking(k, target, sum, i+1);
            sum -=i;
            path.removeLast();
        }
    }


}