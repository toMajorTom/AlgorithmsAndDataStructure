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
	�ҳ����н��Ϊ22��·�� ��һ���Ӹ��ڵ����
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
		//������ڸ����Ļ��Ϳ��Լ�������Ѱ��
		res += getPath(node.left, sum - node.val);
		res += getPath(node.right, sum - node.val);
		return res;
	}
}