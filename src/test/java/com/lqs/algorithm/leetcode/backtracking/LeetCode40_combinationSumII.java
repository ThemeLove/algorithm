package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.*;

/**
 * 组合总和，每个元素只能用一次
 * 数组有重复元素，需要去重
 * 参考题解：https://leetcode.cn/problems/combination-sum-ii/solutions/14753/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 * 解题关键：对数组排序后，回溯函数中对同层处理过的元素去重
 * create by lqs
 * date:2024-10-12
 */
public class LeetCode40_combinationSumII {

    @Test
    public void test() {
//        int[] nums = {10,1,2,7,6,1,5};
        int[] nums = {1, 10 ,2,7,6,1,5};

        List<List<Integer>> ret = combinationSum(nums, 8);

        System.out.println("ret -> " + ret);
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        backTracking(ret, new ArrayList<>(), nums, target, 0);

        return ret;
    }

    public void backTracking(List<List<Integer>> ret, List<Integer> path, int[] nums, int target, int start) {
        // exit condition
        if (target == 0) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // loop
        for (int i = start; i < nums.length; i++) {
            // 大剪枝, 如果当前要处理的元素大于剩余和，则直接跳出循环，因为数组是排序的，后续的元素也不满足条件
            if (nums[i] > target) break;

            // 小剪枝，层剪枝，跳过处理过的重复元素，本层循环是从start开始的，所以从start+1个元素开始就需要判断去重逻辑
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            path.add(nums[i]);
            backTracking(ret, path, nums, target-nums[i], i+1);
            path.removeLast();
        }
    }



    @Test
    public void test2() {

    }

}