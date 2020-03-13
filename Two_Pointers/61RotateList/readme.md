# 61. Rotate List

```
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
```
## 死抠型two pointers: 0ms, 100%
* 首先，如果K大于整个list的长度len，那么需要对K进行一个除余处理，因为对list进行len次的旋转后的结果和最开始的list完全一样。这样使k<len，提高了效率
* 观察得到，进行K次旋转，就是把**后K**个node整体平移到head的前方，因此我们需要：
   * 找到**后K**个node：一个指向**倒数K+1**个node的start pointer。
   * 指向整个list最后的元素的end pointer,，其在之前计算len时已经得到。
   * 这样我们就可以得到start.next到end的所有需要被平移的nodes。
* how 平移：
   * start 会成为新的end node，所以保存tmp = start.next之后，将start.next = null
   * end 的next会从null变成head(一直没动head变量），所以: end.next = head
   * 最后返回tmp即可，新的head
 
