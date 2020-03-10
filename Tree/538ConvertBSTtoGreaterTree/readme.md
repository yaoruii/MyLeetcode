# 538. Convert BST to Greater Tree
```
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 ```

## 自己递归的方法：有点复杂和慢了，33%



## 学习后的递归方法：100% 0ms

根据BST的特点：left<root<right:
* 一个node-x只会加比它还右的元素的val，当该node-x也被加进去后，之后的node也会把该node-x的值给加进去，所以可以看成一个从最右开始加，不断更新要加上去的值的过程
* 所以相当于一个：right-root-left，相反的inorder traversal，action是process当前root的时候，把这个root的值加入到全局变量sum中。伪代码：
   * helper(root.right);//这个helper函数也可以是当前的函数，如何可以的话，不可以再创建helper函数，废话。。。。
   * print(root);
   * helper(root.left);
* 但是，要如何构建一个新的tree呢？
   * sum是全局变量，先直接递归调用```helper(root.right)(示意）```,它会一路到最右，然后执行```print(root)```, 这里是重点：
   * 创建一个新的node，让新的node的左右孩子和老的一样？（尝试一下）？？？
   * 第二点不对，该题递归的是自身```public TreeNode convertBST```, 所以每次调用```convertBST(root.right)```的时候就会返回一个treenode
   * 从整体的tree来看，先把root.right转换完，转换完的结果是新root的right, 然后把root转换了，再把root,left转换了，同理是新root的left。
   * hhhhhhhhhhhh，前边都是傻逼了，可以直接改变原来的node的val，然后就ok了，让root.val = sum;
   * 简直傻逼透了，既然可以让newroot.right = right，为啥不可以直接让val=sum。。。。
   * 由于是在原来的那个tree的node的基础上改的，所以也不需要保存递归返回的结果了。

