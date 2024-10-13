package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和，每个元素只能用一次
 * 数组有重复元素，需要去重
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode40_combinationSumII {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    @Test
    public void test() {
        int[] nums = {10,1,2,7,6,1,5};

        List<List<Integer>> ans = combinationSum2(nums, 8);

        System.out.println("ans -> " + ans);
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        backTracking(nums, target, 0, 0);

        return ans;
    }

    public void backTracking(int[] nums, int target, int startIndex, int sum) {
        if (sum > target) return;
        // exit condition
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // loop
        int length = nums.length;

        for (int i = startIndex; i < length; i++) {
            path.add(nums[i]);
            sum+=nums[i];
            backTracking(nums, target, i+1, sum);
            path.removeLast();
            sum-=nums[i];
        }
    }
}