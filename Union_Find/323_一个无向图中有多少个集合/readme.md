# 323. Number of Connected Components in an Undirected Graph

```
Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
```
## bfs:5%
* 效果不太好，对每一个数0-(n-1)进行遍历，如果它在marked数组中是false，说明：它还未被某个源点在进行bfs的时候遍历过了，那么它就可以作为一个新的源，进行bfs。

