package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 572 : 另一个树的子树
 * create by lqs
 * date:2024-10-24
 */
public class LeetCode572_subTreeOfAnotherTree {

    @Test
    public void test() {
        TreeNode root = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 3);
        System.out.println("origin root -> " + root);

        TreeNode root2 = TreeNodeUtil.createTree(2, 4, 3);
//        TreeNode root2 = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 4);
        System.out.println("origin root2 -> " + root2);

        boolean ans = isSubtree(root, root2);
        System.out.println("ans -> " + ans);
    }

    /**
     * 暴力法：遍历root的每个节点 和 subRoot 进行比较
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * 比较是否是相同的树
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    @Test
    public void test2() {
//        TreeNode root = TreeNodeUtil.createTree(3,4,5,1,2,null,null,null,null,0);
        TreeNode root = TreeNodeUtil.createTree(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2);
        System.out.println("origin root -> " + root);

//        TreeNode root2 = TreeNodeUtil.createTree(4,1,2);
        TreeNode root2 = TreeNodeUtil.createTree(1,null,1,null,1,null,1,null,1,null,1,2);
//        TreeNode root2 = TreeNodeUtil.createTree(1, 2, 2, 3, 4, 4, 4);
        System.out.println("origin root2 -> " + root2);

        boolean ans = isSubtree2(root, root2);
        System.out.println("ans -> " + ans);
    }

    /**
     * 技巧：
     * 先深度遍历（前序）2个序列，然后判断subRoot 的序列是否是root 序列的子序列
     * 简化这里用字符串判断
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {

        String rootStr = dfs(root, new StringBuilder());

        String subRootStr = dfs(subRoot, new StringBuilder());

//        System.out.println("rootStr ->" + rootStr);
//        System.out.println("subRootStr -> " + subRootStr);

        return rootStr.contains(subRootStr);
    }

    public String dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return sb.toString();
        sb.append(node.val).append("->");
        if (node.left == null) {
            sb.append("->lnull");
        } else {
            dfs(node.left, sb);
        }
        if (node.right == null) {
            sb.append("->rnull");
        } else {
            dfs(node.right, sb);
        }
        return sb.toString();
    }



}