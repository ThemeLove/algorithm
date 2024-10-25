package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 222 : 完全二叉树节点个数
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode222_countCompleteTreeNodes {

    @Test
    public void test() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, 6);
        System.out.println("original tree -> " + tree);

        int ans = countNodes(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    /**
     * 普通递归法
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;//这里+1 表示任何非null的元素都+1了，每个元素都会被统计到
    }

    @Test
    public void test2() {
        TreeNode tree = TreeNodeUtil.createTree(1, 2, 3, 4, 5, 6);
        System.out.println("original tree -> " + tree);

        int ans = countNodes2(tree); //1, 2, 4, 5, 6, 7, 3, 8, 9
        System.out.println("ans -> " + ans);
    }

    /**
     * 要利用完全二叉树的特性：除了最后一层可能没满，倒数第二成之前都是满二叉树
     * 完全二叉树中可能是有多个子的满二叉树构成的
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        // 判断是否是满二叉树：在完全二叉树中，如果左也自己节点的深度等于右叶子节点的深度，则该节点是满二叉树，
        // 其所有节点数可以有公式计算得出:2 的k 次幂 -1， k 为深度
        int lHeight = 0;
        TreeNode left = root.left;
        while(left != null) {
            lHeight++;
            left = left.left;
        }

        int rHeight = 0;
        TreeNode right = root.right;
        while(right != null) {
            rHeight++;
            right = right.right;
        }
        if (lHeight == rHeight) {//说明以当前节点为根节点的树为满二叉树， 直接返回节点数目
            return (2 << lHeight) - 1;
        }
        // 如果该节点不是满二叉树，则节点数量为左字数的节点数 + 右子树的节点数 + 1
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}