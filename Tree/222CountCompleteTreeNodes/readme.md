# 222. Count Complete Tree Nodes
```
Input: 
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6
```
虽然这道题，它提到了 Complete Tree Nodes，但是最后的解法貌似没有用到这一个特性的时候，就可以达到100% faster了。

## preorder递归

一开始想DFS，后来写着写着，突然意识到：这不是我最拿手的 **递归：总数= root+左边孩子的总数+右边孩子的总数**
然后突然意识到：
> preorder, inorder, postorder都是dfs吧

所以这道题简单方法就是：穷尽遍历完所有的nodes，换一种说法：计算left child的个数，计算right child的个数，然后加上root的1，加在一起就可以了
