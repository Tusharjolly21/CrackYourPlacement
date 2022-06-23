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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return ans;
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> newList = new ArrayList<>();
            for(int i = 0;i<size;i++){
                int index = i;
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                if(flag==true) newList.add(queue.poll().val);
                else newList.add(0,queue.poll().val);
            }
            flag = !flag;
            ans.add(newList);
            
        }
        return ans;
    }
}