package com.lqs.algorithm.leetcode.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 383 赎金信
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 * 
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode383_RansomNote {

    @Test
    public void test() {
        String ransomNote = "aa";
        String magazing = "ab";

        boolean ans = canConstruct(ransomNote, magazing);
        System.out.println("ans -> " + ans);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> cache = new HashMap<>();
        char[] chars = magazine.toCharArray();
        for(char c : chars) {
            Integer count = cache.getOrDefault(c, 0);
            cache.put(c, ++count);
        }

        for(int i = 0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = cache.getOrDefault(c, 0);
            if (count == 0) return false;
            cache.put(c, --count);
        }
        return true;
    }

}