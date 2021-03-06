package recursion;

/*
 * 437. Path Sum III
 * 
 * 
 * 
 * Given the below binary tree and sum = 22,
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \      \
	7    2      1
	找出所有结果为22的路径 不一定从根节点出发
 */
public class LeetCode437 {
	public int pathSum(TreeNode root, int sum) {
        if(root == null)
        	return 0;
        int res = getPath(root,sum);
        res += pathSum(root.left,sum);
        res += pathSum(root.right,sum);
        return res;
    }
	private int getPath(TreeNode node, int sum) {
		if(node == null)
			return 0;
		int res = 0;
		if(sum - node.val  == 0)
			res += 1;
		//如果存在负数的话就可以继续往下寻找
		res += getPath(node.left, sum - node.val);
		res += getPath(node.right, sum - node.val);
		return res;
	}
}