# 305. Number of Islands II

200题的变形题，但是其实关系不是很大，更有点想323，没所谓啦！自己写出来的，效果也不错，就是union-find的方法，不过是一个动态的过程，每一次的操作结果都返回到list中。

* 200题是grid已经固定，我们也只需要给出该固定的grid对应的岛屿的个数，所以对该grid遍历，碰到1就进行bfs/dfs是一种思路。或者，使用union-find，每个1最开始都是一个孤立的小岛，count就是1的个数。然后，对二维grid遍历，如果curr为1，让其与其上下左右四个为1的邻居进行union，如果成功union，count--,并且把这个curr变成0，否则，之后curr右移一个位置后，还要再次调用union(curr,curr+1),虽然不影响count，但是时间长。
* 305的grid是动态的，同时得到每一步的grid对应的count，保存在list中，所以就不可能对每一个grid应用bfs/dfs，也没有必要，因为每一次新的grid只有一个元素不同。
* union-find：所以，305更像323，本来好好地set们，突然多了一个元素，**可能**多了一个edge，这个时候去check是不是多了一个edge，count是不是变了，如果没多edge，那么就是多了一个**孤零零的岛，count++**,如果多了一个edge，先count++，然后把这个新增的node顺着这个edge和他的邻居union()在一起，由于，只有把上下左右都遍历了，才知道出现这个新node后的新格局，所以要union()四次，每次成功的union都会导致count--。
* 四次union()结束后的count，就是此时grid对应的count。
* 所以要用全局变量定义count,id[]，size[]。
