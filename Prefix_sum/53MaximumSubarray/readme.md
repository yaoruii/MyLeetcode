# 53. Maximum Subarray

## 4月3日，在30天挑战的第三天碰到了这题，此时带着已刷147题的经验，使用前缀和解决了

**借鉴的是644题的check()method的思想，check（）这个函数呢在644题中是看一个数组中是否存在平均值大于mid的长度大于k的子数组，子数组的和也是用pre[j]-pre[i]来表示的，pre[j]在644中是所谓的sum，追踪j之前的所有的prefix的最小值min_pre，遍历j从0到数组长度len，得到pre[j]后和当前的min_pre相减，如果大于mid,那就是存在平均值大于mid的长度大于k的子数组，结束寻找**

**所以，53题找和最大的子数组，就是check()的一个小部件，j从左往右遍历整个数组，得到当前的pre[j]（一路加过来即可），然后和最小的min_pre相减，但是min_pre可能是pre[j]，所以这样一减就是0了，且子数组的长度是0，这肯定是不对的**

所以，操作的顺序很关键：
* min_pre必须是j之前的索引的prefix中的最小的，也就是说**把当前的pre[j]和min_pre的比较更新min_pre时，已经完成了sum和(pre[j]-min_pre)进行比较最大值更新sum的操作。

## follow up:[divide and conquer][]

解析说这题是divide and conquer典型的例题之一，能够使用和**merge sort**相似的算法解决。

Let's follow here a solution template for the divide and conquer problems :（厉害了）
* 定义base case(s)
* 把问题分割为子问题，然后迭代式地解决他们。
* 将子问题的解决方法合并，得到原始问题的solution。

对应这道题：
* base case：n=1，return 这个元素。
* 变量left_sum =  **maxSubArray** for the left subarray,左侧的子数组的最大的子数组和，**何为左侧子数组？the first n/2 numbers (middle element at index (left + right) / 2 always belongs to the left subarray).前n/2个元素，中间的元素mid=(left+right)/2永远属于左侧的数组。**
* 同理，变量right_sum = **maxSubArray** for the right subarray, for the last n/2 numbers.
* 变量cross_sum = maximum sum of the subarray containing elements from both left and right subarrays and hence crossing the middle element at index (left + right) / 2：包含来自左侧子数组元素和来自右侧子数组元素的的子数组的最大和，因为肯定穿过中间元素(left + right) / 2。
* Merge the subproblems solutions, i.e. return max(left_sum, right_sum, cross_sum).




