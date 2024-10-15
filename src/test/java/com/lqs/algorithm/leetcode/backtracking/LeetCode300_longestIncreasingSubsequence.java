package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本题目回溯方法可以做，但是会超出时间限制
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode300_longestIncreasingSubsequence {

    @Test
    public void test() {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {0,1,0,3,2,3};
        int[] nums = {7, 7, 7, 7};

        int ans = lengthOfLIS(nums);
        System.out.println("ans -> " + ans);
    }

    public int sum = 0;
    public int lengthOfLIS(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backTracking(path, nums, 0);
        return sum;
    }

    public void backTracking(List<Integer> path, int[] nums, int startIndex) {
        // exit condition
        if (path.size() > sum) {
            sum = path.size();
            System.out.println("got max size path = " + path);
        }

        // loop
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i], true);
            if (path.isEmpty() || nums[i] > path.getLast()){
                path.add(nums[i]);
                backTracking(path, nums, i+1);
                path.removeLast();
            }
        }
    }
}