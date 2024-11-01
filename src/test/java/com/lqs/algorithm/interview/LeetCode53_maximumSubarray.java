package com.lqs.algorithm.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode53: 最大子数组的和，子数组必须是连续的
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 *
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 *
 * create by lqs
 * date:2024-10-14
 */
public class LeetCode53_maximumSubarray {

    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int ans = maxSubArray(nums);

        System.out.println("ans -> " + ans);
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;

        for(int sum: dp){
            max = Math.max(sum, max);
        }
        return max;
    }

    @Test
    public void test2() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int ans = maxSubArray2(nums);

        System.out.println("ans -> " + ans);
    }

    public int maxSubArray2(int[] nums) {
        int p = nums[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            int q = Math.max(p + nums[i], nums[i]);
            p = q;
            max = Math.max(max, q);
        }
        return max;
    }



    /**
     * 暴力解法(Brute force)
     */
    @Test
    public void test3() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = maxSubArray2(nums);
        System.out.println("ans -> " + ans);
    }

    public int maxSubArray3(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int tempSum = 0;
            for (int j = i; j < len; j++) {
                tempSum += nums[j];
                sum = Math.max(sum, tempSum);
            }
        }
        return sum;
    }


}