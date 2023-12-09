package leetcode.BinaryTree;

import java.util.ArrayList;

import java.util.List;

/**
 * @author cuihongyuan
 * @Date: 2023/12/7 0007  - 19:37
 * @Description: leetcode.BinaryTree
 * @version: 1.0
 */
public class LC_145_二叉树的后序遍历 {
    public static void main(String[] args) {
//        TreeNode treeNodeleft = new TreeNode();
          TreeNode treeNoderight = new TreeNode(2);
          treeNoderight.left = new TreeNode(3);;
          TreeNode treeNode = new TreeNode(1,null, treeNoderight);
          LC_145_二叉树的后序遍历 lc_145_二叉树的后序遍历 = new LC_145_二叉树的后序遍历();
          List<Integer> integers = lc_145_二叉树的后序遍历.preorderTraversal(treeNode);
          System.out.println(integers);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        preorder(root.left, result);
        preorder(root.right, result);
        result.add(root.val);
    }
}
