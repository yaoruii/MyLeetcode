# 360. Sort Transformed Array
```
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]

Expected time complexity: O(n)
```

## math + two pointer:
**math知识：二次方抛物线：如果a>0，那么无论原数组如何分布，最大值一定在数组的两端，最小值不确定，因为可能也在两端，可能在中间；当a<0的时候，最小值一定也在两端，最大值无法确定，因为最大值可能在中间，也可能在两端。**

**精炼：a>0的时候，两端大于中间，a<0的时候，中间大于两端？？？奇怪的表达啊**

所以：
* a>0，从末尾开始遍历填充res数组。
* a<0，从开头开始遍历填充res数组。
* left = 0,right = nums.length-1，遍历原输入数组
* 每次得到f(left)和f(right)后，比较两者：a>0，较大的值填充在当前index的res中，index--，并移动left or right得到新的两端；a<0，较小的值填充在当前index的res中，index++，并移动left或者right得到新的两端。所以可以看出，left<= right，等于：指向同一个元素，必须要包括进去，不然会落下一个元素没有填充。
