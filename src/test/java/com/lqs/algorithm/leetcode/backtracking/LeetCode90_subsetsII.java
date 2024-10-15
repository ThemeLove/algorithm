package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode90_subsetsII {

    @Test
    public void test() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = subsetsWithDup(nums);

        System.out.println("ans -> " + ans);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(nums);
        backTracking(ans, path, nums, 0);

        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums, int startIndex){
        ans.add(new ArrayList<>(path));
        // exit condition
        if(startIndex >= nums.length) return;

        // loop
        for(int i = startIndex; i < nums.length; i++) {
            if(i > startIndex && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backTracking(ans, path, nums, i+1);
            path.removeLast();
        }

    }
}