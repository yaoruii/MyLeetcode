# 34. Find First and Last Position of Element in Sorted Array

好题：看了一个很详细的解析：[学习](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/discuss/14699/Clean-iterative-solution-with-two-binary-searches-(with-explanation))

该问题可以分解分：**两个binary search:分别寻找该范围的起始位置**

## 寻找左边界：
首先，i = 0, j= n-1，mid = i + (j-i)/2, 每一步根据nums[mid]和target的大小进行move on：
> if nums[mid]< target: range should begin on right of the mid, >>> i = mid+1  
> if nums[mid]= target: range should begin on left of mid or on mid, >>> j = mid  
> if nums[mid]> target: range should begin on left of mid, >>> j = mid-1  
> 可以将第二三条合并：if nums[mid]>= target: range should begin on left of mid or on mid, >>> j = mid 

在寻找左边界的过程中，最终会将搜索范围缩小到只有两个数，假设target=5，最终会有几种情况：
> [5,7] : nums[mid] = target --- j= mid= i, i == j, 指向左边界，退出循环  
> [5,5] : nums[mid] = target --- j= mid= i, i == j, 指向左边界，退出循环  
> [5,3] : nums[mid] = target --- j= mid= i(pass)  
> [3,5] : nums[mid] < target --- i = mid+1 = j, i == j, 指向左边界，退出循环 
> [3,4] : nums[mid] < target --- i = mid+1 = j, i == j, 但是指向的元素不是target，所以退出循环，不存在左边界  
> [6,7] : nums[mid] > tatget --- j = mid = i,  i == j, 但是指向的元素不是target，所以退出循环，不存在左边界  

所以，寻找左边界的搜索在 i < j 的大条件下即可，当i=j的时候，退出循环得到的就是左边界否则不存在。

## 寻找右边界：
首先，i = 0, j= n-1，mid = i + (j-i)/2, 每一步根据nums[mid]和target的大小进行move on：
> if nums[mid]< target: range should begin on right of the mid, >>> i = mid+1  
> if nums[mid]= target: range should begin on right of mid or on mid, >>> i = mid  
> if nums[mid]> target: range should begin on left of mid, >>> j = mid-1  
> 可以将第一二条合并：if nums[mid] <= target: range should begin on right of mid or on mid, >>> i = mid 

**但是，这里有一个问题，上述规则让i = mid or j = mid-1，所以当i == mid的情况下，陷入了死循环，永远无法结束，而寻找左边界的时候，是让j= mid，j永远都不会==mid，所以不会出现在这个问题。**

**解决方法：让mind = (i+j+1)/2，而不是上边的（i+j)/2，The easiest way to achieve this is by making mid biased to the right, i.e. mid = (i+j)/2+1.由于，我们永远都不会让j = mid，所以这样就解决了问题。而寻找左边界的时候，永远都不会让i=mid，所以可以让mid biased to the left**

* 左边界：mid = lo + (hi - lo)/2
* 右边界：mid = lo + (hi - lo +1)/2


