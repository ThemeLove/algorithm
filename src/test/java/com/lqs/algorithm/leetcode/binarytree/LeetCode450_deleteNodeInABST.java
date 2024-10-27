package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 450 删除二叉搜索树中的节点
 * create by lqs
 * date:2024-10-27
 */
public class LeetCode450_deleteNodeInABST {

    @Test
    public void solution() {
        // 5,3,6,2,4,null,7
        TreeNode root = TreeNodeUtil.createTree(5, 3, 6, 2, 4, null, 7);

        TreeNode ans = deleteNode(root, 3);

        System.out.println("ans -> " + ans);
    }

    /**
     * 递归法
     * 1.如果遍历节点 > 目标节点 key, 则目标节点在左子树中，递归左子树
     * 2.如果便利节点 < 目标节点 key, 则目标节点在右子树中，递归右子树
     * 3.如果遍历节点 == 目标节点 key, 分以下情况讨论
     *   没有左右子树，叶子节点，直接返回null
     *   有左子树，没有右子树，直接返回左子树
     *   有右子树，没有左字树，直接返回右子树
     *   有左右子树，两种处理方法
     *   a. 从左子树中找最大值（它的右子树一定是null）,将右子树挂上去
     *   b. 从右子树中找最小值（它的左子树一定是null）,将左子树挂上去
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        // exit
        if (root == null) return null;
        if (root.val == key) { // 是当前节点
            if (root.left != null && root.right != null) {
                // 采取将左子树挂到右子树最小值节点上去
                TreeNode cur = root.right;
                while(cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
            if (root.left != null) {// 右子树为null
                return root.left;
            }
            if (root.right != null) {// 左子树为null
                return root.right;
            }
            return null; // 叶子节点，左右字数都为null的情况
        }
        if (root.val > key) { // 则key 在左子树里
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) { // 则key 在右子树里
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}