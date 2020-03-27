# 373. Find K Pairs with Smallest Sums

## heap:
 **和378是同一道heap题，几乎一样, [leetcode](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/),[github](https://github.com/yaoruii/MyLeetcode/tree/master/Binary_Search/378KthSmallestElementInaSortedMatrix)**
 
 378是找最k小的数，这是找前k小个数并且把他们都保存起来并返回，所以就比378的heap多了一步：poll()之后，把track加入到res中。

假设这里有一个虚拟的2D矩阵matrix[n1][n2],那么matrix[i][j]的元素就是nums1[i]和nums2[j]的和，由于nums1和nums2都是排好序的，所以，该矩阵和378一样，在row和col上递增！！！！


## binary search + trial and error
**那个人总结的模版中说这一题可以用这个**
