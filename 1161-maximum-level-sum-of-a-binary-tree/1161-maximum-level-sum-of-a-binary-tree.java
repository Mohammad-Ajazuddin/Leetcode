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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int minLevel = -1;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int sum = 0;
            //Traversing at a level
            for(int i=0;i<size;i++)
            {
                //say 2 nodes at this level. size =2
                //first node at this level is popped at i=0 and added to sum
                TreeNode node = q.poll();
                sum += node.val;
                //add its children in next level
                if(node.left!=null)
                {
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                }
            }
            if(maxSum<sum)
            {
                maxSum = sum;
                minLevel = level;
                //capturing level as of now which we got with max sum
            }
            level++;   
        }
        return minLevel;
    }
}