/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        //follow up
        if(node == null) return null;
        if(node.right == null){
            //node是没有右孩子的root或者是其父节点的左孩子
            Node res = node;
            //node是其母结点的右孩子，寻找第一个祖先 which 是第一个再上一级祖先的左孩子
            while(res.parent != null && res != res.parent.left) 
                res = res.parent;
            return res.parent;
        }
        if(node.right != null){
            Node res = node.right;
            while(res.left != null) res = res.left;
            return res;
        }
        return null;
    } 
}
