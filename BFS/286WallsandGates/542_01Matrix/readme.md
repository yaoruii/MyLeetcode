# 542. 01 Matrix
```
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 
 求每一个1距离最近的0的距离
 ```
 
 **和286是同一个类题，都是0到某个数的距离，286多了一个障碍物-1，其实几乎没什么用，542的特殊之处在于，使用1标注目标，但是有的目标到最近的0的距离的确可能是1，这样我们就无法确定这个1到底是还未被遍历的cell 1还是已经被遍历的距离的确是1**
 
 于是，为了解决这个问题，可以额外在定义一个大小相同的2维矩阵res，只有被遍历过的cell在res这个矩阵中的值为其到0的最短距离，剩下未被遍历或者本身就是0的cell保持9，这样即保存记录了每一个cell的距离，又起到marked的作用，避免重复和错误赋值。每次判断当前curr的上下左右的时候，需要两个条件：
 * 1，这个cell是1，不是0 ===>>> matrix[r][c] == 1;
 * 2，这个cell是未被遍历的 ===>>> res[r][c]== 0;
 
 然后，剩下的和286是一样的。