public class FlattenBinaryTreetoLinkedList114 {
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
        public void flatten(TreeNode root) {
            //本质上是一个inorder traversal?
            //先使用一个队列把所有的元素按照inorder的顺序保存，然后再读取？
            //1ms,28%,有点慢
        /*
        if(root== null){return;}
        Queue<TreeNode> fringe = new LinkedList<>();
        helper(fringe, root);

        TreeNode track;
        track = fringe.poll();
        while(!fringe.isEmpty()){
            track.right=fringe.poll();
            track.left = null;
            track = track.right;
        }
        track.left = null;
    }
    public void helper(Queue<TreeNode> fringe, TreeNode root){
        if(root == null) return;
        fringe.offer(root);
        helper(fringe, root.left);
        helper(fringe, root.right);
    }*/
            //可以直接按照postorder的顺序递归
            //1，先完成root.right部分的subtree的flattened：对于1来说，pre就是null，因为它后边不需要加其他东西
            //2，再完成root.left部分的subtree的flattened，将1得到的结果接在2的后边：定义一个pre，对于2来说，pre就是1的返回结果
            //3，再将整体接在root的后边：对于root来说.pre就是2返回的结果
            if(root == null) return;
            TreeNode pre = null;
            root = helper(root, pre);
        }
        public TreeNode helper(TreeNode root, TreeNode pre){
            if(root== null) return pre;//!!!!!!!!!
            pre = helper(root.right, pre);
            pre = helper(root.left, pre);//pre是right边的suntree的root，只是内部变了
            root.right = pre; //root再flattened过程中是不变的,只是孩子变了
            root.left = null;
            return root;//root再flattened过程中是不变的,只是孩子变了,所以返回root，也是作为下一次的pre
        }
    }
}
