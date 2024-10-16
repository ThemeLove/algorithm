package com.lqs.algorithm.leetcode.string;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * 字符串刷题中常用的一些操作
 *  String 类的一些常用方法
 *  toCharArray
 *  valueOf
 *  trim
 *  split
 *  join
 *  chatAt
 *  indexOf
 *  lastIndexOf
 *  subString
 *  equals
 *  isEmpty
 *  length
 *  contains
 *  concat
 *
 *  StringBuffer, StringBuilder 常用方法
 *  append
 *
 *
 * create by lqs
 * date:2024-10-16
 */
public class CommonOperation {
    /**
     * 字符串转字节数组
     */
    @Test
    public void toCharArray() {
        String str = "abcdefg";
        char[] chars = str.toCharArray();
        ArrayUtil.printArr(chars);
    }

    /**
     * valueOf生成字符串
     */
    @Test
    public void valueOf(){
        char[] chars = {'a', 'b', 'c', 'd'};
        String strFromNewWithChars = new String(chars);
        System.out.println("strFromNewWithChars -> " + strFromNewWithChars);

        // String.valueOf with chars 等同 new String with chars
        String strFromChars = String.valueOf(chars);
        System.out.println("strFromChars -> " + strFromChars);

        String strFromCharsWithOffsetAndCount = String.valueOf(chars, 1, 2); // bc
        System.out.println("strFromCharsWithOffsetAndCount -> " + strFromCharsWithOffsetAndCount);

        String strFromInt = String.valueOf(123);
        System.out.println("strFromInt -> " + strFromInt);

        String strFromLong = String.valueOf(456L);
        System.out.println("strFromLong -> " + strFromLong);

        String strFromFloat = String.valueOf(3.1415f);
        System.out.println("strFromFloat -> " + strFromFloat);

        String strFromDouble = String.valueOf(3.1415926d);
        System.out.println("strFromDouble -> " + strFromDouble);
    }

    /**
     * 针对参数 char[] 来说
     * String.copyValueOf 和 String.valueOf 一模一样，内部实现一样
     */
    @Test
    public void copyValueOf() {
        char[] chars = {'a', 'b', 'c'};
        String strFromCopyValueOf = String.copyValueOf(chars);
        System.out.println("strFromCopyValueOf -> " + strFromCopyValueOf);

        String strFromCopyValueOfWithOffsetAndCount = String.valueOf(chars, 1, 2);
        System.out.println("strFromCopyValueOfWithOffsetAndCount -> " + strFromCopyValueOfWithOffsetAndCount);
    }

    /**
     * 去除首尾空格
     */
    @Test
    public void trim() {
        String s = "  a b  c   ";
        String strAfterTrim = s.trim();
        System.out.println("strAfterTrim -> " + strAfterTrim);
    }

    /**
     * 按字符或正则表达式分割字符串
     */
    @Test
    public void split() {
        String s = " abc def ";
        String[] splitWithSpace = s.split(" ");
        // output -> [, abc, def] , 注意空格分割后，尾部的空的字符不会包含在结果数组中
        ArrayUtil.printArr(splitWithSpace);

        String s1 = "-abc--def---ghi-";
        String[] splitWithRegex = s1.split("\\-+");// \\-+ 其中的+号表示一个多个
        // output -> [, abc, def, ghi] , 注意正则表达式分割后，尾部的空的字符不会包含在结果数组中
        ArrayUtil.printArr(splitWithRegex);
    }

    /**
     * 拼接字符穿
     */
    @Test
    public void join() {
        String join = String.join("-", "abc", "def", "ghi");
        System.out.println("join -> " + join);
        // output-> join -> abc-def-ghi

        // 参数也可以是数组，join的参数列表是CharSequence... 可变参数
        String[] toJoins = {"ABC", "DEF", "GHI"};
        String join1 = String.join("*", toJoins);
        System.out.println("join1 -> " + join1);
    }


    /**
     * ***************************StringBuffer, StringBuilder***************************
     * append
     * charAt
     * setCharAt
     * length
     * setLength ->该方法可以用来情况StringBuilder里的内容。 setLength(0)
     * isEmpty
     * subString
     * delete
     * deleteCharAt
     * reverse
     * indexOf
     * lastIndexOf
     * equals
     * replace
     * repeat
     * compareTo
     */

    /**
     * append 拼接字符串
     */
    @Test
    public void append() {
        StringBuilder sb = new StringBuilder("abc");
        sb.append(",def");
        System.out.println(sb);
    }

    /**
     * insert 插入字符或字符串
     */
    @Test
    public void insert() {
        StringBuilder sb = new StringBuilder("world");
        sb.insert(sb.length(), '~');
        System.out.println(sb);

        sb.insert(0, "hello ");
        System.out.println(sb);
    }

