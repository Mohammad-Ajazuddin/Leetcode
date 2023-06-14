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
    public static void inorderTraverse(TreeNode root, ArrayList<Integer> Nodes)
    {
        if(root==null)
            return;
        inorderTraverse(root.left,Nodes);
        Nodes.add(root.val);
        inorderTraverse(root.right,Nodes);
    }
    
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> Nodes = new ArrayList<Integer>();
        inorderTraverse(root,Nodes);
        int size = Nodes.size();
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<size-1;i++)
        {
            minDiff = Math.min(minDiff,Math.abs(Nodes.get(i) - Nodes.get(i+1)));
        }
        return minDiff;
    //     int firstMin=0,secondMin=0,minimumDifference=0;
    //     if(root.left!=null)
    //     {
    //         while(root.left!=null)
    //         {
    //             secondMin=root.val;
    //             root=root.left;
    //             firstMin=root.val;
    //         }
    //         if(root.left==null && root.right!=null)
    //         {
    //             root=root.right;
    //             secondMin=root.val;
    //         }
    //         minimumDifference = secondMin-firstMin;
    //         return minimumDifference;
    //     }
    //     else
    //     {
    //         firstMin=root.val;
    //         root=root.right;
    //         secondMin=root.val;
    //         while(root.left!=null)
    //         {
    //             root=root.left;
    //             secondMin=root.val;
    //         }
    //         minimumDifference = secondMin-firstMin;
    //     }
    //     return minimumDifference;
    // } I'm looking here for only min nodes haha. That's not right. Abs diff b/w any nodes*
    
    }
}