class Solution {
    int count;//使用全局变量，边遍历边计数
    public int countUnivalSubtrees(TreeNode root){
        //base cases:
        if(root == null) return 0;
        //if(root.left == null && root.right == null) return 1;
        isuni(root);
        return count;
        
    }
    public boolean isuni(TreeNode root){
        if(root.left == null && root.right == null) {
            count++;
            return true;
        }
        //剩下的都是有孩子的root
        //布尔变量，确保每一个孩子都是univalue,且孩子的值和root一样
        //一旦有一个孩子不满足这两点，那么这个root也不可能是，结束.
        boolean is_uni = true;
        //再开始check它的孩子们是否是univalue之前，为true，之后碰到不是的赋值为false
        if(root.left != null){
            is_uni = isuni(root.left) && is_uni && root.val == root.left.val;
        }
        if(root.right != null){
            is_uni = isuni(root.right) && is_uni && root.val == root.right.val;
        }
        if(is_uni) count ++;
        return is_uni;
        
    }
}
