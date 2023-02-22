//10th-prblm
class Solution{
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int ans = 0;
		
		// max value from left grandchildren
        if (root.left != null) {
            ans += rob(root.left.left) + rob(root.left.right);
        }
		
		// max value from right grandchildren
        if (root.right != null) {
            ans += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(ans + root.val, rob(root.left) + rob(root.right));  //(Case1,Case2)
    }
}
