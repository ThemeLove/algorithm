package com.lqs.algorithm.algorithm;

/**
 * 快速幂算法
 *
 * 可以解决斐波那契数列问题
 *
 * ref link:https://www.bilibili.com/video/BV1GA411Q79k/?spm_id_from=333.337.search-card.all.click&vd_source=b859174ae70e495ba11b3c433be2a7ee
 *
 * create by lqs
 * date:2024-09-13
 */
public class FastPow {


    public static void main(String[] args) {

        int res = fastPow1(2, 11);

        System.out.println("res- > " + res);
    }

    public static int fastPow(int a, int n) {
        int res = 1;
        while(n != 0) {
            if(n % 2 == 1) {
                res = res * a;
            }
            a = a * a;

            n = n/2;
        }
        return res;
    }

    public static int fastPow1(int a, int n) {
        int res = 1;
        while(n != 0) {
            if((n & 1) == 1) {
                res = res * a;
            }
            a = a * a;

            n = n >> 1;
        }
        return res;
    }


}