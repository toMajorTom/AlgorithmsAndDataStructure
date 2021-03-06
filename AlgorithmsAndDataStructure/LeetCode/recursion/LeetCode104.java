package recursion;

/*
 * 104. Maximum Depth of Binary Tree
 * 		返回二叉树的最大深度
 */
public class LeetCode104 {
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}