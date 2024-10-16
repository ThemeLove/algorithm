package com.lqs.algorithm.leetcode.string;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 151 反转字符串中的单词
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 * There is at least one word in s.
 *
 * create by lqs
 * date:2024-10-16
 */
public class LeetCode151_reverseWordsInAString {

    @Test
    public void test() {
        String s = "  hello   World  Ni hao 3  ";
        String ans = reverseWords(s);
        System.out.println("ans -> [" + ans + "]");
    }

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        s = s.trim();

        String[] split = s.split("\\ +");

        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    @Test
    public void test2() {
        String s = "  hello   World  Ni hao 3  ";
        String ans = reverseWords2(s);
        System.out.println("ans -> [" + ans + "]");
    }

    public String reverseWords2(String s) {
        if (s == null || s.isEmpty()) return s;
        char[] chars = s.toCharArray();

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch: chars) {
            if (Character.isWhitespace(ch)) {
                if (!sb.isEmpty()) {
                    list.add(sb.toString());
                    sb.setLength(0);
                }
                continue;
            }
            sb.append(ch);
        }

        if (!sb.isEmpty()) {
            list.add(sb.toString());
            sb.setLength(0);
        }

        for(int i = list.size() -1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }

}