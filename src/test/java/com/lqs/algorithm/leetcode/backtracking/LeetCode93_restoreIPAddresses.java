package com.lqs.algorithm.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-10-13
 */
public class LeetCode93_restoreIPAddresses {

    @Test
    public void testStr() {
        StringBuilder sb = new StringBuilder("HHH");

        sb.append("aaa").append(".");

        System.out.println(sb);

        sb.delete(7-4, 7);
        System.out.println(sb);
    }

    @Test
    public void test(){
        String s = "25525511135";
//        String s = "0000";
//        String s = "101023";
        List<String> ans = restoreIpAddresses(s);

        System.out.println("ans -> " + ans);
    }

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        backTracking(ans, new StringBuilder(), s, 0, 0);

        return ans;
    }

    public void backTracking(List<String> ans, StringBuilder path, String s, int startIndex, int dotCount){
        // exit condition
        if (dotCount >= 3) {// ip 地址是3个点分割成3个部分，dotCount =3 意味着切割了3次，即递归了3次，就不用再切割了，是出口
            // 需要判断最后一部分（第4部分）字串是否是合格
            String lastPartStr = s.substring(startIndex);
            System.out.println("s->" + s);
            System.out.println("path -> " + path);
            System.out.println("lastPartStr -> " + lastPartStr);
            if (isValid(lastPartStr)) {
                path.append(lastPartStr);// 最后一部分不需要拼接dot
                ans.add(path.toString());
                path.delete(path.length()-lastPartStr.length(), path.length());// 这一部分也要手动回溯
                System.out.println("got it -------> " + path);
            }
            return;
        }


        // loop
        for (int i = startIndex; i < s.length(); i++) {
            String subStr = s.substring(startIndex, i);
            if (isValid(subStr)) {
//                System.out.println("subStr -> " + subStr);
                path.append(subStr).append(".");
                dotCount++;
                backTracking(ans, path, s, i, dotCount);
                path.delete(path.length() - (subStr.length()+1), path.length());
                dotCount--;
            }
        }

    }

    public boolean isValid(String s){
        if (s == null || s.isEmpty()) return false;
        if (s.length() > 1 && s.startsWith("0")) return false;
        if (s.length() > 3) return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

}