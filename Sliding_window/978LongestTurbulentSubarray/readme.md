# 978. Longest Turbulent Subarray
```
A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
每相邻对的各自内部的关系是相反的

Return the length of a maximum size turbulent subarray of A.

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
```
## tag是dp + sliding window

我觉得dp体现在把曾经已经遍历过的一个相邻对的大小关系保存在一个数组中，下次再需要时不需要进行大小比较，直接从数组里面拿出来。剩下的就是sliding window的思想。

本题的sliding window，当不满足条件的时候，left不是加1，而是根据具体的情况去移动到该有的位置，因为本题不是看**总体left-right的子数组的情况
是看局部，right和right-1的大小关系**，一旦目前的right不满足条件，要把left至少移到right重新开始才行，而不是之前的写一个while循环，然后以一个单位右移left。

