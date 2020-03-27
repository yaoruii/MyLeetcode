



* 1，构建候选的solution:非负数
* 2，所有的候选solutions构成的搜索空间：数组的最大值和最小值的dis = max - min = d，所以任何dis都在[0, d]这个范围内。
* 3，**验证一个solution是否符合条件**：定义一个函数count(num)为小于等于num的pair distance的个数，那么第k个num就是使得count(num)>=k的最小的数。
* 4，如何计算count(num)=? : 首先将数组排序，然后d_ij= nums[j]-nums[i]，所以d_ij<=k，等价于：nums[j]<=k+nums[i],固定i，然后遍历j就可以得到count(num)  
     * 寻找j的过程也可以应用binary search，因为数组是有序的。这样整个时间复杂度就是nlog(n)
     * 可以继续优化为线性：n，with i1 < i2, let j1 and j2 be the smallest index such that nums[j1] > nums[i1] + num and nums[j2] > nums[i2] + num，j2 >= j1一定成立，所以，这里可以用**two pointer**的算法，寻找每一个固定i的配对j
* 5，如何**有效地遍历搜索空间？**：到这一步时，已经知道搜索空间、如何构建一个solution，如何验证一个solution是否是结果，但是如何搜索这个空间：
     * 如果我们遍历[0,d]，那么时间复杂度会是：nd，d可以是巨大的，所以很糟糕。
     * 使用基于range的binary search：范围从[0,d]==>>>得到mid：
       * 如果count(mid)<k，lo = mid+1:因为小于等于mid的个数小于k，所以第k个数一定比mid大
       * 如果count(mid)>k，hi = mid-1:因为小于等于mid的个数大于k，所以第k个数可能等于mid可能小于mid（重复数）：hi = mid/mid-1
       * count(mid) = k, mid不一定存在于数组的dis pair中，所以使用一个max在计算count中追踪最大的max，此时就可以返回max。

**一个人总结的模版：同样可以应用于378**
```
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // firt sort the original nums so that we could apply the sliding window properly
        Arrays.sort(nums);
        // in range [0, N-1], min dist is 0, max dist is the dist between max and min num in nums
        int N = nums.length;
        int lo = 0, hi = nums[N - 1] - nums[0];
        while (lo <= hi) {
            // check if mid might be the kth dist
            int mid = lo + (hi - lo) / 2;
            // sliding window: for each `end` index, find the `start` so that
            // 1) in subarray [start, end], max dist == nums[end] - nums[start] <= m
            // 2) [start, end] is the longest subarray, which means start is min index satisfying condition 1
            int count = 0, maxDist = 0;
            for (int start = 0, end = 0; end < N; end++) {
                while (nums[end] - nums[start] > mid) start++;  // adjust start to satisfy conditions
                if (start < end) {
                    count += end - start;          // count num of pair ending with `end` and with dist <= m
                    maxDist = Math.max(maxDist, nums[end] - nums[start]); // mid might not be the exact dist, we need to keep the real dist along the way
                }
            }
            if (count == k) return maxDist;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
```
