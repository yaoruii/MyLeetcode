public class ConstructBTfromInorderPostorder {
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
        HashMap<Integer, Integer> inmap = new HashMap<>();
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            //和105是变形题
            if(inorder.length ==0 || postorder.length ==0 ){
                return null;
            }
            for(int i = 0;i< inorder.length; i++){
                inmap.put(inorder[i], i);
            }
            return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        }
        public TreeNode helper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend){
            if(istart> iend || pstart>pend) return null;
            int r_val = postorder[pend];
            TreeNode r_tree = new TreeNode(r_val);
            int r_index = inmap.get(r_val);
            int leftpostend = r_index - istart + pstart-1;
            r_tree.left = helper(inorder, istart, r_index-1, postorder, pstart,leftpostend);
            r_tree.right = helper(inorder, r_index+1, iend, postorder, leftpostend+1,pend-1);
            return r_tree;
        }
    }
}
