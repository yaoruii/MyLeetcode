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
    public List<Integer> res = new ArrayList<>();
    public boolean flag = true;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        //原始的treenode
        helper(root, voyage, 0, voyage.length-1);
        if(!flag){
            res.clear();
            res.add(-1);
            
        } 
        return res;
    }
    public void helper(TreeNode root, int[] num, int start, int end){
        if(!flag) return;
        if(root == null){
            if(start>end) return;
            else{
                flag = false;
            return;
            }
        }
        if((root.val != num[start])){
            //root都不一样，无药可救了
            flag = false;
            return;
        }
        //root相等，看看root的左右孩子：
        
        if(root.left != null && root.left.val !=num[start+1]){
            //如果root.right == num[start+1]的话。。。
            if(root.right!=null && root.right.val == num[start+1]){
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                res.add(root.val);
                //tree结构已经被改变：此时left是等于num[start+1]的
                //现在为曾经的left，现在的right的val找对应的pointer
            }else{
                //num[start+1]的值即不等于root.left，也不等于root.right，impossible
                flag = false;
                return;
            }
        }
        if(root.left!=null && root.left.val ==num[start+1]){
            //找到right.val在数组中的位置，如果没有，imposs
            if(root.right!=null){
                int rightstart = 0;
                for(int i = start+1; i<= end; i++){
                    if(num[i] == root.right.val){
                        rightstart = i;
                        break;
                    }  
                }
                if(rightstart == 0){
                    //不存在等于right.val的元素：
                    flag = false;
                    return;
                }
                helper(root.left, num, start+1, rightstart-1);
                helper(root.right, num, rightstart, end);    
            }
            else{
                helper(root.left, num, start+1, end);
            }
        }
        //shit，忘记处理left == null的情况了。。
        if(root.left== null){
            //start+1全部都是root.right:
            //这里不用处理root.right是否和num[start+1]相等，这交给递归，就是root都不一样的情况呀！
            helper(root.right, num, start+1, end);    
            
        }
        return;
        
    }
}
