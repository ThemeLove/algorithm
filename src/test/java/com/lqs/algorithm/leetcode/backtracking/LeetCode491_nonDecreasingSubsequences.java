package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode491_nonDecreasingSubsequences {

    @Test
    public void test() {
        int[] nums = {4,7,6,7};
//        int[] nums = {4, 3, 7,7,7};

        List<List<Integer>> ans = findSubsequences(nums);

        System.out.println("ans -> " + ans);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backTracking(ans, path, nums, 0);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums, int startIndex) {
        // exit condition
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }

        // loop
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i], true);
            if (path.isEmpty() || nums[i] >= path.getLast()){
                path.add(nums[i]);
                backTracking(ans, path, nums, i+1);
                path.removeLast();
            }
        }
    }

}