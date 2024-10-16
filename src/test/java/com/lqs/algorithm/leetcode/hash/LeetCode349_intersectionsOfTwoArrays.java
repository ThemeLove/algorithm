package com.lqs.algorithm.leetcode.hash;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * The intersection of two arrays is defined as the set of elements that are present in both arrays.
 *
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection
 * . Each element in the result must be unique and you may return the result in any order.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode349_intersectionsOfTwoArrays {

    @Test
    public void test() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2, 2};
//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9,4,9,8,4};

        int[] ans = intersection(nums1, nums2);

        ArrayUtil.printArr(ans);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Set<Integer> temp = new HashSet<>();
        Set<Integer> cache = new HashSet<>();
        for (int i : nums1) {
            cache.add(i);
        }
        for(int i : nums2) {
            if (cache.contains(i)) temp.add(i);
        }
        int[] ans = new int[temp.size()];

        int index = 0;
        for (Integer i : temp) {
            ans[index] = i;
            index++;
        }
        return ans;
    }

}