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

所以，真正的nums数组，就会满足：1，3，5..奇数索引的数都是大于med的，0,2,4...偶数索引的数都是小于med的，所以，满足wiggle。

问题转化为：
* 1，如何在java中求出median
* 2，是构建一个A，还是用什么方法。

**关于问题2**
不构建A的话，直接在nums[]数组上进行操作，和正常的
