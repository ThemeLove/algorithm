package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 718 最长重复子数组
 * create by lqs
 * date:2024-11-06
 */
public class LeetCode718_maximumLengthOfRepeatedSubArray {

    @Test
    public void solution() {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        int ans = findLength(nums1, nums2);
        System.out.println("ans -> " + ans);
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        return -1;
    }

}