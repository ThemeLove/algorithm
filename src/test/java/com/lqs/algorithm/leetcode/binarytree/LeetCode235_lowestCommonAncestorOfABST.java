package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 235: 二叉搜索树的最近公共祖先
 * create by lqs
 * date:2024-10-27
 */
public class LeetCode235_lowestCommonAncestorOfABST {

    @Test
    public void solution() {
        //[6,2,8,0,4,7,9,null,null,3,5]
        TreeNode node = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        TreeNode root = TreeNodeUtil.createTree(node, node2, node3, node4, node5, node6, node7, null, null, node8, node9);

        TreeNode ans = lowestCommonAncestor(root, node4, node8);

        System.out.println("ans -> " + ans);
    }

    /**
     * 题解一：可以当作普通二叉树求最近公共最先的方法，同LeetCode 236
     * 题解二：利用二叉搜索树的特性：左子树的所有节点都小于当前节点，右子树的所有节点都大于当前节点
     * 遍历过程中比较当前节点和p和q的值，判断p,q是在左子树还是右子树中
     *
     * 特点，只要从上向下遍历判断，找到第一个节点满足，点给钱节点的值满足  (p|q).val <= cur.val <=(q|p).val
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p) return p;
        if (root == q) return q;
        if (root.val > p.val && root.val > q.val) {//p,q 在左子树
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) return left;
        }
        if (root.val < p.val && root.val < q.val) {//p,q 在右子树
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) return right;
        }
        return root;
    }

    @Test
    public void solution2() {
        TreeNode node = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        TreeNode root = TreeNodeUtil.createTree(node, node2, node3, node4, node5, node6, node7, null, null, node8, node9);

        TreeNode ans = lowestCommonAncestor2(root, node4, node8);

        System.out.println("ans -> " + ans);
    }

    /**
     * 迭代法
     * @param root
     * @param p
     * @param q
     * @return
     */
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode cur = root;
            while(cur != null) {
                if (cur.val > p.val && cur.val > q.val) {
                    cur = cur.left;
                } else if (cur.val < p.val && cur.val < q.val) {
                    cur = cur.right;
                } else {
                    break;
                }
            }
            return cur;
        }

}