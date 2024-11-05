package com.lqs.algorithm.kamacoder.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * create by lqs
 * date:2024-11-05
 */
public class KamaCode56_multipleBag {

    @Test
    public void solution() {
        /*
            1 3 4
            15 20 30
            2 3 2
        */
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int[] nums = {2, 3, 2};
        int bagSize = 10;
        int ans = multipleBag(weights, values, nums, bagSize);
        System.out.println("ans -> " + ans);
    }

    /**
     * 多重背包的问题，其实可以把每个物品的数量展开，转换为01背包的问题
     * @param weights
     * @param values
     * @param nums
     * @param bagSize
     * @return
     */
    public int multipleBag(int[] weights, int[] values, int[] nums, int bagSize) {
        // 转化为01背包的问题
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        // 平铺重量
        int[] allWeights = new int[total];
        int weightInx = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                allWeights[weightInx] = weights[i];
                weightInx++;
            }
        }

        // 平铺价值
        int[] allValues = new int[total];
        int valueInx = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i]; j++) {
                allValues[valueInx] = values[i];
                valueInx++;
            }
        }

        // 01 背包解法
        int[] dp = new int[bagSize+1];

        // init

        // loop
        for (int i = 0; i < allWeights.length; i++) { // 先遍历物品
            for (int j = bagSize; j >= allWeights[i]; j--) {// 再倒序遍历背包
                dp[j] = Math.max(dp[j], dp[j-allWeights[i]] + allValues[i]);
            }
        }
        return dp[bagSize];
    }
}