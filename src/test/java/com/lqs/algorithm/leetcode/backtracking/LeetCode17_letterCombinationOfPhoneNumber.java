package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 * create by lqs
 * date:2024-10-13
 */
public class LeetCode17_letterCombinationOfPhoneNumber {

    @Test
    public void test() {
        String digits = "023";

        List<String> ans = letterCombinations(digits);

        System.out.println("ans -> " + ans);

    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ret = new ArrayList<>();
        dps(ret, new StringBuilder(), map, digits.toCharArray(), 0);
        return ret;
    }

    public void dps(List<String> ret, StringBuilder path, Map<Character, String> map, char[] digits, int start) {
        // exit condition
        if (start == digits.length) {
            if (!path.isEmpty()){
                ret.add(path.toString());
            }
            return;
        }
        // loop
        String s = map.getOrDefault(digits[start], ""); // getOrDefault 兼容不合法字符的场景

        for (int i = 0; i < s.length(); i++) {
            path = path.append(s.charAt(i));
            dps(ret, path, map, digits, start+1);
            path = path.deleteCharAt(path.length()-1);
        }
    }

}