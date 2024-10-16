package com.lqs.algorithm.leetcode.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode15_threeSum {

    @Test
    public void test() {
        int[] nums = {-1,0,1,2,-1,-4};
        // {-4,-1,-1,0,1,2}
        List<List<Integer>> ans = threeSum(nums);

        System.out.println("ans -> " + ans);
    }

    /**
     * 暴力解法,超出时间限制
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break; // 因为数组是排序的，剪枝操作
            if (i>0 && nums[i] == nums[i-1]) continue;// 同层去重

            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] > 0) break;// 因为数组是排序的，剪枝操作
                if (j>i+1 && nums[j] == nums[j-1]) continue;//同层去重

                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i] + nums[j] + nums[k] > 0) break;// 因为数组是排序的，剪枝操作
                    if (k>j+1 && nums[k] == nums[k-1]) continue;//同层去重

                    if(nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> path = new ArrayList<>();
                        path.add(nums[i]);
                        path.add(nums[j]);
                        path.add(nums[k]);
                        ans.add(path);
                    }

                }
            }
        }
        return ans;
    }


    @Test
    public void test2() {
        int[] nums = {-1,0,1,2,-1,-4};
        // {-4,-1,-1,0,1,2}
        List<List<Integer>> ans = threeSum2(nums);

        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯算法，本质也是暴力搜索，超出时间限制
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        backTracking(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public void backTracking(List<List<Integer>> ans, List<Integer> path, int[] nums, int startIndex) {
        // exit condition
        if (path.size() == 3){
            if (path.stream().reduce(Integer::sum).get() == 0) {
                ans.add(new ArrayList<>(path));
            }
        }

        // loop
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            backTracking(ans, path, nums, i+1);
            path.removeLast();
        }

    }

}