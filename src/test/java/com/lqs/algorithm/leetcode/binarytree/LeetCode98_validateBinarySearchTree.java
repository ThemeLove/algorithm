package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 98 验证二叉搜索树
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode98_validateBinarySearchTree {

    @Test
    public void solution() {
        TreeNode root = TreeNodeUtil.createTree(4, 2, 7, 1, 3);
        boolean ans = isValidBST(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 技巧：二叉搜索树按照中序便利的话，元素是递增的
     * 先中序遍历，再判断元素是否是递增的
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        traversal(root, vals);
        System.out.println("vals -> " + vals);
        for(int i = 0; i < vals.size() -1; i++) {
            if (vals.get(i) >= vals.get(i+1)) { // 等于也不可以
                return false;
            }
        }
        return true;
    }

    public void traversal(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        traversal(node.left, vals);
        vals.add(node.val);
        traversal(node.right, vals);
    }


    @Test
    public void solution2() {
        TreeNode root = TreeNodeUtil.createTree(4, 2, 7, 1, 3);
        boolean ans = isValidBST2(root);
        System.out.println("ans -> " + ans);
    }

    /**
     * 定义全局变量，省去数组
     */
    TreeNode  pre = null;
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        // 左
        boolean lIsValid = isValidBST2(root.left);

        // 中
        if (pre != null && root.val <= pre.val) {
            return false;
        }
        pre = root;

        // 右
        boolean rIsValid = isValidBST2(root.right);

        return lIsValid && rIsValid;
    }




















}