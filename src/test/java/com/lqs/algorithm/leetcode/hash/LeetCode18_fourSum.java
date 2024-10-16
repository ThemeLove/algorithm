package com.lqs.algorithm.leetcode.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 18
 *
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode18_fourSum {

    @Test
    public void test() {
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> ans = fourSum(nums, 0);

        System.out.println("ans -> " + ans);
    }


    /**
     * 回溯算法，本质也是暴力搜索，超出时间限制
     * @param nums
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        backTracking(ans, new ArrayList<>(), nums, target, 0);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums, int target, int startIndex) {
        // exit condition
        if (path.size() == 4){
            if (path.stream().reduce(Integer::sum).get() == target) {
                ans.add(new ArrayList<>(path));
            }
        }

        // loop
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backTracking(ans, path, nums, target,i+1);
            path.removeLast();
        }

    }
}