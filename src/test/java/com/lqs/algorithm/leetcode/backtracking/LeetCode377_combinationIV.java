package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode377_combinationIV {
    @Test
    public void test() {
        int[] nums = {1, 2, 3};

        int ret = combinationSum(nums, 4);

        System.out.println("ret -> " + ret);
//        System.out.println("sum -> " + sum);
    }

    private int sum = 0;

    /**
     * 朴素dfs, 超出时间限制
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum(int[] nums, int target) {
        backTracking(nums, target, 0);
        return sum;
    }

    public void backTracking(int[] nums, int target, int start) {
//        System.out.println("count = " + count);
//        System.out.println("start = " + start);
//        System.out.println("target = " + target);
        // exit condition
        if (target < 0) return;
        if (target == 0) {
            sum++;
            return;
        }

        // loop
        for (int i = start; i < nums.length; i++) {
            backTracking(nums, target - nums[i], i);
        }

    }
    /**
     * dfs + 记忆化搜索
     * 空间换时间，降低时间复杂度
     */
    @Test
    public void test2() {
        int[] nums = {1, 2, 3};

        int ret = combinationSum2(nums, 4);

        System.out.println("ret -> " + ret);
    }

    public int combinationSum2(int[] nums, int target) {

        Map<Integer, Integer> cache = new HashMap<>();

        return dfs(nums, target, cache);
    }

    public int dfs(int[] nums, int target, Map<Integer, Integer> cache) {
        // exit condition
        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        if (target < 0) return 0;

        if (target == 0) {
            return 1;
        }

        // loop
        // count 意义表示当目标和为target 时，符合的组合数，它是统计遍历每个元素之后的相加的和
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            count += dfs(nums, target - nums[i], cache);

        }
        cache.put(target, count);
        return count;
    }


    /**
     * 动态规划解法
     */
    public void test3(){


        int[] nums = {1, 2, 3};

        int ans = combinationSum3(nums, 4);

        System.out.println("ans -> " + ans);


    }

    public int combinationSum3(int[] nums, int target) {

//        int[] dps = new int[];

        return -1;
    }







    @Test
    public void testDetails() {
        int[] nums = {1, 2, 3};

        List ret = combinationSumDetails(nums, 4);

        System.out.println("ret -> " + ret);
    }

    public List<List<Integer>> combinationSumDetails(int[] nums, int target) {

        List<List<Integer>> ret = new ArrayList<>();
        backTrackingDetails(ret, new ArrayList<>(), nums, target);
        return ret;
    }

    public void backTrackingDetails(List<List<Integer>> ret, List<Integer> path, int[] nums, int target) {
        // exit condition
        if (target < 0) return;
        if (target == 0) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // loop
        for (int i = 0; i < nums.length; i++) {
            path.add(nums[i]);
            backTrackingDetails(ret, path, nums, target - nums[i]);
            path.removeLast();
        }

    }


}