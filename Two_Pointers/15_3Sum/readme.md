# 1. Two Sum

2sum也比想象中难，今天用java写了一下，发现没那么简单，之前是Brute Force+python，没啥意义。
## approach 1: Two-pass Hash Table
这道题需要返回这两个数原来的索引，所以排序后使用start=0，end =len-1的方法不对，因为，这样即使提前把原数组的索引存放在map中，如果存在重复的元素，就被覆盖了，因为map的key不能重复，否则在get()阶段，也无法得到正确的索引。而这种两头夹击的方法，当这两数恰好相等是重复数的时候，我们无法得到他俩在原数组中的索引。

```
To improve our run time complexity, we need a more efficient way to check if the complement exists in the array.   
If the complement exists, we need to look up its index.   
What is the best way to maintain a mapping of each element in the array to its index? A hash table.
```
**而使用2sum的方法可以解决这个问题：先将元素和索引put进入map中，然后  **
**start固定一个数，向右遍历整个数组，去找第二个数。**这样，如果右侧有第二个重复数出现，且和为target，获取map中的索引时，保存的是右侧的这个数，因为map.put()操作时的覆盖作用。如果没有和为target的数，start++，如果有返回start和右侧那个数在map中的索引。
## approach 2: one-pass hash table


# 15. 3Sum

## 




