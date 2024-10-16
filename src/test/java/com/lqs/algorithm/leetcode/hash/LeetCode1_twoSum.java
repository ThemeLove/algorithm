package com.lqs.algorithm.leetcode.hash;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode1_twoSum {

    @Test
    public void test() {
        int[] nums = {2,7,11,15};

        int[] ans = twoSum(nums, 9);

        ArrayUtil.printArr(ans);
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (cache.containsKey(num)) {
                return new int[] {cache.get(num), i};
            }
            cache.put(target - num, i);
        }
        return new int[0];
    }

}