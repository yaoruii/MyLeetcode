public class SumofLefLeaves404 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
        /*BFS
        if(root == null) return 0;
        if(root.left == null && root.right== null) return 0;
        Queue<TreeNode> r = new LinkedList<>();
        Queue<TreeNode> l = new LinkedList<>();
        r.offer(root);
        TreeNode track;
        int sum =0;
        while(!r.isEmpty() || !l.isEmpty()){
            while(!r.isEmpty()){
                track = r.poll();
                if(track.left != null) l.offer(track.left);
                if(track.right != null) r.offer(track.right);
            }
            while(! l.isEmpty()){
                track = l.poll();
                if(track.left != null) l.offer(track.left);
                if(track.right != null) r.offer(track.right);
                if(track.left == null && track.right == null) sum +=track.val;
            }

        }
        return sum;  */
            //这道题还是有很多人用了递归
            //我想不出来这道题的递归是因为我想不出来base case
            //答案：无论划分成什么样子的subtree，最后能够被加到sum上的肯定是root.left!=null && root.left.left == null && root.left.right == null,这时我们把root.left加进去
            //而且光秃秃的root不被认为是leaf!!!
            if(root == null) return 0;
            if(root.left == null && root.right== null) return 0;
            //int sum =0;
            if(root.left!=null && root.left.left == null && root.left.right == null){
                return root.left.val+ sumOfLeftLeaves(root.right);
            }
            else{
                return sumOfLeftLeaves(root.right)+sumOfLeftLeaves(root.left);
            }
        }
    }
}
