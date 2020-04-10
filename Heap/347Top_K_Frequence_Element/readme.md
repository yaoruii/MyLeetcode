# 347：Top K Frequent Elements，前k个出现最多的元素
```
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
```
## 使用heap:

一开始根据之前写过的几题heap的题，比如求第k小的元素，都是把其放入到heap中，然后一个个地pop()出去，第k个pop()出去的就是第k小，所以这一题也很容易联想到这个用法。

同时，频率问题，经常使用一个map去保存每个元素出现的次数，所以也很容易想到，但是如何将heap和map结合，用heap存储map，不对，要存储的是**键值对**，而且键值对还要comparable，超出了知识范围。

在变形题451看到了有人用这个思路，学习：[在heap中存储map的键值对](https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogm)-PriorityQueue-Solution-easy-to-understand)

学习：

## 使用bucket sort()

* 在得到frequence的map后，将map中的key(也就是原数组中的元素）根据对应的value(也就是元素出现的频率）放入桶中，桶的序号就是出现的频率value，同样的频率放在同样的桶中
* 放完后，就得到了一个**基于出现的频率的排好序的桶**
* 把每一个桶中的元素gather起来：从最右边（下边）开始（频率最大），一旦res数组的size>=k,结束。

