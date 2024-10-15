package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode47_permutationsII {

    @Test
    public void test(){
        int[] nums = {1, 1, 2};
        // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        List<List<Integer>> ans = permuteUnique(nums);

        System.out.println("ans -> " + ans);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(nums.length);
        boolean[] used = new boolean[nums.length];
        // 先将数组排序，这样相等的元素会相邻，后续利用这个特性判断元素相等，判断同层相等的元素是否处理过
        Arrays.sort(nums);
        backTracking(ans, path, nums, used);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] used) {
        // exit condition
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // loop
        for (int i = 0; i < nums.length; i++) {
            // 大剪枝： 同层剪枝，同层相等元素只需要处理一次，后面相等元素都是重复操作
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            // 小剪枝：一组排列中同一位置的元素之只能使用一次
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backTracking(ans, path, nums, used);
            path.removeLast();
            used[i] = false;
        }
    }


}