package com.lqs.algorithm.leetcode.hash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 202 : 快乐数
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 * Example 1:
 *
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 *
 * Input: n = 2
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 * create by lqs
 * date:2024-10-15
 */
public class LeetCode202_happyNumber {

    @Test
    public void test() {
        boolean ans = isHappy(2);
        System.out.println("ans -> " + ans);
    }

    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<>();
        int curSum = getSum(n);
        while(curSum != 1){
            if (cache.contains(curSum)) return false;
            cache.add(curSum);
            curSum = getSum(curSum);
        }
        return true;
    }

    public int getSum(int n) {
        int sum = 0;
        while(n >= 10) {
            int mod = n%10;
            sum += mod*mod;
            n =n/10;
        }
        sum += n*n;
        return sum;
    }

}