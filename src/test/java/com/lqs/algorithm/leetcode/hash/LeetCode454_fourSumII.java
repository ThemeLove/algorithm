package com.lqs.algorithm.leetcode.hash;

import org.junit.Test;

/**
 * LeetCode 454 : 四数相加II
 *
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * Example 1:
 *
 * Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * Output: 2
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * Example 2:
 *
 * Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 *
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode454_fourSumII {

    @Test
    public void test() {
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};

        int ans = fourSumCount(nums1, nums2, nums3, nums4);

        System.out.println("ans -> " + ans);
    }

    /**
     * 4层循环暴力法
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;

        for(int i = 0; i< nums1.length; i++) {

            for(int j = 0; j< nums2.length; j++) {

                for(int k =0; k< nums3.length; k++) {

                    for(int l = 0; l<nums4.length; l++) {

                        if(nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            ans++;
                        }

                    }
                }
            }
        }

        return ans;
    }

}