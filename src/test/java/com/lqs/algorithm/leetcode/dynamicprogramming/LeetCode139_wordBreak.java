package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode139_wordBreak {

    @Test
    public void solution() {
        String s = "applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        boolean ans = wordBreak(s, wordDict);
        System.out.println("ans -> " + ans);
    }

    /**
     * 可以转化为完全背包问题（有点硬套的意思）
     * 背包为s
     * 物品为wordDict
     * 求能否正好装满背包
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int j = 0; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                // sub string
                String subStr = s.substring(i, j);
                if(dp[i] && wordDict.contains(subStr)) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    // 第二中思路
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        // init
        dp[0] = true;
        for (int j = 0; j <= s.length(); j++) {
            for (String word : wordDict) {
                int len = word.length();
                if (j >= len && dp[j - len] && word.equals(s.substring(len, j - len))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}