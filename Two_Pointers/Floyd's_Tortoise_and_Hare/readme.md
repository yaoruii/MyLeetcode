# Floyd's Tortoise and Hare for detect a loop link

> Imagine two runners running on a track at different speed. What happens when the track is actually a circle?  
>  case A： The fast runner is just one step behind the slow runner. In the next iteration, they both increment one and two steps respectively and meet each other.  
> we have not considered cases where the fast runner is two or three steps behind the slow runner yet. This is simple, because in the next or next's next iteration, this case will be reduced to case A mentioned above.  
> 总有一天快的那个人会遇到慢的那个人，不过快的那个人可能已经比慢的人多跑好几圈了。

**相关题目：287. Find the Duplicate Number，141. Linked List Cycle,142. Linked List Cycle II**  
一篇介绍的连接：https://www.jianshu.com/p/4f7dc8b9aa3c

## 步骤一：寻找是否有环 

首先，初始化两个指针，一个快速的hare指针，一个慢的Tortoise指针。让hare一次走两个个结点，tortoise指针一次走一个结点。最终，如果存在环，hare和tortoiser会相遇。

<img src="https://tva1.sinaimg.cn/large/00831rSTgy1gcsl3mzi5hj30yk0jq432.jpg" alt="屏幕快照 2020-03-13 下午8.36.55" style="zoom:50%;" />

如图所示，循环中的结点已经被标注为***0到(c -1)***，c是环的长度，非环结点被标注为-1到-F，F是非环结点的个数。经过F次的迭代后，tortoise指向0结点，hare走过了2F个结点，前F次指向0，后F次指向环内的F结点。然后再经过C-F次迭代后，tortoise指向了C-F结点，hare从F先走C-F到C，也就是0结点，再走C-F到C-F结点，和tortoise结点相遇。该结点为两者第一次相遇的点。

## 步骤二：寻找环的入口

经过步骤一，已经得到此刻在C-F结点的相遇结点。初始化两个指针：ptr1指向list的头部，ptr2指向相遇点。经过F次的迭代，ptr1来到了0结点，ptr2来到了C结点，也就是0结点，两者相遇，相遇点是环的入口。



## 287 寻找重复数

所以，经过上述的分析，141和142题就变的很简单了，但是287属于变形体，需要学习一下。

```
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

There is only one duplicate number in the array, but it could be repeated more than once.
```

```
Input: [1,3,4,2,2]
Output: 2
```

**for each pair of index *i* and value v_i, the "next" value v_j is at index v_i**

**为什么可以看成是一个detect loop问题？**

**First off, we can easily show that the constraints of the problem imply that a cycle *must* exist. （一定会有重复数）Because each number in `nums` is between 1 and n, it will necessarily point to an index that exists（所以value作为索引去寻找下一步的时候，一定能够找到）. Therefore, the list can be traversed infinitely, （所以这个数组可以按照这种方式一直迭代下去）which implies that there is a cycle（符合这里一定有一个环）. Additionally, because 0 cannot appear as a value in `nums`, `nums[0]` cannot be part of the cycle（永远都不会有value=0，所以nums[0]一定不会再次被迭代到，即在环外边）. Therefore, traversing the array in this manner from `nums[0]` is equivalent to traversing a cyclic linked list. Given this, the problem can be solved just like list**

### phase 1

刚开始，hare和tortoise都在index=0处，nums[0] = 1，所以接下来他们要移动到index= 1的地方，然后nums[1]=4，所以接下来会移动到index=4的地方，也就是nums[4]。hare一次移动两步，tortoise依旧是一次一步的移动。

<img src="https://tva1.sinaimg.cn/large/00831rSTgy1gcsm8n79ifj30z60ia0vo.jpg" alt="屏幕快照 2020-03-13 下午9.20.48" style="zoom:50%;" />

此处的value=6，所以下一步go to index 6，也就是3。之后：hare go to index 3, 两者的value一样，相遇。因为，***value相等即是相遇，存在重复的元素，但是我们不能认为相遇这里的这个元素就是重复的那个数，就像ListNode中相遇的地方也不一定是环的开口一样。因为有可能出现在了同样的index处。***

<img src="https://tva1.sinaimg.cn/large/00831rSTgy1gcsmas5lirj30zs0j00wm.jpg" alt="屏幕快照 2020-03-13 下午9.20.28" style="zoom:50%;" />

### phase 2

找到intersect后，我们让ptr2= intersect/hare/tortoise，ptr1=nums[0]，一次移动一步，直到两者相等。

<img src="https://tva1.sinaimg.cn/large/00831rSTgy1gcsnalfri4j30za0h642r.jpg" alt="屏幕快照 2020-03-13 下午9.51.09" style="zoom:50%;" />

