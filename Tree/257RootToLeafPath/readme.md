# 257 Root to leaf path

给定一个树，得到以下这样的输出：
>Output: ["1->2->5", "1->3"]

## 递归：不过只有50%，应该还有好的，再说吧。。

* 如果是null，就是一个空list
* 如果是一个Leaf，就返回只有root.val自己的一个list
* 剩下的有child的情况，分别将root.lefe和root.right传入到自身函数，得到的结果，使用list.addAll()合并在一起。
* 对第三步得到的合并结果进行遍历，每一个string都在其前边加上root.val，然后加入到res。
* 返回最终的res list。

# 113. Path Sum II

这道题是找到所有的Root to leaf paths which 这些结点加在一起等于某个数的路径

于是我用了上述257的方法，同一天的题，算法一样，只是base case多了一个条件：如果是一个Leaf，且root.val == sum，就返回只有root.val自己的一个list
base case被改变了，结果自然得到我们想要的。**但是太慢了，只有8%，所以这道题应该不是用这个算法**，明天再说。

