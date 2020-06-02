# 207. Course Schedule

## ARE:
学习了以下拓扑排序，在算法文件夹。

## DC:
由于写代码之前刚学了不少，不过都是讲解以及伪代码，真正到写代码的时候，还是需要功底，写的贼慢
### bfs:
**lc207**

在算法中，每次都选择没有前置课的操作叫做，选取入度为 0 的结点加入拓扑队列。由于选过的课就算完成了前置，所以选择过后还要删除当前点和与之相关的所有边。




### dfs:
由于**210. Course Schedule II**，和这一题基本上一样，不过最后输出该拓扑排序的结果，其在上一题的bfs的代码中，我也已经实现，所以，210决定使用dfs的方法

[见算法文件夹中关于拓扑排序的总结](https://github.com/yaoruii/MyLeetcode/blob/master/Algorithms/topological_sort.md)
