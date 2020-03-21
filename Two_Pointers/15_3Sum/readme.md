# 1. Two Sum

2sum也比想象中难，今天用java写了一下，发现没那么简单，之前是Brute Force+python，没啥意义。
## approach 1: Two-pass Hash Table
这道题需要返回这两个数原来的索引，所以排序后使用start=0，end =len-1的方法不对，因为，这样即使提前把原数组的索引存放在map中，如果存在重复的元素，就被覆盖了，因为map的key不能重复，否则在get()阶段，也无法得到正确的索引。而这种两头夹击的方法，当这两数恰好相等是重复数的时候，我们无法得到他俩在原数组中的索引。

```
To improve our run time complexity, we need a more efficient way to check if the complement exists in the array.   
If the complement exists, we need to look up its index.   
What is the best way to maintain a mapping of each element in the array to its index? A hash table.
```

**而使用2sum的方法可以解决这个问题：先将元素和索引put进入map中，然后**
**start固定一个数，向右遍历整个数组，去找第二个数。**  这样，如果右侧有第二个重复数出现，且和为target，获取map中的索引时，保存的是右侧的这个数，因为map.put()操作时的覆盖作用。如果没有和为target的数，start++，如果有返回start和右侧那个数在map中的索引。
## approach 2: one-pass hash table
```
It turns out we can do it in one-pass.   
While we iterate and inserting elements into the table,   
we also look back to check if current element's complement already exists in the table.   
If it exists, we have found a solution and return immediately.
```
在把元素和索引放入map的过程中，我们寻找当前该元素的另一半是否已经存在map中，此时的当前元素相当于上个方法的start指向的元素了。如果此时的元素就是答案之一，那么另一半要么在它前边被放入了，即使是重复数，上一个数的value也不等于当前的索引，返回即可。如果还未被放进去，等遍历到它的另一半的时候，就找到了。

# 15. 3Sum

## 2sum的变形：固定一个start后，要在剩下的数组中找两个数
这道题不要求返回索引，所以可以sort(), 然后在剩下的数组中使用两头夹击方法寻找pairs。

# 18 4Sum
**比3sum多一层loop用于第二个元素即可，确定第一个后，遍历第二个：每次确定一个元素作为第二个，然后从剩下的数中，*1，和3sum中是一样的：寻找一个pair和为t，使用two pointer寻找pair(当我们可以排序的时候）。2，和2sum一样，当不可以排序的时候。

# general KSum