    /**
     * 设置指定索引位的字符
     */
    @Test
    public void setCharAt() {
        StringBuilder sb = new StringBuilder("aaaaa");
        sb.setCharAt(2, 'b');
        System.out.println(sb);
    }

    /**
     * 按字典序比较
     */
    @Test
    public void compareTo() {
        StringBuilder sb = new StringBuilder("aaa");
        StringBuilder sb2 = new StringBuilder("acb");
        int i = sb.compareTo(sb2);
        System.out.println(i);
    }

    /**
     * 删除子序列，左开右闭
     * delete (int start, int end) [start, end)
     */
    @Test
    public void delete() {
        StringBuilder sb = new StringBuilder("abcde");
        sb.delete(1, 4);
        System.out.println(sb);
    }

    /**
     * 删除指定位置的字符
     */
    @Test
    public void deleteCharAt() {
        StringBuilder sb = new StringBuilder("abcde");
        sb.deleteCharAt(1);
        System.out.println(sb);
    }

    /**
     * 反转字符串
     */
    @Test
    public void reverse() {
        StringBuilder sb = new StringBuilder("abc");
        sb.reverse();
        System.out.println(sb);
    }

    /**
     * setLength设置字符串的长度，类似切断删除的作用
     */
    @Test
    public void setLength() {
        StringBuilder sb = new StringBuilder("abcdefghijk");
        System.out.println(sb);
        sb.setLength(3);
        System.out.println(sb);
        sb.setLength(0);
        System.out.println(sb);
        sb.append("lmn");
        System.out.println(sb);
    }

    /**
     * Since JDK 21
     * 快速添加多组重复元素
     */
    @Test
    public void repeat() {
        StringBuilder sb = new StringBuilder("abc");
        sb.repeat("ha", 3);
        System.out.println(sb);
    }





    /**
     * ***************************Character***************************
     */

    @Test
    public void characterUsefulMethod() {
        // 判断是否是字符
        boolean isALetter = Character.isLetter('A');
        System.out.println("isALetter -> " + isALetter);

        boolean is0Letter = Character.isLetter('0');
        System.out.println("is0Letter -> " + is0Letter);

        boolean isDotLetter = Character.isLetter('.');
        System.out.println("isDotLetter -> " + isDotLetter);

        // 判断是否是数字
        boolean isADigit = Character.isDigit('A');
        System.out.println("isADigit -> " + isADigit);

        boolean is0Digit = Character.isDigit('0');
        System.out.println("is0Digit -> " + is0Digit);

        boolean isDotDigit = Character.isDigit('.');
        System.out.println("isDotDigit -> " + isDotDigit);

        // 判断是否是字符或数字
        boolean isALetterOfDigit = Character.isLetterOrDigit('A');
        System.out.println("isALetterOfDigit -> " + isALetterOfDigit);

        boolean is0LetterOfDigit = Character.isLetterOrDigit('0');
        System.out.println("is0LetterOfDigit -> " + is0LetterOfDigit);

        boolean isDotLetterOfDigit = Character.isLetterOrDigit('.');
        System.out.println("isDotLetterOfDigit -> " + isDotLetterOfDigit);

        // 判断是否是小写字符
        boolean isALower = Character.isLowerCase('A');
        System.out.println("isALower -> " + isALower);
        boolean isbLower = Character.isLowerCase('b');
        System.out.println("isbLower -> " + isbLower);
        boolean isDotLower = Character.isLowerCase('.');
        System.out.println("isDotLower -> " + isDotLower);

        // 判断是否是大写字符
        boolean isAUpper = Character.isUpperCase('A');
        System.out.println("isAUpper -> " + isAUpper);
        boolean isbUpper = Character.isUpperCase('b');
        System.out.println("isbUpper -> " + isbUpper);
        boolean isDotUpper = Character.isUpperCase('.');
        System.out.println("isDotUpper -> " + isDotUpper);

        // 判断是否是空格
        boolean isASpace = Character.isSpaceChar('A');
        System.out.println("isASpace -> " + isASpace);
        boolean isSpace = Character.isSpaceChar(' ');
        System.out.println("isSpace -> " + isSpace);

        boolean isAWhitesapce = Character.isWhitespace('A');
        System.out.println("isAWhitesapce -> " + isAWhitesapce);
        boolean isWhitespace = Character.isWhitespace(' ');
        System.out.println("isWhitespace -> " + isWhitespace);
    }

    /**
     * char 和 int 一样，也是直接可以用在循环里的哦
     */
    @Test
    public void charUsedInLoop() {
        for(char ch = 'A'; ch <= 'z'; ch++) {
            System.out.print(ch);
        }
        System.out.println();
        for(char ch = '0'; ch <= '9'; ch++) {
            System.out.print(ch);
        }
    }

}