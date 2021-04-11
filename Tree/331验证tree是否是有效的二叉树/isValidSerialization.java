

import java.util.*;
class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] nodes = preorder.split(",");
        String curr; int n = nodes.length;
        for(int i = 0; i<n; i++){
            curr = nodes[i];
            while(curr.equals("#") && !stack.isEmpty() && stack.peek().equals(curr)){
                //peek是#，所以peek是left child, curr是right child，可以cancel这个Leaf
                stack.pop();
                //pop()前要check stack是否为空
                while(stack.isEmpty()){
                    //invalid
                    return false;
                }
                stack.pop();//pop root u of this subtree
            }//while loop：确保root u 是否是root t 的right child，如果是的，此时的peek依然是#，所以要while继续cancel，直到peek不为#
            //peek不为#
            stack.push(curr);//我们把此时的peek的left child 取消了，用curr=# 替换（mark）
        }
        //最后，把整颗树cancel了，就剩一个#
        return stack.size()==1 && stack.peek().equals("#");
    }
}
// @lc code=end

