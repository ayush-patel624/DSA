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
        sum(root);
        return res;
    }

    int[] sum(TreeNode node){
        if(node == null) return new int[]{0,0};

        int[] left = sum(node.left);
        int[] right = sum(node.right);

        int leftSum = left[0];
        int leftN = left[1];

        int rightSum = right[0];
        int rightN = right[1];

        if((leftSum+rightSum+node.val)/(leftN+rightN+1) == node.val) res++; 

        return new int[]{leftSum+rightSum+node.val,leftN+rightN+1};
    }
}