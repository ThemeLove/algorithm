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

}