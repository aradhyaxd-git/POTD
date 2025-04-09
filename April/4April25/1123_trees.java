/*1123. Lowest Common Ancestor of Deepest Leaves

Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

The node of a binary tree is a leaf if and only if it has no children
The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is
 in the subtree with root A. */


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
    public int maxDepth=0;
    HashMap<TreeNode,Integer> map= new HashMap<>();
    public void depth_func(TreeNode root,int depth){
        if(root==null) return;
        maxDepth= Math.max(maxDepth,depth);
        map.put(root,depth);
        if(root.left!=null)
            depth_func(root.left,depth+1);
        if(root.right!=null)
            depth_func(root.right,depth+1);
    }

    public TreeNode lcaHelper(TreeNode root){
        if(root==null || map.get(root)==maxDepth)
            return root;

        TreeNode left= lcaHelper(root.left);
        TreeNode right= lcaHelper(root.right);

        if(left!=null && right!=null) return root;

        if(left!=null) return left;

        return right;


        
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        depth_func(root,0);
        return lcaHelper(root);
    }
}