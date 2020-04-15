# 323. Number of Connected Components in an Undirected Graph

```
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
```
## bfs:5%
* 效果不太好，对每一个数0-(n-1)进行遍历，i，如果i在marked数组中是false，说明：它还未被某个源点在进行bfs的时候遍历过了，那么它就可以作为一个新的源，进行bfs。
* 在进行bfs的时候，如何确定邻居：1，marked数组中这个数是false，2，在edges[]数组中，显示该数和当前poll()出得curr结点是相连的。所以每一个curr，都要遍历一遍edges[]数组，非常低效。
* 确定邻居后，marked数组标记该结点、将结点放入到队列中。直到以以i为源，所有可到达的结点都被标记为止。
* 然后遍历i+1，如果是false，bfs，如果不是，i++。每进行一次bfs，res++;
* 最后的res的值就是结果。

## union find:100%
* 一开始，让这n个数作为n个独立的结点，一共有n个set。
* 然后，根据edges[]数组的内容，把edges[i][0]和edges[i][1]这两个结点**union**:
* 如何union，就需要用到union find中的quick-union算法，寻找root，然后让两者的root相连。
* 同时，在find()这个函数中，使用**路径压缩**提高效率：让每一个被遍历的p都指向其祖先。
* 每完成一次union，n--，所以最后n就是答案。
