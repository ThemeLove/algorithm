package com.lqs.algorithm.interview;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 马士基算法面试题目
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode300_longestIncreasingSubsequence {

    @Test
    public void solution() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int ans = lengthOfLIS(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划解法
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        ArrayUtil.printArr(dp);
        return maxLen;
    }

    @Test
    public void solution2() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int ans = lengthOfLIS2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 回溯算法
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(nums, ans, new ArrayList<>(), 0);
        int maxLen = 0;
        for(List<Integer> list: ans) {
            maxLen = Math.max(list.size(), maxLen);
        }
        System.out.println("ans -> " + ans);
        return maxLen;
    }

    public void backTracking(int[] nums, List<List<Integer>> ans, List<Integer> path, int startIndex) {
        // exit condition
        for(int i = startIndex; i < nums.length; i++) {
            boolean isAdd = false;
            if (path.isEmpty()) {
                path.add(nums[i]);
                isAdd = true;
            } else {
                Integer last = path.getLast();
                if (nums[i] > last) {
                    path.add(nums[i]);
                    isAdd = true;
                }
            }
            backTracking(nums, ans, path, i+1);
            if (isAdd) {
                path.removeLast();
            }
        }

    }

}