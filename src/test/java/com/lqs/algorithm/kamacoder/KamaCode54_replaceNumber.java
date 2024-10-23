package com.lqs.algorithm.kamacoder;

import org.junit.Test;

/**
 * 卡码网：https://kamacoder.com/
 * kamacode 54 替换数字： link :https://kamacoder.com/problempage.php?pid=1064
 *
 * 题目描述
 * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
 * 输入描述
 * 输入一个字符串 s,s 仅包含小写字母和数字字符。
 * 输出描述
 * 打印一个新的字符串，其中每个数字字符都被替换为了number
 * 输入示例
 * a1b2c3
 * 输出示例
 * anumberbnumbercnumber
 * 提示信息
 * 数据范围：
 * 1 <= s.length < 10000。
 *
 * create by lqs
 * date:2024-10-16
 */
public class KamaCode54_replaceNumber {

    @Test
    public void test() {
        String s = "a1b2c3";
        String ans = replaceNumber(s);
        System.out.println("ans -> " + ans);
    }

    /**
     * 双指针做法
     * Time O(n)
     * Space O(1)
     * @param s
     * @return
     */
    public String replaceNumber(String s) {
        if (s == null || s.isEmpty()) return s;
        return null;
    }

    @Test
    public void test2() {
        String s = "a1b2c3";
        String ans = replaceNumber2(s);
        System.out.println("ans -> " + ans);
    }

    /**
     * 用字符数组替换实现
     * @param s
     * @return
     */
    public String replaceNumber2(String s) {
        if (s == null || s.isEmpty()) return s;
        String replaceStr = "number";
        char[] replaceChars = replaceStr.toCharArray();
        char[] chars = s.toCharArray();
        int digitCount = 0;
        for(char ch: chars) {
            if (Character.isDigit(ch)) {
                digitCount++;
            }
        }
        // 构造新的字节数组
        int len = chars.length + digitCount * replaceChars.length;
        char[] newChars = new char[len];
        int curIndex = 0;
        for(char ch: chars) {
            if (Character.isDigit(ch)) {
                for(char ch1: replaceChars) {
                    newChars[curIndex] = ch1;
                    curIndex++;
                }
            } else {
                newChars[curIndex] = ch;
                curIndex++;
            }
        }
        return new String(newChars);
    }

    @Test
    public void test3() {
        String s = "a1b2c3";
        String ans = replaceNumber3(s);
        System.out.println("ans -> " + ans);
    }

    /**
     * 用字符串的方法实现
     * @param s
     * @return
     */
    public String replaceNumber3(String s) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char ch: chars) {
            if (!Character.isDigit(ch)) {
                sb.append(ch);
            } else {
                sb.append("number");
            }
        }
        return sb.toString();
    }
}