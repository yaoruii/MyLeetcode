# topological sort

* 应用于：课程表、程序设计时的依赖关系、系统设计时的依赖等，需要先完成A，才能完成B。
* 有tree和无环有向图

# DFS:
学习资源：
* 两个油管视频不错：[1](https://www.youtube.com/watch?v=ddTC4Zovtbc),[2](https://www.youtube.com/watch?v=eL-KzMXSXXI)

基本上，是结合DFS，使用一个stack存放最终的ordering的结点，或者用简单的数组但是从最后开始赋值，index--，来代替。还需要一个set用来存放已经被visited的元素，或者使用一个数组，用false/true来表示是否被visited。


* 对每一个node进行遍历，首先判断是否被visited,如果已经被visited说明已经被调用了dfs（作为别人的孩子，在递归中被调用了dfs），那么可以直接pass。否则，调用dfs
* dfs函数：
   * 首先，将结点加入到set中，marked为visited的
   * 然后，找到其所有的accessable的孩子，其中对被为visited的孩子调用dfs。
   * 所有的孩子都处于visited的状态或者没有孩子后，即可将该node加入到stack中。
* 最终的ordering是将stack一个个poll出，因为是和进入堆栈的顺序相反的。

# BFS or Kahn's algorithm
lc 310题就是使用bfs的拓扑排序的变形体！！

(百科-资料)[https://en.wikipedia.org/wiki/Topological_sorting#Algorithms]

> If the graph is a DAG, a solution will be contained in the list L (the solution is not necessarily unique). Otherwise, the graph must have at least one cycle and therefore a topological sort is impossible.

如果一个图是DAG，那么它存在拓扑排序的结果，就是L，如果不是DAG，那么它就存在一个环，无法得到拓扑排序的结果，返回error。

# 如何在寻找order过程中把是否是DAG也一并确认了：
(百科-资料)[https://en.wikipedia.org/wiki/Topological_sorting#Algorithms] 中总结了所有的方法

## 如果是bfs:
> 选取入度为 0 的结点加入拓扑队列。由于选过的课就算完成了前置，所以选择过后还要删除当前点和与之相关的所有边。

每次都会把相应的结点及其边删除掉，所以最终的DAG不会存在任何一条edge，因此，在bfs结束后，判断以下graph是否还有edge即可。

## 如果是dfs：
