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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        findPaths(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;
    }
    private void findPaths(TreeNode root,int sum,int currSum){
        if(root==null) return;
        currSum+=root.val;
        if(currSum==sum){
            ans++;
        }
        findPaths(root.left,sum,currSum);
        findPaths(root.right,sum,currSum);
    }
}