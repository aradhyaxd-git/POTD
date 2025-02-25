/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class FindElements {
    public HashSet<Integer> set;
    public void solve(TreeNode root, int x,HashSet<Integer> set) {
      if (root == null)
        return;
      root.val = x;
      set.add(x);
      if (root.left != null) {
        solve(root.left, 2 * x + 1 , set);
      }
      if (root.right != null) {
        solve(root.right, 2 * x + 2 , set);
      }
    }
  
    public FindElements(TreeNode root) {
      set= new HashSet<>();
      solve(root,0,set);
    }
  
    public boolean find(int target) {
      return set.contains(target);
  
    }
  }
  
  /**
   * Your FindElements object will be instantiated and called as such:
   * FindElements obj = new FindElements(root);
   * boolean param_1 = obj.find(target);
   */