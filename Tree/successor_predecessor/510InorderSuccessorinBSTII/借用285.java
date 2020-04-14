class Solution {
    public Node inorderSuccessor(Node node) {
        //可以先找到root，然后调用285的方法。
        if(node == null) return node;
        if(node.left == null && node.right == null && node.parent == null) return null;
        Node root = node;
        while(root.parent != null){
            root = root.parent;
        }
        return successor(root, node);
    }
    public Node successor(Node root, Node p){
        if(root == null) return null;
        if(root.val <= p.val) return successor(root.right, p);
        else {
            Node left = successor(root.left, p);
            left = left != null? left:root;
            return left;
        }
    }
}
