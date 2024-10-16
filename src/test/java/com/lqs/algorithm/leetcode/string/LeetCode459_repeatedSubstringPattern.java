package com.lqs.algorithm.leetcode.string;

import org.junit.Test;

/**
 * LeetCode 459 重复的子字符串
 *
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 *
 * Example 1:
 *
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 *
 * Input: s = "aba"
 * Output: false
 * Example 3:
 *
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 * create by lqs
 * date:2024-10-16
 */
public class LeetCode459_repeatedSubstringPattern {

    @Test
    public void test() {
        String s = "abcabcabc";
//        String s = "aab";
        boolean ans = repeatedSubstringPattern(s);
        System.out.println("ans -> " + ans);
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) return false;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for(int i = 1 ; i < len/2 + 1; i++) {// len/2 + 1 是剪枝， 最长的子序列不能超过总长度的一半
            if (chars[i] == chars[0]) {
                // 字符串的长度必须是字串长度的倍数，取模 要 == 0
                if(len % i != 0) continue;
                String subStr = String.valueOf(chars, 0, i);
                int j = i;
                for (; j < len; j += i) {
                    String toCheck = String.valueOf(chars, j, i);
                    if (!subStr.equals(toCheck)) break;
                }
                if (j == len) return true;
            }
        }
        return false;
    }

}