# Heap

## PriorityQueue

在上cs61b的时候，学过pq的interface，在课程里，是用数据结构**二叉堆minHeap进行实现的**，但是没有学习java内部是如何实现的，也就是说我们在刷题时是可以拿过来直接用的。

**在java内部，priority queue是通过小顶堆来实现的，我们不需要在意具体代码，就像list和stack一样，直接拿过来用，接口为queue，所以具有以下的method:  
add()和offer()，element()和peek()，remove()和poll()：删除对首元素，以上三个接口都是queue，remove(object o)该方法是collection接口的函数，删除队列中和o相等的某个元素。
