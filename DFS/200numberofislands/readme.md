# 200. Number of Islands

```
Input:
11110
11010
11000
00000

Output: 1
```
## DFS：

把该grid看成一个graph,在两个相邻的1之间存在一个edge，0和0之间，0和1之间不存在edge，所以，一个node最多只可能和其上下左右的四个node相连。

如果一个node为1，那么该node做为source触发一次dfs遍历，原经典模型中的marked这一操作，在这里变成将node变成0，寻找和该source相连的node的操作，变成查看node的上下左右四个元素是否为1.  
最终，完成该source的dfs遍历：找到了从该source出发到所有能够到达的nodes的路径，也就是一个岛屿。

所以岛屿的个数就是多少个source触发了dfs。
