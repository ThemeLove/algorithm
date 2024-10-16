package com.lqs.algorithm.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 242 : 有效的字母异位词
 *
 * Given two strings s and t, return true if t is an
 * anagram
 *  of s, and false otherwise.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 *
 * Output: true
 *
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 *
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode242_validAnagram {

    @Test
    public void test() {
//        String s = "anagram";
//        String t = "nagaram";

        String s = "cat";
        String t = "bab";

        boolean ans = isAnagram(s, t);

        System.out.println("ans -> " + ans);
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> cache = new HashMap<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            Integer count = cache.getOrDefault(c, 0);
            cache.put(c, ++count);

        }
        char[] charArr2 = t.toCharArray();
        for (char c : charArr2) {
            Integer count = cache.getOrDefault(c, 0);
            if(count <= 0) {
                return false;
            }
            cache.put(c, --count);
            if (count == 0) {
                cache.remove(c);
            }
        }
        return cache.isEmpty();
    }

}