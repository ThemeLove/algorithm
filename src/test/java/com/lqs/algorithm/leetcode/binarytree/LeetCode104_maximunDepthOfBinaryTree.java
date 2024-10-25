package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode 104: 二叉树的最大深度
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode104_maximunDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original root -> " + root);

        int ans = maxDepth(root); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }


    /**
     * 二叉树的最大深度 就是 根节点的高度
     * 所以采用左右中后续递归的方式求高即可
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = maxDepth(root.left); // 左
        int rightHeight = maxDepth(root.right); // 右

        int height = Math.max(leftHeight, rightHeight) + 1; // 中
        return height;
    }

    @Test
    public void test2() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9);
        System.out.println("original root -> " + root);

        int ans = maxDepth2(root); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    /**
     * 层序遍历，层数即最大层数
     * @param node
     * @return
     */
    public int maxDepth2(TreeNode node){
        if (node == null) return 0;
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(node);
        int depth = 0;
        while(!nodes.isEmpty()) {
            int size = nodes.size();
            while(size-- > 0) {
                TreeNode tempNode = nodes.removeFirst();
                if (tempNode.left != null) {
                    nodes.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodes.add(tempNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
