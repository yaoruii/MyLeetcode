class Solution {
    public class result{
            public int size;
            public int lower;
            public int upper;
            
            public result(int s, int l, int u){
                size = s;
                lower = l;
                upper = u;
            }
        }
    public int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        traversal(root);
        return max;
        
    }
    /*
    该helper函数返回以root为根的树的result，描述了树的大小以及取值范围
    */
    public result traversal(TreeNode root){
        //null的情况比较特殊：最小赋值为最大值，最大赋值为最小值
        if(root == null) return new result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        result left = traversal(root.left);
        result right = traversal(root.right);
        if(left.size == -1 || right.size == -1 || root.val <= left.upper || root.val>= right.lower){
            return new result(-1, 0,0);//此时后两个参数是多少并不重要
        }
        int size = left.size + 1 + right.size;
        max = Math.max(max, size);
        return new result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));//因为root的left和right孩子可能是null，所以root的最大最小值可能就是root.val，所以要比较一下。
        
    }
}
