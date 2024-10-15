package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode78_subsets {

    @Test
    public void test(){
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);

        System.out.println("ans -> " + ans);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        ans.add(new ArrayList<>(path));

        backTracking(ans, path, nums, 0);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums, int startIndex) {
        // loop
        // 子序列问题要收集每一个路径
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backTracking(ans, path, nums, i+1);
            path.removeLast();
        }
    }

}