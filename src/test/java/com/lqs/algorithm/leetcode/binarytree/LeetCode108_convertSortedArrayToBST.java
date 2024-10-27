package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import org.junit.Test;

/**
 * LeetCode 108 将有序数组转换为二叉搜索树
 * create by lqs
 * date:2024-10-27
 */
public class LeetCode108_convertSortedArrayToBST {

    @Test
    public void solution() {
        //[-10,-3,0,5,9]
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode ans = sortedArrayToBST(nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 将有序数组转换为二叉搜索树（并且是平衡二叉树）
     * 题解：如果不是平衡二叉树的话，可以从小到大构建一个链式二叉树或从大到小构建一个倒序二叉树
     * 比如：
     * -10->-3->0->5->9   (left 都为null)
     * 9->5->0->-3->-10   (right 都为null)
     *
     * 如果要构建平衡二叉树，上述链式就不符合要求
     *
     * 构建平衡二叉树逻辑：
     * 总是选取数组中间位置的元素，当作中间节点，左边子数组为二叉搜索树左子树，右边子数组为二叉搜索树右子树，然后递归处理左右子数组
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 循环不变量为左开右开
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        // mid index
        int midIndex = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST(nums, left, midIndex -1);
        root.right = sortedArrayToBST(nums, midIndex + 1, right);
        return root;
    }
}