# 130. Surrounded Regions
```
X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
```
**这道题，一开始也想到了，和边界处于同一个set的0元素要怎么办？但是没想到解决方法**

对边界进行bfs，将与边界0相连的在同一个set的元素都变成e，因为这些0是不能变成x的0元素，然后再将剩下的0变成x，将e变成0即可。

同理，对其能进行bfs，也能进行dfs，所以有两种方法。

