# 240 Search a 2D Matrix II

## Search Space Reduction

* 大概就是利用好：该二维矩阵的特性，将初始的起点pointer定位为左下角：
* 这样：在row上是最大的，在col上是最大的一排中的最小的
* 如果比target大，pointer的右侧的元素都是比pointer更大的，所以col不变，row往上走，上边的元素小
* 如果比target小，pointer的col右移，因为row是我们一路走上来的，所以不需要减row了，不然之前也不会减上来。如果row是最后一排，更不需要减了。
* 当col到达最后一列的时候还是比target小，继续右移col，超过了矩阵的范围，结束，不存在target。

## divide and conquer!
 **Intuition:**
 可以把该二维矩阵分成四个，其中两个肯定不包含target，其中两个可能包含target
 **算法**
 1，base case：如果二维数组的元素个数为0，或者，target小于最小的元素（左上角），或者大于最大的元素（右下角），那么肯定是不包含target的。
 2，
 
