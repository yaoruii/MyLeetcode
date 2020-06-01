# topological sort

* 应用于：课程表、程序设计时的依赖关系、系统设计时的依赖等，需要先完成A，才能完成B。
* 有tree和无环有向图

学习资源：
* 两个油管视频不错：[1](https://www.youtube.com/watch?v=ddTC4Zovtbc),[2](https://www.youtube.com/watch?v=eL-KzMXSXXI)

基本上，是结合DFS，使用一个stack存放最终的ordering的结点，或者用简单的数组但是从最后开始赋值，index--，来代替。还需要一个set用来存放已经被visited的元素，或者使用一个数组，用false/true来表示是否被visited。


* 对每一个node进行遍历，首先判断是否被visited,如果已经被visited说明已经被调用了dfs（作为别人的孩子，在递归中被调用了dfs），那么可以直接pass。否则，调用dfs
* dfs函数：
   * 首先，将结点加入到set中，marked为visited的
   * 然后，找到其所有的accessable的孩子，其中对被为visited的孩子调用dfs。
   * 所有的孩子都处于visited的状态或者没有孩子后，即可将该node加入到stack中。
* 最终的ordering是将stack一个个poll出，因为是和进入堆栈的顺序相反的。

