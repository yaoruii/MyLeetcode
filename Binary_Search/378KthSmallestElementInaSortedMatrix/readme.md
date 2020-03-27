# 378. Kth Smallest Element in a Sorted Matrix

```
找到二维数组中第K小的元素
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
```

## Binary Search
**有人总结了bs的模版，明天好好学习一下**  

[起源于719题](https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109082/Approach-the-problem-using-the-%22trial-and-error%22-algorithm)  

[这个人总结的378模版](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code)，[719，同一个模版](https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/143604/Java-Binary-Search-+-Sliding-window-With-Line-by-Line-Comments)

基于这些人的总结写的总结在719了，378是如何变形的呢？
* 构建候选solution：整数
* 搜索范围：719和378都是基于range的搜索，719是两数之差，378是二维矩阵里面的数据本身
* 验证solution:count(num)是小于等于num的元素个数，第k个元素就是是的count(num)>=k的最小的数。
* 如何计算count(num):从右上角开始，寻找第一行第一个<=num的数，然后row++，直接从上一行的col那里开始col的遍历。count()时追踪这些数中最大的数。
* 如何遍历搜索范围：二分法，和719一样，不再重复


## Heap
**核心在于：minheap这一队列本来就是按照从小到大的顺序排列的（兼容重复数），所以当每次都poll()一个元素出来，第K次poll的就是第K小的元素，但是每次poll（）后要把该元素x在原数组中对应的下一行的元素offer()进去，因为下一个最小数可能是已经存在minheap中的x右侧的元素y，也可能是还未进入minheap的x下方的元素z，所以要把z放进去，然后再下一次poll()，得到的结果才是这一次的最小值。**

if we keep removing the smallest element from the matrix for k-1 times, then after removing, the smallest element now in the matrix will be the kth smallest element we are looking for.

怎样得到poll()出来的x的的行和列呢？  
创建一个类，保存元素的值和行列信息，将这个类放入到minheap中作为元素。


## 有个人总结了一个帖子
[就378的总结](https://leetcode.com/problems/k-th-smallest-prime-fraction/discuss/115819/Summary-of-solutions-for-problems-%22reducible%22-to-LeetCode-378)

* 这个总结，循序渐进地讲了好几种方法，包括：**如果当前的二维矩阵是随机的，要怎么办**
* 得到一点启发：如果只有row是递增的（或者只有col是递增的），这个时候初始先把第一列放进heap中（第一行放入heap）中，这样列（行）在heap中会自动排序了，x被poll()出来后，下一个元素可能和其在一列或者在同一行的右侧，所以把右侧的元素放进去（下一个元素可能和其在一行或者在同一列的下侧，所以把下侧的元素放进去）
* heap的方法是保存的长度为2的整型数组，保存的是x的row和col，amazing!

该总结中的binary search：见上文。


