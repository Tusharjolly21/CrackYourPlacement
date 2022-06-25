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

    class Pair {
        TreeNode root;
        int num;

        public Pair(TreeNode root, int num) {
            this.root = root;
            this.num = num;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        if(root==null) return 0;
        queue.offer(new Pair(root,0));
        int ans = 0;
        while(!queue.isEmpty()){
            int min = queue.peek().num;
            int first = 0,last = 0;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int curr_id = queue.peek().num-min;
                TreeNode node = queue.peek().root;
                queue.poll();
                if(i==0) first = curr_id;
                if(i==size-1) last = curr_id;
                if(node.left!=null){
                    queue.offer(new Pair(node.left,curr_id*2+1));
                }
                if(node.right!=null){
                    queue.offer(new Pair(node.right,curr_id*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
        
        
    }
}
