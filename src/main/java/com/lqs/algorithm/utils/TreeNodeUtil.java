package com.lqs.algorithm.utils;

import com.lqs.algorithm.datastructure.TreeNode;

/**
 * 二叉树构造帮助类： 入参用数组表示
 * 公式为：
 * 当前元素在数组中的位置为i,则：
 * 左叶子节点为的索引为2的k次幂+1，
 * 右叶子节点的索引为2的k次幂+2
 * create by lqs
 * date:2024-08-20
 */
public class TreeNodeUtil {

    /**
     * Create Tree node from Integer array
     * @param nodes
     * @return
     */
    public static TreeNode createTree(Integer... nodes) {
        if (nodes == null || nodes.length == 0) return null;
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for(int i = 0; i < nodes.length; i++) {
            treeNodes[i] = nodes[i] == null ? null :  new TreeNode(nodes[i]);
        }
        return createTree(treeNodes);
    }

    public static TreeNode createTree(TreeNode... nodes) {
        if (nodes == null || nodes.length == 0) return null;
        if (nodes[0] == null) return null; // 如果数组头节点为null, 则说明二叉树根节点为null
        int len = nodes.length;
        int nullCount = 0;

        for (int i = 0; i < len; i++) {
            if (nodes[i] == null) { // 说明是叶子节点,nullCount++
                nullCount++;
                continue;
            }
            // 左节点索引为 2*i + 1
            int leftIndex = 2 * (i - nullCount) + 1;
            if (leftIndex < len) { // 说明左节点在数组入参范围内
                nodes[i].left = nodes[leftIndex];
            }

            // 右节点索引为 2*i + 2
            int rightIndex = 2 * (i - nullCount) + 2;
            if (rightIndex < len) { // 说明右节点在入参数组范围内
                nodes[i].right = nodes[rightIndex];
            }
        }
        return nodes[0];
    }

    /**
     * 将有序数组转换为二叉搜索树（并且是平衡二叉树）
     * 题解：如果不是平衡二叉树的话，可以从小到大构建一个链式二叉树或从大到小构建一个倒序二叉树
     * 比如：输入数组为[-10->-3->0->5->9]
     * -10->-3->0->5->9   (left 都为null)
     * 9->5->0->-3->-10   (right 都为null)
     *
     * 如果要构建平衡二叉树，上述链式就不符合要求
     *
     * 构建平衡二叉树逻辑：
     * 总是选取数组中间位置的元素，当作中间节点，左边子数组为二叉搜索树左子树，右边子数组为二叉搜索树右子树，然后递归处理左右子数组
     * @param nums sorted array
     * @return Binary search Tree (height-balanced)
     * Height-Balanced: A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.)
     */
    public static TreeNode createBSTFromSortedArray(int[] nums) {
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
    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        // mid index
        int midIndex = left + (right - left)/2;
        TreeNode root = new TreeNode(nums[midIndex]);
        root.left = sortedArrayToBST(nums, left, midIndex -1);
        root.right = sortedArrayToBST(nums, midIndex + 1, right);
        return root;
    }

}