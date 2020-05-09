# 148 Sort List

```
Input: 4->2->1->3
Output: 1->2->3->4
Sort a linked list in O(n log n) time using constant space complexity.
```
**要求了时间和空间复杂度，因此只能用自底向上的归并排序，但是太难了，先实现了自顶向下的归并排序**

# 自顶向下归并排序
* 如何实现mid元素的寻找：
使用pre、slow和fast指针，slow和pre一次只移动一个node，pre初始是null，slow初始是head，这样保持pre一直在slow的后边一个，fast一次移动两个，初始化的时候是head：
  * 如果是偶数长度(x)，三者移动len/2次，fast==null，退出循环，slow指向后半段的第一个元素，让pre.next=null，断开前后两半，结束
  * 如果是奇数长度(x+1)，三者移动len/2（小数部分会舍去，所以，和上边是一样的），fast指向最后一个**落单**的最后元素，slow和pre依旧是上边的那些node，fast.next==null，退出循环，pre的处理同上。

这样，head指向前半段，slow指向后半段，结束！递归排序后，再merge。
