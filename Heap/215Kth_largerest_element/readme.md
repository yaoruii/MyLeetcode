# 215
```
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.:是第k大的元素，不是第k大的distinct元素。

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4（两个5都要算进去）
```
# 直接系统排序，输出倒数第k个元素
That would be an algorithm of NlogN time complexity and O(1) space complexity.
# heap sort：不需要真正的排好，一个个地输出n-k次即可结束
**但是要先把数组里面的元素全部都offer到heap中，然后在poll()n-k次。**

**插入元素的时间复杂度是：Θ(log N)，remove最小的元素的时间复杂度是：Θ(log N)，所以Θ（2n-k)(log N)。空间复杂度：n**

# heap:
**维护一个大小为k的heap，一旦heap的size大于了k，就poll()出最小的元素，当把所有的n个元素都加入到heap中后，该heap存放着k个较大的元素，最后，再poll()最小的元素即可，便可得到第k大的元素**

**The time complexity of adding an element in a heap of size k is O(logk), 一共插入了n次，n个数组元素，所以是：O(2n-k)(logk)

# ⚠️：快速选择：quick-select
