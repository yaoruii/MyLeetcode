# 220. Contains Duplicate III

```
Given an array of integers, find out whether there are two distinct indices i and j in the array   
such that the absolute difference between nums[i] and nums[j] is at most t and   
the absolute difference between i and j is at most k.
```

不会，看的答案

# 使用桶，有点类似那个gap的题，使用桶的一些特点，来达到某种目的。。
思路：
* 根据nums[i]的值，为其分配桶的序号，桶的size：0/size = 0，1/size = 0，size-1/size = 0，所以，一共会有size个元素在同一个桶里。
* 这样的话，在同一个桶内的nums[i]的值之间的差距，最多为```size-1```，所以，我们可以设size=t+1：
   * 于是，同一个桶内的差值最多为t，一旦在同一个桶内，两个数的差距一定<=t，所以，直接可以返回true；
   * 两个数在相邻的桶内，也有可能差距在t这个范围内，因此，需要将两数相减，进行比较即可   

**上述是如何确定nums[i]的值是否在t范围内，那要如何保证两个值的索引在k范围内呢？**

* 遍历nums，使用一个map保存每一个i的信息：(nums[i]应该在的bucket的label，nums[i]的值)
* 一直保持该map最多只有K个元素，一旦size>k，也就是size=k+1的时候，就把最开始放进去的元素从map中remove()出去。
* 为什么要这样做：这样map中的k个元素，包括还未被放进去map中的下一个i的nums[i]元素，加在一起一共最多K+1个元素。题目中的，索引的差值最多是K，也就是说第一个元素和最后一个元素的索引的差最多是k，0-k，一共有k+1个元素。
* 所以，他们K+1个元素进行值比较，看看是否在t范围内，才有意义！
* 解决了k和t的问题

有几个需要注意的点：
* 并不需要真正的创建这些桶，只需要在map中记录一下桶的标签。
* 当nums[i]的值为负数的时候，不好处理。。所以，桶的标签的算法采用的是：
```
long size =(long)t+1;
long num = (long) nums[i] - Integer.MIN_VALUE;
long bucket = (long) num/size;//防止t==0的情况
```
* 首先，size = t+1，但是一定要先把t转换为long后，再加一，否则，如果t是Integer.MAX_VALUE的话，先加1，就溢出了，再转换也没什么意义了
* 和Integer.MIN_VALUE相减，用差作为nums[i]的值，放在map中。
