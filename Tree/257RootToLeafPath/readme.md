# 257 Root to leaf path

给定一个树，得到以下这样的输出：
>Output: ["1->2->5", "1->3"]

还是想出的递归：

* 如果是null，就是一个空list
* 如果是一个Leaf，就返回只有root.val自己的一个list
* 剩下的有child的情况，分别将root.lefe和root.right传入到自身函数，得到的结果，使用list.addAll()合并在一起。
* 对第三步得到的合并结果进行遍历，每一个string都在其前边加上root.val，然后加入到res。
* 返回最终的res list。

