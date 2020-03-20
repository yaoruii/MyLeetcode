# 285:求successor

```
找到p的 in-order successor :有序继任者，如果不存在就返回null
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
```
* 刚开始让p和root比较：
   * root<= p，p的继任者一定在右侧
   * root> p, p的继任者在左侧或者是root
   
所以，按照这个思路，逐步实现：
* root == null : base case 返回null
```
if(root == null) return null;
```
* root<= p:递归调用自身函数，在root的right中寻找p的继任者。
* 虽然这样在伪代码层面上是足够了，但是实战上为什么这样也够了？
    * 如果root.val == p.val：进入root.right这棵tree后，p会小于接下来的所有可能的root，所以会一路进入到left分支，直到最后一个node，这时，在该node下调用left分支的递归，返回null，所以该node的递归返回root，即该node自身  
    然后，bottom-left node作为变量left不为null的值，一路返回到最开始的uccessor(root.left,p)，然后到最开始的successor(root, p);--结束
    * 如果是root.val< p.val: 就不用管了，直接调用和最开始的successor(root, p)一样
    * 如果一直进入不了left分支：p比一路以来的root都大，直到最后一个bottom-right node的right == null,返回null，一路再往上返回null
```
if(root.val <= p.val) return successor(root.right, p);
```
* root >p: 继任者可能是root也可能存在于left分支中:
* 一旦进入该left分支，说明：
   * p的继任者是root：在root.left这棵树中无法找到，返回null，最终left赋值为root
   * p的继任者在left这棵树中，返回left!=null，最终返回left
```
if(root.val > p.val){
    TreeNode left = successor(root.left,p);
    left = left != null? left: root;
    return root;
}
```
