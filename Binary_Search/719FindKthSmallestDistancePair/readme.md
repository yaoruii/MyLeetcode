



* 1，构建候选的solution:非负数
* 2，所有的候选solutions构成的搜索空间：数组的最大值和最小值的dis = max - min = d，所以任何dis都在[0, d]这个范围内。
* 3，验证一个solution是否符合条件：定义一个函数count(num)为小于等于num的pair distance的个数，那么第k个num就是使得count(num)>=k的最小的数。
* 4，如何计算count(num)=? : 首先将数组排序，然后d_ij= nums[j]-nums[i]，所以d_ij<=k，等价于：nums[j]<=k+nums[i],固定i，然后遍历j就可以得到count(num)  
     * 寻找j的过程也可以应用binary search，因为数组是有序的。这样整个时间复杂度就是nlog(n)
     * 可以继续优化为线性的：with i1 < i2, let j1 and j2 be the smallest index such that nums[j1] > nums[i1] + num and nums[j2] > nums[i2] + num，j2 >= j1一定成立，所以，这里可以用**two pointer**的算法，寻找每一个固定i的配对j
* 5，如何**有效地遍历搜索空间？**：
    
