
class Solution {
    public boolean isValidBST(TreeNode root) {
        //把元素放进list再比较太糟糕了：11%
        //改用before追踪提升到：34.5%
        //按照inorder traversal对tree进行遍历，得到一系列的val，这些val是递增的 
        /*if(root== null || (root.left == null && root.right == null)){return true;}
        TreeNode curr = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //别把before定义为int，定义为treenode，这样只有最开始的时候是null
        //不会带来：第一个元素真的是Integer.MIN_VALUE的尴尬
        //int before = Integer.MIN_VALUE;
        TreeNode before = null;
        while(curr != null || ! stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            
            // if(before > curr.val){
            //     return false;
            // }
            // else{
            //     before = curr.val;
            // }
            if(before != null && before.val >= curr.val) return false;
            else{//before == null或者before小于curr
                before = curr;
            }
            
//             if(list.size()>0 && list.get(list.size()-1)>= curr.val){
//                 return false;
//             }
//             else{
//                 list.add(curr.val);
//             }
            
            curr = curr.right;   
        }
        return true;*/
        //递归？
        return isbst(root, null, null);
       
        
        
    }
    public boolean isbst(TreeNode root, Integer lower, Integer upper){
        if(root == null) return true;
        int val = root.val;
        if(lower != null && val<= lower) return false;
        if(upper != null && val>= upper) return false;
        
        if(!(isbst(root.left, lower, val))) return false;
        if(! isbst(root.right, val, upper)) return false;
        return true;
    }
    
}
