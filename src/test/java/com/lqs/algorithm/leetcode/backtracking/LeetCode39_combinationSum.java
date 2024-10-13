package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode39_combinationSum {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    @Test
    public void test() {

        int[] cadidates = {2,3,6,7};

        List<List<Integer>> ans = combinationSum(cadidates, 7);

        System.out.println("ans -> " + ans);

    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        backStracking(nums, target, 0, 0);

        return ans;
    }

    public void backStracking(int[] nums, int target, int startIndex, int sum) {
        // exit condition
        if (sum > target) return;

        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // loop
        int length = nums.length;
        for (int i = startIndex; i < length; i++) {
            path.add(nums[i]);
            sum+=nums[i];
            backStracking(nums, target, i, sum);
            sum-=nums[i];
            path.removeLast();
        }
    }

}