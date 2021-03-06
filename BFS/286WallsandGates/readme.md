# 286. Walls and Gates

```
INF  -1  0  INF   0为S   INF -1  0   1   1为S   INF -1 0   1  2为S    3 -1 -1 0   3为S   3 -1 -1 0
INF INF INF  -1  =====> INF INF 1   -1  =====>> 2  2  1   -1 =====>> 2  2  1 -1 =====>> 2  2  1 -1
INF  -1 INF  -1   赋为1  1   -1  INF -1   赋为2  1  -1  2   -1 赋为3   1  -1 2  -1 赋为4   1  -1 2  -1
  0  -1 INF INF         0   -1  INF INF         0  -1 INF INF        0  -1 3  INF       0  -1 3  4

上边的每一步都是一次bfs的while循环，可以看出一个循环，是把所有的S的坐标都遍历一边，每一次被发掘的INF距离都比0远1，所以分别将INF赋值为1、2、3.。。
  
After running your function, the 2D grid should be:
3  -1   0   1
2   2   1  -1
1  -1   2  -1
0  -1   3   4
```
大概的思路如下：
* 首先，可以看出是：2d grid的bfs，找到一个源，确定targer，确定什么算“可到达的相邻的邻居”：
* 最开始能想到的是：INF是源，0是目标，-1是不可到达的邻居，剩下的上下左右的邻居都可达到。对每一个INF进行bfs，返回距离或者不存在路径，返回INF，将该源在数组中的值赋值为返回的值。
* 这就是答案中的**“暴力解法”**，稍微一想，就发现可以优化，于是有了：
* 在寻找某一个INF的到最近的0路径中，遇到的INF，后者的最短路径在求前者INF的最短路径的时候就确定了，比如上例，求（0，0）的过程中，我们遇到了（1,0),(2,0),如果（3，0）是（0，0）的最近的0，那么它也是（1，0）最近的0
* 因为，（1，0）到任何可到达的0的路径比（0，0）小1（注意：（0，0）必定经过（1，0）），所以如果存在一个0使得到（1，0）的距离更短，那么加1后，即到（0，0）的距离也是最短的。
* 这样的话，**求得（0，0）的最短路径后，这条路径中的其他的INF的最短路径也确定了，终点和（0，0）的目标0是同一个**
* **但是这样需要追踪具体的路径，目前还不知道如何实现**
* 然后，突然想到可以从0出发，target为INF，遇到INF就令其值为此次bfs遍历中对应的level，也就是离源0的距离。
* 同时，注意：即使一个INF和某个0相连，但是这个0不一定是最短的目标0，所以，迭代到下一个0的时候，**如果碰到了上一个0已经赋值过的INF，也要当成可到达的邻居，对其再次赋值时，调用Math,min()函数，看两个0下的level谁大谁小，取娇小的那个作为最短路径**
* 但是超时了。。。我觉得是因为，每一个INF都可能被遍历很多遍，取觉域其与多少个0在同一个set中。
* 所以，目前，INF只有在最近的0的bfs中得到level才是正确的结果，**于是就引出了答案的做法：**
> 上边的都是错的❌❌，这题用下边的思路，和994是一类题。

## bfs + “从所有的0一起出发”：厉害！
 * 首先，把所有的0都放入到队列中，然后，每一个0都只向外寻找一步的邻居：上下左右，然后可到达的邻居被放入到队列中。当所有的0都出队列后，所有的和0只有1步距离的INF也被加入队列，**NF被赋值为1**。
 * 然后这些INF的位置坐标出队列，只向外寻找一步，值为INF的邻居，除此之外的其他值都不可以，1)，因为如果是0，那么其作为源点，周围的INF已经被赋值为1，如果此时再把0放进入，以取access之后的INF，那么距离一定不是最短距离，因为此时的0一定比之前的0离INF更近。2)，如果是-1，障碍，3)，如果是其他值，说明，这个曾经的INF早已经被遍历到，level一定比当前新的level小。
 * 把正确的邻居放入到队列中，INF被赋值为2.
 * 重复下去。
 * 重点在于：没有一个明确的源，一开始把所有的源都放进去，然后出来，放入邻居。这些邻居是所有的0的邻居。邻居再出来，再放入邻居，**这些邻居是所有的距离某个0为2的iNF，and 且不存在0使之距离为1**，同理，这些出来，再放进入邻居，是距离为3的iNF，以此类推。
 
> 上边的是3月份写的，今天是2020/5/31日，写了一道用到第二种思路的题994，就没写出来，唉，难过，看来要经常重复，多看看
