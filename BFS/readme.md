# BFS
## 基本定义：
找到从s结点到其他结点的最短路径

* 初始化一个队列fringe，里面有开始的结点s，并将该结点marked。
* 重复以下步骤直到队列为空：
   * 从队列中将V结点移除：第一个元素
   * 对于V结点的每一个unmarked结点 n：
      * mark n结点
      * 将n加入到队列末尾
      * edge[n] = v：从v结点可以到达n结点

![](https://tva1.sinaimg.cn/large/007S8ZIlgy1gfbr8hl1lmj31iu0taah4.jpg)


## 用于tree


## 用于2d Grid

## 用于graph

