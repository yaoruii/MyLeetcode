# 200. Number of Islands

**和323是一样的，不过323是一维的，200题是二维的，如果使用union-find算法的话，本质上都是根据题目自己的框架/数据结构，创建quick-find中的id这个数组，创建find()和union()这两个函数。**

**200题，答案把上述构建过程，单独列出来作为一个class了，不再单独把其看成一个普通数组了**

**323是edges[][]这个数组揭示了结点之间的连接关系，200题是二维数组本身的地里位置决定的连接关系：上下左右是相连的。所以200题更像graph，323更像union-find，当然200题使用dfs最快，union-find比较慢，323反之，时间复杂度呢？？？**
