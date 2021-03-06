package recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * 257. Binary Tree Paths
 * 	  返回从根节点到叶子节点的所有路径
 * 
 * 
Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class LeetCode257 {
	public List<String> binaryTreePaths(TreeNode root) {
		 List<String> res = new ArrayList<>();	
        if(root == null)
        	return res;
        if(root.right == null && root.left == null) {
        	res.add(root.val + "");
        	return res;
        }
        List<String> leftRes = binaryTreePaths(root.left);
        for(int i = 0; i <  leftRes.size(); i++) {
        	res.add(root.val + "->" + leftRes.get(i));
        }
        List<String> rightRes = binaryTreePaths(root.right);
        for(int i = 0; i <  rightRes.size(); i++) {
        	res.add(root.val + "->" + rightRes.get(i));
        }
        return res;
    }
}