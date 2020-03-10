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
* 所以相当于一个：right-root-left，相反的inorder traversal，action是process当前这个root的时候，把这个root的值加入到全局变量sum中。
* 但是，要如何构建一个新的tree呢？
