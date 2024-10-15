package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46
 * Given an array nums of distinct integers, return all the possible
 * permutations
 * . You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode46_permutations {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        //[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        List<List<Integer>> ans = permute(nums);
        System.out.println("ans -> " + ans);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(ans, path, nums);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums) {
        // exit condition
        // path数量和nums数量一样时，收集结果
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // loop
        for (int i = 0; i < nums.length; i++) {
            // 因为是排列问题，取过的元素不能重复取，又因为nums 里元素为唯一的，所以直接用path的contains 方法判单当前元素是否已经选取过
            if (path.contains(nums[i])) continue;
            path.add(nums[i]);
            backTracking(ans, path, nums);
            path.removeLast();
        }
    }

}