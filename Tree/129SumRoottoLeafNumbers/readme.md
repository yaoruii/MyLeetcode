# 129. Sum Root to Leaf Numbers

```
Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
```
## 递归法：自己写的还不错：0ms 100%

```
class Solution {
    private int sum = 0;//使用一个全局变量追踪total sum,只有当碰到leaf的时候增加sum即可，我觉得很省事，不需要每次都返回
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return sum;
    }
    public  void helper(TreeNode root, int pre){
        if(root == null) return;
        pre = pre*10 + root.val;
        if( root.left== null && root.right == null){//说明我们碰到了Leaf
            sum +=pre;
        }
        else{
             helper(root.left, pre);//在同一次call的环境下这两个函数被传入的pre是一样的，进入这两个语句后，pre*10再加上root.left.val了
             helper(root.right, pre);//但是此时被更新的pre是helper(root.left, pre)这个语句的环境下的值，不会影响 helper(root.right, pre)传入的以及后来更新的的pre
        }
       
        }
    }
    ```
