# 360. Sort Transformed Array
```
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]

Expected time complexity: O(n)
```

## math + two pointer:
**math知识：二次方抛物线：如果a>0，那么无论原数组如何分布，最大值一定在数组的两端，最小值不确定，因为可能也在两端，可能在中间；当a<0的时候，最小值一定也在两端，最大值无法确定，因为最大值可能在中间，也可能在两端。**

所以：
