# 102 对树进行level order traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

## BFS
### 不会写完全没思路，看了下代码，是BFS，尝试自己写
自己写出来了代码

* 创建一个queue，将根结点放进去
* 开始level层级的traversal，查看当前队列的size,size是遍历的次数，重复步骤三size次：
* 将队列最前端的元素poll()出来，加入到该level对应的list<INteger>（）中，如果该结点有left or right child，那么把childern加入到队列中
* 当把步骤三重复了size次后，队列中只有这些被加入到level对应的list的结点的孩子了，而且也是左边的元素的孩子先加进去，右边的孩子后加进去，所以符合下一层level的先后顺序
* 然后回到步骤二，重复，直到队列为空。

**注意一：属于同一个level的node同时处于队列中，同时出去**

**注意二：在操作前先读取了当前队列的size，这样在操作的过程中即使新加了一些元素，也只会把属于该level的node仍出来**

# 107 和102基本上就是一题：the bottom-up level order traversal 
就是把102的res反过来，如何反过来，这一点体现了一些问题

* 最简单的就是直接和102一样，得到res，再创建一个res2，一个个地加进去
* 后来发现可以用LinkedList<>()来实现List，然后就可以用addFirst去添加每一个level，但是发现**addFirst是继承了deque的，就像offer是继承自queue和deque一样**
* 忘记了最简单继承自list的方法：**add(index, element),让index=0即可**
