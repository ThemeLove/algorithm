package com.lqs.algorithm.leetcode.string;

import org.junit.Test;

/**
 * LeetCode 28
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 *
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 *
 *
 * Constraints:
 *
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 *
 * create by lqs
 * date:2024-10-16
 */
public class LeetCode28_findFirstSubStrIndex {

    @Test
    public void test() {
//        String str = "HelloWorld";
//        String subStr = "llo";
        String str = "a";
        String subStr = "a";
        int ans = strStr(str, subStr);
        System.out.println("ans -> " + ans);
    }

    public int strStr(String str, String subStr) {
        if (str.length() < subStr.length()) return -1;
        char[] chars = str.toCharArray();
        char[] subChars = subStr.toCharArray();
        int charsLen = chars.length;
        int subCharsLen = subChars.length;
        for(int i = 0; i <= charsLen - subCharsLen; i++) {// 根据长度大小有个剪枝操作
            if (chars[i] == subChars[0]) {
                for (int j = 0; j < subCharsLen; j++) {
                    if (chars[i+j] != subChars[j]) break;
                    // 说明已经全匹配了
                    if (j == subCharsLen -1) return i;
                }
            }

        }
        return -1;
    }


    public int strStr3(String str, String subStr) {
        if (str.length() < subStr.length()) return -1;
        char[] chars = str.toCharArray();
        char[] subChars = subStr.toCharArray();
        int charsLen = chars.length;
        int subCharsLen = subChars.length;
        for(int i = 0; i <= charsLen - subCharsLen; i++) {// 根据长度大小有个剪枝操作
            if (chars[i] == subChars[0]) {
                int j = 1; // 这样写可以使j=1开始，因为j==0 的场景上面已经算过了，同时兼容i==0的场景
                for (; j < subCharsLen; j++) {
                    if (chars[i+j] != subChars[j]) break;
                }
                if (j == subCharsLen) return i;
            }

        }
        return -1;
    }

}