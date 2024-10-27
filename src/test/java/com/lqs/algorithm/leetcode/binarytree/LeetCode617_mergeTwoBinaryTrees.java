package com.lqs.algorithm.leetcode.binarytree;

import com.lqs.algorithm.datastructure.TreeNode;
import com.lqs.algorithm.utils.TreeNodeUtil;
import org.junit.Test;

/**
 * LeetCode 617 合并二叉树
 * create by lqs
 * date:2024-10-26
 */
public class LeetCode617_mergeTwoBinaryTrees {

    @Test
    public void solution() {
        TreeNode root1 = TreeNodeUtil.createTree(1, 3, 2, 5);
        TreeNode root2 = TreeNodeUtil.createTree(2,1,3,null,4,null,7);

        TreeNode ans = mergeTrees(root1, root2
        );

        System.out.println("ans -> " + ans);
    }

    /**
     * 把root2 合并到 root1， 不额外创建新的Tree
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null) {
            root1 = new TreeNode(root2.val);
        } else {
            root1.val = root2 == null ? root1.val : root1.val + root2.val;
        }
        if(root2 != null) {
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
        }
       return root1;
    }

}