994. Rotting Oranges

# ARE：after reading exercise(记录自己的想法、思路、如何实现以及如果不会实现，是因为什么问题）
我觉得和200题有多少个岛屿有相似之处，200题本质上是利用BFS找到union set的个数，但是994在找set的过程中记录了时间

**另一个难点**：同时有俩腐烂的，那就是2方向的bfs，如果有n个，那就是n方向的。草。因为同一分钟内，n个腐烂的水果是同时影响周围的新鲜的水果的，--难点。

**于是就去看答案了**

但是看了答案，就恍然大悟了，和**tree的level-level级的遍历是一样的！！！！！**
* 在level级遍历中，一开始放进入的是root，然后root出来后，**将root的左右孩子放进入，也就是2个node**
* 之后，while判断中，队列不为空，这时**bfs应该poll一个node出来**，但是，为了实现level遍历且将同一个level的元素放入到同一个list中返回，**我们在这一次的while循环内，再循环fringe.size（）次，也就是把左右孩子在该while下使用for循环poll出来**
* 这样，root的两个孩子可以进入了该while下新生成的list中。实现了level级别的遍历。

回到这一题：
* 初始化时，多处同时有多个腐烂的水果，他们会同时影响自己**上下左右**潜在的四个水果，而这只需要一秒
* 因此，可以，先将所有初始就腐烂的水果放入到队列中，在原本队列一个while循环只poll出第一个元素的基础上，改为：**一个while内利用for循环完成fringe.size次的任务，每一个任务就是原本一个while循环的任务，这样做，可以使得这些被poll出来腐烂水果同时影响周围的水果，而时间只+1：在while循环内for循环外，使counter++即可实现**
* 相当于：**初始时所有的腐烂的是1号list，1号list改变的的水果放在2号list，2号改变的放在3号list。。。最后用的时间就是list的个数。**
* 而上文说的**任务**具体是什么：
   * 找到上下左右四个邻居中的未腐烂的水果，**同时注意不要越界**
   * 将该未腐烂的水果放入到队列中（相当于 tree的孩子们），将该水果标记为腐烂。
   * 未腐烂的水果数--，为什么要追踪未腐烂的水果数？：
      * 如果最后 未腐烂的水果数 > 0，说明有未被影响的新鲜水果，那么最后应该返回0
      * 如果 未腐烂的水果数 = 0，那么应该返回 ```while执行的次数-1```
* 当队列为空时，结束循环。判断最后结果应该为多少。

# DC：during coding（编程过程中）
* 向dirs这种二维数组，里面的内容是固定的，可以使用`int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};//还可以这样写！`这种直接赋值的方法。

```java
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int row = grid.length; int col = grid[0].length;
        Queue<int[]> fringe = new LinkedList<>();
        int count = -1, fresh = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2) fringe.offer(new int[]{i,j});//队列存储腐败的水果，这是第一批
                if(grid[i][j] == 1) fresh++;
            } 
        }
        if(fresh == 0) return 0;//一开始就没有腐败的果实。
        int size;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};//还可以这样写！！
        while(!fringe.isEmpty()){
            count++;
            size = fringe.size();
            for(int i = 0; i<size; i++){//这一批腐败的水果在一个while内搞完
                int[] pos = fringe.poll();
                for(int[] dir: dirs){
                    int r = pos[0]+dir[0];
                    int c = pos[1]+dir[1];
                    if(r<0 || r>=row || c<0 || c>= col || grid[r][c] == 2 || grid[r][c]==0) continue;//下边的代码都不会被执行了
                    if(grid[r][c] == 1){
                        grid[r][c] =2;
                        fringe.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? count:-1;

    }
}
```
