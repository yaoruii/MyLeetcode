# 250. Count Univalue Subtrees
```
寻找这棵树有几个Univalue子树：所有的元素的val都相同
Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
```

不会，直接看的答案：  
因为第二点不知道怎么用代码实现

如果一个tree是univalue subtree，那么它满足：
* this node is a leaf, has no children.(base case)
* all of node's children are univalue tree, the node and its children have the same value.(不知道怎么实现）
   * 确认node的children们是否都是univalue tree，且node的值和chidren的值相同
* 综上，我们**自下而上地**测试每个subtree是否是univalue tree.

## DFS
**自下而上：首先搜索bottom left node，所以需要用DFS递归的方法，最终先返回的那个函数是调用bottom left node的函数**

本质上，这是一道不算难的DFS题，不过没做出来也没事。

* 定义一个全局变量count，在每一个root的测试结束后，如果该root引领的tree符合条件，那么count++
* 每一个root的检查是自下而上的，所以是DFS，先check不为null的left child是否符合上边的两个条件，然后再check不为null的right child是否符合条件，最后如果都符合，那么该root满足条件，count++
* 于是

