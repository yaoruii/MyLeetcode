public class BinarySearchTree_terator173 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class BSTIterator {
        private TreeNode r;
        private Queue<Integer> fringe;

        public BSTIterator(TreeNode root) {
            r = root;
            fringe = new LinkedList<>();
            inorder(root, fringe);
        }
        private void inorder(TreeNode root, Queue<Integer> fringe){
            if(root == null) return;
            inorder(root.left, fringe);
            fringe.offer(root.val);
            inorder(root.right, fringe);
        }
        //平均：
        //时间复杂度是1
        //空间复杂度是logn，n是所有的结点数
        //所以应该是把结点都储存起来了
        /** @return the next smallest number */
        public int next() {
            return fringe.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !fringe.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
