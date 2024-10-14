package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-13
 */
public class LeetCode131_palindromePartitioning {

    @Test
    public void test() {

        String s = "abb";
//        String s = "aab";

        List<List<String>> ans = partition(s);

        System.out.println("ans -> " + ans);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        backTracking(ans, new ArrayList<>(), s);

        return ans;
    }

    public void backTracking(List<List<String>> ans, List<String> path, String s) {
        // exit condition
        if (s == null || s.isEmpty()) {// 结束条件，收集结果
            ans.add(new ArrayList<>(path));
            return;
        }

        // loop
        for (int i = 0; i <= s.length(); i++) {
            String leftStr = s.substring(0, i);
            if (!isPalindrome(leftStr)) continue; // 剪枝操作
            path.add(leftStr);
            String rightStr = s.substring(i);
            System.out.println("left str -> " + leftStr);
            System.out.println("rightStr str -> " + rightStr);
            backTracking(ans, path, rightStr);
            path.removeLast();
        }
    }

    /**
     * 判断字符川是否是否是回文字符串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        if(s.length() ==1) return true;
        int left = 0;
        int right = s.length() -1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}