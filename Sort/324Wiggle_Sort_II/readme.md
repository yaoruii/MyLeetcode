# 324. Wiggle Sort II
```
Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
```
恶心。。

# index mapping

**本来看一个解说，看了好久也没看明白，然后回到[投票最多的的实现](https://leetcode.com/problems/wiggle-sort-ii/discuss/77677/O(n)%2BO(1)-after-median-Virtual-Indexing)，就看懂了，虽然人家是c++?,差距啊。。难过**


```
That algorithm simply works with indexes 0 to n-1 as usual, but sneaky as I am, I rewire those indexes where I want the numbers to actually end up. The partitioning-algorithm doesn't even know that I'm doing that, it just works like normal (it just uses A(x) instead of nums[x]).
```
**这句话：我们使用三向切分，使得大于median的元素在前边，小于mdeian的元素在后边，但是，在A这个数组上进行:**

Accessing A(0) actually accesses nums[1].

Accessing A(1) actually accesses nums[3].

Accessing A(2) actually accesses nums[5].

Accessing A(3) actually accesses nums[7].

Accessing A(4) actually accesses nums[9].

Accessing A(5) actually accesses nums[0].

Accessing A(6) actually accesses nums[2].

Accessing A(7) actually accesses nums[4].

Accessing A(8) actually accesses nums[6].

Accessing A(9) actually accesses nums[8].

所以，真正的nums数组，就会满足：1，3，5..奇数索引的数都是**大于**med的，对应A数组是0,1,2,3,4索引都是大于med的。0,2,4...偶数索引的数都是小于med的，对用的A数组是5,6,7,8,9都是小于med的，所以，满足wiggle。

问题转化为：
* 1，如何在java中求出median
* 2，是构建一个A，还是用什么方法。

**关于问题2**
不构建A的话，直接在nums数组上进行操作，和正常的相比：n=9
* 正：i从0-(n-1)，现：i：1,3,5,7,9,0,2,4,6,8。
* 正：left:从0开始，指向第一个等于v的元素，每一个大于v的元素，都和left交换，然后left++，i++；现：left从1开始，依旧是指向第一个等于v的元素，每一个大于v的元素，都和left交换，然后left+2，开始指向3，5，7...（下一个等于med的元素）
* 正：right从n-1开始，指向最后一个未被遍历的元素，每一个大于v的元素，都和right交换，然后right--，i不变，要check原来right处的元素是否应该放在现在的i处；现：right从8开始，每次减2，6，4，2，0.
* 结束的
* 正：right从n-1开始，指向最后一个未被遍历的元素，每一个大于v的元素，都和right交换，然后right--，i不变，要check原来right处的元素是否应该放在现在的i处；现：right从8开始，每次减2，6，4，2，0.
* 正：right从n-1开始，指向最后一个未被遍历的元素，每一个大于v的元素，都和right交换，然后right--，i不变，要check原来right处的元素是否应该放在现在的i处；现：right从8开始，每次减2，6，4，2，0
* 结束的标志：正：i>right，这个时候结束，因为没有未被遍历的元素了；现：本质上是一样的：**没有未被遍历的元素了**，所以如果上边的每一次的i、left、right都**明面上**是**正常的数**，通过正常的数来计算**现在的数**，用**现在的数来access nums数组**，那么结束的标志也是```i>right```。
* 所以，如何通过正常的数来计算**现在的数**：```现在的数=(1+2*(i)) % (n|1)，i是明面的正常数```。0-1，1-3，2-5.。。6-2，7-4.。。。
* 所以，i、left、right按照正常数进行遍历，实际上每一次指的数都是现在的数。

**关于问题1：**
* 如果使用quick-sort得到中位数，那么nums数组已经是左侧都是大于med的，右侧都是小于med的。
* 所以？接下来，还需要上边的再次三向切分吗？
