package com.lqs.algorithm.leetcode.string;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * LeetCode 344 : 反转字符串
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ['h','e','l','l','o']
 * Output: ['o','l','l','e','h']
 * Example 2:
 *
 * Input: s = ['H','a','n','n','a','h']
 * Output: ['h','a','n','n','a','H']
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode344_reverseString {

    @Test
    public void test() {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

        ArrayUtil.printArr(s);
    }

    /**
     * 双指针法
     * @param s
     */
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;
        int left = 0;
        int right = s.length-1;
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}