# 102 对树进行level order traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

## 方法一：BFS+队列
### 不会写完全没思路，看了下代码，是BFS，尝试自己写
官方解释：
>In BFS, **we start by pushing the root node into a queuequeue**. Then, we remove an element(node) from the front of the queuequeue. For every node removed from the queuequeue, **we add all its children to the back of the same queuequeue**. We keep on continuing this process till the queuequeue becomes empty. **In this way, we can traverse the given tree on a level-by-level basis**.
>
>其实，BFS在图中是用来寻找最短路径，对于level-level的tree的traversal，本质上是一样，一个level的node距离root的是一样的。

自己写出来了代码：
* 创建一个queue，将根结点放进去
* 开始level层级的traversal，查看当前队列的size,size是遍历的次数，重复步骤三size次：
* 将队列最前端的元素poll()出来，加入到该level对应的list<INteger>（）中，如果该结点有left or right child，那么把childern加入到队列中
* 当把步骤三重复了size次后，队列中只有这些被加入到level对应的list的结点的孩子了，而且也是左边的元素的孩子先加进去，右边的孩子后加进去，所以符合下一层level的先后顺序
* 然后回到步骤二，重复，直到队列为空。

**注意一：属于同一个level的node同时处于队列中，同时出去**

**注意二：在操作前先读取了当前队列的size，这样在操作的过程中即使新加了一些元素，也只会把属于该level的node仍出来**
## 方法二：DFS+递归
官方解释：
>In DFS, we try to exhaust each branch of the given tree during the tree traversal before moving onto the next branch.我们在移动到另一条branch之前，把当前的branch穷尽。看了别人的代码，自己写

* 需要一个helper函数，传入当前要处理的node，由主函数传入的最终要返回给lc的res-list，当前要处理的node的level:root是0，所以level在这里也可以看作是level-list在res-list中的索引。
* 在主函数中将（root, res,0)传给helper后，之后的操作都在helper中进行递归。
* 如果当前res的size=传入的level，也就是说传入的level对应的list还未声明（size = 最大索引+1），我们往res中加入一个新的level-list，并把当前被处理的node进去，然后我们递归调用该helper函数，对当前被处理的node的left,right child进行处理。
* 先处理left,即重复第三步，当把left放进去，然后处理left的孩子，也是先left，处理完了，处理right，然后处理完了，再去处理步骤三带过来的right。
* **美丽之处在于：** 对于res-list里面的每一个level-list,我们一开始只add了left的val，最后处理完left后，再去处理right时，定位到之前的level-list把当前处理的right的val加进去，这种定位得益于：**使用level这个变量去追踪，即使当前node的level也是其在res中的索引**，这样我们后来把right的结果也加进去就ok了。
* helper()函数可以是void，不返回任何东西，在内部对res进行操作后，在主函数中声明定义的res也会跟着改变。最终在主函数调用helper()之后，再返回res即可。



# 107 the bottom-up level order traversal 
就是把102的res反过来，如何反过来，这一点体现了一些问题

* 最简单的就是直接和102一样，得到res，再创建一个res2，一个个地加进去
* 后来发现可以用LinkedList<>()来实现List，然后就可以用addFirst去添加每一个level，但是发现**addFirst是继承了deque的，就像offer是继承自queue和deque一样**
* 忘记了最简单继承自list的方法：**add(index, element),让index=0即可**

# 637 Average of Levels in Binary Tree
## BFS:
也是一道题，就是求出来同一个level的list后，对这些数据求个平均数，然后只把这个平均数放到res这个list中。
* 求几个int整型的数的平均数的时候，要注意**数据出界的情况**
* 所以求和的变量sum要声明为long整型

## DFS:
这道题用DFS的话，由于每一个level-list的元素都是逐步添加进去的，不是一起添加进去的，其size也就是要最后才能确定，所以可以引入一个新的list用于追踪level=i处的count，最后用res(i)=res(i)/count(i)返回res即可。
