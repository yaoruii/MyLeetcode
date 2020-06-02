# 269. Alien Dictionary

## ARE:

**如何根据题目构建一个graph，然后找到该graph的拓扑排序。。。不会啊**

All approaches break the problem into three steps.
* Extracting dependency rules from the input. For example "A must be before C", "X must be before D", or "E must be before B".
* Putting the dependency rules into a graph with letters as nodes and dependencies as edges (an adjacency list is best).
* Topologically sorting the graph nodes.

The first and second parts are straightforward; we'll leave you to look at the code for these. It should extract the order relations and then insert them into an adjacency list. The only thing we need to be careful of is ensuring that we've handled the "prefix" edge case correctly.

但是对我来说，难点就是前两点，因为第三点已经学会了。

**首先，去寻找字母之间的**依赖关系**
* 两两字符串比较，第一个不同的字母进行比较，并把结果就是一个依赖关系
* 遍历完之后就得到所有的依赖关系：也就是A-->B

**然后，根据依赖关系，使用list代表出graph**

[官方的solution写的不错](https://leetcode.com/problems/alien-dictionary/solution/)

## DC:
第三点就不再叙述了，使用的是bfs。

前两点，得到graph的过程，写的代码又臭又长，而且，没有想到很多cases，大概sumbit了很多很多很多次，才把118个case通过。。。想到了用map来映射outgoing关系，这个值得表扬，但是好多case没想到，后来在代码上添添改改的，很ugly，明天学习一下答案的代码。
