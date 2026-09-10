/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }

    void helper(TreeNode node){
        if(node==null) return;

        int n = count(node);
        int add = sum(node);

        if((add/n)==node.val) res++;

        helper(node.left);
        helper(node.right);
    }

    int count(TreeNode node){
        if(node ==null) return 0;

        int left = count(node.left);
        int right = count(node.right);

        return 1 + left + right;

    }

    int sum(TreeNode node){
        if(node == null) return 0;

        int left = sum(node.left);
        int right = sum(node.right);

        return left+right+node.val;
    }
}