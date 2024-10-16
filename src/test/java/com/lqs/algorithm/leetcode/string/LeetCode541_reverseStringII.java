package com.lqs.algorithm.leetcode.string;

import org.junit.Test;

/**
 * LeetCode541 反转字符串II
 *
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Example 2:
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 104
 *
 * create by lqs
 * date:2024-10-16
 */
public class LeetCode541_reverseStringII {

    @Test
    public void test() {
        String s = "abcdefg";
        // bacdfeg
        String ans = reverseStr(s, 2);
        System.out.println("ans -> " + ans);
    }


    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1 || k <= 1) return s;
        int index = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;

        while(len - index > 2*k) {
            reverse(chars, index, index + k -1);
            index += 2*k;
        }

        int endIndex = chars.length - index >= k ? index + k - 1:  chars.length -1;

        reverse(chars, index, endIndex);
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            char temp = chars[startIndex];
            chars[startIndex] = chars[endIndex];
            chars[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    @Test
    public void test2() {
        String s = "abcdefg";
        // bacdfeg
        String ans = reverseStr2(s, 2);
        System.out.println("ans -> " + ans);
    }

    public String reverseStr2(String s, int k) {
        if (s == null || s.length() <= 1 || k <= 1) return s;
        char[] chars = s.toCharArray();
        int len = chars.length;

        for(int i = 0; i < len; i += 2 * k) {
            // 注意这里最后范围的处理
            reverse(chars, i, Math.min(i+k, len) - 1);
        }
        return new String(chars);
    }

}