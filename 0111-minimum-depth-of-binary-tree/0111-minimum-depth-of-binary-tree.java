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
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        else{
            int ld = minDepth(root.left);
            int rd = minDepth(root.right);
            if(ld==0 || rd==0)
            {
                //There are nodes only in 1 direction. 
                //so that will be  the only depth
                return Math.max(ld,rd) + 1;
            }
            else{
                return Math.min(ld,rd) + 1;
            }
        }
    }
}