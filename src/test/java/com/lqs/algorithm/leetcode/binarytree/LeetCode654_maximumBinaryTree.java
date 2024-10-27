package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import org.junit.Test;

/**
 * LeetCode 654 最大二叉树
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode654_maximumBinaryTree {

    @Test
    public void solution() {
        int[] nums = {3,2,1,6,0,5};
        TreeNode ans = constructMaximumBinaryTree(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归模拟
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int maxIndex = getMaxIndex(nums);
        TreeNode node =new TreeNode(nums[maxIndex]);
        int[] lArr = new int[maxIndex];
        System.arraycopy(nums, 0, lArr, 0, maxIndex);

        int[] rArr = new int[nums.length - (maxIndex+1)];
        System.arraycopy(nums, maxIndex+1, rArr, 0, nums.length - (maxIndex + 1));

        node.left = constructMaximumBinaryTree(lArr);
        node.right = constructMaximumBinaryTree(rArr);
        return node;
    }

    public int getMaxIndex(int[] nums) {
        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Test
    public void solution2() {
        int[] nums = {3,2,1,6,0,5};
        TreeNode ans = constructMaximumBinaryTree2(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 递归模拟，实际上不用每次构造新的子数组，还用原来的数组，维护子数组的左右区间索引即刻，可以较少空间复杂度
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return buildMaxTree(nums, 0, nums.length);
    }

    public TreeNode buildMaxTree(int[] nums, int left, int right) {
        if (nums == null || nums.length == 0 || right - left <= 0) return null;
        int maxIndex = left;
        for(int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        // left subTree
        root.left = buildMaxTree(nums, left, maxIndex);
        // right subTree
        root.right = buildMaxTree(nums, maxIndex+1, right);
        return root;
    }

}